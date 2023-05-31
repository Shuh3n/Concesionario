package model;

import java.io.Serializable;

public class Suv extends Sedan implements Serializable{

	private boolean is4x4;

	public Suv() {
		super();
	}

	public Suv(boolean is4x4) {
		super();
		this.is4x4 = is4x4;
	}


	public boolean isIs4x4() {
		return is4x4;
	}

	public void setIs4x4(boolean is4x4) {
		this.is4x4 = is4x4;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (is4x4 ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suv other = (Suv) obj;
		if (is4x4 != other.is4x4)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+ "Suv [is4x4=" + is4x4 + "]";
	}






}
