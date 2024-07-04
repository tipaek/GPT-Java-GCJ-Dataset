package USACO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for(int test = 1; test <= t; test++){
            int n= in.nextInt();
            Interval[] acts = new Interval[n];
            for(int i = 0; i<n; i++){
               acts[i] = new Interval(in.nextInt(), in.nextInt(), i);
            }

            Arrays.sort(acts);
            Interval c = null;
            Interval j = null;
            String[] ans = new String[n];
            boolean check = false;
            for(int i = 0; i<acts.length; i++){
                if(c == null) {
                    c = acts[i];

                    ans[acts[i].index] = "C";
                }
                else{
                    if(c.end <= acts[i].start){
                        c = acts[i];
                        ans[acts[i].index] = "C";
                    }
                    else{
                        if(j == null){
                            j = acts[i];
                            ans[acts[i].index] = "J";
                        }
                        else{
                            if(j.end <= acts[i].start){
                                j= acts[i];
                                ans[acts[i].index] = "J";
                            }
                            else {
                                System.out.println("Case #" + test + ": IMPOSSIBLE");
                                check = true;
                            }
                        }
                    }
                }

            }

            if(!check){
                System.out.print("Case #" + test +": ");
                for(String a : ans) System.out.print(a);
                System.out.println();
            }


        }
    }
}

class Interval implements Comparable<Interval>{
    int start;
    int end;
    int index;

    public Interval(int start, int end, int index){
        this.start = start;
        this.end = end;
        this.index = index;

    }

    public int compareTo(Interval i){
        return ((Integer)start).compareTo(i.start);
    }
}
