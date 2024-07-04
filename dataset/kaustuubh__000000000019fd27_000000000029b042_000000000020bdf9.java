import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void sortbyColumn(int arr[][], int col) {
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(final int[] entry1, final int[] entry2) {
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ttt = scan.nextInt();
        for (int t1 = 0; t1 < ttt; t1++) {

            int n = scan.nextInt();
            int cfree = -1, jfree = -1, flag = 0;
            char[] s = new char[n + 1];
            for (int i = 0; i < s.length; i++) {
                s[i] = ' ';
            }
            int arr[][] = new int[n][3];
            for (int i = 0; i < n; i++) {
                arr[i][0] = scan.nextInt();
                arr[i][1] = scan.nextInt();
                arr[i][2] = i;
            }
            sortbyColumn(arr, 0);
            s[arr[0][2]] = 'C';
            cfree = arr[0][1];
            flag = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i][0] >= cfree) {
                    s[arr[i][2]] = 'C';
                    cfree = arr[i][1];
                } else if (arr[i][0] < cfree && jfree == -1) {
                    jfree = arr[i][1];
                    s[arr[i][2]] = 'J';
                } else if (arr[i][0] < cfree && arr[i][0] >= jfree) {
                    jfree = arr[i][1];
                    s[arr[i][2]] = 'J';
                } else if (arr[i][0] < cfree && arr[i][0] < jfree) {
                    flag = 1;
                    break;
                }
            }
            String s1 = "";
            for (char c: s) {
                s1 = s1.concat(String.valueOf(c));
            }
            if (flag == 0) System.out.print("Case #" + (t1 + 1) + ": " + s1 + "\n");
            else System.out.print("Case #" + (t1 + 1) + ": IMPOSSIBLE\n");
        }
    }

}