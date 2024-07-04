import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        QuantumFluctuationSolver solver = new QuantumFluctuationSolver();

        OutputStream outputStream = System.out;
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(outputStream);

        int testCases = in.nextInt();
        int bitLength = in.nextInt();

        for (int i = 1; i <= testCases; i++) {
            solver.solve(bitLength, in, out);
        }
        out.close();
    }

    static class QuantumFluctuationSolver {
        public void solve(int bitLength, Scanner in, PrintWriter out) {
            char[] bits = new char[bitLength];
            Arrays.fill(bits, '*');
            int leftIndex = bitLength / 2 - 1;
            int rightIndex = (bitLength + 1) / 2;
            int left = leftIndex - 1;
            int right = rightIndex + 1;
            boolean midChanged = false, edgeChanged = false, sameMid = false;
            int leftEdgeIndex = -1, rightEdgeIndex = -1;

            for (int i = 0; i < 150; i += 2) {
                if (i % 10 == 0) {
                    if (i == 0) {
                        bits[leftIndex] = query(leftIndex, in, out);
                        bits[rightIndex] = query(rightIndex, in, out);
                        sameMid = (bits[leftIndex] == bits[rightIndex]);
                    } else {
                        char currentMid = query(leftIndex, in, out);
                        midChanged = (currentMid != bits[leftIndex]);
                        if (leftEdgeIndex != -1) {
                            char currentEdge = query(leftEdgeIndex, in, out);
                            edgeChanged = (currentEdge != bits[leftEdgeIndex]);
                            adjust(bits, midChanged, edgeChanged, sameMid);
                        } else {
                            query(rightIndex, in, out);
                            if (midChanged) invert(bits);
                        }
                    }
                } else {
                    char leftBit = query(left, in, out);
                    char rightBit = query(right, in, out);

                    if (leftEdgeIndex == -1 && rightEdgeIndex == -1) {
                        if (isEdgeValid(leftBit, rightBit, sameMid)) {
                            leftEdgeIndex = left;
                            rightEdgeIndex = right;
                        }
                    }

                    bits[left--] = leftBit;
                    bits[right++] = rightBit;
                }

                if (left == -1 && right == bitLength) {
                    if (outputResult(bits, in, out)) return;
                    leftEdgeIndex = rightEdgeIndex = -1;
                    left = leftIndex - 1;
                    right = rightIndex + 1;
                }
            }
        }

        boolean outputResult(char[] bits, Scanner in, PrintWriter out) {
            out.println(String.valueOf(bits));
            out.flush();
            return in.next().equals("Y");
        }

        boolean isEdgeValid(char leftBit, char rightBit, boolean sameMid) {
            return sameMid ? leftBit != rightBit : leftBit == rightBit;
        }

        void adjust(char[] bits, boolean midChanged, boolean edgeChanged, boolean sameMid) {
            if (sameMid) {
                if (midChanged) {
                    invert(bits);
                    if (!edgeChanged) reverse(bits);
                } else {
                    if (edgeChanged) reverse(bits);
                }
            } else {
                if (midChanged) {
                    if (edgeChanged) invert(bits);
                    else reverse(bits);
                } else {
                    if (edgeChanged) {
                        reverse(bits);
                        invert(bits);
                    }
                }
            }
        }

        char query(int pos, Scanner in, PrintWriter out) {
            out.println(pos + 1);
            out.flush();
            return in.next().charAt(0);
        }

        void reverse(char[] bits) {
            int left = 0, right = bits.length - 1;
            while (left < right) {
                char temp = bits[left];
                bits[left] = bits[right];
                bits[right] = temp;
                left++;
                right--;
            }
        }

        void invert(char[] bits) {
            for (int i = 0; i < bits.length; i++) {
                bits[i] = bits[i] == '0' ? '1' : '0';
            }
        }
    }
}