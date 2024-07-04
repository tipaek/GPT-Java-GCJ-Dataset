//package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

public long getStart() {
 return start;
}

public void setStart(long start) {
 this.start = start;
}

public long getEnd() {
 return end;
}

public void setEnd(long end) {
 this.end = end;
}

private long start;
private long end;

public static void main(String[] args) {
 // TODO Auto-generated method stub
 Scanner sc = new Scanner(System.in);
 long test = sc.nextLong();
 for (long t = 1; t <= test; t++) {
 	long N = sc.nextLong();
 	List<Solution> setJ = new ArrayList<>();
 	List<Solution> setC = new ArrayList<>();
 	String ss = "";
 	boolean isImpossible = false;

 	for (long i = 0; i < N; i++) {
   Solution sol = new Solution();
   sol.setStart(sc.nextLong());
   sol.setEnd(sc.nextLong());
   boolean J = setJ.stream().anyMatch(item -> {
   	if (sol.getStart() >= item.getEnd()) {
     return false;
   	} 
   	if (sol.getEnd() <= item.getStart()) {
     return false;
   	}
   	return true;
   });
   if (!J) {
   	setJ.add(sol);
   	if (!isImpossible) {
     ss += "J";
   	}
   } else {
   	boolean C = setC.stream().anyMatch(item -> {
      
if (sol.getStart() >= item.getEnd()) {
     return false;
   	} 
   	if (sol.getEnd() <= item.getStart()) {
     return false;
   	}
   	return true;


   	});
   	if (!C) {
     setC.add(sol);
     if (!isImpossible) {
     	ss += "C";
     }
   	} else {
     ss = "IMPOSSIBLE";
     isImpossible = true;
   	}

   }

 	}
 	System.out.println("Case #" + t + ": " + ss);

 }
 sc.close();
}

}

