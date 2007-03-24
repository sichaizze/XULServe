package net.lojjic.xml.javascript.events;

import net.lojjic.rhino.annotations.JSClassName;
import net.lojjic.rhino.annotations.JSFunction;
import net.lojjic.rhino.annotations.JSGetter;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Context;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

/**
 * Scriptable wrapper for {@link org.w3c.dom.events.MouseEvent}
 */
@JSClassName("MouseEvent")
public class ScriptableMouseEvent extends ScriptableUIEvent {
	
	protected MouseEvent delegateMouseEvent;

	public ScriptableMouseEvent(Scriptable scope, MouseEvent event) {
		super(scope, event);
		this.delegateMouseEvent = event;
	}
	

	@JSGetter("altKey")
	public boolean getAltKey() {
		return delegateMouseEvent.getAltKey();
	}

	@JSGetter("button")
	public short getButton() {
		return delegateMouseEvent.getButton();
	}

	@JSGetter("clientX")
	public int getClientX() {
		return delegateMouseEvent.getClientX();
	}

	@JSGetter("clientY")
	public int getClientY() {
		return delegateMouseEvent.getClientY();
	}

	@JSGetter("ctrlKey")
	public boolean getCtrlKey() {
		return delegateMouseEvent.getCtrlKey();
	}

	@JSGetter("metaKey")
	public boolean getMetaKey() {
		return delegateMouseEvent.getMetaKey();
	}

	@JSGetter("relatedTarget")
	public Object getRelatedTarget() {
		return Context.javaToJS(delegateMouseEvent.getRelatedTarget(), getParentScope());
	}

	@JSGetter("screenX")
	public int getScreenX() {
		return delegateMouseEvent.getScreenX();
	}

	@JSGetter("screenY")
	public int getScreenY() {
		return delegateMouseEvent.getScreenY();
	}

	@JSGetter("shiftKey")
	public boolean getShiftKey() {
		return delegateMouseEvent.getShiftKey();
	}
	
	@JSFunction("initMouseEvent")
	public void initMouseEvent(String type, boolean canBubble, boolean cancelable, Object view,
			int detail, int screenX, int screenY, int clientX, int clientY, boolean ctrlKey, boolean altKey, 
			boolean shiftKey, boolean metaKey, short button, Object relatedTarget) {
		delegateMouseEvent.initMouseEvent(type, canBubble, cancelable, convertArg(view, AbstractView.class),
				detail, screenX, screenY, clientX, clientY, ctrlKey, altKey, shiftKey, metaKey,
				button, convertArg(relatedTarget, EventTarget.class));
	}

}
