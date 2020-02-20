package org.metaborg.lang.tiger.refactoring.strategies;

import org.strategoxt.lang.JavaInteropRegisterer;
import org.strategoxt.lang.Strategy;

public class InteropRegisterer extends JavaInteropRegisterer {
	public InteropRegisterer() {
		super(new Strategy[] { calc_eq_classes_0_0.instance });
	}
}
