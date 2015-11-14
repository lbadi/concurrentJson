package com.hufflepuff.domain;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;

import java.io.IOException;

public class Partners implements DataSerializable {

	String actor1;
	String actor2;
	int appearances;

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

	public int getAppearances() {
		return appearances;
	}

	public String getActor1() {
		return actor1;
	}

	public String getActor2() {
		return actor2;
	}

	public void setActor1(String actor1) {
		this.actor1 = actor1;
	}

	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}

	public void setAppearances(int appearances) {
		this.appearances = appearances;
	}

	@Override
	public void writeData(ObjectDataOutput out) throws IOException {
		out.writeUTF(actor1);
		out.writeUTF(actor2);
		out.writeUTF(String.valueOf(appearances));
	}

	@Override
	public void readData(ObjectDataInput in) throws IOException {
		actor1 = in.readUTF();
		actor2 = in.readUTF();
		appearances = Integer.valueOf(in.readUTF());
	}
}
