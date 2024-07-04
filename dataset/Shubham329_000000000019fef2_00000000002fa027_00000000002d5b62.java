import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static int[] store = new int[32];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        store[1] = 1;
        for (int i = 2; i < 31; i++) {
            store[i] = 2 * store[i - 1];
        }

        for (int t = 0; t < T; t++) {
            sb.append("Case #").append(t + 1).append(": ");

            int x = sc.nextInt();
            int y = sc.nextInt();

            ArrayList<Character> path = new ArrayList<>();
            if (traverse(x, y, 0, 0, path, 1)) {
                path.forEach(sb::append);
            } else {
                sb.append("IMPOSSIBLE");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean traverse(int x, int y, int i, int j, List<Character> path, int jump) {
        if (i == x && y == j)
            return true;
        int a = Math.abs(x);
        int b = Math.abs(y);
        int c = Math.abs(i);
        int d = Math.abs(j);
        if (c > a || d > b)
            return false;

        int len = path.size();

        path.add('N');
        if (traverse(x, y, i, j + store[jump], path, jump + 1))
            return true;

        path.set(len, 'S');
        if (traverse(x, y, i, j - store[jump], path, jump + 1))
            return true;

        path.set(len, 'E');
        if (traverse(x, y, i + store[jump], j, path, jump + 1))
            return true;

        path.set(len, 'W');
        if (traverse(x, y, i - store[jump], j, path, jump + 1))
            return true;
        path.remove(len);
        return false;
    }
}
