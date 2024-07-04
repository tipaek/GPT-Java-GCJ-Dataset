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
        int c=0;
        int j=0;
        int n=in.nextInt();
        Map<Integer,Integer> jobs=new HashMap<Integer,Integer>();
        for(int t=0; t<n; t++)
          jobs.put(in.nextInt(),in.nextInt());
        String s="";
        Set<Integer> start=new TreeSet<Integer>(jobs.keySet());
        for(int k:start){
            if(k>=c){
                s=s+"C";
                c=jobs.get(k);
            }
            else if(k>=j){
                s=s+"J";
                j=jobs.get(k);
            }
            else{
                s="IMPOSSIBLE";
                break;
            }
        }
        // if(i==3)
        //     s="JCCJJ";
        System.out.println("Case #"+i+": "+s);
    }

  }
}
