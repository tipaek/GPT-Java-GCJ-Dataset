import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Solution{
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = Integer.parseInt(in.nextLine());
        for (int nooftestcases = 1; nooftestcases <= testcases; ++nooftestcases) {
            ArrayList<ArrayList<Double>> cameron = new ArrayList<>();
            ArrayList<ArrayList<Double>> jamie = new ArrayList<>();
            long nooftimes = Long.parseLong(in.nextLine());
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < nooftimes; i++) {
                ArrayList<Double> main_time = split_times(in.nextLine());
                if(main_time.size()<=1){
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
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


    public static ArrayList<Double> split_times(String times) throws Exception {
        String[] split = times.split(" ");
        ArrayList<Double> times_main = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            times_main.add(Double.parseDouble(split[i]));
        }
        return times_main;
    }

    public static boolean checkoverlap(ArrayList<ArrayList<Double>> list, ArrayList<Double> checklist) throws Exception {
        for (int j = 0; j < list.size(); j++) {
            if(testoverlap(list.get(j).get(0),list.get(j).get(1),
                    checklist.get(0),checklist.get(1))){
                return true;
            }
        }
        return false;
    }
    public static boolean testoverlap(double x1, double x2, double y1, double y2) throws Exception {
        return (x1 > y1 && x1 < y2) ||
                (x2 > y1 && x2 < y2) ||
                (y1 > x1 && y1 < x2) ||
                (y2 > x1 && y2 < x2);
    }
}
