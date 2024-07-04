import java.util.Scanner;

public class Solution {


    private static int cas = 0,x = 0, y = 0;
    private static final Scanner sc = new Scanner(System.in);

    private static void foo() {
        x = Integer.parseInt(sc.next());
        y = Integer.parseInt(sc.next());
        String cat = sc.next();
        int counter = 0, dist = x + y;
        if (counter >= dist) {
            System.out.println("Case #" + cas + ": " + counter);
            return;
        }
        for (int i = 0; i < cat.length(); i++) {
            dist = update(cat.charAt(i));
            counter++;
            if (counter >= dist) {
                System.out.println("Case #" + cas + ": " + counter);
                return;
            }
        }
        System.out.println("Case #" + cas + ": IMPOSSIBLE");
    }

    public static int update(char c) {

        if (c == 'W') x--;
        else if (c == 'E') x++;
        if (c == 'S') y--;
        else if (c == 'N') y++;

        return Math.abs(x) + Math.abs(y);
    }

    public static void main(String[] args) {
        int cases = Integer.parseInt(sc.nextLine());
        for (cas = 1; cas <= cases; cas++) {
            foo();
        }
    }
}