package main.java.com.example.ec.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TourPackage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String code;
	
	@Column
	private String name;
	
	protected TourPackage() {
	}
	
	public TourPackage(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "TourPackagee{code='" + code + "\', name='" + name + "\'}" ;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o ) return true;
		return false;
	}
}