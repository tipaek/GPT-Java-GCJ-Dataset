
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i +": ");
            int[] all = new int[60*24 +1];
            int n = in.nextInt();
            StringBuffer sb = new StringBuffer();
            for (int j=0; j < n; j++) {
                String assignmentTo = assignTo(all, in.nextInt(), in.nextInt());
                if (assignmentTo.length() > 1) {
                    sb = new StringBuffer(assignmentTo);
                    break;
                } else {
                    sb.append(assignmentTo);
                }
            }
            System.out.println(sb.toString());
        }


    }

    static String assignTo(int[] all, int start, int end) {

        boolean doneByC = false; // 1
        boolean doneByJ = false; // 2

        for (int i = start; i < end; i++) {
            if (all[i] == 1) {
                doneByC = true;
            }
            if (all[i] == 2) {
                doneByJ = true;
            }
            if (all[i] == 3 || doneByC && doneByJ) {
                return "IMPOSSIBLE";
            }
        }

        String result = "C";
        int toAdd = 1;
        if (doneByC) {
            result =  "J";
            toAdd = 2;
        }
        for (int i = start; i < end; i++) {
            all[i] += toAdd;
        }
        return result;
    }

}
