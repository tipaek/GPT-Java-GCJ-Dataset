import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input= new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T= input.nextInt();

        for (int i= 0; i < T; i++ ) {
            List<List<Integer>> intervals= new ArrayList<>();
            int numIntervals= input.nextInt();
            for (int j= 0; j < numIntervals; j++ ) {
                List<Integer> interval= new ArrayList<>();
                interval.add(input.nextInt());
                interval.add(input.nextInt());
                intervals.add(interval);
            }

            String caseNum= String.format("Case #%d: ", i + 1);
            System.out.println(caseNum + assign(intervals));
        }
    }

    public static String assign(List<List<Integer>> intervals) {
        // inv:
        Map<List<Integer>, Character> assignments= new HashMap<>();
        Map<Integer, List<Integer>> orgIndex= new HashMap<>();
        for (int i= 0; i < intervals.size(); i++ ) {
            orgIndex.put(i, intervals.get(i));
        }

        Collections.sort(intervals, (a, b) -> a.get(0) - b.get(0));

        int i= 0; // interval index
        int cBusy= 0;
        int jBusy= 0; // end time of busy-ness
        while (i < intervals.size()) {
            List<Integer> interval= intervals.get(i);
            if (interval.get(0) >= cBusy) {
                cBusy= interval.get(1);
                assignments.put(interval, 'C');
                i++ ;
            } else if (interval.get(0) >= jBusy) {
                jBusy= interval.get(1);
                i++ ;
                assignments.put(interval, 'J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result= new StringBuilder();
        for (int j= 0; j < intervals.size(); j++ ) {
            List<Integer> interval= orgIndex.get(j);
            result.append(assignments.get(interval));
        }

        return result.toString();
    }

}
