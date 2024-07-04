import java.util.*;
import java.io.*;

class Interval {
    int start;
    int end;
    
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public boolean isOccupied(int start, int end) {
        if((end < this.end && end > this.start) || (end > this.end && start < this.end))
            return true;
        return false;
    }
    public static boolean assign(ArrayList<Interval> list, int start, int end) {
        for(Interval i : list) 
            if(i.isOccupied(start, end))
                return false;
                
        list.add(new Interval(start, end));
        return true;
    }
}

public class Solution {
    public static void main(String []args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for(int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            ArrayList<Interval> cList = new ArrayList<>();
            ArrayList<Interval> jList = new ArrayList<>();
            String ans = new String();
            int start, end;
            for(int j = 0; j < n; j++) {
                start = sc.nextInt();
                end = sc.nextInt();
                if(Interval.assign(cList, start, end))
                    ans += "C";
                else if(Interval.assign(jList, start, end))
                    ans += "J";
                else {
                    ans = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case # " + i + ": " + ans);
        }
    }
}