
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
   Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
//	Scanner in = null;
//	try {
//		in = new Scanner(new File("D:\\perso\\GoogleCodeJam\\GoogleCodeJam\\src\\_2020\\QualificationRound\\C\\files\\C.TXT"));
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

	
    		int nbCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    		for(int caseNumber = 0; caseNumber < nbCases; caseNumber++){
    			boolean[] cBool = new boolean[60*24];
    			boolean[] jBool = new boolean[60*24];
    			
    			int nbActivites = in.nextInt();
        		
    			int[] starts = new int[nbActivites];
    			int[] ends = new int[nbActivites];
        		for (int i = 0; i < nbActivites; i++) {
        			starts[i] = in.nextInt();
        			ends[i] = in.nextInt();        			
        		}
        		
        		String result = result("", 0, cBool, jBool, starts, ends);
        		if (result == null) {
        			result = "IMPOSSIBLE";
        		}
        		
				System.out.println("Case #"+(caseNumber+1) + ": " + result);
			}
    		in.close();
	}
  
  private static String result(String currentResult, int index, boolean[] cBool, boolean[] jBool, int[] starts, int[] ends) {
	  
	  if (index == starts.length) {
		  return currentResult;
	  }
	  else {
		  boolean[] cloneCBool = cBool.clone();
		  boolean[] cloneJBool = jBool.clone();
		  if(possible(starts[index], ends[index], cloneCBool)) {
			  String result = result(currentResult+"C", index+1, cloneCBool, jBool, starts, ends);
			  if (result != null) {
				  return result;
			  }
		  }
		  if(possible(starts[index], ends[index], cloneJBool)) {
			  String result = result(currentResult+"J", index+1, cBool, cloneJBool, starts, ends);
			  if (result != null) {
				  return result;
			  }
		  }
		  return null;
		  
	  }
  }
  
  private static boolean possible (int start, int end, boolean[] xBool) {
	  for (int i = start; i < end; i++) {
		  if (xBool[i]) {
			  return false;
		  }
		  xBool[i] = true;
	  }
	  return true;
  }
  
}