import java.util.ArrayList;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++){
			int N = sc.nextInt();
			int p1 = 0;
			int p2 = 0;
			char[] res = new char[N];
			ArrayList<ArrayList<Integer>> activ = new ArrayList<ArrayList<Integer>>();
			for(int j = 0; j < N; j++){
				int start = sc.nextInt();
				int end = sc.nextInt();
				ArrayList<Integer> a = new ArrayList<Integer>();
				a.add(start);
				a.add(end);
				a.add(j);
				activ.add(a);
			}
			activ.sort((l1, l2) -> l1.get(0).compareTo(l2.get(0)));
			//System.out.println(activ);
			boolean breaks = false;
			for(int j = 0; j < N; j++){
				ArrayList<Integer> a = activ.get(j);
				if(p1<p2){
					if(a.get(0) < p1){
						System.out.println("Case #"+i+ ": "+ "IMPOSSIBLE");
						breaks = true;
						break;
					}else{
						p1 = a.get(1);
						res[a.get(2)] = 'C';
					}
				}else{
					if(a.get(0) < p2){
						System.out.println("Case #"+i+ ": "+ "IMPOSSIBLE");
						breaks = true;
						break;
					}else{
						p2 = a.get(1);
						res[a.get(2)] = 'J';
					}
				}
				
			}
			if(!breaks){
				StringBuilder sb = new StringBuilder();
				for(char c: res){
					sb.append(c);
				}
				System.out.println("Case #"+i+ ": "+sb.toString());
			}
		}
		sc.close();
	}

}
