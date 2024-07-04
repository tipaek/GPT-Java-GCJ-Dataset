import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(s.nextLine());
        String ans;
        String[] dirs;
        int[][] holes;
        int num;
        for (int q = 1; q <= cases; q++) {
            num = Integer.parseInt(s.nextLine());
            holes = new int[num][2];
            for (int x = 0; x < holes.length; x++) {
                dirs = s.nextLine().split(" ");
                holes[x][0] = Integer.parseInt(dirs[0]);
                holes[x][1] = Integer.parseInt(dirs[1]);
                
            }
            ans = ""+golf(holes);
            System.out.println("Case #"+q+": "+ans);
        }
    }
    public static int golf(int[][] holes) {
        HashMap<Double,Integer> pair = new HashMap<Double,Integer>();
        HashMap<Double,Boolean> sofar;
        double input;
        for (int x = 0; x < holes.length; x++) {
            sofar = new HashMap<Double,Boolean>();
            for (int i = 0; i < holes.length; i++) {
                if (i != x) {
                    if (holes[x][0] == holes[i][0]) {
                        input = Double.POSITIVE_INFINITY;
                    }
                    else {
                        input = (0.0+holes[i][1]-holes[x][1])/(0.0+holes[i][0]-holes[x][0]);
                    }
                    if (!sofar.containsKey(input) || sofar.get(input)) {
                        if (!pair.containsKey(input)) {
                            pair.put(input,0);
                        }
                        if (i < x) {
                            sofar.put(input,true);
                        }
                        else {
                            sofar.put(input,false);
                            pair.put(input,pair.get(input)+2);
                        }
                    }
                    else {
                        pair.put(input,pair.get(input)-1);
                    }
                }
            }
        }
        int high = 0;
        for (Map.Entry m : pair.entrySet()) {
            high = Math.max(high,(Integer)m.getValue());
        }
        return Math.min(high+2,holes.length);
    }
}