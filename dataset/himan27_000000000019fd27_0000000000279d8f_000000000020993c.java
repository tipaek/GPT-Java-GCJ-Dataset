import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int i,j,k;
    
    
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    //System.out.println(t);
    
    for (k = 1; k <= t; ++k) {
        long r=0,c=0;
        long d = 0;
    int n = in.nextInt();
    int m[][] = new int[n][n];
    //input
    for(i=0;i<n;i++){
        for(j=0;j<n;j++){
            m[i][j] = in.nextInt();
        }
    }
    
    //row count
    for(i=0;i<n;i++){
        Set<Integer> s=new HashSet<>();
        for(j=0;j<n;j++){
            if(s.contains(m[i][j])){
                c++;
                break;
            }
            s.add(m[i][j]);
        }
    }
    
    //column count
    for(i=0;i<n;i++){
        Set<Integer> s1=new HashSet<>();
        for(j=0;j<n;j++){
            if(s1.contains(m[j][i])){
                r++;
                break;
            }
            s1.add(m[j][i]);
        }
    }
    
    //diagonal count
    for(i=0;i<n;i++){
        for(j=0;j<n;j++){
            if(i==j){
                d+=m[i][j];
            }
        }
    }
    
    System.out.println(d+" "+c+" "+r);
    }
  }
}