<<<<<<< HEAD
import java.awt.Graphics;

public abstract class Shape {
	protected int x,y;
	
	public Shape(int x, int y) { this.x = x; this.y = y; }
	
	public abstract void draw(Graphics g) ;	
	public void translate(int dx,int dy){
		x+=dx;
		y+=dy;
	}
	public abstract Rectangle boundingbox();
}
class Circles extends Shape{
	private int r;

	public Circles(int x, int y,int r) {
		super(x, y);
		this.r = r;
	}

	public void draw(Graphics g) {
		g.drawOval(x, y, r, r);
	}

	public Rectangle boundingbox() {
		return new Rectangle(x-r,y-r,2*r,2*r);
	}
	
}
class Rectangle extends Shape{
	private int width,height;
	public Rectangle(int x,int y,int width,int height){
		super(x,y);
		this.width = width;
		this.height = height;
	}
	@Override
	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
		
	}
	@Override
	public Rectangle boundingbox() {
		return this;
	}
	
	
}
//class Line extends Shape{
//	private int x2,y2;
//	public Line(int x,int y,int x2,int y2){
//		super(x,y);
//		this.x2 = x2;
//		this.y2 = y2;
//		
//	}
//	@Override
//	public void draw(Graphics g) {
//		// TODO Auto-generated method stub
//		g.drawLine(x, y, x2, y2);
//	}
//	@Override
//	public Rectangle boundingbox() {
//		// TODO Auto-generated method stub
//		return new Rectangle(x,y,(x2-x),(y2-y));
//	}
=======
//import java.awt.Graphics;
//
//public abstract class Shape {
//	protected int x,y;
//
//	public Shape(int x, int y) { this.x = x; this.y = y; }
//
//	public abstract void draw(Graphics g) ;	
//	public void translate(int dx,int dy){
//		x+=dx;
//		y+=dy;
//	}
//	public abstract Rectangle boundingbox();
//}
//class Circles extends Shape{
//	private int r;
//
//	public Circles(int x, int y,int r) {
//		super(x, y);
//		this.r = r;
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public void draw(Graphics g) {
//		// TODO Auto-generated method stub
//		g.drawOval(x, y, r, r);
//	}
//
//	@Override
//	public Rectangle boundingbox() {
//		// TODO Auto-generated method stub
//		return new Rectangle();
//	}
//
//}
//class Rectangle extends Shape{
//
>>>>>>> 62c54fd7d09f887b05690a77604a75978c0b2a47
//}
