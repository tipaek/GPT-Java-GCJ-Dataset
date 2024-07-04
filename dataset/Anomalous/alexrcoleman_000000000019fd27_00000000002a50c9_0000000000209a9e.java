import java.util.Scanner;

public class Solution {
    static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            Env env = new Env(n, null);
            int[] result = env.solve();
            System.out.printf("Case #%d: ", t);
            for (int i : result) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    static class Env {
        int n, queryCount = 0;
        int[] mockArray;

        int equalCache = -1, nonEqualCache = -1;

        public Env(int n, int[] mockArray) {
            this.n = n;
            this.mockArray = mockArray;
        }

        void clearCache() {
            equalCache = -1;
            nonEqualCache = -1;
        }

        public int[] solve() {
            boolean[] equal = new boolean[n / 2];
            int[] base = new int[n / 2];

            int firstEqualIndex = -1, firstNonEqualIndex = -1;

            for (int i = 0; i < n / 2; i++) {
                if (queryCount % 10 == 9) {
                    poll(0);
                }
                if (queryCount % 10 == 0) {
                    clearCache();
                }
                base[i] = poll(i);
                equal[i] = base[i] == poll(n - 1 - i);
                if (equal[i]) {
                    if (firstEqualIndex == -1) {
                        firstEqualIndex = i;
                    } else {
                        if (queryCount % 10 == 0 && equalCache == -1) {
                            base[i] = poll(i);
                        }
                        int polledValue = (equalCache == -1) ? poll(firstEqualIndex) : equalCache;
                        equalCache = polledValue;
                        int flips = polledValue ^ base[firstEqualIndex];
                        base[i] ^= flips;
                    }
                } else {
                    if (firstNonEqualIndex == -1) {
                        firstNonEqualIndex = i;
                    } else {
                        if (queryCount % 10 == 0 && nonEqualCache == -1) {
                            base[i] = poll(i);
                        }
                        int polledValue = (nonEqualCache == -1) ? poll(firstNonEqualIndex) : nonEqualCache;
                        nonEqualCache = polledValue;
                        int flips = polledValue ^ base[firstNonEqualIndex];
                        base[i] ^= flips;
                    }
                }
            }

            while (queryCount % 10 >= 8) {
                poll(0);
            }

            int equalFlips = 0, nonEqualFlips = 0;
            if (firstEqualIndex != -1) {
                equalFlips = poll(firstEqualIndex) ^ base[firstEqualIndex];
            }
            if (firstNonEqualIndex != -1) {
                nonEqualFlips = poll(firstNonEqualIndex) ^ base[firstNonEqualIndex];
            }

            int[] result = new int[n];
            for (int i = 0; i < n / 2; i++) {
                if (equal[i]) {
                    result[i] = base[i] ^ equalFlips;
                    result[n - 1 - i] = result[i];
                } else {
                    result[i] = base[i] ^ nonEqualFlips;
                    result[n - 1 - i] = 1 - result[i];
                }
            }
            return result;
        }

        int poll(int index) {
            if (mockArray != null) {
                if (queryCount % 10 == 0) {
                    boolean swap = Math.random() < 0.5;
                    boolean negate = Math.random() < 0.5;
                    if (negate) {
                        for (int i = 0; i < n; i++) {
                            mockArray[i] = 1 - mockArray[i];
                        }
                    }
                    if (swap) {
                        for (int i = 0; i < n / 2; i++) {
                            int temp = mockArray[i];
                            mockArray[i] = mockArray[n - 1 - i];
                            mockArray[n - 1 - i] = temp;
                        }
                    }
                }
                queryCount++;
                return mockArray[index];
            }
            queryCount++;
            System.out.println(index + 1);
            System.out.flush();
            return in.nextInt();
        }
    }
}