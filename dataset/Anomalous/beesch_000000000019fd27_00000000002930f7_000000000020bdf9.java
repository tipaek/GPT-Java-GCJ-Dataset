import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();

            int[][] timeSlots = new int[1441][2];
            for (int i = 1; i <= testCases; ++i) {
                try {
                    int activities = scanner.nextInt();
                    scanner.nextLine();

                    boolean impossible = false;

                    // Reset timeSlots
                    for (int[] slot : timeSlots) {
                        slot[0] = 0;
                        slot[1] = 0;
                    }

                    for (int j = 1; j <= activities && scanner.hasNextLine(); ++j) {
                        String[] times = scanner.nextLine().split(" ");
                        int start = Integer.parseInt(times[0]);
                        int end = Integer.parseInt(times[1]);

                        for (int k = start; k < end; k++) {
                            if (k >= timeSlots.length) {
                                break;
                            }

                            if (timeSlots[k][0] == 0) {
                                timeSlots[k][0] = j;
                            } else if (timeSlots[k][1] == 0) {
                                timeSlots[k][1] = j;
                            } else {
                                impossible = true;
                                break;
                            }
                        }

                        if (impossible) {
                            break;
                        }
                    }

                    if (impossible) {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                    } else {
                        char[] result = new char[activities];

                        for (int x = 1; x < timeSlots.length; x++) {
                            if (timeSlots[x - 1][1] == timeSlots[x][0] && timeSlots[x][0] != 0) {
                                swap(timeSlots, x);
                            } else if (timeSlots[x - 1][0] == timeSlots[x][1] && timeSlots[x][1] != 0) {
                                swap(timeSlots, x);
                            }

                            if (timeSlots[x - 1][0] != timeSlots[x][0] && timeSlots[x - 1][0] != 0) {
                                result[timeSlots[x - 1][0] - 1] = 'C';
                            }
                            if (timeSlots[x - 1][1] != timeSlots[x][1] && timeSlots[x - 1][1] != 0) {
                                result[timeSlots[x - 1][1] - 1] = 'J';
                            }
                        }
                        System.out.println("Case #" + i + ": " + new String(result));
                    }
                } catch (NoSuchElementException | IllegalStateException e) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                }
            }
        }
    }

    private static void swap(int[][] timeSlots, int index) {
        int temp = timeSlots[index][0];
        timeSlots[index][0] = timeSlots[index][1];
        timeSlots[index][1] = temp;
    }
}