import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = Integer.parseInt(in.nextLine());
        for (int nooftestcases = 1; nooftestcases <= testcases; ++nooftestcases) {
            ArrayList<ArrayList<Integer>> cameron = new ArrayList<>();
            ArrayList<ArrayList<Integer>> jamie = new ArrayList<>();
            int nooftimes = Integer.parseInt(in.nextLine());
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < nooftimes; i++) {
                ArrayList<Integer> main_time = split_times(in.nextLine());
                boolean jamieoverlap = checkoverlap(jamie, main_time);
                if (!jamieoverlap) {
                    jamie.add(main_time);
                    result.append("J");
                }
                else {
                    boolean cameronoverlap = checkoverlap(cameron, main_time);
                    if (!cameronoverlap) {
                        cameron.add(main_time);
                        result.append("C");
                    }
                    else{
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }

            }
            System.out.println("Case #" + nooftestcases + ": " + result);
        }
    }


    public static ArrayList<Integer> split_times(String times) {
        String[] split = times.split(" ");
        ArrayList<Integer> times_main = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            times_main.add(Integer.parseInt(split[i]));
        }
        return times_main;
    }

    public static boolean checkoverlap(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> checklist) {
        for (int j = 0; j < list.size(); j++) {
            if(testoverlap(list.get(j).get(0),list.get(j).get(1),
                    checklist.get(0),checklist.get(1))){
                return true;
            }
        }
        return false;
    }
    public static boolean testoverlap(int x1, int x2, int y1, int y2) {
        return (x1 > y1 && x1 < y2) ||
                (x2 > y1 && x2 < y2) ||
                (y1 > x1 && y1 < x2) ||
                (y2 > x1 && y2 < x2);
    }
}