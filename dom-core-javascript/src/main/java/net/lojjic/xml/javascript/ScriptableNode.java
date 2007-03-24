package net.lojjic.xml.javascript;

import net.lojjic.rhino.annotations.*;
import net.lojjic.xml.javascript.events.ScriptableEventListener;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.w3c.dom.*;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;

/**
 * Scriptable wrapper for {@link org.w3c.dom.Node}
 */
@JSClassName("Node")
public class ScriptableNode extends ScriptableDOMObject {

	protected Node delegateNode;

	public ScriptableNode() {
		super();
	}

	public ScriptableNode(Scriptable scope, Node node) {
		super(scope, node);
		this.delegateNode = node;
	}

	@JSStatic @JSGetter("ELEMENT_NODE")
	public static short get_ELEMENT_NODE(ScriptableObject obj) {
		return Node.ELEMENT_NODE;
	}

	@JSStatic @JSGetter("ATTRIBUTE_NODE")
	public static short get_ATTRIBUTE_NODE(ScriptableObject obj) {
		return Node.ATTRIBUTE_NODE;
	}

	@JSStatic @JSGetter("TEXT_NODE")
	public static short get_TEXT_NODE(ScriptableObject obj) {
		return Node.TEXT_NODE;
	}

	@JSStatic @JSGetter("CDATA_SECTION_NODE")
	public static short get_CDATA_SECTION_NODE(ScriptableObject obj) {
		return Node.CDATA_SECTION_NODE;
	}

	@JSStatic @JSGetter("ENTITY_REFERENCE_NODE")
	public static short get_ENTITY_REFERENCE_NODE(ScriptableObject obj) {
		return Node.ENTITY_REFERENCE_NODE;
	}

	@JSStatic @JSGetter("ENTITY_NODE")
	public static short get_ENTITY_NODE(ScriptableObject obj) {
		return Node.ENTITY_NODE;
	}

	@JSStatic @JSGetter("PROCESSING_INSTRUCTION_NODE")
	public static short get_PROCESSING_INSTRUCTION_NODE(ScriptableObject obj) {
		return Node.PROCESSING_INSTRUCTION_NODE;
	}

	@JSStatic @JSGetter("COMMENT_NODE")
	public static short get_COMMENT_NODE(ScriptableObject obj) {
		return Node.COMMENT_NODE;
	}

	@JSStatic @JSGetter("DOCUMENT_NODE")
	public static short get_DOCUMENT_NODE(ScriptableObject obj) {
		return Node.DOCUMENT_NODE;
	}

	@JSStatic @JSGetter("DOCUMENT_TYPE_NODE")
	public static short get_DOCUMENT_TYPE_NODE(ScriptableObject obj) {
		return Node.DOCUMENT_TYPE_NODE;
	}

	@JSStatic @JSGetter("DOCUMENT_FRAGMENT_NODE")
	public static short get_DOCUMENT_FRAGMENT_NODE(ScriptableObject obj) {
		return Node.DOCUMENT_FRAGMENT_NODE;
	}

	@JSStatic @JSGetter("NOTATION_NODE")
	public static short get_NOTATION_NODE(ScriptableObject obj) {
		return Node.NOTATION_NODE;
	}

	@JSStatic @JSGetter("DOCUMENT_POSITION_DISCONNECTED")
	public static short get_DOCUMENT_POSITION_DISCONNECTED(ScriptableObject obj) {
		return Node.DOCUMENT_POSITION_DISCONNECTED;
	}

	@JSStatic @JSGetter("DOCUMENT_POSITION_PRECEDING")
	public static short get_DOCUMENT_POSITION_PRECEDING(ScriptableObject obj) {
		return Node.DOCUMENT_POSITION_PRECEDING;
	}

	@JSStatic @JSGetter("DOCUMENT_POSITION_FOLLOWING")
	public static short get_DOCUMENT_POSITION_FOLLOWING(ScriptableObject obj) {
		return Node.DOCUMENT_POSITION_FOLLOWING;
	}

	@JSStatic @JSGetter("DOCUMENT_POSITION_CONTAINS")
	public static short get_DOCUMENT_POSITION_CONTAINS(ScriptableObject obj) {
		return Node.DOCUMENT_POSITION_CONTAINS;
	}

	@JSStatic @JSGetter("DOCUMENT_POSITION_CONTAINED_BY")
	public static short get_DOCUMENT_POSITION_CONTAINED_BY(ScriptableObject obj) {
		return Node.DOCUMENT_POSITION_CONTAINED_BY;
	}

	@JSStatic @JSGetter("DOCUMENT_POSITION_IMPLEMENTATION_SPECIFIC")
	public static short get_DOCUMENT_POSITION_IMPLEMENTATION_SPECIFIC(ScriptableObject obj) {
		return Node.DOCUMENT_POSITION_IMPLEMENTATION_SPECIFIC;
	}

	@JSGetter("nodeName")
	public String getNodeName() {
		return delegateNode.getNodeName();
	}

	@JSGetter("nodeValue")
	public String getNodeValue() {
		return delegateNode.getNodeValue();
	}

	@JSSetter("nodeValue")
	public void setNodeValue(String val) {
		delegateNode.setNodeValue(val);
	}

	@JSGetter("nodeType")
	public short getNodeType() {
		return delegateNode.getNodeType();
	}
	
	@JSGetter("parentNode")
	public Object getParentNode() {
		return delegateNode.getParentNode();
	}
	
	@JSGetter("childNodes")
	public Object getChildNodes() {
		return delegateNode.getChildNodes();
	}
	
	@JSGetter("firstChild")
	public Object getFirstChild() {
		return delegateNode.getFirstChild();
	}
	
	@JSGetter("lastChild")
	public Object getLastChild() {
		return delegateNode.getLastChild();
	}
	
	@JSGetter("previousSibling")
	public Object getPreviousSibling() {
		return delegateNode.getPreviousSibling();
	}
	
	@JSGetter("nextSibling")
	public Object getNextSibling() {
		return delegateNode.getNextSibling();
	}
	
	@JSGetter("attributes")
	public Object getAttributes() {
		return delegateNode.getAttributes();
	}
	
	@JSGetter("ownerDocument")
	public Object getOwnerDocument() {
		return delegateNode.getOwnerDocument();
	}

	@JSFunction("insertBefore")
	public Object insertBefore(Object newNode, Object refNode) {
		return delegateNode.insertBefore(convertArg(newNode, Node.class), convertArg(refNode, Node.class));
	}

	@JSFunction("replaceChild")
	public Object replaceChild(Object newNode, Object refNode) {
		return delegateNode.replaceChild(convertArg(newNode, Node.class), convertArg(refNode, Node.class));
	}

	@JSFunction("removeChild")
	public Object removeChild(Object node) {
		return delegateNode.removeChild(convertArg(node, Node.class));
	}

	@JSFunction("appendChild")
	public Object appendChild(Object node) {
		return delegateNode.appendChild(convertArg(node, Node.class));
	}
	
	@JSFunction("hasChildNodes")
	public boolean hasChildNodes() {
		return delegateNode.hasChildNodes();
	}
	
	@JSFunction("cloneNode")
	public Object cloneNode(boolean deep) {
		return delegateNode.cloneNode(deep);
	}
	
	@JSFunction("normalize")
	public void normalize() {
		delegateNode.normalize();
	}
	
	@JSFunction("isSupported")
	public boolean isSupported(String feature, String version) {
		return delegateNode.isSupported(feature, version);
	}

	@JSGetter("namespaceURI")
	public String getNamespaceURI() {
		return delegateNode.getNamespaceURI();
	}
	
	@JSGetter("prefix")
	public String getPrefix() {
		return delegateNode.getPrefix();
	}
	
	@JSSetter("prefix")
	public void setPrefix(String prefix) {
		delegateNode.setPrefix(prefix);
	}
	
	@JSGetter("localName")
	public String getLocalName() {
		return delegateNode.getLocalName();
	}
	
	@JSFunction("hasAttributes")
	public boolean hasAttributes() {
		return delegateNode.hasAttributes();
	}
	
	@JSGetter("baseURI")
	public String getBaseURI() {
		return delegateNode.getBaseURI();
	}
	
	@JSFunction("compareDocumentPosition")
	public short compareDocumentPosition(Object node) {
		return delegateNode.compareDocumentPosition(convertArg(node, Node.class));
	}
	
	@JSGetter("textContent")
	public String getTextContent() {
		return delegateNode.getTextContent();
	}
	
	@JSSetter("textContent")
	public void setTextContent(String text) {
		delegateNode.setTextContent(text);
	}
	
	@JSFunction("isSameNode")
	public boolean isSameNode(Object node) {
		return delegateNode.isSameNode(convertArg(node, Node.class));
	}
	
	@JSFunction("lookupNamespaceURI")
	public String lookupNamespaceURI(String uri) {
		return delegateNode.lookupNamespaceURI(uri);
	}
	
	@JSFunction("isEqualNode")
	public boolean isEqualNode(Object node) {
		return delegateNode.isEqualNode(convertArg(node, Node.class));
	}
	
	@JSFunction("getFeature")
	public Object getFeature(String feature, String version) {
		return delegateNode.getFeature(feature, version);
	}

	@JSFunction("isDefaultNamespace")
	public boolean isDefaultNamespace(String namespaceURI) {
		return delegateNode.isDefaultNamespace(namespaceURI);
	}

	@JSFunction("lookupPrefix")
	public String lookupPrefix(String namespaceURI) {
		return delegateNode.lookupPrefix(namespaceURI);
	}

	@JSFunction("setUserData")
	public Object setUserData(String key, Object data, Object handler) {
		return delegateNode.setUserData(key, data, convertArg(handler, UserDataHandler.class));
	}

	@JSFunction("getUserData")
	public Object getUserData(String key) {
		return delegateNode.getUserData(key);
	}


	
	///// EventTarget interface: /////
	
	@JSFunction("addEventListener")
	public void addEventListener(String type, Object listener, boolean useCapture) {
		checkEventsSupported();
		if(listener instanceof Function) {
			listener = new JSFunctionEventListener(this, (Function)listener);
		}
		if(listener instanceof ScriptableEventListener) {
			listener = ((ScriptableEventListener)listener).getDelegateEventListener();
		}
		if(!(listener instanceof EventListener)) {
			throw new DOMException(DOMException.TYPE_MISMATCH_ERR, "Must supply an EventListener or JavaScript function object.");
		}
		((EventTarget)delegateNode).addEventListener(type, (EventListener)listener, useCapture);
	}
	
	@JSFunction("dispatchEvent")
	public boolean dispatchEvent(Object event) {
		checkEventsSupported();
		return ((EventTarget)delegateNode).dispatchEvent((Event)event);
	}
	
	@JSFunction("removeEventListener")
	public void removeEventListener(String type, Object listener, boolean useCapture) {
		checkEventsSupported();
		if(listener instanceof ScriptableEventListener) {
			listener = ((ScriptableEventListener)listener).getDelegateEventListener();
		}
		if(!(listener instanceof EventListener)) {
			throw new DOMException(DOMException.TYPE_MISMATCH_ERR, "Must supply an EventListener or JavaScript function object.");
		}
		((EventTarget)delegateNode).removeEventListener(type, (EventListener)listener, useCapture);
	}
	
	private void checkEventsSupported() {
		if(!(delegateNode instanceof EventTarget)) {
			throw new DOMException(DOMException.NOT_SUPPORTED_ERR, 
					"This DOM node does not support EventTarget interface methods.");
		}
	}
	
	private class JSFunctionEventListener implements EventListener {
		private ScriptableNode node;
		private Function function;
		
		public JSFunctionEventListener(ScriptableNode node, Function function) {
			this.node = node;
			this.function = function;
		}

		public void handleEvent(Event event) {
			function.call(Context.getCurrentContext(), getParentScope(), node, new Object[] {event});
		}
	}

}
