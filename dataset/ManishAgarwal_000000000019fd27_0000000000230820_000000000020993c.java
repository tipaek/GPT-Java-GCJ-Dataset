import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
class Solution {
  public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
        int noOfTC = in.nextInt();
    int sum=0;
        for(int i=1; i<=noOfTC; i++) {
          sum=0;  
          int n=in.nextInt();
          int r=0;
          Integer[][] arr =new Integer[n][n];
          Integer[][] arr1 =new Integer[n][n];
            for(int j=0; j<n; j++) {
              Set<Integer> set=new HashSet<Integer>();
              for(int k=0; k<n; k++) {
                    arr[j][k]=in.nextInt();
                    arr1[k][j]=arr[j][k];
                    set.add(arr[j][k]);
                    if(j==k)
                      sum+=arr[j][k];
                }
                if(set.size()!=n)
                    r++;
              }
              int c=0;
           for(Integer[] a:arr1){
            Set<Integer> set = new HashSet<>(Arrays.asList(a));
             if(set.size()!=n)
                c++;   
            }
          
          System.out.println("Case #"+i+": "+sum+" "+r+" "+c);
        }
  }
}
