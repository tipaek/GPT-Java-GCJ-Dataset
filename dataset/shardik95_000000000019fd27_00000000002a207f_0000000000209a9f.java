import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      String s = in.next();
      String output = parenthesis(s);
      System.out.println("Case #" + i + ": " + output);
    }
  }
  
  public static String parenthesis(String input) {
      String output = "";
      String currentString = "";
      char lastChar = '\0';
      Stack<Integer> depthStack = new Stack<Integer>();
      for(int i=0;i<=input.length();i++) {
        
        if(i == input.length()) {
            // string finished
            output += currentString;
            if(!depthStack.isEmpty()) {
                int x = depthStack.pop();
                for(int d=0;d<x;d++){
                    output += ")";
                }
            }
        } else {
            char currentChar = input.charAt(i);
            
            if(currentChar == lastChar) {
                // repeated chars
                currentString += currentChar;
            } else {
                
                if(lastChar == '\0') {
                    // first time
                    lastChar = currentChar;
                    currentString += currentChar;
                    
                    int numberChar = Integer.parseInt(""+currentChar);
                    if(numberChar!=0) {
                        depthStack.push(numberChar);
                        for(int d = 0; d<numberChar; d++) {
                            output += "(";
                        }
                    }
                } else {
                    if (Integer.parseInt(""+currentChar) < Integer.parseInt(""+lastChar)) {
                        // eg: ((2) 1) 
                        int diff = Integer.parseInt(""+lastChar) - Integer.parseInt(""+currentChar);
                        output += currentString;
                        currentString = ""+currentChar;
                        lastChar = currentChar;
                        for(int d=0;d< diff;d++) {
                            output += ")";
                        }
  
                         depthStack.push(diff);
                    } else {
                        //eg: ((2) (3)))
                        int diff = Integer.parseInt(""+currentChar) - Integer.parseInt(""+lastChar);
                        output += currentString;
                        currentString = ""+currentChar;
                        lastChar = currentChar;
                        for(int d=0;d<diff;d++) {
                            output += "(";
                        }
                        if(!depthStack.isEmpty())  {
                          depthStack.pop();
                          
                        } 
                        depthStack.push(Integer.parseInt(""+currentChar));
                    }
                }
            }
        }
          
      }
      
      return output;
  }
}