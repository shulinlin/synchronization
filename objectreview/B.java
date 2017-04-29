package objectreview;
public class B implements Cloneable{
	private String name;
	private int age;
	private boolean sex;
	public B(){}
	public B(String name,int age,boolean sex){
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public void setname(String name){
		this.name = name;
	}
	public B clone(){
		return new B(name,age,sex);
	}
	public String toString(){
		return "I am "+name+" and "+age+" years old,boy "+sex;
	}
}
