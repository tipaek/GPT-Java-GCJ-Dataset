import java.util.*;
import java.io.*;
import java.math.*;


public class Solution {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		for(int i = 0; i < num; ++i){
			boolean possible = true;
			
			int numTasks = sc.nextInt();
			ArrayList<ArrayList<Integer>> conflicts = new ArrayList<>();
			for(int j = 0; j < numTasks; ++j){
				conflicts.add(new ArrayList<>());
				int one = sc.nextInt();
				int two = sc.nextInt();
				conflicts.get(j).add(one);
				conflicts.get(j).add(two);
				conflicts.get(j).add(j);
			}
			
			for(int j = 1; j < conflicts.size(); j++){
				int pivot = conflicts.get(j).get(0);
				ArrayList<Integer> adf = conflicts.get(j);
				int ind = j-1;
				
				while(ind >= 0 && conflicts.get(ind).get(0) > pivot){
					conflicts.set(ind+1, conflicts.get(ind));
					ind--;
				}
				conflicts.set(ind+1, adf);
			}
			
			char[] ans = new char[numTasks];
			ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
			for(int j = 0; j < conflicts.size(); j++){
				if(!possible)
					break;
				if(temp.size() == 0){
					ans[conflicts.get(j).get(2)] = 'C';
					temp.add(conflicts.get(j));
				} else if(temp.size() == 1){
					int number = temp.get(0).get(2);
					if(conflicts.get(j).get(0) >= temp.get(0).get(1)){
						temp.remove(0);
					}
					temp.add(conflicts.get(j));
					if(ans[number] == 'J')
						ans[conflicts.get(j).get(2)] = 'C';
					else
						ans[conflicts.get(j).get(2)] = 'J';
				} else{
					if(conflicts.get(j).get(0) < temp.get(0).get(1) &&
					   conflicts.get(j).get(0) < temp.get(1).get(1)){
						System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
						possible = false;
						break;
					} else if(conflicts.get(j).get(0) < temp.get(0).get(1)){
						char letter = ans[temp.get(1).get(2)];
						temp.remove(1);
						temp.add(conflicts.get(j));
						if(letter == 'J')
							ans[temp.get(1).get(2)] = 'J';
						else
							ans[temp.get(1).get(2)] = 'C';
					} else if(conflicts.get(j).get(0) < temp.get(1).get(1)){
						char letter = ans[temp.get(0).get(2)];
						temp.remove(0);
						temp.add(conflicts.get(j));
						if(letter == 'J')
							ans[temp.get(1).get(2)] = 'J';
						else
							ans[temp.get(1).get(2)] = 'C';
					} else {
						char letter = ans[temp.get(0).get(2)];
						temp.remove(0);
						temp.add(conflicts.get(j));
						if(letter == 'J')
							ans[temp.get(1).get(2)] = 'J';
						else
							ans[temp.get(1).get(2)] = 'C';
					}
				}
			}
			
			if(possible){
				String answer = new String(ans);
				System.out.println("Case #" + (i+1) + ": " + answer);
			}
		}
		sc.close();
	}
}

