import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        long a = sc.nextLong();
        long b = sc.nextLong();
        sc.nextLine();

        for (int i = 0; i < test; i++) {
            doit(a, b, sc);

            System.out.flush();
            System.exit(0);
        }

    }

    private final static long MIN = -9_000_000_000L;
    private final static long MAX = 9_000_000_000L;

    private static void doit(long a, long b, Scanner sc) {
        final long r = a;
        long xcur = MIN;
        while (true) {
            System.out.println(String.format("%d %d", xcur, 0));
            System.out.flush();
            String response = sc.nextLine();
            if (handle(response)) return;
            if (response.equals("HIT")) {
                xcur += r;
                break;
            } else {
                xcur++;
            }
        }
        long ycur = MIN;
        while (true) {
            System.out.println(String.format("%d %d", 0, ycur));
            System.out.flush();
            String response = sc.nextLine();
            if (handle(response)) return;
            if (response.equals("HIT")) {
                ycur += r;
                break;
            } else {
                ycur++;
            }
        }
        System.out.println(String.format("%d %d", xcur, ycur));
        System.out.flush();
        String response = sc.nextLine();
        if (!handle(response)) System.exit(0);
    }

    static boolean handle(String response) {
        if (response.equals("CENTER")) return true;
        if (!response.equals("HIT") && !response.equals("MISS")) System.exit(0);
        return false;
    }
}
