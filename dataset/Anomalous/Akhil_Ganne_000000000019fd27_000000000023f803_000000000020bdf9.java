import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            writer.write("Case #" + caseNumber + ": ");
            int n = Integer.parseInt(reader.readLine());
            int[] cSchedule = new int[24 * 60 + 1];
            int[] jSchedule = new int[24 * 60 + 1];
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int k = 0; k < n; k++) {
                String[] input = reader.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                boolean assignedToC = true;

                for (int i = start; i < end; i++) {
                    if (cSchedule[i] != 0) {
                        assignedToC = false;
                        break;
                    }
                }

                if (assignedToC) {
                    result.append("C");
                    for (int i = start; i < end; i++) {
                        cSchedule[i] = 1;
                    }
                } else {
                    boolean assignedToJ = true;
                    for (int i = start; i < end; i++) {
                        if (jSchedule[i] != 0) {
                            assignedToJ = false;
                            break;
                        }
                    }

                    if (assignedToJ) {
                        result.append("J");
                        for (int i = start; i < end; i++) {
                            jSchedule[i] = 1;
                        }
                    } else {
                        possible = false;
                    }
                }
            }

            if (possible) {
                writer.write(result.toString() + "\n");
            } else {
                writer.write("IMPOSSIBLE\n");
            }
        }
        writer.flush();
    }
}