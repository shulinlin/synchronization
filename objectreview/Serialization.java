package objectreview;

import java.io.*;


public class Serialization {
	public static void main(String[] args) throws Exception{
		A a1 = new A("Tom",26);
		FileOutputStream fos = new FileOutputStream("F:\\test.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(a1);
		oos.close();
		fos.close();
		System.out.println("Serialization is completed !");
	}
}
