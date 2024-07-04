package Package_Practice;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class codeJam1 {
	
	static int count(int a[], int n) {
		int c = 0;
		for(int i = 0 ; i<a.length; i++) {
			if(a[i]==n) {
				c+=1;
			}
		}
		return c;
	}
	
	static int trace(int a[][]) {
		int rows = a.length;
		int s = 0;
		for(int i = 0; i<rows ; i++) {
			s = s+a[i][i];
		}
		return s;
	}
	
	static int no_of_rows(int a[][]) {
		int r = 0;
		for(int i = 0 ; i<a.length ; i++) {
			for(int j = 0 ; j<a.length ; j++) {
				if(count(a[i],j+1)>1) {
					r+=1;
					break;
				}
			}
		}
		return r;
	}
	
	static int[][] transpose(int a[][]){
		int n = a.length;
		int b[][] = new int[n][n];
		for(int i = 0 ; i<n ; i++) {
			for(int j = 0 ; j<n ; j++) {
				b[i][j] = a[j][i];
			}
		}
		return b;	
	}
	
	static int no_of_columns(int a[][]) {
		int col = 0;
		for(int i = 0 ; i<a.length ; i++) {
			for(int j = 0 ; j<a.length ; j++) {
				a = transpose(a);
				if(count(a[i],j+1)>1) {
					col=col+1;
					break;
				}
			}
		}
		return col;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		String s = reader.readLine();// no of test cases
		int n = Integer.parseInt(s);
		for(int i = 0 ; i<n ; i++) {
			String s1 = reader.readLine();
			int N = Integer.parseInt(s1);
			int a[][] = new int[N][N];
			for(int j = 0 ; j<N ; j++) {
				String s2 = reader.readLine();
				String s3[] = s2.split(" ");
				for(int k = 0 ; k<N ; k++) {
					a[j][k] = Integer.parseInt(s3[k]);
				}
			}
			System.out.println("Case #"+(i+1)+": "+trace(a)+" "+no_of_rows(a)+" "+no_of_columns(a));
		}	
	}

}
