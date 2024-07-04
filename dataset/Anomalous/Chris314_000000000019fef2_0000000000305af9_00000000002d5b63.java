import java.util.Scanner;

public class Solution {
    
    public static void solve(Scanner input, int A, int B, int[] upperLeft, int[] bottomRight, int size) {
        if (A != B) return;
        
        String response;
        
        if (size <= 11) {
            for (int i = upperLeft[0]; i <= bottomRight[0]; i++) {
                for (int j = bottomRight[1]; j <= upperLeft[1]; j++) {
                    System.out.println(i + " " + j);
                    response = input.next();
                    if (response.equals("CENTER")) return;
                }
            }
        }
        
        int distance = (int) ((double) A / 1.42) - size / 2 - 1;
        
        System.out.println((upperLeft[0] - distance) + " " + (upperLeft[1] + distance));
        response = input.next();
        if (response.equals("CENTER")) return;
        if (response.equals("HIT")) {
            solve(input, A, B, upperLeft, new int[]{upperLeft[0] + (size + 1) / 2, upperLeft[1] - (size + 1) / 2}, (size + 1) / 2);
            return;
        }
        
        System.out.println((bottomRight[0] + distance) + " " + (upperLeft[1] + distance));
        response = input.next();
        if (response.equals("CENTER")) return;
        if (response.equals("HIT")) {
            solve(input, A, B, new int[]{bottomRight[0] - (size + 1) / 2, upperLeft[1]}, new int[]{bottomRight[0], upperLeft[1] - (size + 1) / 2}, (size + 1) / 2);
            return;
        }
        
        System.out.println((bottomRight[0] + distance) + " " + (bottomRight[1] - distance));
        response = input.next();
        if (response.equals("CENTER")) return;
        if (response.equals("HIT")) {
            solve(input, A, B, new int[]{bottomRight[0] - (size + 1) / 2, bottomRight[1] + (size + 1) / 2}, bottomRight, (size + 1) / 2);
            return;
        }
        
        System.out.println((upperLeft[0] - distance) + " " + (bottomRight[1] - distance));
        response = input.next();
        if (response.equals("CENTER")) return;
        if (response.equals("HIT")) {
            solve(input, A, B, new int[]{upperLeft[0], bottomRight[1] + (size + 1) / 2}, new int[]{upperLeft[0] + (size + 1) / 2, bottomRight[1]}, (size + 1) / 2);
            return;
        }
        
        if (response.equals("MISS")) {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static void main(String[] args) {
        int pow = 1;
        for (int i = 1; i <= 9; i++) {
            pow *= 10;
        }
        
        int[] initUpperLeft = new int[]{-50, 50};
        int[] initBottomRight = new int[]{50, -50};
        
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int A = input.nextInt();
        int B = input.nextInt();
        
        for (int ks = 1; ks <= T; ks++) {
            if (A == pow - 5 && B == pow - 5) {
                solve(input, A, B, new int[]{-5, 5}, new int[]{5, -5}, 10);
            } else {
                solve(input, A, B, initUpperLeft, initBottomRight, 101);
            }
        }
        
        input.close();
    }
}