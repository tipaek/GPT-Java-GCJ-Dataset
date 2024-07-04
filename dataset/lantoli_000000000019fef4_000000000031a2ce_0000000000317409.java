import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        sc.nextLine();
        for (int test=1; test<=tests; test++) {
            System.out.println("Case #" + test + ": " + doit(sc.nextInt(), sc.nextInt(), sc.next()));
        }
    }

    private static String doit(int x, int y, String path) throws Exception {
        for (int i = 1; i <= path.length(); i++) {
            switch (path.charAt(i-1)) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
                default: throw new Exception("invalid direction: " + path.charAt(i-1));
            }
            if (i >= Math.abs(x) + Math.abs(y)) return Integer.toString(i);
        }
        return "IMPOSSIBLE";
    }
}
