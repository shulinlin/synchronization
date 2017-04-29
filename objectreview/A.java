package objectreview;

import java.io.*;
import java.util.Locale;

public class A implements Serializable{
	private String name;
	private int age;
	public int SSN = 1002;
	private boolean sex;
	public A(){}
	public A(String name,int age){
		this.name = name;

		this.age = age;
	}
	public String toString(){
		return name+" "+age;
	}

}
