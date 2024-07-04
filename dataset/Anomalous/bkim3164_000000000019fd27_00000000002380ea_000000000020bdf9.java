import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve(scanner);
            System.out.println();
        }
        scanner.close();
    }

    static void solve(Scanner scanner) {
        int N = scanner.nextInt();
        int[] startTimes = new int[N];
        int[] endTimes = new int[N];
        HashMap<Integer, Integer> timeMap = new HashMap<>();
        boolean isCameronBusy = false;
        boolean isJamieBusy = false;
        boolean isImpossible = false;
        StringBuilder schedule = new StringBuilder();

        for (int i = 0; i < N; i++) {
            startTimes[i] = scanner.nextInt();
            endTimes[i] = scanner.nextInt();
            timeMap.put(startTimes[i], endTimes[i]);
        }

        Arrays.sort(startTimes);
        int maxEndTime = Arrays.stream(endTimes).max().orElse(Integer.MIN_VALUE);

        outerLoop:
        for (int currentTime = 0; currentTime <= maxEndTime + 10; currentTime++) {
            for (int j = 0; j < N; j++) {
                if (startTimes[j] == currentTime) {
                    if (isCameronBusy && isJamieBusy) {
                        isImpossible = true;
                        break outerLoop;
                    } else if (isCameronBusy) {
                        isJamieBusy = true;
                        schedule.append("J");
                    } else {
                        isCameronBusy = true;
                        if (timeMap.containsKey(timeMap.get(startTimes[j])) && j != 0) {
                            schedule.append("J");
                        } else {
                            schedule.append("C");
                        }
                    }
                }

                if (timeMap.get(startTimes[j]) == currentTime) {
                    if (isCameronBusy) {
                        isCameronBusy = false;
                    } else {
                        isJamieBusy = false;
                    }
                }
            }
        }

        if (isImpossible) {
            System.out.print("IMPOSSIBLE");
        } else {
            System.out.print(schedule.toString());
        }
    }
}