import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskB solver = new TaskB();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int U = in.nextInt();
            int limit = 10000;
            long Q[] = new long[limit];
            String R[] = new String[limit];
            int lengths[] = new int[limit];
            boolean impossible = false;
            HashSet<Character> characters = new HashSet<>();
            for (int i = 0; i < limit; i++) {
                Q[i] = in.nextLong();
                if (Q[i] == -1) {
                    impossible = true;
                }
                R[i] = in.next();
                lengths[i] = R[i].length();
                for (int j = 0; j < lengths[i]; j++) {
                    characters.add(R[i].charAt(j));
                }
            }
            char res[] = new char[10];
            if (U == 2) {
                res = solvefirst(Q, R, lengths, characters);
            } else {
                if (!impossible) {
                    res = solveNotImpossible(Q, R, lengths, characters);
                } else {

                }
            }
            out.print("Case #" + testNumber + ": ");
            String ans = "";
            for (int i = 0; i < res.length; i++) {
                ans += res[i];
            }
            out.printLine(ans);
        }

        public char[] solvefirst(long Q[], String R[], int length[], HashSet<Character> characters) {
            int N = 10000;
            char result[] = new char[10];
            HashSet<Character> used = new HashSet<>();
            for (int i = 0; i < N; i++) {
                if (length[i] == 2) {
                    used.add(R[i].charAt(0));
                }
            }
            int index = 0;
            Character perm[] = new Character[9];
            for (Character c : characters) {
                if (!used.contains(c)) {
                    result[0] = c;
                } else {
                    perm[index++] = c;
                }
            }
            HashSet<Character[]> permutations = new HashSet<>();
            generatePermutations(9, perm, permutations);
            for (Character[] c : permutations) {
                HashMap<Character, Integer> map = new HashMap<>();
                for (int i = 0; i < 9; i++) {
                    map.put(c[i], i + 1);
                }
                map.put(result[0], 0);
                boolean status = true;
                for (int i = 0; i < N; i++) {
                    long num = 0;
                    for (int j = 0; j < length[i]; j++) {
                        num = num * 10 + map.get(R[i].charAt(j));
                    }
                    if (num > Q[i]) {
                        status = false;
                        break;
                    }
                }
                if (status) {
                    for (int i = 1; i < 10; i++) {
                        result[i] = c[i - 1];
                    }
                    break;
                }
            }
            return result;
        }

        public char[] solveNotImpossible(long Q[], String R[], int length[], HashSet<Character> characters) {
            int N = 10000;
            char result[] = new char[10];
            HashSet<Character> used = new HashSet<>();
            for (int i = 0; i < N; i++) {
                if (length[i] > 1) {
                    used.add(R[i].charAt(0));
                }
            }
            int index = 0;
            Character perm[] = new Character[9];
            for (Character c : characters) {
                if (!used.contains(c)) {
                    result[0] = c;
                } else {
                    perm[index++] = c;
                }
            }
            HashSet<Character[]> permutations = new HashSet<>();
            generatePermutations(9, perm, permutations);
            for (Character[] c : permutations) {
                HashMap<Character, Integer> map = new HashMap<>();
                for (int i = 0; i < 9; i++) {
                    map.put(c[i], i + 1);
                }
                map.put(result[0], 0);
                boolean status = true;
                for (int i = 0; i < N; i++) {
                    long num = 0;
                    for (int j = 0; j < length[i]; j++) {
                        num = num * 10 + map.get(R[i].charAt(j));
                    }
                    if (num > Q[i]) {
                        status = false;
                        break;
                    }
                }
                if (status) {
                    for (int i = 1; i < 10; i++) {
                        result[i] = c[i - 1];
                    }
                    break;
                }
            }
            return result;
        }

        public void generatePermutations(int N, Character[] elements, HashSet<Character[]> set) {
            if (N == 1) {
                set.add(elements.clone());
            } else {
                for (int i = 0; i < N - 1; i++) {
                    generatePermutations(N - 1, elements, set);
                    if (N % 2 == 0) {
                        swap(elements, i, N - 1);
                    } else {
                        swap(elements, 0, N - 1);
                    }
                }
                generatePermutations(N - 1, elements, set);
            }
        }

        public void swap(Character[] elements, int index1, int index2) {
            char temp = elements[index1];
            elements[index1] = elements[index2];
            elements[index2] = temp;
        }

    }

    static class OutputWriter {
        PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }

    static class InputReader {
        BufferedReader in;
        StringTokenizer tokenizer = null;

        public InputReader(InputStream inputStream) {
            in = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            try {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(in.readLine());
                }
                return tokenizer.nextToken();
            } catch (IOException e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

