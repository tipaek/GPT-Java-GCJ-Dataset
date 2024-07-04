import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int[][] grid = new int[9][9];
            int x = sc.nextInt();
            int y = sc.nextInt();
            int absX = Math.abs(x);
            int absY = Math.abs(y);
            String result = "";
            System.out.print("Case #" + caseNum + ": ");

            if ((absX + absY) % 2 == 0) {
                System.out.println("IMPOSSIBLE");
            } else {
                if (absX == 1 && absY == 0)
                    result += "E";
                if (absX == 0 && absY == 1)
                    result += "N";
                if (absX == 2 && absY == 1)
                    result += "NE";
                if (absX == 1 && absY == 2)
                    result += "EN";
                if (absX == 3 && absY == 0)
                    result += "EE";
                if (absX == 0 && absY == 3)
                    result += "NN";
                if (absX == 2 && absY == 3)
                    result += "SEN";
                if (absX == 3 && absY == 2)
                    result += "WNE";
                if (absX == 4 && absY == 1)
                    result += "SNE";
                if (absX == 1 && absY == 4)
                    result += "WEN";
                if (absX == 3 && absY == 4)
                    result += "NNE";
                if (absX == 4 && absY == 1)
                    result += "EEN";

                if (absX != x) {
                    result = result.replaceAll("W", "e");
                    result = result.replaceAll("E", "w");
                    result = result.toUpperCase();
                }
                if (absY != y) {
                    result = result.replaceAll("N", "s");
                    result = result.replaceAll("S", "n");
                    result = result.toUpperCase();
                }
                System.out.println(result);
            }
        }
    }
}