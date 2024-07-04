import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTest = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= numTest; i++) {
            List<Integer[]> C = new ArrayList<>();
            List<Integer[]> J = new ArrayList<>();
            String result = "";
            int numActivities = Integer.parseInt(in.nextLine());
            for (int j = 0; j < numActivities; j++) {
                String vals = in.nextLine();
                if (!result.equals("IMPOSSIBLE")) {
                   Scanner line = new Scanner(vals);
                   Integer[] event = {line.nextInt(), line.nextInt()};
                   if (!isBusy(C, event)) {
                       C.add(event);   
                       result += "C";
                   } else if (!isBusy(J, event)) {
                       J.add(event);
                       result += "J";
                   } else {
                       result = "IMPOSSIBLE";
                   }
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
        
        public static boolean isBusy(List<Integer[]> list, Integer[] event) {
            for (int i = 0; i < list.size(); i++) {
                if (overlapping(list.get(i), event)) {
                    return true;
                }
            }
            return false;
        }
        
        public static boolean overlapping(Integer[] event1, Integer[] event2) {
            if (event1[0] == event2[0]) {
                return true;
            } else if (event1[0] > event2[0] && event1[0] < event2[1]) {
                return true;
            } else if (event2[0] > event1[0] && event2[0] < event1[1]) {
                return true;
            } else if (event1[1] > event2[0] && event1[1] < event2[1]) {
                return true;
            } else if (event2[1] > event1[0] && event2[1] < event1[1]) {
                return true;
            } else {
                return false;
            }
        }
    }