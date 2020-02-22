package org.metaborg.eqclac;

public final class NameIndex {
	
	private final int numIndex;
	private final String fileName;
	
	public NameIndex(int numIndex, String fileName) {
		this.numIndex = numIndex;
		this.fileName = fileName;
	}

	public int getNumIndex() {
		return numIndex;
	}

	public String getFileName() {
		return fileName;
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
		
		if(!other.getFileName().equals(this.fileName)) {
			return false;
		}
		
		return true;
	}

}
