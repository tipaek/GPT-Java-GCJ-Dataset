
import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	
	public static void main (String args[]) {
	Scanner inp = new Scanner(System.in);
	int T = inp.nextInt();
	for(int t = 0 ;t < T; t++) {
		int  N = inp.nextInt();
		int arr [] [] = new int [N][N];
		int c= 0; 
		int r = 0; 
		int k = 0;
		for(int i = 0 ; i <N ;i++) {
			for(int j=0 ; j<N; j++) {
				arr[i][j]=inp.nextInt();
				if(i==j) {
					k+=arr[i][j];
				}
			}
		}
		
		//For rows
		int ar [] = new int [N];
		for(int i = 0 ; i <N; i++) {
			boolean ok = true;
			for(int j = 0 ; j <N; j++) {
				ar[j] = arr[i][j];
			}
			Arrays.sort(ar);
			for(int j =0 ;j<N;j++) {
				if((j+1)!=ar[j]){
					ok = false;
					j=N+1;
					r++;
				}
			}
		}
		
		//For cols
		for(int i = 0 ; i <N; i++) {
			boolean ok = true;
			for(int j = 0 ; j <N; j++) {
				ar[j] = arr[j][i];
			}
			Arrays.sort(ar);
			for(int j =0 ;j<N;j++) {
				if((j+1)!=ar[j]){
					ok = false;
					j=N+1;
					c++;
				}
			}
		}
		
		System.out.println("Case #"+ (t+1) + ": " +k +" "+ r+" "+ c);
	}
		
	}

}