package net.lojjic.xul.javascript;

import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public abstract class ScriptableDOMObject extends ScriptableObject {

	public static String JS_CLASS_NAME;
	
	public ScriptableDOMObject(Scriptable scope) {
		super(scope, getClassPrototype(scope, JS_CLASS_NAME));
	}

	@Override
	public String getClassName() {
		return JS_CLASS_NAME;
	}

}