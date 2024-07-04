import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nProblems = in.nextInt();
        int nBits = in.nextInt();

        for (int problem = 0; problem < nProblems; problem++) {
            String res = solve(nBits, in);
            if (res.equals("N")) {
                break;
            }
        }

    }

    private static String solve(int size, Scanner in) {

        int[] oldOrder = new int[150];
        int[] newOrder = new int[150];

        for (int block = 0; block < 15; block++) {
            System.out.println(1); //1 --> reordering
            in.nextInt();

            for (int dist = 0; dist < 4; dist++) {
                System.out.println(dist + 1); //2, first
                newOrder[dist] = in.nextInt();

                System.out.println(size - dist); //3, last
                newOrder[size - 1 - dist] = in.nextInt();
            }

            System.out.println(1); //10th, ignore for now
            in.nextInt();

            if (block == 0) {
                oldOrder = newOrder; //nothing to compare
            } else {
                oldOrder = compareAndReorder(oldOrder, newOrder);
            }
        }

        //postResult
        System.out.println(formatResult(oldOrder));
        return in.next(); //Y or N
    }

    private static int[] compareAndReorder(int[] oldOrder, int[] newOrder) {
        boolean complemented = false;
        boolean reversed = false;
        for (int dist = 0; dist < 4; dist++) {

        }
        return oldOrder;
    }

    private static String formatResult(int[] result) {
        return Arrays.toString(result).replaceAll("\\[|\\]|,|\\s", "");
    }
}