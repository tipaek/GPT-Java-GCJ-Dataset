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
	  short[] ca = new short[(24*60)+1], ja = new short[(24*60)+1];
	  StringBuffer res = new StringBuffer();
	  
	  for (int i = 0; i < chores.length; i++) {
		  int start = chores[i][0], end = chores[i][1];
		  
		  if(checkBusy(ca, start, end) == -1)	{ assignPer(ca, start, end); res.append("C"); }
		  else if(checkBusy(ja, start, end) == -1)	{ assignPer(ja, start, end); res.append("J"); }
		  else	{ res = new StringBuffer("IMPOSSIBLE"); break; }
	  }
	  
	  
	  System.out.println("Case #" + t + ": " + res.toString());
  }
  
  public static int checkBusy(short per[], int start, int end) {
	  if(per[start] != 2 && per[start] !=0)	return start;
	  if(per[end] != 2 && per[end] !=0)	return end;
	  if(per[start] == 2 && per[end] ==2)	return start;
	  
	  for(int i=start+1; i<end; i++) {
		  if(per[i] != 0) return i;
	  }
	  
	  return -1;
  }
  
  public static void assignPer(short[] per, int start, int end) {
	  per[start] = 2; per[end] = 2;
	  
	  for(int i=start+1; i<end; i++) {
		  per[i] = 1;
	  }
  }
  
}
