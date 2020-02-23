package org.metaborg.eqclac;

import java.util.Objects;

public final class ResolutionPair {
	
	private final NameIndex reference;
	private final NameIndex declaration;
	
	public ResolutionPair(NameIndex reference, NameIndex declaration) {
		if (reference == null || declaration == null) {
			throw new IllegalArgumentException("Invalid constructor arguments.");
		}
		this.reference = reference;
		this.declaration = declaration;
	}

	public NameIndex getReference() {
		return reference;
	}

	public NameIndex getDeclaration() {
		return declaration;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ResolutionPair)) {
			return false;
		}
		
		ResolutionPair other = (ResolutionPair) obj;
		
		if(!other.getReference().equals(this.reference)) {
			return false;
		}
		
		if(!other.getDeclaration().equals(this.declaration)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(reference, declaration);
	}

}
