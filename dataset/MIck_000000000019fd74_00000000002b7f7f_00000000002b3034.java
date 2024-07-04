import java.util.*;
import java.io.*;
public class Solution {

	
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); //Number of cases
    String unused = in.nextLine();
    for (int i = 1; i <= t; ++i) {//iterate over number of cases
      boolean invalid = false;
      int N = in.nextInt();//
      unused = in.nextLine();
      
      ArrayList<Character> answer = new ArrayList<Character>();
      for (int j = 1; j <= N; j++) {
    	  char[] pattern = in.nextLine().toCharArray();
    	  if(j == 1) {
    		  for (char c : pattern) {
    			  answer.add(c);
    			}
    	  } else {
    		  int answerIndex = answer.size();
    		  for (int patternIndex = pattern.length-1; patternIndex > 0; patternIndex--) {
    			  answerIndex--;
    			  if(pattern[patternIndex] == '*' ) {
    				  continue;
    			  }
    			  if(answer.get(answerIndex) == '*') {
    				  answerIndex++;
    				  answer.add(answerIndex,pattern[patternIndex]);
    			  }
    			  if(pattern[patternIndex] != answer.get(answerIndex)) {
    				  invalid = true;
    				  break;
    			  }
    		  }
    	  }
      }
      
      if(invalid) {
    	  System.out.println("Case #" + i + ": *"); 
      } else {
    	  System.out.println("Case #" + i + ": " + getStringRepresentation(answer).replace("*", "")); 
      }
	   
	  
      
    }
    in.close();
  }
  
  static String getStringRepresentation(ArrayList<Character> list)
  {    
      StringBuilder builder = new StringBuilder(list.size());
      for(Character ch: list)
      {
          builder.append(ch);
      }
      return builder.toString();
  }
}
