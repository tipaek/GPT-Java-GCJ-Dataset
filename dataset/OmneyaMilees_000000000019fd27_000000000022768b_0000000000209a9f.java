import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
	static String problemSolving(String m) {
	    String answer = "";
	    
	    int currentOpen = 0;
	    
	    for(int i=0; i<m.length(); i++ ) {
	      char currentCharacter = m.charAt(i);
	      int currentNum = Integer.parseInt(currentCharacter+"");
	      
	      int requiredOpen = currentNum - currentOpen;
	      for (int j=0; j< requiredOpen ; j++) {
	        answer += '(';
	        currentOpen += 1;
	      }
	      answer += currentCharacter;
	      
	      int requiredClose = 0;
	      if (i+1 < m.length()) {
	        int nextNum = Integer.parseInt(m.charAt(i+1)+"");
	       
	        if (nextNum < currentNum) { // next is smaller
	          requiredClose = currentOpen - nextNum;
	        }
	      } else {
	        requiredClose = currentOpen;
	      }
	      
	      for (int j=0; j< requiredClose ; j++) {
	        answer += ')';
	        currentOpen -= 1;
	      }
	    }
	    
	    return answer;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(scanner.nextLine().trim());
        for (int i=0; i <t; i++) {
            String s = scanner.nextLine().trim();

            String answer =  problemSolving(s);
            
            System.out.println("Case #"+ (i+1) + ": " +  answer);
        }
    }
}