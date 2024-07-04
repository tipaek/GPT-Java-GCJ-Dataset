
import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  
    for (int x = 1; x <= t; x++) {
    	String result ="";
    	
    	int n = in.nextInt();
    	List<Task> list = new ArrayList<>();
    	for (int i=0; i<n; i++) {
    		list.add(new Task(in.nextInt(), in.nextInt(), i));
    	}
    	
    	Comparator<Task> byStart = (Task o1, Task o2)->Integer.valueOf(o1.start).compareTo(o2.start);
    	Comparator<Task> byOrig = (Task o1, Task o2)->Integer.valueOf(o1.origOrder).compareTo(o2.origOrder);
    	list.sort(byStart);
    	
    	boolean isC = true;
    	boolean isJ = false;
    	int cUntil = list.get(0).end;
    	list.get(0).assigned="C";
    	int jUntil=0;
    	
    	for (int i =1; i<n; i++) {
    		Task cur = list.get(i);
    		if (isC && cUntil<=cur.start) isC=false;
    		if (isJ && jUntil<=cur.start) isJ=false;
    		if (isC && isJ) {
    			result = "IMPOSSIBLE";
    			break;
    		} else if (isC) {
    			isJ=true;
    			cur.assigned="J";
    			jUntil=cur.end;
    		} else {
    			isC=true;
    			cur.assigned="C";
    			cUntil=cur.end;
    			
    		}
    	}
    	
    	if (result.length()==0) {
    		list.sort(byOrig);
    		for (int i =0; i<n; i++) result = result+list.get(i).assigned;
    	}
   
      System.out.println("Case #" + x + ": "+result);
    }
  }
  
  private static class Task {
	  public int start;
	  public int end;
	  public int origOrder;
	  public String assigned;
	  public Task (int s, int e, int o) {
		  start=s;
		  end=e;
		  origOrder=o;
	  }
  }
}