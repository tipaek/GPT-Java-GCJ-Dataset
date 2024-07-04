
import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));    
    int t = in.nextInt(); //number of tests
    for (int i = 1; i <= t; ++i) {
        boolean possible = true;
        int n = in.nextInt(); //num of activites
        int[][] time = new int[n][4];
        //[start][end][orignal order][parent]
        for(int act = 0; act < n; act++){
             time[act][0] = in.nextInt();
             time[act][1] = in.nextInt();
             time[act][2] = act;
            //System.out.println(time[act][0] + "-" +time[act][1]);
        }
        
        //sort array by start time
        java.util.Arrays.sort(time, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        int[] parentEnd = new int[2]; //keep track of end time. c =0, j = 1
        String[] parents = {"C", "J"};
        //time[0][3] = parent;
        for(int act = 0; act < n; act++){
            //check the start time of next activity is after last end
            if(time[act][0] >= parentEnd[0]){//can C do it?
                time[act][3] = 0;
                parentEnd[0] = time[act][1]; //update end time
            } else if(time[act][0] >= parentEnd[1]){ //can J do it?
                time[act][3] = 1;
                parentEnd[1] = time[act][1];
            } else{
                possible = false;   
            }
        }
        
        //if impossible
        if(!possible){
            System.out.println("Case #" + i +": IMPOSSIBLE" );
        }
        else{
            //resort the array
            java.util.Arrays.sort(time, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[2], b[2]);
                }
            });
            System.out.print("Case #" + i +": " );
            for(int act = 0; act < n; act++){
                System.out.print(parents[time[act][3]]);
            }
            System.out.println();
        }
    }
  } 
}
