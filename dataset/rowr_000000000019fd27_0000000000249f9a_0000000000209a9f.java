import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); 
    in.nextLine();
    for (int i = 1; i <= t; ++i) {
      String myCase = in.nextLine();
      char[] numberChars = myCase.trim().toCharArray();
      int[] numbers = new int[numberChars.length];
      for(int j=0; j<numberChars.length; j++) numbers[j] = Character.getNumericValue(numberChars[j]);
      String results = nestingDepth(numbers);
      System.out.println("Case #" + i + ": " + results);
    }
  }
  
  public static String nestingDepth(int[] numbers){
    String results = "";
    int current = 0;
    for(int i = 0; i<numbers.length; i++){
        int x = numbers[i];
        if(x > current){
            while(x > current){
                results = results + "(";
                current++;
            }
        } 
        else if(x < current){
            while(x < current){
                results = results + ")";
                current--;
            }
        }
        results = results + numbers[i];
    }
    while(current>0){
        results = results + ")";
        current--;
    }
    return results;
  }
  
  
 }