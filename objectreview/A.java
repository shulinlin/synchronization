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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSSN() {
		return SSN;
	}
	public void setSSN(int sSN) {
		SSN = sSN;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String toString(){
		return name+" "+age;
	}

}
