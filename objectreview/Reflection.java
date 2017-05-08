package objectreview;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.*;

public class Reflection extends D {

	public static void main(String[] args){
//		B b1 = new B("tom",25,true);
//		Method[] m = b1.getClass().getMethods();
//		for(int i=0;i<m.length;i++){
//			System.out.println(m[i]);
//		}
		String[] str = new String[8];
		String[] str1 = str.clone();
		ArrayList<Integer> arr = new ArrayList<Integer>();
//		for(int i=0;i<100;i++)
//			arr.add(i);
		ListIterator ite =  arr.listIterator();
//	long t1 =System.nanoTime();
		for(int i=0;i<100;i++){
			ite.add(i);
//			ite.nextIndex();
		}
//		System.out.println();
//		System.out.println(ite.nextIndex());
		ListIterator ite1 =  arr.listIterator(10);
//		System.out.println(ite1.nextIndex());
//		System.out.println(ite1.hasNext());
		ite1.add(-20);
//		for(int i=0;i<98;i++){
//			ite1.next();
//		}
//		System.out.println(ite1.hasNext());
//		System.out.println(ite1.nextIndex());
		for(ListIterator<Integer> st = arr.listIterator();st.hasNext();){
			System.out.print(st.next()+" ");
		}
//		long t2=System.nanoTime();
//		System.out.println(t2-t1);
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
//		long t3=System.nanoTime();
		for(int i=0;i<100;i++)
			arr1.add(i);
//		long t4 = System.nanoTime();
//		System.out.println(t4-t3);
//		for(int i:arr)
//			System.out.print(i+" ");
	}
}
