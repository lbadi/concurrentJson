package com.hufflepuff.domain;

public class Partners implements Comparable<Partners> {

	String actor1;
	String actor2;
	long appearances;

	public Partners(String actor1, String actor2) {
		this.actor1 = actor1;
		this.actor2 = actor2;
		appearances = 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actor1 == null) ? 0 : actor1.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partners other = (Partners) obj;
		if (actor1 == null) {
			if (other.actor1 != null)
				return false;
		} else if ((actor1.equals(other.actor1) && actor2.equals(other.actor2)) ||
				(actor1.equals(other.actor2) && actor2.equals(other.actor1)))
			return true;
		return false;
	}

	public void incAppearances() {
		appearances++;
	}

	public long getAppearances() {
		return appearances;
	}
}
