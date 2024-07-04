import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = input.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int H = input.nextInt();
            int W = input.nextInt();

            long[][] S = new long[H][W];
            for (int i = 0; i < H; i++)
                for (int j = 0; j < W; j++)
                    S[i][j] = input.nextInt();

            Part[][] parts = new Part[H][W];
            for (int i = 0; i < H; i++)
                for (int j = 0; j < W; j++)
                    parts[i][j] = new Part(i - 1, i + 1, j - 1, j + 1);

            long totalInterest = 0;
            for (int round = 1; true; round++) {
                long interest = 0;
                for (int i = 0; i < H; i++)
                    for (int j = 0; j < W; j++)
                        if (parts[i][j] != null)
                            interest += S[i][j];
//                System.out.println(round + " " + interest); // MFD
                totalInterest += interest;

                boolean[][] elim = new boolean[H][W];
                for (int i = 0; i < H; i++)
                    for (int j = 0; j < W; j++)
                        if (parts[i][j] != null) {
                            Part part = parts[i][j];
                            long count = 0;
                            long sum = 0;
                            if (part.above >= 0) {
                                count++;
                                sum += S[part.above][j];
                            }
                            if (part.below < H) {
                                count++;
                                sum += S[part.below][j];
                            }
                            if (part.left >= 0) {
                                count++;
                                sum += S[i][part.left];
                            }
                            if (part.right < W) {
                                count++;
                                sum += S[i][part.right];
                            }
                            if (sum > count * S[i][j])
                                elim[i][j] = true;
                        }

                boolean stop = true;
                for (int i = 0; i < H; i++)
                    for (int j = 0; j < W; j++)
                        if (elim[i][j]) {
                            Part part = parts[i][j];
                            if (part.above >= 0)
                                parts[part.above][j].below = part.below;
                            if (part.below < H)
                                parts[part.below][j].above = part.above;
                            if (part.left >= 0)
                                parts[i][part.left].right = part.right;
                            if (part.right < W)
                                parts[i][part.right].left = part.left;
                            stop = false;
                            parts[i][j] = null;
                        }

//                for (int i = 0; i < H; i++) {
//                    for (int j = 0; j < W; j++)
//                        System.out.printf("%s ", parts[i][j]);
//                    System.out.println();
//                }
                if (stop)
                    break;
            }

            System.out.printf("Case #%d: %s\n", caseNum, totalInterest);
        }
    }

    static class Part {

        int above;
        int below;
        int left;
        int right;

        public Part(int above, int below, int left, int right) {
            super();
            this.above = above;
            this.below = below;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Part [above=" + above + ", below=" + below + ", left=" + left + ", right=" + right + "]";
        }
    }
}
