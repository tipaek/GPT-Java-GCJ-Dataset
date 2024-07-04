import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; ++i) {
            Integer U = Integer.parseInt(in.nextLine());
            int[][] map = new int[10][26];

            int i1 = 10000;
            for (int j = 0; j < i1; j++) {
                String[] s = in.nextLine().split(" ");

                if (s[0].equals("-1")) {
                    continue;
                }

                String r = s[0];
                if (s[0].length() > s[1].length()) {
                    r = lpad99(s[1].length());
                }

                for (int k = 0; k < r.length(); k++) {
                    int code = s[1].charAt(k) - 'A';
                    int max = r.charAt(k) - '0';
                    int min = k>0 ? 0 : 1;
                    for (int z = min; z <= max; z++) {
                        map[z][code] += ((max + 1) * 100) / 10;
                    }
                }

            }

            String result = printResult(map);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String printResult(final int[][] map) {
//        for (int i = 0; i < 26; i++) {
//            System.out.print((char) ('A' + i));
//            System.out.print('\t');
//        }
//        System.out.println();
//
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                if (j == 0) {
//                    System.out.print(i + ") ");
//                }
//                System.out.print(map[i][j]);
//                System.out.print('\t');
//            }
//            System.out.println();
//        }

        StringBuilder sb = new StringBuilder();
        Set<Integer> used = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            int maxindex = -1;
            int maxval = 0;
            for (int j = 0; j < map[i].length; j++) {
                if (!used.contains(j) && maxval < map[i][j]) {
                    maxval = map[i][j];
                    maxindex = j;
                }
            }
            char x = (char) ('A' + maxindex);
            if (maxindex < 0) {
                throw new RuntimeException();
            }
            used.add(maxindex);
            sb.append(x);
        }
        return sb.toString();
    }

    static String lpad99(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append('9');
        }
        return sb.toString();
    }

}
