

import java.util.*;

public class Solution {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		
		for(int t=0; t<T; t++){
			int N = Integer.parseInt(sc.next());
			StringBuilder ans = new StringBuilder();
			int finish_C = 0;
			int finish_J = 0;
			boolean enable = true;
			int[][] tasks = new int[N][2];
			for(int i=0; i<N; i++){
				tasks[i][0] = Integer.parseInt(sc.next());
				tasks[i][1] = Integer.parseInt(sc.next());
			}
			Arrays.sort(tasks, (a,b) -> Integer.compare(a[0], b[0]));
			
			for(int[] task : tasks){
				if(finish_C <= task[0]){
					finish_C = task[1];
					ans.append("C");
				}else if(finish_J <= task[0]){
					finish_J = task[1];
					ans.append("J");
				}else{
					enable = false;
					break;
				}
			}
			
			System.out.println("Case #"+(t+1)+": "+ (enable? ans : "IMPOSSIBLE"));
		}
		
		
		sc.close();
		return;
	}
	

	
}
