import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        if (T < 1 || T > 100) return;

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            if (N < 2 || N > 1000) return;

            StringBuilder output = new StringBuilder();
            int[] startTimes = new int[N];
            int[] endTimes = new int[N];

            for (int j = 0; j < N; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();

                if (startTimes[j] < 0 || startTimes[j] > 1440 || endTimes[j] < 0 || endTimes[j] > 1440 || startTimes[j] > endTimes[j]) {
                    break;
                }
            }

            int cTrack = 0, jTrack = -1;
            String ongoing = "C";
            boolean possible = true;

            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    output.append("C");
                    cTrack = j;
                    ongoing = "C";
                    continue;
                }

                if (startTimes[j] < endTimes[j - 1]) {
                    if ("J".equals(ongoing)) {
                        if (endTimes[cTrack] - startTimes[cTrack] <= endTimes[j - 1] - startTimes[j - 1]) {
                            output.append("C");
                            ongoing = "C";
                            cTrack = j;
                        } else {
                            output = new StringBuilder("IMPOSSIBLE");
                            possible = false;
                            break;
                        }
                    } else {
                        if (jTrack != -1) {
                            if (endTimes[jTrack] - startTimes[jTrack] <= endTimes[j - 1] - startTimes[j - 1]) {
                                output.append("J");
                                ongoing = "J";
                                jTrack = j;
                            } else {
                                output = new StringBuilder("IMPOSSIBLE");
                                possible = false;
                                break;
                            }
                        } else {
                            output.append("J");
                            ongoing = "J";
                            jTrack = j;
                        }
                    }
                } else {
                    output.append(ongoing);
                }
            }

            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + output);
            }
        }
    }
}