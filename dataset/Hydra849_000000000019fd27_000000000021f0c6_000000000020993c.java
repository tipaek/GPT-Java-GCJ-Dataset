import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = Integer.parseInt(sc.nextLine().trim());
		
		for(int z=1;z<=t;z++) {
			int N = Integer.parseInt(sc.nextLine());
			int sum=0;
			int r=0;
			int c=0;
			int[][]matrix = new int[N][N];
			
			for(int i=0;i<N;i++) {
				
				String a = sc.nextLine();
				
				System.out.println(i);
				String[]b = a.split(" ");
				for(int j=0;j<N;j++) {
					
					matrix[i][j]=Integer.parseInt(b[j]);
					

				}
				sum+=matrix[i][i];
			}
			
			System.out.println();
			for(int i=0;i<N;i++) {
				
				if(!multiple(matrix[i])) {
					r++;
					
				}
			}
			
			for(int i=0;i<N;i++) {
				int[]check = new int[N];
				for(int j=0; j<N; j++){
					check[j] = matrix[j][i];
				}
				if(!multiple(check)) {
					c++;
				}
			}


			System.out.println("Case #"+z+": "+sum+" "+r+" "+c);
		}

	}

	public static boolean multiple(int[]check) {
		int[]check2 = Arrays.copyOf(check, check.length);
		Arrays.parallelSort(check2);
		for(int i=0;i<check2.length;i++) {
			
		}
		
		for(int i=1;i<check2.length;i++) {
			
			if(check2[i]==check2[i-1]) {
				
				return false;
			}
		}
		return true;
	}

}
