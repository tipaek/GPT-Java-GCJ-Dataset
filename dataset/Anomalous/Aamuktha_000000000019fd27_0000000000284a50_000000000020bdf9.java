import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int h = 1; h <= t; h++) {
            int n = sc.nextInt();
            int[] startTimes = new int[n + 1];
            int[] endTimes = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
            }

            StringBuilder answer = new StringBuilder();
            boolean isPossible = true;

            List<Integer> JStart = new ArrayList<>();
            List<Integer> JEnd = new ArrayList<>();
            List<Integer> CStart = new ArrayList<>();
            List<Integer> CEnd = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                boolean isJAvailable = checkAvailability(startTimes[i], endTimes[i], JStart, JEnd);
                boolean isCAvailable = checkAvailability(startTimes[i], endTimes[i], CStart, CEnd);

                if (!isJAvailable && !isCAvailable) {
                    isPossible = false;
                    break;
                } else if (isCAvailable) {
                    CStart.add(startTimes[i]);
                    CEnd.add(endTimes[i]);
                    answer.append("C");
                } else if (isJAvailable) {
                    JStart.add(startTimes[i]);
                    JEnd.add(endTimes[i]);
                    answer.append("J");
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + h + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + h + ": " + answer.toString());
            }
        }
    }

    private static boolean checkAvailability(int start, int end, List<Integer> startArray, List<Integer> endArray) {
        if (startArray.isEmpty()) {
            return true;
        }

        for (int i = 0; i < startArray.size(); i++) {
            int a, b, c, d;
            if (start < startArray.get(i)) {
                a = start;
                b = end;
                c = startArray.get(i);
                d = endArray.get(i);
            } else {
                c = start;
                d = end;
                a = startArray.get(i);
                b = endArray.get(i);
            }
            if (b > c) {
                return false;
            }
        }
        return true;
    }
}