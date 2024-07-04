import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
    int t = Integer.parseInt(scanner.nextLine().trim());
    
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(scanner.nextLine().trim());
      Integer[][] chores = new Integer[n][2];
      
      for (int j = 0; j < chores.length; j++) {
    	  String[] line = scanner.nextLine().trim().split("\\s+");
    	  chores[j] = Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList()).toArray(chores[j]);
	  }
      
      
      calcChores(chores, i+1);
    }
    
    scanner.close();
  }
  
  public static void calcChores(Integer[][] chores, int t) {
	  ArrayList<Integer[]> ca = new ArrayList<>(), ja = new ArrayList<>();
	  StringBuffer res = new StringBuffer();
	  
	  for (int i = 0; i < chores.length; i++) {
		  int start = chores[i][0], end = chores[i][1];
		  
		  if(checkBusy(ca, start, end) == -1)	{ assignPer(ca, start, end); res.append("C"); }
		  else if(checkBusy(ja, start, end) == -1)	{ assignPer(ja, start, end); res.append("J");}
		  else	{ res = new StringBuffer("IMPOSSIBLE"); break; }
	  }
	  
	  System.out.println("Case #" + t + ": " + res.toString());
  }
  
  public static int checkBusy(ArrayList<Integer[]> per, int start, int end) {
	  for (Integer[] entry:per) {
		  //if(start>=entry[0] && start<entry[1])	return 1;
		  //if(end>entry[0] && end<=entry[1])	return 1;
		  
		  if((Math.min(end, entry[1]) > Math.max(start, entry[0]))) return 1;
		  if(start<=entry[0] && end>=entry[1]) return 1;
	  }
	  return -1;
  }
  
  public static void assignPer(ArrayList<Integer[]> per, int start, int end) {
	  Integer[] tmp = new Integer[2];
	  tmp[0]=start;tmp[1]=end;
	  per.add(tmp);
  }
}
