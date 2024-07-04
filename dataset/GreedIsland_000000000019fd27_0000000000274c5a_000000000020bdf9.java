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
			if(t.end <= this.start)
				return false;
			if(t.start >= this.end)
				return false;
			this.nbOverlap ++;
			return true; 
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt(); 
			String solution = "";
			LinkedList<Tache> ActivitiesC = new LinkedList<Tache>();
			LinkedList<Tache> ActivitiesJ = new LinkedList<Tache>();
			for(int j = 0; j < N; j++) {
				int startTime = sc.nextInt();
				int endTime = sc.nextInt();
				Tache t = new Tache(startTime, endTime);
				if(ActivitiesC.size() == 0) {
					ActivitiesC.add(t);
					solution += 'C';
				} else if(ActivitiesJ.size() == 0) {
					ActivitiesJ.add(t);
					solution += 'J';
				} else {
					boolean overlapC = overlap(t, ActivitiesC);
					if(overlapC) {
						boolean overlapJ = overlap(t, ActivitiesJ);
						if(overlapJ) {
							System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
						} else {
							ActivitiesJ.add(t);
							solution += 'J';
						}
					} else {
						ActivitiesC.add(t);
						solution += 'C';
					}
				}
			}
			if(solution.length() == N)
				System.out.println("Case #"+(i+1)+": "+solution);
		}
	}
	
	public static boolean overlap(Tache t, LinkedList<Tache> list) {
		for(int i = 0; i < list.size(); i++) {
			if(t.overlap(list.get(i)))
				return true;
		}
		return false;
	}

}
