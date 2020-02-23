package org.metaborg.eqclac;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class EquivalenceClassCalculatorTest {

	@Test
	void testGatherNameIndexes() {
		NameIndex ref1 = new NameIndex(2, "foo");
		NameIndex dec1 = new NameIndex(1, "foo");
		ResolutionPair pair1 = new ResolutionPair(ref1, dec1);
		
		NameIndex ref2 = new NameIndex(2, "foo");
		NameIndex dec2 = new NameIndex(3, "foo");
		ResolutionPair pair2 = new ResolutionPair(ref2, dec2);
		
		Set<ResolutionPair> resolutionRelation = new HashSet<>();
		resolutionRelation.add(pair1);
		resolutionRelation.add(pair2);
		
		Set<NameIndex> indexes = EquivalenceClassCalculator.gatherNameIndexes(resolutionRelation);
		assertEquals(indexes.size(), 3);
	}

}
