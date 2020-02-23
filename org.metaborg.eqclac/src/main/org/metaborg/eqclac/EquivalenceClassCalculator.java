package org.metaborg.eqclac;

import java.util.HashSet;
import java.util.Set;

public final class EquivalenceClassCalculator {
	
	private EquivalenceClassCalculator() {
		
	}

	public static void main(String[] args) {
		
	}
	
	public static void calculate(Set<ResolutionPair> resolutionRelation) {
		//calculate reflexive closure
		//calculate symetric closure
		//calculate transitive closure
		//calculate equivalence classes
	}
	
	public static Set<NameIndex> gatherNameIndexes (Set<ResolutionPair> resolutionRelation) {
		Set<NameIndex> indexes = new HashSet<>();
		for(ResolutionPair pair: resolutionRelation) {
			indexes.add(pair.getDeclaration());
			indexes.add(pair.getReference());
		}
		return indexes;
	}

}
