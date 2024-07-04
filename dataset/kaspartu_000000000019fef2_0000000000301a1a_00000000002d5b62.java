import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            List<List<Character>> solutions = new ArrayList<>();

            if (((x & 1) == 0 && (y & 1) == 0) || ((x & 1) == 1 && (y & 1) == 1)) {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            }
            else {
                backtrack(0, 0, 0, x, y, new ArrayList<>(), solutions);
                List<Character> sol = new ArrayList<>();
                int min = Integer.MAX_VALUE;
                for (List<Character> l : solutions) {
                    if (l.size() < min) {
                        min = l.size();
                        sol = l;
                    }
                }
                String output = "";
                for (char c : sol) {
                    output += c;
                }
                System.out.println("Case #" + tc + ": " + output);
            }
        }
    }

    private static void backtrack(int jump, int curX, int curY, int x, int y, List<Character> res, List<List<Character>> solutions) {
        if (jump > 31) return;
        if (curX == x && curY == y) solutions.add(new ArrayList<>(res));

        int j = (int) Math.pow(2, jump);
        List<Character> newL = new ArrayList<>(res);

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                newL.add('E');
                backtrack(jump + 1, curX + j, curY, x, y, newL, solutions);
            }
            else if (i == 1) {
                newL.add('W');
                backtrack(jump + 1, curX - j, curY, x, y, newL, solutions);
            }
            else if (i == 2) {
                newL.add('N');
                backtrack(jump + 1, curX, curY + j, x, y, newL, solutions);
            }
            else {
                newL.add('S');
                backtrack(jump + 1, curX, curY - j, x, y, newL, solutions);
            }
            newL.remove(newL.size()-1);
        }
    }
}