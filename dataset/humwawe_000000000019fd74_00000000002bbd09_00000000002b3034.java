import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author hum
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        String result = "Case #%d: %s";
        for (int cas = 1; cas <= n; cas++) {
            int len = sc.nextInt();
            String[] arr = new String[len];
            String[] start = new String[len];
            String[] end = new String[len];
            int[][] index = new int[len][2];
            for (int i = 0; i < len; i++) {
                arr[i] = sc.next();
                int i1 = arr[i].indexOf("*");
                int i2 = arr[i].lastIndexOf("*");
                index[i][0] = i1;
                index[i][1] = i2;
                start[i] = arr[i].substring(0, i1);
                end[i] = arr[i].substring(i2 + 1);
            }
            Arrays.sort(start, Comparator.comparingInt(String::length));
            Arrays.sort(end, Comparator.comparingInt(String::length));
            boolean f = true;
            for (int i = 1; i < len; i++) {
                if (!start[i].startsWith(start[i - 1])) {
                    f = false;
                    break;
                }
            }
            for (int i = 1; i < len && f; i++) {
                if (!end[i].endsWith(end[i - 1])) {
                    f = false;
                    break;
                }
            }
            if (!f) {
                System.out.println(String.format(result, cas, "*"));
                continue;
            }
            StringBuilder res = new StringBuilder();
            res.append(start[len - 1]);
            for (int i = 0; i < arr.length; i++) {
                for (int j = index[i][0] + 1; j < index[i][1]; j++) {
                    char c = arr[i].charAt(j);
                    if (c != '*') {
                        res.append(c);
                    }
                }
            }
            res.append(end[len - 1]);
            System.out.println(String.format(result, cas, res.toString()));
        }
    }
}