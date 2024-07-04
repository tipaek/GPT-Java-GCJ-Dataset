import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 public class Main {
public static void main (String args[]){
Scanner sc = new Scanner ();
 int l= sc.nextInt();
for (int k = 0;  k<l  ;k++){
	//System.out.println("1" );

	int n = sc.nextInt(); 
	int c =0 ;
	int r =  0; 
	int[][] h = new int [n+1][n+1];
	int[][] p = new int [n+1][n+1];

	for (int i =0 ;i<n;i++){
		boolean f =false ; 
		for (int j=0;j<n;j++){
			
			int temp = sc.nextInt();
		//	System.out.print(temp+"  ");
			h[i][temp]++;
			p[temp][j]++;
			if (j ==c && !f){
				r+=temp;
				c++;
				f=true; 
			}
			
			
		}

		}
//for (int i = 0 ;i<n+1;i++)
//	System.out.println(Arrays.toString(h[i]));

	int row = 0 ; 
	int col =0 ;
	for (int i =0 ;i<n+1;i++){
		boolean f =false ;

		 for (int j=0;j<n+1;j++){
			if (h[i][j]>1) {row ++; f = true;}
			if (f)break ;
		}

		}
	for (int i =0 ;i<n+1;i++){
		boolean f =false ;

		 for (int j=0;j<n+1;j++){
			if (p[j][i]>1) {col ++; f = true;}
			if (f)break ;
		}

		}
	System.out.println("Case #"+(k+1)+": "+ r+" "+ row+" "  +col );


	}
 
	
 
}
 }
 
class Scanner {
	BufferedReader br;
	StringTokenizer st;

	public Scanner(String s) {
		try {
			br = new BufferedReader(new FileReader(s));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Scanner() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String nextToken() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}
}
