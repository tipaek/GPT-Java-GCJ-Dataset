import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Pair{
	int start;
	int end;
	Pair(int start, int end){
		this.start = start;
		this.end = end;
	}
	
}

class MyComparator implements Comparator<Pair>
{
  public int compare(Pair e1, Pair e2)
  {
    return e1.start - e2.start;
  }
}

public class Solution {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int testsSets;
		int currentCase = 0;
		testsSets = scan.nextInt();
		
		
		while(testsSets > currentCase) {
			int activities = scan.nextInt();
			ArrayList<Pair> activitiesList = new ArrayList<Pair>();
			
			for(int i = 0; i < activities; i++) {
				int start = scan.nextInt();
				int end = scan.nextInt();
				activitiesList.add(new Pair(start, end));
			}
			Collections.sort(activitiesList, new MyComparator());
			
			Pair c, j;
			c = j = new Pair(-1, -1);
			String newString = "";
			
			for(int i = 0; i < activities; i++) {
				if(c.end <= activitiesList.get(i).start) {
					c = activitiesList.get(i);
					newString += 'C';
				}
				else if(j.end <= activitiesList.get(i).start) {
					j = activitiesList.get(i);
					newString += 'J';
				}
				else {
					newString = "IMPOSSIBLE";
					break;
				}
			}
			
			System.out.printf("Case #%d: %s\n", currentCase + 1, newString);
			
			currentCase++;
		}
	}

}