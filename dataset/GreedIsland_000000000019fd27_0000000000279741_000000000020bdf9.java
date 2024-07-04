import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	
	public static class Tache {
		public int start;
		public int end;
		public int nbOverlap; 
		
		public Tache(int startTime, int endTime) {
			this.start = startTime; 
			this.end = endTime; 
			this.nbOverlap = 0;
		}
		
		public boolean overlap(Tache t) {
			if(t.end <= this.start || t.start >= this.end)
				return false;
			this.nbOverlap ++;
			return true; 
		}
	}

	public static void main(String[] args) {
		//reader 
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		//loop for test cases
		for(int i = 0; i < T; i++) {
			// number of tasks to assign
			int N = sc.nextInt(); 
			// solution to print 
			String solution = "";
			LinkedList<Tache> ActivitiesC = new LinkedList<Tache>();
			LinkedList<Tache> ActivitiesJ = new LinkedList<Tache>();
			boolean impossible = false;
			// for each task 
			for(int j = 0; j < N; j++) {
				// create task with start and end 
				int startTime = sc.nextInt();
				int endTime = sc.nextInt();
				Tache t = new Tache(startTime, endTime);
				
				// check if the task overlap with another one already assigned to C
				boolean overlapC = overlap(t, ActivitiesC);
				if(overlapC) {
					// check if the task overlap with another one already assigned to J
					boolean overlapJ = overlap(t, ActivitiesJ);
					// cannot be assigned then print impossible
					if(overlapJ) {
						impossible = true; 
						break;
					// can be assigned to J
					} else {
						ActivitiesJ.add(t);
						solution += 'J';
					}
				} else { // can be assigned to C
					ActivitiesC.add(t);
					solution += 'C';
				}
			}
			if(!impossible)
				System.out.println("Case #"+(i+1)+": "+solution);
			else
				System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
		}
	}
	
	
	
	
	//check if task overlap with one task already assigned 
	public static boolean overlap(Tache t, LinkedList<Tache> list) {
		if(list.size() == 0)
			return false; 
		for(int i = 0; i < list.size(); i++) {
			if(t.overlap(list.get(i)))
				return true;
		}
		return false;
	}

}