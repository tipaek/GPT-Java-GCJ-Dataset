
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
			char answer[] = new char[n + 1];
			HashMap<String, Integer> map = new HashMap<>();
			List<Task> taskList = new ArrayList<>();

			int index = 1;
			while(n-- > 0){
				String ai[] = br.readLine().split(" ");
				String key = ai[0] + "-" + ai[1];
				map.put(key, index++);
				taskList.add(new Task(Integer.parseInt(ai[0]), Integer.parseInt(ai[1])));
			}
			
			Collections.sort(taskList, new Comparator<Task>(){
				@Override
				public int compare(Task t1, Task t2){
					return t1.init.compareTo(t2.init);
				}

			});


			boolean isPossible = true;
			String key = taskList.get(0).init + "-" + taskList.get(0).end;
			answer[map.get(key)] = 'J';
			int k = map.get(key);

			for(int i = 1; i < taskList.size() - 1; i++){
					key = taskList.get(i).init + "-" + taskList.get(i).end;
					
					if(taskList.get(i).init < taskList.get(i - 1).end){

						//Case I
						if(taskList.get(i).end > taskList.get(i + 1).init){
							//Case Ib
							if(taskList.get(i - 1).end > taskList.get(i + 1).init){
								isPossible = false;
								break;
							//Case Ia
							}else{
								char car = (answer[k] == 'J')? 'C' : 'J';
								answer[map.get(key)] = car;
								k = map.get(key);
							}
						//Case II
						}else{
								char car = (answer[k] == 'J')? 'C' : 'J';
								answer[map.get(key)] = car;
								k = map.get(key);
						}
					}else{
						answer[map.get(key)] = answer[k];
						k = map.get(key);
					}					
			}

			key = taskList.get(taskList.size() - 1).init + "-" + taskList.get(taskList.size() - 1).end;
			if(taskList.get(taskList.size() - 2).end > taskList.get(taskList.size() - 1).init){
				char car = (answer[k] == 'J')? 'C' : 'J';
				answer[map.get(key)] = car;
			}else{
				answer[map.get(key)] = answer[k];
			}
			if(!isPossible){
				System.out.println("Case #" +  (kase++) + ": IMPOSSIBLE");
			}else{
				System.out.println("Case #" +  (kase++) + ": " + new String(answer).trim());
			}
			
		}

	}
}