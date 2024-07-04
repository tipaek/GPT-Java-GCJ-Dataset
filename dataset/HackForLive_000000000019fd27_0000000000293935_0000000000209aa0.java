import java.io.*;
import java.util.*;

import java.nio.file.Path;
import java.nio.file.Files;
import java.util.regex.*;
import java.io.*;
import java.math.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.text.*;
import java.util.Locale;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String[] pom = in.nextLine().split(" ");
      
      int n = Integer.parseInt(pom[0]);
      int k = Integer.parseInt(pom[1]);
      
      boolean possible = false;
      int start = -1;
      for(int j = 1; j < n + 1; j++){
          if(k == j*n){
            possible = true;
            start = j;
          }
      }
       
       if(possible){
        System.out.println("Case #" + i + ": POSSIBLE");     
        printLatin(n, start);
       }
       else{
           System.out.println("Case #" + i + ": IMPOSSIBLE");
       }
    }
  }
  static void printLatin(int n, int start) 
    { 
          
        // A variable to control the  
        // rotation point. 
        //int k = n+1; 
        int k = start;
        // Loop to print rows 
        for (int i = 1; i <= n; i++) 
        { 
  
            // This loops runs only after 
            // first iteration of outer  
            // loop. It prints 
            // numbers from n to k 
            int temp = k;
            
  
            while (temp <= n) 
            { 
                System.out.print(temp + " "); 
                temp++; 
            } 
      
            // This loop prints numbers from 
            // 1 to k-1. 
            for (int j = 1; j < k; j++) 
                System.out.print(j + " "); 
            k--;
            if(k==0)k=n;
            
            System.out.println(); 
        } 
    }  
}