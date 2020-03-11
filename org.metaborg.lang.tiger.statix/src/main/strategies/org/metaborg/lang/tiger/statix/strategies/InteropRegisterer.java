package org.metaborg.lang.tiger.statix.strategies;

import org.strategoxt.lang.JavaInteropRegisterer;
import org.strategoxt.lang.Strategy;

public class InteropRegisterer extends JavaInteropRegisterer {
	public InteropRegisterer() {
		super(new Strategy[] { calc_name_cluster_0_0.instance });
	}
}
