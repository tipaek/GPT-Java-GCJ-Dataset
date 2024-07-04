import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = sc.nextInt();
        int testNum = 1;

        while (testCases-- > 0) {
            int N = sc.nextInt();
            int[] C = new int[2];
            int[] J = new int[2];
            StringBuilder ans = new StringBuilder();
            boolean isImpossible = false;

            sc.nextLine();
            int[] startTimes = new int[N];
            int[] sortedStartTimes = new int[N];
            int[] endTimes = new int[N];
            int[] originalStartTimes = new int[N];

            for (int i = 0; i < N; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
                originalStartTimes[i] = startTimes[i];
                sortedStartTimes[i] = startTimes[i];
                sc.nextLine();
            }

            Arrays.sort(sortedStartTimes);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (sortedStartTimes[i] == startTimes[j]) {
                        endTimes[i] = endTimes[j];
                        startTimes[j] = -1;
                        break;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                if (C[1] == 0 || sortedStartTimes[i] >= C[1]) {
                    C[0] = sortedStartTimes[i];
                    C[1] = endTimes[i];
                    ans.append("C");
                } else if (J[1] == 0 || sortedStartTimes[i] >= J[1]) {
                    J[0] = sortedStartTimes[i];
                    J[1] = endTimes[i];
                    ans.append("J");
                } else {
                    System.out.println("Case #" + testNum + ": IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            if (!isImpossible) {
                System.out.print("Case #" + testNum + ": ");
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (originalStartTimes[i] == sortedStartTimes[j]) {
                            System.out.print(ans.charAt(j));
                            sortedStartTimes[j] = -1;
                            break;
                        }
                    }
                }
                System.out.println();
            }

            testNum++;
        }
    }
}