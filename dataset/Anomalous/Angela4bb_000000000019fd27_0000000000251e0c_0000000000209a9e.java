import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        ESAb solver = new ESAb();

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner scanner = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);

        int testCases = scanner.nextInt();
        int B = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, B, scanner, writer);
        }
        writer.close();
    }

    static class ESAb {
        public void solve(int testNumber, int B, Scanner scanner, PrintWriter writer) {
            int[] arr = new int[B];
            Arrays.fill(arr, -1);

            int mid1 = -1, mid2 = -1, left = -1, right = -1;
            int mid1Idx = (B % 2 == 0) ? B / 2 - 1 : B / 2;
            int mid2Idx = B / 2;
            int l = mid1Idx - 1, r = mid2Idx + 1;
            boolean isMiddleChanged = false;

            for (int i = 1; i <= 75; i++) {
                if (r == B) break;

                if (i % 5 == 1) {
                    int i1 = read(mid1Idx, scanner, writer);
                    int i2 = read(mid2Idx, scanner, writer);

                    if (mid1 != -1 && mid2 != -1) {
                        isMiddleChanged = mid1 != i1 && mid2 != i2;
                    } else {
                        arr[mid1Idx] = i1;
                        arr[mid2Idx] = i2;
                    }

                    if (left == -1 && right == -1 && isMiddleChanged) {
                        complement(arr, l, r);
                    }

                    mid1 = i1;
                    mid2 = i2;

                } else if (i % 5 == 2 && left != -1 && right != -1) {
                    int i1 = read(left, scanner, writer);
                    int i2 = read(right, scanner, writer);

                    if (mid1 == mid2) {
                        if (isMiddleChanged) {
                            if (i1 != left && i2 != right) {
                                complement(arr, l, r);
                            } else {
                                reverse(arr, l, r);
                                complement(arr, l, r);
                            }
                        } else {
                            if (i1 != left && i2 != right) {
                                reverse(arr, l, r);
                            }
                        }
                    } else {
                        if (isMiddleChanged) {
                            if (i1 != left && i2 != right) {
                                complement(arr, l, r);
                            } else {
                                reverse(arr, l, r);
                            }
                        } else {
                            if (i1 != left && i2 != right) {
                                reverse(arr, l, r);
                                complement(arr, l, r);
                            }
                        }
                    }
                } else {
                    int i1 = read(l, scanner, writer);
                    int i2 = read(r, scanner, writer);

                    if (left == -1 && right == -1) {
                        if (mid1 == mid2) {
                            if (i1 != i2) {
                                left = l;
                                right = r;
                            }
                        } else {
                            if (i1 == i2) {
                                left = l;
                                right = r;
                            }
                        }
                    }

                    arr[l--] = i1;
                    arr[r++] = i2;
                }
            }

            print(arr, writer);
            readResult(scanner);
        }

        private boolean readResult(Scanner scanner) {
            return "Y".equals(scanner.next());
        }

        private void print(int[] arr, PrintWriter writer) {
            for (int i : arr) {
                writer.print(i);
            }
            writer.println();
            writer.flush();
        }

        private int read(int pos, Scanner scanner, PrintWriter writer) {
            writer.println(pos + 1);
            writer.flush();
            return scanner.nextInt();
        }

        private void reverse(int[] arr, int l, int r) {
            while (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }

        private void complement(int[] arr, int l, int r) {
            while (l <= r) {
                arr[l] = (arr[l] == 0) ? 1 : 0;
                l++;
            }
        }
    }
}