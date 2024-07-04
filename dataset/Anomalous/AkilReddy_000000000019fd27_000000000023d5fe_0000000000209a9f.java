import java.util.*;
import java.io.*;

class Solution {
    public static String buildString(char c, int n) {
        char[] arr = new char[n];
        Arrays.fill(arr, c);
        return new String(arr);
    }

    public static String change(String str) {
        int length = str.length();
        Integer[] ari = new Integer[length];
        for (int i = 0; i < length; i++) {
            ari[i] = Character.getNumericValue(str.charAt(i));
        }

        int min = Arrays.stream(ari).min(Integer::compare).orElse(10);
        for (int i = 0; i < length; i++) {
            ari[i] -= min;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(ari[i]);
        }

        int st = 0;
        for (int i = 0;; i++) {
            if (sb.charAt(i) == '0') {
                if (st != i) {
                    String chs = change(sb.substring(st, i));
                    sb.replace(st, i, chs);
                    i += chs.length() - (i - st);
                }
                st = i + 1;
            } else if (i == sb.length() - 1) {
                sb.replace(st, i + 1, change(sb.substring(st, i + 1)));
                break;
            }
            if (i + 1 >= sb.length()) break;
        }

        sb.insert(0, buildString('(', min));
        sb.append(buildString(')', min));
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int it = 1; it <= t; it++) {
            String str = scanner.next();
            StringBuilder sb = new StringBuilder(str);
            int st = 0;

            for (int i = 0;; i++) {
                if (sb.charAt(i) == '0') {
                    if (st != i) {
                        String chs = change(sb.substring(st, i));
                        sb.replace(st, i, chs);
                        i += chs.length() - (i - st);
                    }
                    st = i + 1;
                } else if (i == sb.length() - 1) {
                    sb.replace(st, i + 1, change(sb.substring(st, i + 1)));
                    break;
                }
                if (i + 1 >= sb.length()) break;
            }

            int ik = 0;
            for (int i = 0; i < sb.length(); i++) {
                if (Character.isDigit(sb.charAt(i))) {
                    sb.replace(i, i + 1, Character.toString(str.charAt(ik)));
                    ik++;
                }
            }

            System.out.println("Case #" + it + ": " + sb);
        }

        scanner.close();
    }
}