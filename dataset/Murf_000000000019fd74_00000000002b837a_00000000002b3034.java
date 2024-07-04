import java.util.*;
import java.io.*;
    
public class Solution {
   public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int testCases = in.nextInt();
      for( int t=1; t<=testCases; t++ ) {
         int n = in.nextInt();          
         String[] words = new String[n];
         String[] mustMatchLeft = new String[n];
         String[] mustMatchRight = new String[n];
         for( int i=0; i<n; i++ ) {
            words[i] = in.next();
            int astIndex = words[i].indexOf("*");
            if( astIndex == -1 ) {
               mustMatchLeft[i] = "";
               mustMatchRight[i] = words[i];
            }
            else {
               mustMatchLeft[i] = words[i].substring(0, astIndex);
               mustMatchRight[i] = words[i].substring(astIndex+1);
            }
            //System.out.println( mustMatchLeft[i] + " ---- " + mustMatchRight[i] ); 
         }
         int[] rightIdx = new int[n];
         for( int i=0; i<n; i++ ) rightIdx[i] = mustMatchRight[i].length()-1;
         Set<Character> set = new HashSet<>();
         String addition = "";
         boolean collect = false;
         for( int j=0; j<=100; j++ ) {
            for( int i=0; i<n; i++ ) {
               if( rightIdx[i]-j >= 0 ) {
                  set.add(mustMatchRight[i].charAt(rightIdx[i]-j));
               }
               else collect = true;
            }
            if( set.size() == 0 ) {
               j = 150;
            }
            else if( set.size() > 1 ) {
               addition = "*";
               j = 150;
            }
            else {
               Character[] y = set.toArray(new Character[0]);
               addition = y[0] + addition;
            }
            set.clear();
         }         
         /////LEFT SIDE
         String leftAddition = "";
         int[] leftIdx = new int[n];
         for( int i=0; i<n; i++ ) leftIdx[i] = 0;
         set = new HashSet<>();
         //String addition = "";
         collect = false;
         for( int j=0; j<=100; j++ ) {
            for( int i=0; i<n; i++ ) {
               if( j < mustMatchLeft[i].length() ) {
                  set.add(mustMatchLeft[i].charAt(j));
               }
               else collect = true;
            }
            if( set.size() == 0 ) {
               j = 150;
            }
            else if( set.size() > 1 ) {
               leftAddition = "*";
               j = 150;
            }
            else {
               Character[] y = set.toArray(new Character[0]);
               leftAddition = leftAddition + y[0];
            }
            set.clear();
         }         
                  
         if( leftAddition.equals("*") || addition.equals("*") ) {
            addition = "*";
         }
         else addition = leftAddition + addition;
         
         System.out.println( "Case #" + t + ": " + addition);
      }
   }
}
  