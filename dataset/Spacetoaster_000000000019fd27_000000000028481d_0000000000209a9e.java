import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static int[] complement(int[] bits) {
        int[] newBits = new int[bits.length];
        for (int i = 0; i < bits.length; i++) {
            newBits[i] = bits[i] == 0 ? 1 : 0;
        }
        return newBits;
    }

    public static int[] invert(int[] bits) {
        int[] newBits = new int[bits.length];
        for (int i = 0; i < bits.length; i++) {
            newBits[i] = bits[bits.length - 1 - i];
        }
        return newBits;
    }

    public static int[] fluctuateBits(int[] bits, int diffIndex, int equalIndex, int rightStart, Scanner in) {
        if (diffIndex == -1 || equalIndex == -1) {
            // all elements are equal or different
            System.out.println(rightStart + 1);
            in.nextLine();
            System.out.println(rightStart + 1);
            int newRightStart = Integer.parseInt(in.nextLine());
            if (bits[rightStart] != newRightStart) {
                return complement(bits);
            }
        } else {
            int oldEqual = bits[equalIndex];
            int oldDiff = bits[diffIndex];
            System.out.println(equalIndex + 1);
            int newEqual = Integer.parseInt(in.nextLine());
            System.out.println(diffIndex + 1);
            int newDiff = Integer.parseInt(in.nextLine());
            if (oldEqual != newEqual) {
                if (oldDiff != newDiff) {
                    return complement(bits);
                } else {
                    return invert(complement(bits));
                }
            } else {
                if (oldDiff != newDiff) {
                    return invert(bits);
                }
            }
        }
        return bits;
    }

    public static void query(int[] bits, int i, Scanner in) {
        System.out.println(i + 1);
        bits[i] = Integer.parseInt(in.nextLine());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer sb1 = new StringTokenizer(in.nextLine());
        int T = Integer.parseInt(sb1.nextToken());
        int B = Integer.parseInt(sb1.nextToken());
        boolean uneven = B % 2 != 0;
        for (int i = 1; i <= T; ++i) {
            int[] bits = new int[B];
            int equalIndex = -1;
            int diffIndex = -1;
            final int rightStart = (int) Math.ceil(B / 2.0);
            final int leftStart = (int) Math.floor(B / 2.0) - 1;

            // Case for B <= 10
            if (B <= 10) {
                for (int j = 0; j < B; j++) {
                    query(bits, j, in);
                }
            } else {
                // read initial 5 right
                for (int d = 0; d < 5; d++) {
                    int query = rightStart + d;
                    query(bits, query, in);
                }

                // read initial 5 left
                for (int d = 0; d < 5; d++) {
                    int query = leftStart - d;
                    query(bits, query, in);
                    int matchingRightIndex = rightStart + d;
                    if (bits[query] == bits[matchingRightIndex]) {
                        equalIndex = matchingRightIndex;
                    } else {
                        diffIndex = matchingRightIndex;
                    }
                }
                bits = fluctuateBits(bits, diffIndex, equalIndex, rightStart, in);
                int numQueries = 12;
                // int remainingBits = (int) Math.floor(B / 2.0) - 5;
                int d = 5;
                while (rightStart + d < B) {
                    if (numQueries % 10 == 0) {
                        bits = fluctuateBits(bits, diffIndex, equalIndex, rightStart, in);
                        numQueries += 2;
                    }
                    query(bits, rightStart + d, in);
                    query(bits, leftStart - d, in);
                    if (equalIndex == -1) {
                        equalIndex = bits[rightStart + d] == bits[leftStart - d] ? rightStart + d : -1;
                    }
                    if (diffIndex == -1) {
                        diffIndex = bits[rightStart + d] != bits[leftStart - d] ? rightStart + d : -1;
                    }
                    numQueries += 2;
                    d++;
                }
                if (uneven) {
                    if (numQueries % 10 == 0) {
                        bits = fluctuateBits(bits, diffIndex, equalIndex, rightStart, in);
                        numQueries += 2;
                    }
                    query(bits, rightStart - 1, in);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < B; j++) {
                sb.append(bits[j]);
            }
            System.out.println(sb.toString());
            String result = in.nextLine();
            if (result.equals("N")) {
                break;
            }
        }
    }
}
