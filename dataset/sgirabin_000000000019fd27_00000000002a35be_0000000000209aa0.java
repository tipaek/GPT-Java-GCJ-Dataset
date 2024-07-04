import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Solution {
    	private Scanner scanner;
	private PrintWriter writer;

	public Solution(InputStream in, OutputStream out) {
		scanner = new Scanner(in);
		writer = new PrintWriter(out);
	}
	
	public void reverse(int[] arr, int start, int  end) {
		while (start<end) {
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}
	
	public  void rotate(int[] arr, int n) {
		if (n>0) {
			n = n%arr.length;
			reverse(arr, 0, n-1);
			reverse(arr, n, arr.length-1);
			reverse(arr, 0, arr.length-1);
		}
	}
	
	public void solve() {

		String positive = "POSSIBLE";
		String negative = "IMPOSSIBLE";
		String result   = "";
		
		int T = scanner.nextInt();
        for (int i=0;i<T;i++) {
            
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[][] matrix = new int[N][N];
            
            int[] base = new int[N];
            for (int j=0;j<N;j++) {
            	base[j]=j+1;
            }
            
            int trace=0;
            int max = N; 
            int  count=0;
            while (count < max  &&  trace != K) {
                for (int j=0;j<N;j++) {
                	rotate(base,1);
                	for (int k=0;k<N;k++) {
                		matrix[j][k]=base[k];
                		
                		if (j==k) {
                			trace = trace + matrix[j][k];
                		}
                	}
                }
                count = count + 1;
            }

            if  (trace == K) {
            	result = positive;
            }else {
            	result = negative;
            }

            writer.printf("Case #%d: %s%n",i+1, result);
            if (result.equalsIgnoreCase(positive)) {
                for (int j=0;j<N;j++) {
                	for (int k=0;k<N;k++) {
                		writer.printf("%d ", matrix[j][k]);
                	}
                	writer.println();
                }            	
            }
            
        }
        writer.flush();
        writer.close();
	}


	public static void main(String[] args) {
    	Solution solution = new Solution(System.in, System.out);
        solution.solve();
    }
}