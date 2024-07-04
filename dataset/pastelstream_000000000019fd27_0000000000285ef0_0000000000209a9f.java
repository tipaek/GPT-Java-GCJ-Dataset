import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      
      
      
      System.out.printf("\nCase #" + i + ":");
      
      
      String current = in.nextLine();
      String str[] = current.split("");
      
      int length = current.length();
      int j=0;
      int [] int_array = new int [length];
      
      while (j<length){
            int_array[j]=Integer.parseInt(str[j]);      
            j+=1;
      }
      
      
      int prev = 0;
      j=0;
      
      while (j<length){
            
    if (prev<int_array[j])  {
        int counter = 0;
        while (counter<int_array[j]-prev){
            System.out.printf("(");
            counter+=1;
        }
    }
    else if (prev>int_array[j])  {
        int counter = 0;
        while (counter<prev-int_array[j]){
            System.out.printf(")");
            counter+=1;
        }
    }
    
    System.out.printf(""+int_array[j]);
      
      prev =  int_array[j]; 
          j+=1;
      }
      
      
    }
  }
}