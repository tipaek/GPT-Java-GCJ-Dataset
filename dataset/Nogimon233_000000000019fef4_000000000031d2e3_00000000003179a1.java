import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        //.out.println("codejam");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String temp = in.nextLine();

        int max = 10000;

        for (int i = 1; i <= t; ++i) {
            String us = in.nextLine();
            int u = Integer.parseInt(us);
            String[] input = new String[max];
            String[] output = new String[max];
            for (int j = 0; j < max; j++) {
                String line = in.nextLine();
                String[] ss = line.split(" ");
                //int x = Integer.parseInt(ss[0]);
                input[j] = ss[0];
                output[j] = ss[1];
            }

            String ans = solve(input, output);
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static String solve(String[] input, String[] output) {
        Set<Character>[] sets = new Set[10];
        Set<Character> all = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            sets[i] = new HashSet<>();
        }

        for (int i = 0; i < input.length; i++) {
            //check skip
            if (input[i].charAt(0) == '-') {
                continue;
            }
            int in = input[i].charAt(0) - '0';
            char out = output[i].charAt(0);

            if (input[i].length() == output[i].length()) {
                sets[in].add(out);
            }

            for (int j = 0; j < output[i].length(); j++) {
                all.add(output[i].charAt(j));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            char curr = sets[i].iterator().next();
            sb.append(curr);

            for (int j = i+1; j <= 9; j++) {
                sets[j].remove(curr);
            }
            all.remove(curr);
        }
        char curr = all.iterator().next();
        sb.insert(0, curr);
        return sb.toString();




    }


    private static String solve0(int x, int y, String s) {
        char[] route = s.toCharArray();
        int t = 0;
        int n = route.length;

        for (int i = 0; i < n; i++) {
            int curr = Math.abs(x) + Math.abs(y);
            if (curr <= t) {
                return String.valueOf(i);
            }

            if (route[i] == 'S') {
                y--;
            } else if (route[i] == 'N') {
                y++;
            } else if (route[i] == 'E') {
                x++;
            } else {
                x--;
            }
            t++;

        }
        if (Math.abs(x) + Math.abs(y) <= t) {
            return String.valueOf(n);
        } else {

            return "IMPOSSIBLE";
        }
    }




}




class TrieNode{
    char c;
    int count;
    TrieNode[] next;
    public TrieNode(char _c){
        c = _c;
        next = new TrieNode[26];
        count = 0;
    }
}
