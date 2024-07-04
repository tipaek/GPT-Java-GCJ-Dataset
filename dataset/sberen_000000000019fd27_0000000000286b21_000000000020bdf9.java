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
                Integer[] event2 = list.get(i);
                if (Math.max(event2[0], event[0]) < Math.min(event[1], event2[1])) {
                    return true;
                }
            }
            return false;
        }
    }