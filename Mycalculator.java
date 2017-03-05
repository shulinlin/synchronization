/*
 * This calculator program is designed by Gade Aditya,Yu Luo and Shulin Yang. 
 * In this program, we've designed several basic operations of numbers. 
 * We use two stacks to store the input number values and operation sign, 
 * our calculator also takes operation priority into consideration. More details about 
 * the program are as below:
 * Operation function			Gade Aditya
 * Display function				Yu Luo
 * Calculator frame create		Shulin Yang
 * components Merge and debug	Yu Luo ,Shulin Yang
 * Copyright Reserved 
 * 
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.*;
public class Mycalculator extends JFrame implements ActionListener{
	JTextField text = new JTextField(30);
	/*
	 * the follow array is to name the buttons and I have put some space for extra function
	 */
	final double PI =3.1415926;
	String data1;
	String input;
	boolean first = true;
	boolean dot = false;
	Stack data = new Stack();
	Stack operation = new Stack();
	String[] name={"7","8","9","X","4","5","6","/","1","2","3","+","0",".","=","-"};
	JButton[] b  = new JButton[20];
	JButton ce = new JButton("CE");     //  modify the last input number
	JButton clear = new JButton("C");   //   to clear all the numbers inputed
	public Mycalculator(){
		super("calculator");
		setSize(600,600);
		JPanel p1 = new JPanel(new GridLayout(4,4));
		JPanel p2 = new JPanel();
		Container c = this.getContentPane();	
		for(int i = 0;i<name.length;i++){
			b[i] = new JButton(name[i]);
			p1.add(b[i]);
		}
		p2.add("West", text);
		p2.add("East",ce); 
		p2.add("East",clear);
		c.add("Center",p1);
		c.add("North",p2);
		for(int i=0;i<name.length;i++){
			b[i].addActionListener(this);
		}
		clear.addActionListener(this);
		text.addActionListener(this);
		ce.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		text.setText("0");
		text.setHorizontalAlignment(JTextField.RIGHT);
		text.setEditable(false);
	}
	public int getprior(String s){
		if(s.equals("="))
			return 0;
		else if(s.equals("+")||s.equals("-"))
			return 1;
		else return 2;
	}

	/*
	 * operation function including "+,-,*,/"
	 */
	public void sum(double a,double b){
		//System.out.println("peek2 = "+data.peek()+" ");
		double sum = a+b;
		data.push(sum);
	}

	public void sub(double a,double b){
		double sub = a-b;
		data.push(sub);
	}

	public void multi(double a,double b){
		double multi = a*b;
		data.push(multi);
	}


	public void div(double a,double b){
		double div = a/b;
		data.push(div);
	}

	/*
	 *  main funtion to create the window
	 */
	public static void main(String[] args){
		Mycalculator t = new Mycalculator();
	}

	/*
	 * operations to do after the button is clicked
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		data1 = e.getActionCommand();
		if("0123456789.".indexOf(data1)>=0){       //  check if the button's label is numbers
			if(first){
				if(!dot&&data1.equals(".")){
					input = "0.";
					dot = true;
					data.push(input);
					first = false;
				}
				input = data1;
				data.push(input);
				first = false;
				text.setText(data.peek().toString());
			}
			else{                            //    below are the operations of buttons whose label is not numbers 
				if(data1.equals(".")){
					if(dot){
						return;
					}
				}
					input+=data1;
					data.pop();
					data.push(input);
					text.setText(data.peek().toString());

				}
			}
/*
 *   From then on, this part is used to identify different operational button
 */
		else if(data1.equals("C")){
			while(!data.isEmpty()){
				data.pop();
			}
			while(!operation.isEmpty()){
				operation.pop();
			}
			text.setText("0");
			first = true;
		}
		else if(data1.equals("CE")){
			text.setText("0");
			first = true;
		}
		else{
			first = true;
			if(operation.empty()){
				if(data1.equals("=")){
					return;
				}
				operation.push(data1);
				return;
			}

			if(getprior(data1)>getprior(operation.peek().toString())){
				operation.push(data1);
				return;
			}
			else{
				/*
				 * This part is to decide which operation should be used to calculate the numbers
				 */
				while(!operation.isEmpty()&&getprior(data1)<getprior(operation.peek().toString())){

//					System.out.print("peek = "+data.peek()+" ");
					String op = operation.pop().toString();
					double b = Double.parseDouble(data.pop().toString());
					double a = Double.parseDouble(data.pop().toString());
//					System.out.print(a+" "+b+" ");
					if(op.equals("+")){
						sum(a,b);
						text.setText(data.peek().toString());
					}
					else if(op.equals("-")){
						sub(a,b);
						text.setText(data.peek().toString());

					}
					else if(op.equals("X")){
						multi(a,b);
						text.setText(data.peek().toString());

					}
					else if(op.equals("/")){
						div(a,b);
						text.setText(data.peek().toString());

					}
					else continue;
				}
			}
			operation.push(data1);                   //   push the latest operation sign in stack operation
		}
	}
}
