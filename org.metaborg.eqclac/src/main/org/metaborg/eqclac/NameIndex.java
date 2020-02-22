package org.metaborg.eqclac;

public final class NameIndex {
	
	private final int numIndex;
	private final String path;
	
	public NameIndex(int numIndex, String path) {
		if (numIndex < 0 || path == null) {
			throw new IllegalArgumentException("Invalid constructor arguments.");
		}
		this.numIndex = numIndex;
		this.path = path;
	}

	public int getNumIndex() {
		return numIndex;
	}

	public String getPath() {
		return path;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof NameIndex)) {
			return false;
		}
		NameIndex other = (NameIndex) obj;
		
		if(other.getNumIndex() != this.numIndex) {
			return false;
		}
		
		if(!other.getPath().equals(this.path)) {
			return false;
		}
		
		return true;
	}

}
