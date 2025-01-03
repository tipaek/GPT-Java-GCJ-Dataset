import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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
            pw.println(String.format("Case #%d: %s", (i + 1), results.get(i)));
            pw.flush();
        }

        pw.close();
        scanner.close();
    }

    private static class State {
        private String string;
        private int[] pointers;

        public State(String string, int[] pointers) {
            this.string = string;
            this.pointers = pointers;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return Objects.equals(string, state.string) &&
                    Arrays.equals(pointers, state.pointers);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(string);
            result = 31 * result + Arrays.hashCode(pointers);
            return result;
        }
    }

    private static class Finder {
        private char[][] patterns;
        private String string;
        private Set<State> states = new HashSet<>();

        public Finder(char[][] patterns) {
            this.patterns = patterns;
        }

        public String find() {
            int[] pointers = new int[patterns.length];
            find("", pointers);

            return string == null ? "*" : string;
        }

        private void find(String current, int[] pointers) {
            //print(pointers);
            if (string != null) return;

            State state = new State(current, pointers);
            if (states.contains(state)) return;

            int terminal = 0;
            for (int i = 0; i < patterns.length; i++) {
                if (pointers[i] == patterns[i].length) {
                    terminal++;
                }
            }

            if (terminal == patterns.length) {
                string = current;
                states.add(state);
                return;
            }

            // we have reached end of some but not all
            if (terminal > 0) {
                states.add(state);
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
                        states.add(state);
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

            for (int i = 0; i < flexible.size(); i++) {
                String ns = current;
                int[] nnp = Arrays.copyOf(np, pointers.length);
                if (common != '.') {
                    ns += common;
                }
                nnp[flexible.get(i)]++;
                find(ns, nnp);
            }

            states.add(state);
        }

    }
}
