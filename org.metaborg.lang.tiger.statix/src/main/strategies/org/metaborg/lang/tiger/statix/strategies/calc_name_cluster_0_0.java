package org.metaborg.lang.tiger.statix.strategies;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.metaborg.eqclac.NameGraph;
import org.metaborg.eqclac.NameIndex;
import org.spoofax.interpreter.core.Tools;
import org.spoofax.interpreter.terms.IStrategoList;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;
import org.strategoxt.lang.Context;
import org.strategoxt.lang.Strategy;
import org.strategoxt.stratego_lib.debug_0_0;

public class calc_name_cluster_0_0 extends Strategy {

	public static calc_name_cluster_0_0 instance = new calc_name_cluster_0_0();

	@Override
	public IStrategoTerm invoke(Context context, IStrategoTerm current) {		
		List<IStrategoTerm> resolutionRelation = Tools.asJavaList(current.getSubterm(1));
		NameIndex selectedOccurrence = new NameIndex(current.getSubterm(0));
		NameGraph nameGraph = new NameGraph(resolutionRelation);
		
		Set<NameIndex> cluster = nameGraph.find(selectedOccurrence).get();		
		ITermFactory factory = context.getFactory();
		IStrategoList targetIndices = factory.makeList(
				cluster
				.stream()
				.map(term -> term.getTermIndex())
				.collect(Collectors.toList()));
		
		return targetIndices;
	}
	
	private void debug(Context context, String message) {
		ITermFactory factory = context.getFactory();
		String debugMessage = "JAVA DEBUG: " + message;
		IStrategoTerm debugTerm = factory.makeString(debugMessage);
		debug_0_0.instance.invoke(context, debugTerm);
	}
}

