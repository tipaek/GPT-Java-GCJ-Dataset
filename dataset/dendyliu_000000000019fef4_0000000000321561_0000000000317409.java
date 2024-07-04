import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
    public static int[] move(int x, int y, char ch) {
        int[] next = new int[2];
        next[0] = x;
        next[1] = y;
        if (ch == 'N') next[1]++;
        if (ch == 'S') next[1]--;
        if (ch == 'E') next[0]++;
        if (ch == 'W') next[0]--;
        return next;
    }

    public static int findMinPath(int[][] posP) {
        for (int i = 0; i < posP.length; ++i) {
            int x =  posP[i][0];
            int y =  posP[i][1];
            int dist = Math.abs(x) + Math.abs(y);
            if (dist <= i) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        StringBuilder result = new StringBuilder();
        for (int t = 0; t < T; ++t) {
            String[] input = scan.nextLine().split(" ");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);
            String moves = input[2];
            int[][] posP = new int[moves.length() + 1][2];
            posP[0][0] = X;
            posP[0][1] = Y;
            for (int i = 0; i < moves.length(); ++i) {
                posP[i + 1] = move(X, Y, moves.charAt(i));
                X = posP[i + 1][0];
                Y = posP[i + 1][1];
            }
            int minPath = findMinPath(posP);
            String res = minPath == -1 ? "IMPOSSUBLE" : minPath + "";
            String answer = "Case #" + (t + 1) + ": " + res;
            result.append(answer + "\n");
        }
        System.out.println(result);
    }
}