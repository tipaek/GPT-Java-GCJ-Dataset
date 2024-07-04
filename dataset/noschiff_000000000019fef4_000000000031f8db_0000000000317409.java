import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            String[] ins = scanner.nextLine().split(" ");
            int X = Integer.valueOf(ins[0]);
            int Y = Integer.valueOf(ins[1]);
            String M = ins[2];
            String answer = solve(X,Y,M);
            System.out.println("Case #" + (i + 1) + ": " + answer);
        }
    }

    private static String solve(int x, int y, String m) {
        for (int i = 1; i <= m.length(); i++) {
            String str = m.substring(0,i);
            int totalMoves = findAndCount(str,x,y);
            if (totalMoves <= i) {
                return String.valueOf(i);
            }
        }
        return "IMPOSSIBLE";
    }

    private static int findAndCount(String instruction, int x, int y) {
        int N = (int) instruction.codePoints().filter(ch -> ch == 'N').count();
        int S = (int) instruction.codePoints().filter(ch -> ch == 'S').count();
        int E = (int) instruction.codePoints().filter(ch -> ch == 'E').count();
        int W = (int) instruction.codePoints().filter(ch -> ch == 'W').count();
        return Math.abs(x+E-W) + Math.abs(y+N-S);
    }
}