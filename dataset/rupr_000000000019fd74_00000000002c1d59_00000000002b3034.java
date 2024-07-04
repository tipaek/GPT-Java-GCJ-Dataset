import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        List<String> results = new ArrayList<>();
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(scanner.nextLine());
            Set<String> patterns = new HashSet<>();
            for (int n = 0; n < N; n++) {
                // potentially can be deduped?
                patterns.add(scanner.nextLine());
            }

            char[][] deduped = new char[patterns.size()][];
            int index = 0;
            for (String pattern : patterns) {
                deduped[index] = pattern.toCharArray();
                index++;
            }
            results.add(new Finder(deduped).find());
        }

        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        for (int i = 0; i < results.size(); i++) {
            pw.println(String.format("Case #%d: %s", (i + 1), results.get(i).trim()));
            pw.flush();
        }

        pw.close();
        scanner.close();
    }

    private static class Finder {
        private char[][] patterns;
        private String string;

        public Finder(char[][] patterns) {
            this.patterns = patterns;
        }

        public String find() {
            int[] pointers = new int[patterns.length];
            find("", pointers);

            return string == null ? "*" : string;
        }

        private void find(String current, int[] pointers) {
            print(pointers);
            if (string != null) return;

            int terminal = 0;
            int aTerminal = 0;
            for (int i = 0; i < patterns.length; i++) {
                if (pointers[i] == patterns[i].length) {
                    terminal++;
                } else if (pointers[i] == patterns[i].length - 1 && patterns[i][pointers[i]] == '*'){
                  aTerminal++;
                }
            }

            if (terminal + aTerminal == patterns.length) {
                string = current;
                return;
            }

            // we have reached end of some but not all
            if (terminal > 0) {
                return;
            }

            List<Integer> fixed = new ArrayList<>();
            List<Integer> flexible = new ArrayList<>();
            char common = '.';
            for (int i = 0; i < pointers.length; i++) {
                if (patterns[i][pointers[i]] == '*') {
                    flexible.add(i);
                } else {
                    // cant match after this;
                    if (common != '.' && common != patterns[i][pointers[i]]) {
                        return;
                    }

                    fixed.add(i);
                    common = patterns[i][pointers[i]];
                }
            }

            int[] np = Arrays.copyOf(pointers, pointers.length);
            for (int i = 0; i < fixed.size(); i++) {
                np[fixed.get(i)]++;
            }

            if (common != '.') {
                find(current + common, np);
            }

            if (string == null) {
                for (int i = 0; i < flexible.size(); i++) {
                    String ns = current;
                    int[] nnp = Arrays.copyOf(np, pointers.length);
                    if (common != '.') {
                        ns += common;
                    }
                    nnp[flexible.get(i)]++;
                    find(ns, nnp);
                }
            }
        }

    }
}
