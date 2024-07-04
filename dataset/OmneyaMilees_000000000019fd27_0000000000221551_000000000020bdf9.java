import java.io.*;
import java.util.*;

public class Solution {
	static String problemSolving(int[][] m) {
	    char[] answer = new char[m.length];
	    
	    // Sort Array
	    java.util.Arrays.sort(m, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

	    int CEnd = 0;
	    int JEnd = 0;
	    
	    boolean isFaild = false;
	    
	    for(int i=0; i< m.length; i++) {
	      int intervalStart = m[i][0];
	      int intervalEnd = m[i][1];
	      
	      if (intervalStart >= CEnd) {
	        answer[m[i][2]] = 'C'; 
	        CEnd = intervalEnd;
	      } else if (intervalStart >= JEnd) {
	        answer[m[i][2]] = 'J';
	        JEnd = intervalEnd;
	      } else {
	        isFaild = true;
	        break;
	      }
	    }
	    
	    if (isFaild) {
	      return "IMPOSSIBLE";
	    } else {
	      String result = "";
	      
	      for (int i=0; i< answer.length; i++) {
	        result += answer[i];
	      }
	      
	      return result;
	    }
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(scanner.nextLine().trim());
        for (int i=0; i <t; i++) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            int[][] m = new int[n][3];
            for(int j=0; j< n; j++) {
                String[] row = scanner.nextLine().split(" ");
                int[] elements = new int[3];
                elements[0] = Integer.parseInt(row[0]);
                elements[1] = Integer.parseInt(row[1]);
                elements[2] = j;

                m[j] = elements;
            }

            String answer =  problemSolving(m);
            
            System.out.println("Case #"+ (i+1) + ": " +  answer);
        }
    }
}