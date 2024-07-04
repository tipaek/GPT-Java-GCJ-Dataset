import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++){
			int N = sc.nextInt();
			ArrayList<int[]> time = new ArrayList<int[]>();
			
			for(int j = 0; j < N; j++){
				time.add(new int[]{sc.nextInt(), sc.nextInt(), j});
			}

			Collections.sort(time, new Comparator<int[]>(){
	            @Override
	            public int compare(int[] x, int[] y) {
	                return (x[1] - y[1]);
	            }
	        });
			
			Collections.sort(time, new Comparator<int[]>(){
	            @Override
	            public int compare(int[] x, int[] y) {
	                return (x[0] - y[0]);
	            }
	        });
			
			System.out.print("Case #"+(i + 1)+": ");
			
			char[] result = new char[N];

			result[time.get(0)[2]] = 'C';
			int endC = time.get(0)[1];
			boolean C = false;
			int endJ = 0;
			boolean J = true;
			boolean flag = true;
			for(int j = 1; j < N; j++){
				int now = time.get(j)[0];
				if(now >= endC)C = true;
				if(now >= endJ)J = true;
				if(C){
					result[time.get(j)[2]] = 'C';
					endC = time.get(j)[1];
					C = false;
				}
				else if(J){
					result[time.get(j)[2]] = 'J';
					endJ = time.get(j)[1];
					J = false;
				}
				else{
					flag = false;
					break;
				}
			}
			if(!flag)System.out.println("IMPOSSIBLE");
			else{
				for(int j = 0; j < N; j++){
					System.out.print(result[j]);
				}
				System.out.println();
			}
		}
	}
}