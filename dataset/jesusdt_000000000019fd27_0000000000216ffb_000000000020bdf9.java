import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt();
      
      for (int i = 1; i <= t; ++i) {
    	  int n = in.nextInt();
    	  List<Tuple> activities = new ArrayList<Tuple>();
    	  for(int j = 0; j < n; j++) {
    		  int x = in.nextInt();
    		  int y = in.nextInt();
    		  activities.add(new Tuple(x, y, j));
    	  }
    	  Collections.sort(activities, new TupleComparator());
    	  System.out.println("Case #" + i + ": " + solve(activities));
      }
      in.close();
    }

	private static String solve(List<Tuple> activities) {
		int cBusy = 0;
		int jBusy = 0;
		boolean impossible = false;
		boolean[] camerons = new boolean[activities.size()];
		for(Tuple activity : activities) {
			if(cBusy > activity.x) {
				if(jBusy > activity.x) {
					impossible = true;
					break;
				}else{
					jBusy = activity.y;
				}
			}else{
				cBusy = activity.y;
				camerons[activity.originalIndex] = true;
			}
		}
		if(impossible) {
			return "IMPOSSIBLE";
		}
		
		String distribution = "";
		for(int i = 0; i < camerons.length; i++)
			distribution += camerons[i] ? "C" : "J";
		return distribution;
	}
	
	static class Tuple { 
		  public int x; 
		  public int y; 
		  public int originalIndex; 
		  public Tuple(int x, int y, int originalIndex) {
		    this.x = x; 
		    this.y = y; 
		    this.originalIndex = originalIndex;
		  } 
	}
	
	static class TupleComparator implements Comparator<Tuple> { 
		  
        @Override
        public int compare(Tuple t1, Tuple t2) { 

            return t1.x-t2.x;
        } 
    } 
	
}
