import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution{
	
	private int start;
	private int end;
	
	public Solution(int s, int e){
		start = s;
		end = e;
	}
	public int getStart(){return start;}
	public int getEnd(){return end;}
	public boolean overlapsWith(Solution assignment){
		if(assignment.getEnd() > start && assignment.getStart() < start)
			return true;
		if(assignment.getEnd() > end && assignment.getStart() < end)
			return true;
		if(assignment.getStart() < start && assignment.getEnd() > end)
			return true;
		if(assignment.getStart() > start && assignment.getEnd() < end)
			return true;
		return false;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		
		for(int loop=1; loop<=t; loop++){
			String str = "";
			
			int numAssignments = in.nextInt();
			Solution[] times = new Solution[numAssignments];
			for(int i=0; i<numAssignments; i++){
				int start = in.nextInt();
				int end = in.nextInt();
				times[i] = new Solution(start, end);
			}
			
			
			ArrayList<Solution> c = new ArrayList<Solution>();
			ArrayList<Solution> j = new ArrayList<Solution>();
			for(Solution assign : times){
				str += getStr(c, j, assign);
			}
			

			if(str.contains("I"))
				str = "IMPOSSIBLE";
			
			System.out.println("Case #" + loop + ": " + str);
		}
	}
	
	public static String getStr(ArrayList<Solution> c, ArrayList<Solution> j, Solution assignment){
		boolean overlapC = false;
		for(Solution x : c){
			if(assignment.overlapsWith(x))
				overlapC = true;
		}
		boolean overlapJ = false;
		for(Solution x : j){
			if(assignment.overlapsWith(x))
				overlapJ = true;
		}
		
		if(!overlapC){
			c.add(assignment);
			return "C";
		}
		else if(!overlapJ){
			j.add(assignment);
			return "J";
		}
		else return "I";
		
		
	}
	
	
}
