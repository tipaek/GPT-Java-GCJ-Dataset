import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            //schedules for c and j false is free true is busy 0-1440
            boolean[] c = new boolean[1441];
            boolean[] j = new boolean[1441];
            boolean busyC = false;
            boolean busyJ = false;
            int start = 0;
            int end = 0;
            String output = "";
            //go through n tasks to try and assign
            for(int x=0; x<n; x++){
                start = in.nextInt();
                end = in.nextInt();
                for(int k=start; k<end; k++){
                    //check schedule for c and j
                    if(c[k]){
                        busyC = true;
                    }
                    if(j[k]){
                        busyJ = true;
                    }
                }
                if(!busyC){
                    output+="C";
                    //fill C's schedule
                    for(int k=start; k<end; k++){
                        c[k] = true;
                    }
                }
                else if(!busyJ){
                    output+="J";
                    //fill J's schedule
                    for(int k=start; k<end; k++){
                        j[k] = true;
                    }
                }
                else{
                    output="IMPOSSIBLE";
                    break;
                }
                busyC=false;
                busyJ=false;
            }
            System.out.println("Case #" + i + ": " + output);
        }
    }
}