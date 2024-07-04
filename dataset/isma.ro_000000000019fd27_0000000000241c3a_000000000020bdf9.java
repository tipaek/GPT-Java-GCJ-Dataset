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
			Map<String, Integer> m = new TreeMap<String,Integer>();
			for (int j = 0; j < N; j++) {
				task[j][0]=in.nextInt();
				task[j][1]=in.nextInt();
				String horriblehack="";
				if(task[j][0]<10){
					horriblehack="000";
				}else if(task[j][0]<100){
					horriblehack="00";
				}else if(task[j][0]<1000){
					horriblehack="0";
				}
				m.put(horriblehack+task[j][0]+"_"+j, task[j][1]);
			}
			String sol ="";
			int j=0;
			int c=0;
			/*for (Map.Entry<String, Integer> entry : m.entrySet()) {
				System.out.println(entry.getKey()+" -> " + entry.getValue());
				
			}*/
			for (Map.Entry<String, Integer> entry : m.entrySet()) {
				//System.out.println(m.size());
				String s=entry.getKey().split("_")[0];
			   int start = Integer.parseInt(s);
			   if(start<j && start<c){
				   sol="IMPOSSIBLE";
				   //System.out.println(sol);
				   break;
			   }
			   if(start>=j){
				   j=entry.getValue();
				   for (int k = 0; k < N; k++) {
					if(task[k][0]==start&&task[k][1]==entry.getValue()&&task[k][2]==0){
						task[k][2]=1;
						break;
					}
				   }
				   
			   }else{
				   c=entry.getValue();
				//   System.out.println("Start "+entry.getKey()+" End "+entry.getValue()+" c");
				   for (int k = 0; k < N; k++) {
						if(task[k][0]==start&&task[k][1]==entry.getValue()&&task[k][2]==0){
							task[k][2]=2;
							break;
						}
					   }
				   
			   }
			}
			
			if (!sol.equals("IMPOSSIBLE")){
				for (int k = 0; k < N; k++) {
					if(task[k][2]==1){
						sol=sol+"C";
					}
					if(task[k][2]==2){
						sol=sol+"J";
					}
				   }
			}
		
			System.out.println("Case #"+(i+1)+": "+sol);
		}

	}
	
}