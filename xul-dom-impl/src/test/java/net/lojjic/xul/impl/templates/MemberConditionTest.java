package net.lojjic.xul.impl.templates;

import junit.framework.TestCase;
import net.lojjic.xul.rdf.RDFService;
import net.lojjic.xul.rdf.RDFDataSource;
import net.lojjic.xul.rdf.RDFNode;
import net.lojjic.xul.rdf.RDFResource;
import net.lojjic.xul.rdf.impl.RDFServiceImpl;
import org.w3c.dom.Element;
import org.apache.xml.utils.UnImplNode;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Unit test for {@link MemberCondition}
 */
public class MemberConditionTest extends TestCase {

	/**
	 * Test forward arc triple where both container and child are variables
	 */
	public void testForwardArcBothVariable() throws Exception {
		RDFService rdfService = new RDFServiceImpl();
		RDFDataSource dataSource = rdfService.getDataSource("classpath:net/lojjic/xul/impl/templates/photos.rdf");

		Element element = new UnImplNode() {
			public String getAttribute(String name) {
				if(name.equals("container")) {
					return "?start";
				}
				if(name.equals("child")) {
					return "?photo";
				}
				return super.getAttribute(name);
			}
		};

		MemberCondition memberCondition = new MemberCondition(rdfService, element);
		List<Map<String, RDFNode>> varsList = new ArrayList<Map<String, RDFNode>>();
		Map<String, RDFNode> varsMap = new HashMap<String, RDFNode>();
		RDFResource start = rdfService.getResource("http://www.xulplanet.com/rdf/myphotos");
		varsMap.put("?start", start);
		varsList.add(varsMap);

		memberCondition.applyToVariablesList(dataSource, varsList, start);

		assertEquals(3, varsList.size());
		assertEquals(2, varsList.get(0).size());
		assertEquals(2, varsList.get(1).size());
		assertEquals(2, varsList.get(2).size());
		assertEquals(start, varsList.get(0).get("?start"));
		assertEquals(start, varsList.get(1).get("?start"));
		assertEquals(start, varsList.get(2).get("?start"));
		assertEquals(rdfService.getResource("http://www.xulplanet.com/ndeakin/images/t/palace.jpg"), varsList.get(0).get("?photo"));
		assertEquals(rdfService.getResource("http://www.xulplanet.com/ndeakin/images/t/canal.jpg"), varsList.get(1).get("?photo"));
		assertEquals(rdfService.getResource("http://www.xulplanet.com/ndeakin/images/t/obelisk.jpg"), varsList.get(2).get("?photo"));
	}

	/**
	 * Test forward arc triple where container is variable but child is a URI
	 */
	public void testForwardArcChildURI() throws Exception {
		RDFService rdfService = new RDFServiceImpl();
		RDFDataSource dataSource = rdfService.getDataSource("classpath:net/lojjic/xul/impl/templates/photos.rdf");

		Element element = new UnImplNode() {
			public String getAttribute(String name) {
				if(name.equals("container")) {
					return "?start";
				}
				if(name.equals("child")) {
					return "http://www.xulplanet.com/ndeakin/images/t/canal.jpg";
				}
				return super.getAttribute(name);
			}
		};

		MemberCondition memberCondition = new MemberCondition(rdfService, element);
		List<Map<String, RDFNode>> varsList = new ArrayList<Map<String, RDFNode>>();
		Map<String, RDFNode> varsMap = new HashMap<String, RDFNode>();
		RDFResource start = rdfService.getResource("http://www.xulplanet.com/rdf/myphotos");
		varsMap.put("?start", start);
		varsList.add(varsMap);

		memberCondition.applyToVariablesList(dataSource, varsList, start);

		assertEquals(1, varsList.size());
		assertEquals(1, varsList.get(0).size());
		assertEquals(start, varsList.get(0).get("?start"));

		// negative test:
		start = rdfService.getResource("http://www.xulplanet.com/rdf/not-in-graph");
		varsMap.put("?start", start);
		memberCondition.applyToVariablesList(dataSource, varsList, start);
		assertEquals(0, varsList.size());
	}


	/**
	 * Test backward arc triple where both container and child are variables
	 */
	public void testBackwardArcBothVariable() throws Exception {
		RDFService rdfService = new RDFServiceImpl();
		RDFDataSource dataSource = rdfService.getDataSource("classpath:net/lojjic/xul/impl/templates/photos.rdf");

		Element element = new UnImplNode() {
			public String getAttribute(String name) {
				if(name.equals("container")) {
					return "?container";
				}
				if(name.equals("child")) {
					return "?start";
				}
				return super.getAttribute(name);
			}
		};

		MemberCondition memberCondition = new MemberCondition(rdfService, element);
		List<Map<String, RDFNode>> varsList = new ArrayList<Map<String, RDFNode>>();
		Map<String, RDFNode> varsMap = new HashMap<String, RDFNode>();
		RDFResource start = rdfService.getResource("http://www.xulplanet.com/ndeakin/images/t/palace.jpg");
		varsMap.put("?start", start);
		varsList.add(varsMap);

		memberCondition.applyToVariablesList(dataSource, varsList, start);

		assertEquals(1, varsList.size());
		assertEquals(2, varsList.get(0).size());
		assertEquals(start, varsList.get(0).get("?start"));
		assertEquals(rdfService.getResource("http://www.xulplanet.com/rdf/myphotos"), varsList.get(0).get("?container"));
	}

	/**
	 * Test backward arc triple where child is variable but container is a URI
	 */
	public void testBackwardArcContainerURI() throws Exception {
		RDFService rdfService = new RDFServiceImpl();
		RDFDataSource dataSource = rdfService.getDataSource("classpath:net/lojjic/xul/impl/templates/photos.rdf");

		Element element = new UnImplNode() {
			public String getAttribute(String name) {
				if(name.equals("container")) {
					return "http://www.xulplanet.com/rdf/myphotos";
				}
				if(name.equals("child")) {
					return "?start";
				}
				return super.getAttribute(name);
			}
		};

		MemberCondition memberCondition = new MemberCondition(rdfService, element);
		List<Map<String, RDFNode>> varsList = new ArrayList<Map<String, RDFNode>>();
		Map<String, RDFNode> varsMap = new HashMap<String, RDFNode>();
		RDFResource start = rdfService.getResource("http://www.xulplanet.com/ndeakin/images/t/palace.jpg");
		varsMap.put("?start", start);
		varsList.add(varsMap);

		memberCondition.applyToVariablesList(dataSource, varsList, start);

		assertEquals(1, varsList.size());
		assertEquals(1, varsList.get(0).size());
		assertEquals(start, varsList.get(0).get("?start"));

		// negative test:
		start = rdfService.getResource("http://www.xulplanet.com/ndeakin/images/t/not-a-photo.jpg");
		varsMap.put("?start", start);
		memberCondition.applyToVariablesList(dataSource, varsList, start);
		assertEquals(0, varsList.size());
	}

}
