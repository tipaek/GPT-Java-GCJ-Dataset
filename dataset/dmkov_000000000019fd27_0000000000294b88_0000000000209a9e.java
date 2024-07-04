import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        int n = in.nextInt();
        for (int t = 1; t <= tests; t++) {

            int[] arr = new int[n+1];
            int i = 0;
            int query = 10;
            while (i <= n / 2 - 1) {
                if (query == 0) {
                    int[] val = getRemaining(arr, i, in);
                    query = val[0];
                    i = val[1];
                }
                if (query == 1) {
                    getNum(1, in);
                    query--;
                }
                while (query > 1 && i <= n / 2 - 1) {
                    arr[1 + i] = getNum(1+ i, in);
                    arr[n - i] = getNum(n - i, in);
                    query -= 2;
                    i++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < arr.length; j++) {
                sb.append(arr[j]);
            }
            System.out.println(sb.toString());

            // not sure...
            in.nextLine();
            String res = in.nextLine();
            if (res.equals("N")) {
                break;
            }

        }
    }

    private static int[] getRemaining(int[] arr, int i, Scanner in) {
        int query = 10;
        int k = 0;
        HashSet<Integer> set = new HashSet<>(Arrays.asList(new Integer[]{1,2,3,4}));
        boolean equalCheck = false;
        boolean notEqualCheck = false;

        while (query > 0 && k <= i) {
            int start = arr[1 + k];
            int end = arr[arr.length - 1 - k];

            if (start == end && equalCheck) {
                k++;
                continue;
            } else if (start != end && notEqualCheck) {
                k++;
                continue;
            }

            int start_ = getNum(1 + k, in);

            if (start == start_ && start == end) {
                set.remove(2);
                set.remove(4);
                equalCheck = true;
            }
            if (start == start_ && start != end) {
                set.remove(1);
                set.remove(2);
                notEqualCheck = true;
            }
            if (start != start_ && start == end) {
                set.remove(1);
                set.remove(3);
                equalCheck = true;
            }
            if (start != start_ && start != end) {
                set.remove(3);
                set.remove(4);
                notEqualCheck = true;
            }

            query--;
            k++;

            if (set.size() == 1) {
                break;
            }
        }

        updateArray(arr, set.iterator().next());
        return new int[]{query, i};
    }

    private static void updateArray(int[] arr, Integer scenario) {
        int n = (arr.length - 1);
        if (scenario == 1) {
            int i = 0;
            while (i != n / 2 - 1) {
                int temp = arr[1 + i];
                arr[1 + i] = arr[n - i];
                arr[n - i] = temp;
                i++;
            }
        } else if (scenario == 2) {
            for (int i = 1; i <= n; i++) {
                arr[i] = (arr[i] == 1) ? 0 : 1;
            }
        } else if (scenario == 4) {
            updateArray(arr, 1);
            updateArray(arr, 2);
        }
    }

    private static int getNum(int i, Scanner in) {
        System.out.println(i);
        return in.nextInt();
    }

}
