import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int o = 1; o <= t; o++) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            int[] index = new int[n];
            char[] ch = new char[n];

            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
                index[i] = i + 1;
                ch[i] = 'x';
            }

            sortActivitiesByEndTime(start, end, index);

            if (assignActivities(start, end, ch)) {
                System.out.print("Case #" + o + ": ");
                printActivityAssignments(index, ch);
            } else {
                System.out.println("Case #" + o + ": IMPOSSIBLE");
            }
        }
    }

    private static void sortActivitiesByEndTime(int[] start, int[] end, int[] index) {
        for (int i = 0; i < end.length; i++) {
            for (int j = 0; j < end.length - i - 1; j++) {
                if (end[j] > end[j + 1]) {
                    swap(end, j, j + 1);
                    swap(start, j, j + 1);
                    swap(index, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean assignActivities(int[] start, int[] end, char[] ch) {
        int e = end[0];
        ch[0] = 'C';

        for (int i = 1; i < start.length; i++) {
            if (start[i] >= e) {
                ch[i] = 'C';
                e = end[i];
            }
        }

        int k = findFirstUnassignedActivity(ch);
        if (k == -1) return false;

        ch[k] = 'J';
        e = end[k];

        for (int i = k + 1; i < start.length; i++) {
            if (start[i] >= e && ch[i] != 'C') {
                ch[i] = 'J';
                e = end[i];
            }
        }

        return !hasUnassignedActivity(ch);
    }

    private static int findFirstUnassignedActivity(char[] ch) {
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'x') {
                return i;
            }
        }
        return -1;
    }

    private static boolean hasUnassignedActivity(char[] ch) {
        for (char c : ch) {
            if (c == 'x') {
                return true;
            }
        }
        return false;
    }

    private static void printActivityAssignments(int[] index, char[] ch) {
        for (int m = 1; m <= index.length; m++) {
            for (int i = 0; i < index.length; i++) {
                if (index[i] == m) {
                    System.out.print(ch[i]);
                }
            }
        }
        System.out.println();
    }
}