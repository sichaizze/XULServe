package net.lojjic.xml.javascript.views;

import net.lojjic.rhino.annotations.JSClassName;
import net.lojjic.rhino.annotations.JSGetter;
import net.lojjic.xml.javascript.ScriptableDOMObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Context;
import org.w3c.dom.views.AbstractView;

/**
 * Scriptable wrapper for {@link org.w3c.dom.views.AbstractView}
 */
@JSClassName("AbstractView")
public class ScriptableAbstractView<T extends AbstractView> extends ScriptableDOMObject<T> {

	public ScriptableAbstractView() {
		super();
	}

	public ScriptableAbstractView(Scriptable scope, T abstractView) {
		super(scope, abstractView);
	}

	@JSGetter("document")
	public Object getDocument() {
		return Context.javaToJS(unwrap().getDocument(), getParentScope());
	}

}
