package objectreview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.*;


interface E{
	
	public void f();
}
public class Anonymous {
	
	public static void main(String[] args) throws Exception{ 
//		JButton b1 = new JButton();
//		b1.addActionListener((new E() {
//			
//			@Override
//			public void f() {
//				// TODO Auto-generated method stub
//				System.out.print("hello");
//			}
//			
//		
//		});
		HashMap<String,Integer> sh = new HashMap<String,Integer>();
		LinkedList<Integer> lk = new LinkedList<Integer>();
		for(int i=0;i<10;i++)
		lk.add(i);
		ListIterator<Integer> list = lk.listIterator();
		while(list.hasNext()){
			System.out.print(list.next()+" ");
		}
//		int i=0;
//		System.out.println(false&&(i++)==2);
//		System.out.println(i);
//		System.out.println(false&&true||true);
//		System.out.println(true||true&&false);
	}
}
