import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] cameron = new int[1440];
            int[] jamie = new int[1440];
            StringBuilder result = new StringBuilder();

            boolean impossible = false;
            
            for (int n = 0; n < N; n++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();
                
                if (impossible) {
                    continue;
                }

                boolean isCameronAvail = true;
                for (int i = startTime; i < endTime; i++) {
                    if (cameron[i] > 0) {
                        isCameronAvail = false;
                        break;
                    }
                }

                boolean isJamieAvail = true;
                for (int i = startTime; i < endTime; i++) {
                    if (jamie[i] > 0) {
                        isJamieAvail = false;
                        break;
                    }
                }

                if (isCameronAvail) {
                    result.append("C");
                    for (int i = startTime; i < endTime; i++) {
                        cameron[i]++;
                    }
                } else if (isJamieAvail) {
                    result.append("J");
                    for (int i = startTime; i < endTime; i++) {
                        jamie[i]++;
                    }
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                }
            }

            System.out.println("Case #" + test_case + ": " + result);
        }
    }
}