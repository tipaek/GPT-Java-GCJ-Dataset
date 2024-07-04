import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++){
			int N = sc.nextInt();
			int trace =0;
			int r = 0;
			ArrayList<HashSet<Integer>> tot = new ArrayList<HashSet<Integer>>();
			for(int j = 0; j < N; j++){
				tot.add(new HashSet<Integer>());
			}
			for(int j = 0; j < N; j++){
				boolean doub = false;
				HashSet<Integer> items = new HashSet<Integer>();
				for(int k = 0; k < N; k++){
					int n = sc.nextInt();
					if(k==j){
						trace+=n;
					}
					if(items.contains(n))
						doub = true;
					tot.get(k).add(n);
					
				}
				if(doub){
					r++;
				}
			}
			int c = 0;
			for(int j = 0; j<N; j++){
				if(tot.get(j).size()<N){
					c++;
				}
			}
			System.out.println("Case #"+i+ ": "+trace+" " + r +" " + c );
		}
		sc.close();
	}

}
