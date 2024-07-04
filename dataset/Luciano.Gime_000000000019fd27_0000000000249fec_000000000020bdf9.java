/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LUCIANO.
 */
import java.util.*;

public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.next());
        for(int tt = 0; tt < t; tt++) {
            int n = in.nextInt();
            Activity[] activities = new Activity[n];
            for(int i = 0; i < n; i++) activities[i] = new Activity(in.nextInt(), in.nextInt(), i);
            Arrays.sort(activities);
            int end = 0;
            for(int i = 0; i < n; i++) {
                if(activities[i].start >= end) {
                    activities[i].owner = "C";
                    end = activities[i].end;
                }
            }
            end = 0;
            for(int i = 0; i < n; i++) {
                if((activities[i].start >= end) && (!activities[i].owner.equals("C"))) {
                    activities[i].owner = "J";
                    end = activities[i].end;
                }
            }
            String[] ans = new String[n];
            boolean flag = true;
            for(int i = 0; i < n; i++) {
                if(activities[i].owner.equals(".")) {
                    flag = false;
                    break;
                }else {
                    ans[activities[i].index] = activities[i].owner;
                }
            }
            System.out.print("Case #" + (tt + 1) + ": ");
            if(flag == true) {
                System.out.print(Arrays.toString(ans).replace("[", "").replace("]", "").replace(",", "").replace(" ", ""));
            }else {
                System.out.print("IMPOSSIBLE");
            }
            System.out.print("\n");
        }
    }
}
class Activity implements Comparable<Activity> {
    Integer start;
    Integer end;
    Integer index;
    String owner;
    public Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
        this.owner = ".";
    }
    @Override
    public int compareTo(Activity obj) {
        return this.start.compareTo(obj.start);
    }
}