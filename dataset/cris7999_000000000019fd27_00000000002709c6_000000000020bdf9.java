import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int numTest = sc.nextInt();
		
		for(int test=0;test<numTest;++test) {
			
			int numActivities=sc.nextInt();
			List<List<Integer>> jaimeList = new ArrayList<>();
			List<List<Integer>> cameronList=new ArrayList<>();
			List<Character> result= new ArrayList<>();
			
			boolean impossibleCombination = false;
			int start,finish;
			String task;
			String[] formatTask;
			sc.nextLine();
			for(int i=0 ; i <numActivities && !impossibleCombination; ++i) {
				
				task= sc.nextLine();
				formatTask=task.split(" ");
											
				start= Integer.parseInt(formatTask[0]);
				finish= Integer.parseInt(formatTask[1]);			
				
				if(iCanDoThatActivitie(cameronList, start, finish)) {
					List<Integer> newTask = new ArrayList<>();
					newTask.add(start);
					newTask.add(finish);
					cameronList.add(newTask);
					result.add('C');
				}else {
					if(iCanDoThatActivitie(jaimeList, start, finish)) {
						List<Integer> newTask = new ArrayList<>();
						newTask.add(start);
						newTask.add(finish);
						jaimeList.add(newTask);						
						result.add('J');
					}else {
						impossibleCombination=true;
					}
				}
				
			}
			if(impossibleCombination) {
				System.out.println("Case #"+(test+1)+": IMPOSSIBLE");
			}else {
				System.out.print("Case #"+(test+1)+": ");
				for(Character c: result) {
					System.out.print(c);
				}
				System.out.println("");
			}
			
		}	
	}
	
	public static boolean iCanDoThatActivitie(List<List<Integer>> myList, int start, int finish) {
		

		for(int i = 0; i<myList.size();++i) {
			if(start >myList.get(i).get(0) && start < myList.get(i).get(1))
				return false;
			if(finish >myList.get(i).get(0) && finish < myList.get(i).get(1))
				return false;
		}
		
		return true;
	}
}
