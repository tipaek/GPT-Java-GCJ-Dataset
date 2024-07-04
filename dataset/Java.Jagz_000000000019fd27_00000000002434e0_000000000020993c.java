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
          int N=in.nextInt();
          int col[][]=new int[N][N];
          int SUM=0,R=0,C=0;
          boolean checkc[]=new boolean[N];
          Arrays.fill(checkc,Boolean.TRUE);
          for(int c=0;c<N;c++){
            boolean checkr=true;
            int row[]=new int[N];
            for(int r=0;r<N;r++){
            int val=in.nextInt();
            
            if(checkr==true){
              
               if(search(row,val)==false)
                row[r]=val;
               else{
                checkr=false;
                R++;
                }}
            
            if(c==r)SUM=SUM+val;
            if(checkc[r]==true){
              
            if(search(col[r],val)==false)col[r][c]=val;
            
            else {
                
                checkc[r]=false;
                C++;
            }
             
        }
            
        
            }
        }
          System.out.println("Case #" + i + ": "+SUM+" "+R+" "+C );
        }
      }
    }