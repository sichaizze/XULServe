package net.lojjic.xul.impl.rdf;

import net.lojjic.xul.rdf.RDFDataSource;
import net.lojjic.xul.rdf.RDFRemoteDataSource;
import net.lojjic.xul.rdf.RDFService;
import org.openrdf.sesame.admin.StdOutAdminListener;
import org.openrdf.sesame.constants.RDFFormat;

import java.net.URL;

/**
 * RDF data source implementation that gets its data from a RDF-XML file.
 * That file may be local or remote.
 */
public class RDFXMLDataSourceImpl extends RDFMemoryDataSourceImpl implements RDFDataSource, RDFRemoteDataSource {

	private String uri;
	private boolean loaded = false;

	/**
	 * Constructor.
	 * @param uri: The URI of the RDF-XML file holding the graph data.
	 */
	public RDFXMLDataSourceImpl(RDFService rdfService, String uri) {
		super(rdfService);
		init(uri);
	}

	/**
	 * The "URI" of the data source. This used by the RDF service's
	 * getDataSource() method to cache datasources.
	 */
	public String getURI() {
		return uri;
	}

	/**
	 * This value is true when the datasource has fully loaded itself.
	 */
	public boolean isLoaded() {
		return loaded;
	}

	/**
	 * Request that a data source write it's contents out to permanent storage, if applicable.
	 */
	public void flush() {
		flushTo(uri);
	}

	/**
	 * @param uri
	 */
	public void flushTo(String uri) {
		//TODO
	}

	/**
	 * Specify the URI for the data source: this is the prefix that will be used to register
	 * the data source in the data source registry.
	 *
	 * @param uri: the URI to load
	 */
	public void init(String uri) {
		this.uri = uri;
		refresh(true);
	}

	/**
	 * Refresh the remote datasource, re-loading its contents from the URI.
	 *
	 * @param blocking: If true, the call will block until the datasource has completely reloaded.
	 *                  This implementation only supports blocking; a false value will throw an exception.
	 */
	public void refresh(boolean blocking) {
		if(!blocking) {
			throw new UnsupportedOperationException("Non-blocking RDF-XML file loading is not supported by this implementation.");
		}

		try {
			// TODO implement special AdminListener that logs messages or something
			repository.addData(new URL(uri), null, RDFFormat.RDFXML, true, new StdOutAdminListener());
		}
		catch (Exception e) {
			throw new RuntimeException("Error loading RDFXML source.", e);
		}
	}
}