import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {

    public static boolean can(ArrayList<ArrayList<Integer>> schedule, ArrayList<Integer> interval) {
        if (schedule.isEmpty()) {
            return true;
        }

        for (int i = 0; i < schedule.size(); i++) {
            if (i == 0 && interval.get(1) <= schedule.get(i).get(0)) {
                return true;
            }
            if (i == schedule.size() - 1 && schedule.get(i).get(1) <= interval.get(0)) {
                return true;
            }
            if (i > 0 && schedule.get(i - 1).get(1) <= interval.get(0) && interval.get(1) <= schedule.get(i).get(0)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Comparator<ArrayList<Integer>> compare = Comparator.comparingInt(o -> o.get(0));
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                ArrayList<Integer> interval = new ArrayList<>();
                interval.add(Integer.parseInt(input[0]));
                interval.add(Integer.parseInt(input[1]));
                intervals.add(interval);
            }

            ArrayList<ArrayList<Integer>> C = new ArrayList<>();
            ArrayList<ArrayList<Integer>> J = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            
            for (ArrayList<Integer> interval : intervals) {
                if (can(C, interval)) {
                    result.append("C");
                    C.add(interval);
                    C.sort(compare);
                } else if (can(J, interval)) {
                    result.append("J");
                    J.add(interval);
                    J.sort(compare);
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            bw.write("Case #" + (i + 1) + ": " + result.toString());
            bw.newLine();
        }
        bw.flush();
    }
}