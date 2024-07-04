import java.util.*;
    import java.io.*;
    public class Solution {
        static boolean search(int a[],int val){
        for(int i=0;i<a.length;i++){
        if(a[i]==val)return true;
        }
        return false;
            
        }
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String I = in.next().trim();
            String O="";
            int count=0;
            for(int r=0;r<I.length();r++){
            int m = Integer.parseInt(""+I.charAt(r));
            int differ=m-count;
            count=m;
            char n;
            if(differ>0)n='(';
            else n=')';
            
            for(int k=1;k<=Math.abs(differ);k++)O=O+n;
            O=O+m;  
            }
            for(int k=1;k<=count;k++)O=O+')';
        
          System.out.println("Case #" + i + ": "+O  );
        }
      }
    }