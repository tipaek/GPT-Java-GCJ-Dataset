

import java.util.*;
import java.io.*;
public class Solution{
	
	static class Task{

		Integer init = 0;
		Integer end = 0;
		public Task(Integer i, Integer e){
			init = i;
			end = e;
		}

		@Override
		public String toString(){
			return "{init: " + init + ", end: " + end + "}";
		}
	}
	public static void main(String args[]) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int kase = 1;
		while(t-- > 0){
			int n = Integer.parseInt(br.readLine());
			List<Task> taskList = new ArrayList<>();
			while(n-- > 0){
				String ai[] = br.readLine().split(" ");
				taskList.add(new Task(Integer.parseInt(ai[0]), Integer.parseInt(ai[1])));
			}
			Collections.sort(taskList, new Comparator<Task>(){
				@Override
				public int compare(Task t1, Task t2){
					return t1.init.compareTo(t2.init);
				}

			});
			StringBuilder ans = new StringBuilder();
			if(taskList.size() == 1){
				ans.append("J");
			}else{
				ans.append("J");
				for(int i = 1; i < taskList.size(); i++){
					int overlappings = 0;
					//overlapping
					for(int j = i - 1; j >= 0; j--){
						if(taskList.get(i).init < taskList.get(j).end){
							overlappings++;
						}
					}
					
					if(overlappings > 1){
						ans = new StringBuilder("IMPOSSIBLE");
						break;
					}else{
						if(taskList.get(i).init < taskList.get(i - 1).end){
							char car = (ans.charAt(ans.length() - 1) == 'J')? 'C' : 'J';
							ans.append(car);
						}else{
							ans.append(ans.charAt(ans.length() - 1));
						}
					}
				}

		}
			System.out.println("Case #" +  (kase++) + ": " + ans.toString());
		}



	}
}