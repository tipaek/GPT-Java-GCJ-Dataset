
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static class Tache {
		public int start;
		public int end;
		
		public Tache(int startTime,int endTime){
			this.start = startTime;
			this.end = endTime; 
		}
		
		public boolean overlap(Tache t) {
			if(this.start >= t.end || t.start >= this.end)
				return false;
			return true; 
		}
		
	 @Override
	   public boolean equals(Object o) {
		 if (o == this) return true;
		 if (!(o instanceof Tache)) 
			 return false;
		 Tache t = (Tache) o;
		 if(this.start == t.start && this.end == t.end) 
	 		return true; 
		 return false;
	   }
	 
	 @Override
	    public int hashCode() {
		 	Integer start = this.start;
		 	Integer end = this.end; 
	        int result = start.hashCode() + end.hashCode();
	        return result;
	    }
	}
	
   public static Comparator<Tache> TacheComparator = new Comparator<Tache>() {
	   public int compare(Tache t1, Tache t2) {
		   Integer start1 = t1.start;
		   Integer start2 = t2.start;
		   return start1.compareTo(start2);
	    }};
		    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			ArrayList<Tache> arrTaches = new ArrayList<Tache>();
			ArrayList<Tache> arrTachesSorted = new ArrayList<Tache>();
			ArrayList<Tache> C = new ArrayList<Tache>();
			ArrayList<Tache> J = new ArrayList<Tache>();
			String solution = "";
			for(int j = 0; j < N; j++) {
				int start = sc.nextInt(); int end = sc.nextInt();
				Tache t = new Tache(start,end);
				arrTaches.add(t);
				arrTachesSorted.add(t);
			}
			Collections.sort(arrTachesSorted,TacheComparator);
			HashMap<Tache,String> myMap = new HashMap<Tache,String>();
			for(int idx = 0; idx < arrTachesSorted.size(); idx++) {
				Tache curr = arrTachesSorted.get(idx);
				if(C.size() == 0) {
					C.add(curr);
					if(myMap.containsKey(curr)) {
						if(myMap.get(curr).length() == 1) {
							myMap.put(curr, myMap.get(curr)+"C");
						} else {
							solution = "IMPOSSIBLE";
							break;
						}
					} else {
						myMap.put(curr,"C");
					}
					continue;
				}
				
				boolean intersection = false;
				intersection = C.get(C.size()-1).overlap(curr);
				if(!intersection) {
					C.add(curr);
					if(myMap.containsKey(curr)) {
						if(myMap.get(curr).length() == 1) {
							myMap.put(curr, myMap.get(curr)+"C");
						} else {
							solution = "IMPOSSIBLE";
							break;
						}
					} else {
						myMap.put(curr,"C");
					}
					continue;	
				}
				
				// assign to J 
				if(J.size() == 0) {
					J.add(curr);
					if(myMap.containsKey(curr)) {
						if(myMap.get(curr).length() == 1) {
							myMap.put(curr, myMap.get(curr)+"J");
						} else {
							solution = "IMPOSSIBLE";
							break;
						}
					} else {
						myMap.put(curr,"J");
					}
					continue;
				}
				
				intersection = J.get(J.size()-1).overlap(curr);
				if(!intersection) {
					J.add(curr);
					if(myMap.containsKey(curr)) {
						if(myMap.get(curr).length() == 1) {
							myMap.put(curr, myMap.get(curr)+"J");
						} else {
							solution = "IMPOSSIBLE";
							break;
						}
					} else {
						myMap.put(curr,"J");
					}
					continue;	
				}

				if(!intersection)
					continue;
				else {
					solution = "IMPOSSIBLE";
					break;
				}
			}
				
				if(solution.equals("IMPOSSIBLE") == false) {
					solution = "";
					for(int idx_notSort = 0; idx_notSort < arrTaches.size(); idx_notSort++) {
						String tmp = myMap.get(arrTaches.get(idx_notSort));
						if(tmp.length() > 1) {
							solution += tmp.charAt(0);
							myMap.put(arrTaches.get(idx_notSort), ""+tmp.charAt(1));
							continue;
						}
						solution += myMap.get(arrTaches.get(idx_notSort));
					}
				}
				
				System.out.println("Case #"+(i+1)+": "+solution);
				
			}
		}
}
