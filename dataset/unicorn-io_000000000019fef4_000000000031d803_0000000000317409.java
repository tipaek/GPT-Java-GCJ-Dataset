import java.util.Scanner;

public class Solution {

    static class cat {
        private int myX = 0;
        private int myY = 0;
        private int catx;
        private int caty;
        private int cc = 0;
        private int dis;

        public cat(int x, int y) {
            this.catx = x;
            this.caty = y;
            dis = x + y;
        }

        public void move(Character K) {
            cc++;
            switch(K) {
                case 'N':
                    caty++;
                    break;
                case 'S':
                    caty--;
                    break;
                case 'E':
                    catx++;
                    break;
                case 'W':
                    catx--;
                    break;
            }
        }

        public int dist() {
            return Math.abs(catx) + Math.abs(caty);
        }

    }

    private static final Scanner scn = new Scanner(System.in);
    private static int cas;
    private static int num;

    private static void foo() {
        int x = scn.nextInt();
        int y = scn.nextInt();
        cat pp = new cat(x, y);
        String path = scn.next();
        Boolean check = false;
        for (int i = 0; i < path.length(); i++) {
            pp.move(path.charAt(i));
            if (pp.cc >= pp.dist()) {
                System.out.printf("Case #%d: %d\n", num-cas, pp.cc);
                check = true;
                break;
            }

        }
        if (!check) System.out.printf("Case #%d: IMPOSSIBLE\n", num-cas);
    }

    public static void main(String[] args) {
        cas = scn.nextInt();
        num = cas;
        while (cas-- > 0) foo();
    }
}