import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int b = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            makeAGuess(in, b);
        }
    }

    public static boolean makeAGuess(Scanner in, int b) {
        int diff = -1, same = -1;
        int[] result = new int[b];
        for (int i = 0, time = 0; i <= (result.length - 1) / 2; i++) {
            if (time > 0 && time % 10 == 0) {
                // calculate change
                if (diff == -1 || same == -1) {
                    int target = diff == -1 ? same : diff;
                    System.out.println(target + 1);
                    time++;
                    if (in.nextInt() != result[target]) {
                        complement(result, i);
                    }

                    // burn a query
                    System.out.println(1);
                    in.nextLine();
                } else {
                    System.out.println(same + 1);
                    time++;
                    boolean sameChange = in.nextInt() != result[same];

                    System.out.println(diff + 1);
                    time++;
                    boolean diffChange = in.nextInt() != result[diff];

                    if (diffChange && sameChange) {
                        complement(result, i);
                    } else if (diffChange && !sameChange) {
                        reverse(result, i);
                    } else if (!diffChange && sameChange) {
                        both(result, i);
                    }
                }
            }

            System.out.println(i + 1);
            time++;
            result[i] = in.nextInt();

            System.out.println(b - i);
            time++;
            result[b - i - 1] = in.nextInt();

            if (diff == -1 && result[i] != result[b - i - 1]) {
                diff = i;
            }
            if (same == -1 && result[i] == result[b - i - 1]) {
                same = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : result) {
            sb.append(n);
        }

        System.out.println(sb.toString());

        return "Y".equals(in.next());
    }

    private static void complement(int[] arr, int len) {
        for (int left = 0, right = arr.length - 1; left <= len; left++, right--) {
            arr[left] = arr[left] == 0 ? 1 : 0;
            arr[right] = arr[right] == 0 ? 1 : 0;
        }
    }

    private static void reverse(int[] arr, int len) {
        for (int left = 0, right = arr.length - 1; left <= len; left++, right--) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }

    private static void both(int[] arr, int len) {
        for (int left = 0, right = arr.length - 1; left <= len; left++, right--) {
            int tmp = arr[left] == 0 ? 1 : 0;
            arr[left] = arr[right] == 0 ? 1 : 0;
            arr[right] = tmp;
        }
    }
}
