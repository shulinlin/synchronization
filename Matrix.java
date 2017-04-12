
public class Matrix {

	private int[] m;
	private int n;
	Matrix(int n){
		this.n = n;
		m = new int[n*n];
	}
	Matrix(int[] a,int n){
		m=a;
		this.n = n;
	}
	public void disp(){
		int row,col;
		for(row=0;row<n;row++){
			for(col=0;col<n;col++){
				System.out.print(m[row*n+col]+" ");
			}
			System.out.println();	
		}
	}
	public Matrix mul(Matrix m1){
		Matrix mn = new Matrix(m1.n);
		for(int i=0;i<m1.n;i++){
			for(int j=0;j<m1.n;j++){
				mn.m[j*n+i]+=m[j*n+i]*m1.m[j*n+i];
			}
		}
		return mn;
	}
	public static void main(String[] args){
		int[] a = {0,1,2,3};
		int[] b = {1,2,3,4};
		Matrix m = new Matrix(a,2);
		Matrix m1 = new Matrix(b,2);
		Matrix m2 = m.mul(m1);
		m2.disp();
	}
}
