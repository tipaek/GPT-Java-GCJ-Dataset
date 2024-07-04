import java.util.Scanner;

public class Solution {
    public static void solve(Scanner input, int A, int B, int[] upperLeft, int[] bottomRight, int size) {
        if (A != B) return;

        String response;
        if (size <= 9) {
            for (int i = upperLeft[0]; i <= bottomRight[0]; i++) {
                for (int j = bottomRight[1]; j <= upperLeft[1]; j++) {
                    System.out.println(i + " " + j);
                    response = input.next();
                    if (response.equals("CENTER")) return;
                }
            }
        }

        int distance = (int) ((double) A / 1.42) - size / 2 - 1;

        int[][] positions = {
            {upperLeft[0] - distance, upperLeft[1] + distance},
            {bottomRight[0] + distance, upperLeft[1] + distance},
            {bottomRight[0] + distance, bottomRight[1] - distance},
            {upperLeft[0] - distance, bottomRight[1] - distance}
        };

        for (int[] pos : positions) {
            System.out.println(pos[0] + " " + pos[1]);
            response = input.next();
            if (response.equals("CENTER")) return;
            if (response.equals("HIT")) {
                int midX = (upperLeft[0] + bottomRight[0] + 1) / 2;
                int midY = (upperLeft[1] + bottomRight[1] + 1) / 2;
                int[] newUpperLeft = {upperLeft[0], midY};
                int[] newBottomRight = {midX, bottomRight[1]};
                if (pos[0] == upperLeft[0] - distance) {
                    newUpperLeft[0] = upperLeft[0];
                    newBottomRight[0] = midX;
                } else if (pos[0] == bottomRight[0] + distance) {
                    newUpperLeft[0] = midX;
                    newBottomRight[0] = bottomRight[0];
                }
                if (pos[1] == upperLeft[1] + distance) {
                    newUpperLeft[1] = upperLeft[1];
                    newBottomRight[1] = midY;
                } else if (pos[1] == bottomRight[1] - distance) {
                    newUpperLeft[1] = midY;
                    newBottomRight[1] = bottomRight[1];
                }
                solve(input, A, B, newUpperLeft, newBottomRight, (size + 1) / 2);
                return;
            }
        }

        if (response.equals("MISS")) {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int A = input.nextInt();
        int B = input.nextInt();
        int[] initUpperLeft = {-50, 50};
        int[] initBottomRight = {50, -50};

        for (int ks = 1; ks <= T; ks++) {
            solve(input, A, B, initUpperLeft, initBottomRight, 101);
        }
    }
}