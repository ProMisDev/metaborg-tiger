package org.metaborg.eqclac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResolutionPairTest {

	@Test
	void testEqual() {
		NameIndex ref1 = new NameIndex(2, "foo");
		NameIndex dec1 = new NameIndex(1, "foo");
		ResolutionPair pair1 = new ResolutionPair(ref1, dec1);
		
		NameIndex ref2 = new NameIndex(2, "foo");
		NameIndex dec2 = new NameIndex(1, "foo");
		ResolutionPair pair2 = new ResolutionPair(ref2, dec2);
		
		assertEquals(pair1, pair2);
	}
	
	@Test
	void testNotEqualRef() {
		NameIndex ref1 = new NameIndex(2, "foo");
		NameIndex dec1 = new NameIndex(1, "foo");
		ResolutionPair pair1 = new ResolutionPair(ref1, dec1);
		
		NameIndex ref2 = new NameIndex(3, "bar");
		NameIndex dec2 = new NameIndex(1, "foo");
		ResolutionPair pair2 = new ResolutionPair(ref2, dec2);
		
		assertNotEquals(pair1, pair2);
	}
	
	@Test
	void testNotEqualDec() {
		NameIndex ref1 = new NameIndex(2, "foo");
		NameIndex dec1 = new NameIndex(1, "foo");
		ResolutionPair pair1 = new ResolutionPair(ref1, dec1);
		
		NameIndex ref2 = new NameIndex(2, "foo");
		NameIndex dec2 = new NameIndex(3, "foo");
		ResolutionPair pair2 = new ResolutionPair(ref2, dec2);
		
		assertNotEquals(pair1, pair2);
	}
	
	@Test
	void testNotEqualType() {
		NameIndex ref = new NameIndex(2, "foo");
		NameIndex dec = new NameIndex(1, "foo");
		ResolutionPair pair = new ResolutionPair(ref, dec);
		
		String otherType = "foo";
		assertNotEquals(pair, otherType);
	}
	
	@Test
	void testInvalidRef() {
		 assertThrows(IllegalArgumentException.class, () -> {
				NameIndex index = new NameIndex(1, "foo");
				new ResolutionPair(null, index);
			  });
		
	}
	
	@Test
	void testInvalidDec() {
		 assertThrows(IllegalArgumentException.class, () -> {
				NameIndex index = new NameIndex(1, "foo");
				new ResolutionPair(index, null);
			  });
		
	}
	
	@Test
	void testHashCode() {
		NameIndex ref1 = new NameIndex(2, "foo");
		NameIndex dec1 = new NameIndex(1, "foo");
		ResolutionPair pair1 = new ResolutionPair(ref1, dec1);
		
		NameIndex ref2 = new NameIndex(2, "foo");
		NameIndex dec2 = new NameIndex(1, "foo");
		ResolutionPair pair2 = new ResolutionPair(ref2, dec2);
		
		assertEquals(pair1.hashCode(), pair2.hashCode());
		
	}
	
	@Test
	void testToString() {
		NameIndex ref = new NameIndex(2, "foo");
		NameIndex dec = new NameIndex(1, "foo");
		ResolutionPair pair = new ResolutionPair(ref, dec);
		
		assertEquals(pair.toString(), "ResolutionPair(NameIndex(foo, 2), NameIndex(foo, 1))");
	}

}
