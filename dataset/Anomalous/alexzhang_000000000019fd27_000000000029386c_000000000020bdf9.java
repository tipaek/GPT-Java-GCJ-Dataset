import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            System.out.print("Case #" + caseNum + ": ");
            int N = Integer.parseInt(br.readLine());
            int[] startTimes = new int[N];
            int[] endTimes = new int[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                startTimes[i] = Integer.parseInt(st.nextToken());
                endTimes[i] = Integer.parseInt(st.nextToken());
            }

            boolean foundSolution = false;

            for (int mask = 0; mask < (1 << N); mask++) {
                String assignment = Integer.toBinaryString(mask);
                while (assignment.length() < N) {
                    assignment = "0" + assignment;
                }

                boolean isValid = true;
                for (int t = 0; t <= 1440; t++) {
                    int joeCount = 0;
                    int camCount = 0;

                    for (int i = 0; i < N; i++) {
                        if (startTimes[i] <= t && t < endTimes[i]) {
                            if (assignment.charAt(i) == '0') {
                                joeCount++;
                            } else {
                                camCount++;
                            }
                        }
                    }

                    if (joeCount >= 2 || camCount >= 2) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    for (int i = 0; i < N; i++) {
                        System.out.print(assignment.charAt(i) == '0' ? 'J' : 'C');
                    }
                    System.out.println();
                    foundSolution = true;
                    break;
                }
            }

            if (!foundSolution) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}