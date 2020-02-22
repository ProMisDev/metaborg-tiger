package org.metaborg.eqclac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NameIndexTest {

	@Test
	void testEqual() {
		NameIndex index1 = new NameIndex(1, "foo");
		NameIndex index2 = new NameIndex(1, "foo");
		assertTrue(index1.equals(index2));
	}
	
	@Test
	void testNotEqualNumIndex() {
		NameIndex index1 = new NameIndex(1, "foo");
		NameIndex index2 = new NameIndex(2, "foo");
		assertFalse(index1.equals(index2));
	}
	
	@Test
	void testNotEqualPath() {
		NameIndex index1 = new NameIndex(1, "foo");
		NameIndex index2 = new NameIndex(1, "bar");
		assertFalse(index1.equals(index2));
	}
	
	@Test
	void testNotEqualType() {
		NameIndex index = new NameIndex(1, "foo");
		String otherType = "foo";
		assertFalse(index.equals(otherType));
	}
	
	@Test
	void testInvalidNumIndex() {
		 assertThrows(IllegalArgumentException.class, () -> {
			 new NameIndex(-1, "foo");
			  });
		
	}
	
	@Test
	void testInvalidPath() {
		 assertThrows(IllegalArgumentException.class, () -> {
			 new NameIndex(1, null);
			  });
		
	}
}
