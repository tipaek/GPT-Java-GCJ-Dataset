   import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Google_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		int N;
		int[][] matrix;
		int k=0;
		int r=0;
		int c=0;
		HashSet<Integer> rm = new HashSet<Integer>();
		for(int i=1;i<=T;i++){
			N = sc.nextInt();
			matrix = new int[N][N];
			for(int j1=0;i<N;j1++){
				for(int j2=0;i<N;j2++){
					matrix[j1][j2]=sc.nextInt();
				}
			}
			for(int l1=0;l1<N;l1++){
				k=k+matrix[l1][l1];
			}
			
			for(int j1=0;i<N;j1++){
				for(int j2=0;i<N;j2++){
					if(rm.add(matrix[j1][j2])==false){
						r++;
						rm.clear();
						break;
					}
				}
			}
			rm.clear();
			for(int j1=0;i<N;j1++){
				for(int j2=0;i<N;j2++){
					if(rm.add(matrix[j2][j1])==false){
						c++;
						rm.clear();
						break;
					}
				}
			}
			rm.clear();
			System.out.println("Case #"+T+": "+k+" "+r+" "+c);
		}

	}

}
