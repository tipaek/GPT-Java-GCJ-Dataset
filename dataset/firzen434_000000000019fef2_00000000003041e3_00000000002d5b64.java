import java.util.*;
import java.io.*;

public class Solution {
  
    private static String soln(int ranks, int suits) {
        int[] arrToSort = new int[ranks * suits];

        for (int s = 0; s < suits; s++) {
            for (int r = 0; r < ranks; r++) {
                int index = r + s * ranks;
                arrToSort[index] = r + 1;
            }
        }

        List<int[]> operations = new ArrayList<>();
        while (!isSorted(arrToSort)) {
            int bEnd = -1;
            int aEnd = -1;
            int expectedVal = ranks;
            int rankCount = 0;

            for (int i = arrToSort.length - 1; i >= 0; i--) {
                int x = arrToSort[i];

                if (bEnd == -1) {
                    if (x != expectedVal) {
                        bEnd = i;
                    }
                }

                if (bEnd == -1) {
                    rankCount++;
                    if (rankCount == suits) {
                        expectedVal--;
                        rankCount = 0;
                    }
                }

                if (bEnd != -1 && x == expectedVal) {
                    aEnd = i;
                    break;
                }
            }

            assert bEnd != -1;
            assert aEnd != -1;

            swapPiles(arrToSort, aEnd, bEnd);

            int pileASize = aEnd + 1;
            int pileBSize = bEnd - aEnd;
            operations.add(new int[] { pileASize, pileBSize });
        }

        StringBuilder sb = new StringBuilder("" + operations.size()).append("\n");
        for (int[] operation : operations) {
            sb.append(operation[0]).append(" ").append(operation[1]).append("\n");
        }

        return sb.substring(0, sb.length() - 1);
    }

    private static void swapPiles(int[] arr, int aEnd, int bEnd) {
        int pileASize = aEnd + 1;
        int pileBSize = bEnd - aEnd;

        // cache pile B
        int[] pileB = new int[pileBSize];
        int bInd = 0;
        for (int i = aEnd + 1; i <= bEnd; i++) {
            pileB[bInd++] = arr[i];
        }

        // put pile A in place of pile B
        int aInd = aEnd;
        for (int i = bEnd; i > bEnd - pileASize; i--) {
            arr[i] = arr[aInd--];
        }

        // put cached pile B on top
        System.arraycopy(pileB, 0, arr, 0, pileBSize);
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int R = in.nextInt();
            int S = in.nextInt();
            // parse input
            System.out.println("Case #" + i + ": " + soln(R, S));
        }
    }
  
}