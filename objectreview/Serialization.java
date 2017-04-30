package objectreview;

import java.io.*;


public class Serialization {
	public static void main(String[] args) throws Exception{
		A a1 = new A("Tom",26);
		A a2 = new A();
		a2.setAge(20);
		a2.setName("zhoumiming");
		a2.setSex(true);
		FileOutputStream fos = new FileOutputStream("F:\\test.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(a2);
		oos.close();
		fos.close();
		System.out.println("Serialization is completed !");
	}
}
