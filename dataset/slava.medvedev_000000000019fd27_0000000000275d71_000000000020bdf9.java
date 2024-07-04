import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        ScanWrapper input = new ScanWrapper();
        int testsNum = input.nextInt();
        outer:
        for (int testIndex = 0; testIndex < testsNum; testIndex++) {
            int activitiesNum = input.nextInt();
            int[][] activities = new int[activitiesNum][];
            for (int i = 0; i < activitiesNum; i++) {
                activities[i] = input.nextLine();
            }
            Arrays.sort(activities, Comparator.comparingInt(i -> i[0]));

            StringBuilder sb = new StringBuilder();
            SortedClosesStack endStack = new SortedClosesStack();
            for (int[] activity : activities) {
                endStack.removeBelow(activity[0]);
                if (endStack.size == 2) {
                    System.out.println("Case #" + (testIndex + 1) + ": IMPOSSIBLE");
                    continue outer;
                }
                sb.append(endStack.add(activity[1]));
            }

            System.out.println("Case #" + (testIndex + 1) + ": " + sb);
        }
    }

    private static class ScanWrapper {
        private final Scanner scanner;

        ScanWrapper() {
            scanner = new Scanner(System.in);
        }

        int nextInt() {
            return Integer.parseInt(scanner.nextLine());
        }

        int[] nextLine() {
            String[] strings = scanner.nextLine().split(" ");
            return new int[]{
                    Integer.parseInt(strings[0]),
                    Integer.parseInt(strings[1])
            };
        }
    }

    private static class SortedClosesStack {
        private int size = 0;
        private int[] items = new int[2];
        private char[] busyStack = new char[2];

        void removeBelow(int value) {
//            System.out.println("Removing " + value + " from stack " + toString());
            if (size > 0) {
                if (value >= items[0]) {
                    if (value >= items[1]) {
                        size = 0;
                        items[0] = 0;
                        busyStack[0] = ' ';
                    } else {
                        size = 1;
                        items[0] = items[1];
                        busyStack[0] = busyStack[1];
                    }
                    items[1] = 0;
                    busyStack[1] = ' ';
                }
            }
//            System.out.println("Result: " + toString());
        }

        char add(int item) {
            char result = ' ';
            if (size == 0) {
                items[0] = item;
                busyStack[0] = 'C';
                result = 'C';
                size++;
            } else if (size == 1) {
                if (item >= items[0]) {
                    items[1] = item;
                    result = busyStack[0] == 'C' ? 'J' : 'C';
                    busyStack[1] = result;
                } else {
                    int tmp = items[0];
                    items[0] = item;
                    items[1] = tmp;
                    result = busyStack[0] == 'C' ? 'J' : 'C';
                    busyStack[1] = busyStack[0];
                    busyStack[0] = result;
                }
                size++;
            }
            return result;
        }

        @Override
        public String toString() {
            return "size=" + size + ", items=" + Arrays.toString(items) + ", busy=" + Arrays.toString(busyStack);
        }
    }

}