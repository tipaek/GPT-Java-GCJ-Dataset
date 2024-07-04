import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int o = 1; o <= t; o++) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            int[] index = new int[n];
            char[] ch = new char[n];
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
                index[i] = i;
                ch[i] = 'x';
            }
            
            sortActivities(start, end, index, n);
            
            if (assignActivities(start, end, ch, n)) {
                for (int m = 0; m < n; m++) {
                    result.append(ch[index[m]]);
                }
                System.out.println("Case #" + o + ": " + result);
            } else {
                System.out.println("Case #" + o + ": IMPOSSIBLE");
            }
        }
    }

    private static void sortActivities(int[] start, int[] end, int[] index, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
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

    private static boolean assignActivities(int[] start, int[] end, char[] ch, int n) {
        int cEnd = -1, jEnd = -1;

        for (int i = 0; i < n; i++) {
            if (start[i] >= cEnd) {
                ch[i] = 'C';
                cEnd = end[i];
            } else if (start[i] >= jEnd) {
                ch[i] = 'J';
                jEnd = end[i];
            } else {
                return false;
            }
        }
        return true;
    }
}