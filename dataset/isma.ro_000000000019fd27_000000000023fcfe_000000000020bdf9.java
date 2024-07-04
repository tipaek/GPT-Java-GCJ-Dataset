import java.util.Scanner;
import java.util.*;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int N= in.nextInt();
			int [][] task= new int[N][3];
			Map<Integer, Integer> m = new TreeMap<Integer,Integer>();
			for (int j = 0; j < N; j++) {
				task[j][0]=in.nextInt();
				task[j][1]=in.nextInt();
				m.put(task[j][0], task[j][1]);
			}
			String sol ="";
			int j=0;
			int c=0;
			for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
			   int start = entry.getKey();
			   if(start<j && start<c){
				   sol="IMPOSSIBLE";
				   //System.out.println(sol);
				   break;
			   }
			   if(start>=j){
				   j=entry.getValue();
				   for (int k = 0; k < N; k++) {
					if(task[k][0]==entry.getKey()&&task[k][1]==entry.getValue()){
						task[k][2]=1;
					}
				   }
				   
			   }else{
				   c=entry.getValue();
				//   System.out.println("Start "+entry.getKey()+" End "+entry.getValue()+" c");
				   for (int k = 0; k < N; k++) {
						if(task[k][0]==entry.getKey()&&task[k][1]==entry.getValue()){
							task[k][2]=2;
						}
					   }
				   
			   }
			}
			
			if (!sol.equals("IMPOSSIBLE")){
				for (int k = 0; k < N; k++) {
					if(task[k][2]==1){
						sol=sol+"C";
					}else{
						sol=sol+"J";
					}
				   }
			}
		
			System.out.println("Case #"+(i+1)+": "+sol);
		}

	}
	
}