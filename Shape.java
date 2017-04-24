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
//}
