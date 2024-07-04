import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n,i,j,cc,cj;
        String ans;
        boolean flag;
        sc.nextLine();
        for(int z = 1; z<=t;z++){
            n = sc.nextInt();
            ans="";
            cc=-1;
            cj=-1;
            flag=false;
            int job[][] = new int[n][3];
            char ch[] = new char[n];
            for(i=0;i<n;i++){
                job[i][0] = sc.nextInt();
                job[i][1] = sc.nextInt();
                job[i][2] = i;
            }
            Arrays.sort(job, new Comparator<int[]>() { 
                @Override              
                public int compare(final int[] x,final int[] y) { 
                  if (x[0] > y[0]) 
                      return 1; 
                  else
                      return -1; 
                } 
              });
            for(i=0;i<n;i++){
                if(cc<=job[i][0]){
                    ch[job[i][2]] = 'C';
                    cc=job[i][1];
                } else if(cj<=job[i][0]){
                    ch[job[i][2]] = 'J';
                    cj=job[i][1];
                } else{
                    flag=true;
                    break;
                }
            }
            if(flag)
                System.out.println("Case #"+z+": IMPOSSIBLE");
            else
                System.out.println("Case #"+z+": "+String.valueOf(ch));
        }   
        sc.close();
    }
}
