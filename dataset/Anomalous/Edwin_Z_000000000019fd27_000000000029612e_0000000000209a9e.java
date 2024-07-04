import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int T = in.nextInt();
        int B = in.nextInt();
        for (int i = 0; i < T; i++) {
            solver.solve(in, out, B);
        }
        out.close();
    }

    static class Task {
        public void solve(InputReader in, PrintWriter out, int B) {
            int mid1 = B / 2 - 1;
            int mid2 = B / 2;
            int leftDiffIndex = -1, rightDiffIndex = -1;
            int leftSameIndex = -1, rightSameIndex = -1;
            boolean isSameMid = false;
            int left = mid1;
            int right = mid2;
            int[] result = new int[B];
            Arrays.fill(result, -1);

            for (int i = 0; i < 150; i += 2) {
                int first = read(in, out, left);
                int second = read(in, out, right);

                if (i == 0) {
                    isSameMid = (first == second);
                } else {
                    if (first == second && leftSameIndex == -1 && rightSameIndex == -1) {
                        leftSameIndex = left;
                        rightSameIndex = right;
                    } else if (first != second && leftDiffIndex == -1 && rightDiffIndex == -1) {
                        leftDiffIndex = left;
                        rightDiffIndex = right;
                    }
                }

                if (i % 10 == 0) {
                    int newMid1Value = read(in, out, mid1);
                    int newMid2Value = read(in, out, mid2);
                    i += 2;
                    if (isSameMid) {
                        if (newMid1Value != result[mid1] || newMid2Value != result[mid2]) {
                            if (leftDiffIndex == -1 || rightDiffIndex == -1) {
                                complement(result, 0, B);
                            } else {
                                int newLeftDiffValue = read(in, out, leftDiffIndex);
                                int newRightDiffValue = read(in, out, rightDiffIndex);
                                i += 2;
                                if (newLeftDiffValue == result[leftDiffIndex] || newRightDiffValue == result[rightDiffIndex]) {
                                    complement(result, 0, B);
                                    reverse(result, 0, B);
                                } else {
                                    complement(result, 0, B);
                                }
                            }
                        } else {
                            if (leftDiffIndex != -1 || rightDiffIndex != -1) {
                                int newLeftDiffValue = read(in, out, leftDiffIndex);
                                int newRightDiffValue = read(in, out, rightDiffIndex);
                                i += 2;
                                if (newLeftDiffValue != result[leftDiffIndex] || newRightDiffValue != result[rightDiffIndex]) {
                                    reverse(result, 0, B);
                                }
                            }
                        }
                    } else {
                        if (newMid1Value != result[mid1] || newMid2Value != result[mid2]) {
                            if (leftSameIndex == -1 || rightSameIndex == -1) {
                                complement(result, 0, B);
                            } else {
                                int newLeftSameValue = read(in, out, leftSameIndex);
                                int newRightSameValue = read(in, out, rightSameIndex);
                                i += 2;
                                if (newLeftSameValue == result[leftSameIndex] || newRightSameValue == result[rightSameIndex]) {
                                    reverse(result, 0, B);
                                } else {
                                    complement(result, 0, B);
                                }
                            }
                        } else {
                            if (leftSameIndex != -1 || rightSameIndex != -1) {
                                int newLeftSameValue = read(in, out, leftSameIndex);
                                int newRightSameValue = read(in, out, rightSameIndex);
                                i += 2;
                                if (newLeftSameValue != result[leftSameIndex] || newRightSameValue != result[rightSameIndex]) {
                                    complement(result, 0, B);
                                    reverse(result, 0, B);
                                }
                            }
                        }
                    }
                }

                result[left] = first;
                result[right] = second;
                left--;
                right++;
                if (left < 0 || right >= B) {
                    StringBuilder sb = new StringBuilder();
                    for (int val : result) {
                        sb.append(val);
                    }
                    readString(in, out, sb.toString());
                    return;
                }
            }
        }

        private void complement(int[] arr, int left, int right) {
            for (int i = left; i < right; i++) {
                arr[i] = 1 - arr[i];
            }
        }

        private void reverse(int[] arr, int left, int right) {
            right--;
            while (left < right) {
                int temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }

        private int read(InputReader in, PrintWriter out, int pos) {
            out.println(pos + 1);
            out.flush();
            return in.nextInt();
        }

        private void readString(InputReader in, PrintWriter out, String str) {
            out.println(str);
            out.flush();
            in.next();
        }
    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}