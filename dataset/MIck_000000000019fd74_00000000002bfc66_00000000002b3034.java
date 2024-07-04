import java.util.*;
import java.util.regex.Pattern;
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
      
      ArrayList<Character> answerLeft = new ArrayList<Character>();
      ArrayList<Character> answerRight = new ArrayList<Character>();
      String answerMiddle = "";
      answerLeft.add('*');
      answerRight.add('*');
      for (int j = 1; j <= N; j++) {
    	  String patternString = in.nextLine();
    	  int middleStart = -1;
    	  int middleEnd = -1;
    	  char[] pattern = patternString.toCharArray();
    		  int answerIndex = answerRight.size();
    		  for (int patternIndex = pattern.length-1; patternIndex > 0; patternIndex--) {
    			  answerIndex--;
    			  if(pattern[patternIndex] == '*' ) {
    				  middleEnd = patternIndex;
    				  break;
    			  }
    			  if(answerRight.get(answerIndex) == '*') {
    				  answerIndex++;
    				  answerRight.add(answerIndex,pattern[patternIndex]);
    			  }
    			  if(pattern[patternIndex] != answerRight.get(answerIndex)) {
    				  invalid = true;
    				  break;
    			  }
    		  }
    			  answerIndex = -1;
        		  for (int patternIndex = 0; patternIndex < pattern.length-1; patternIndex++) {
        			  answerIndex++;
        			  if(pattern[patternIndex] == '*' ) {
        				  middleStart = patternIndex;
        				  break;
        			  }
        			  if(answerLeft.get(answerIndex) == '*') {
        				  answerLeft.add(answerIndex,pattern[patternIndex]);
        				  
        			  }
        			  if(pattern[patternIndex] != answerLeft.get(answerIndex)) {
        				  invalid = true;
        				  break;
        			  }
        		  }
    		  
    		  
    	  if(middleStart != -1 && middleEnd != -1) {
    		  answerMiddle = answerMiddle + patternString.substring(middleStart+1,middleEnd);
    	  }
   	  //System.out.println("Left: " + getStringRepresentation(answerLeft) + " Right: " + getStringRepresentation(answerRight) + " middle: " + answerMiddle ); 
      }
      
      if(invalid) {
    	  System.out.println("Case #" + i + ": *"); 
      } else {
    	  System.out.println("Case #" + i + ": " + (getStringRepresentation(answerLeft) + answerMiddle + getStringRepresentation(answerRight)).replace("*", "")); 
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
