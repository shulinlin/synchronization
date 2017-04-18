
public class Matrix {

	private double[] m;
	private int n;
	Matrix(int n){
		this.n = n;
		m = new double[n*n];
	}
	Matrix(double[] a,int n){
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
		int temp=0;
		for(int count=0;count<m1.n;count++){
			for(int i=0;i<m1.n;i++){
				for(int j=0;j<m1.n;j++){
					temp+=m[j+count*n]*m1.m[j*n+i];	
				}
				mn.m[i+count*n] = temp;
				temp = 0;
			}
		}

		return mn;
	}
	public Matrix inverse(){
		Matrix iden = new Matrix(n);
		for(int i=0;i<n;i++){
			iden.m[i*n+i] = 1;
		}
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				double pivot = m[i*n+i]/m[j*n+i];
				for(int col=0;col<n;col++){
					m[j*n+col]=m[j*n+col]*pivot-m[i*n+col];
					iden.m[j*n+col] = iden.m[j*n+col]*pivot-iden.m[i*n+col];
				}
			}
		}
		return iden;
	}
	public static void main(String[] args){
		double[] a = {0,1,2,3};
		double[] b = {1,2,3,4};
		Matrix m = new Matrix(a,2);
		
		Matrix m1 = new Matrix(b,2);
		m1.disp();
		System.out.println();
		Matrix m2 = m1.inverse();
		m2.disp();
	}
}
