import java.util.*;

public class Solution {
    Scanner sc = new Scanner(System.in);

    void run(){
        int tests = sc.nextInt();

        for( int t = 0; t < tests; t++){
            solve(t);
        }
    }

    void solve(int t){
        int n = t + 1;
        int x = sc.nextInt();
        int y = sc.nextInt();

        /*
        int xAbs = Math.abs(x);
        int yAbs = Math.abs(y);

        StringBuilder steps = new StringBuilder();

        int largest = 64;
        boolean xLarger;
        while (true) {
            if (xAbs - largest >= 0){
                xLarger = true;
                break;
            }
            if (yAbs - largest >= 0){
                xLarger = false;
                break;
            }
            largest /= 2;
        }

        if (xLarger && x > 0) {
            steps.append("E");
            x -= largest;
        } else if (xLarger && x < 0) {
            steps.append("W");
            x += largest;
        } else if (!xLarger && y > 0) {
            steps.append("N");
            y -= largest;
        } else {
            steps.append("S");
            y += largest;
        }
        largest /= 2;

        while (largest >= 1 && y != 0 && x != 0) {


        }

        steps = steps.reverse();

         */

        int xAbs = Math.abs(x);
        int yAbs = Math.abs(y);

        System.out.print("Case #:" + n +": ");

        if (xAbs == 1 && yAbs == 2) {
            moveX(x);
            moveY(y);
        } else if (xAbs == 2 && yAbs == 1) {
            moveY(y);
            moveX(x);
        } else if (xAbs == 2 && yAbs == 3) {
            moveY(-y);
            moveX(x);
            moveY(y);
        } else if (xAbs == 3 && yAbs == 2) {
            moveX(-x);
            moveY(y);
            moveX(x);
        } else if (xAbs == 3 && yAbs == 4) {
            moveX(x);
            moveX(x);
            moveY(y);
        } else if (xAbs == 4 && yAbs == 3) {
            moveY(y);
            moveY(y);
            moveX(x);
        } else if (xAbs == 0) {
            if (yAbs == 1) {
                moveY(y);
            } else if (yAbs == 3) {
                moveY(y);
                moveY(y);
            }
        } else if (yAbs == 0) {
            if (xAbs == 1) {
                moveX(x);
            } else if (xAbs == 3) {
                moveX(x);
                moveX(x);
            }

        } else {
            System.out.print("IMPOSSIBLE");
        }

        System.out.println();

    }

    void moveY(int y) {
        if (y > 0) {
            System.out.print("N");
        } else {
            System.out.print("S");
        }
    }


    void moveX(int x) {
        if (x > 0) {
            System.out.print("E");
        } else {
            System.out.print("W");
        }
    }

    public static void main(String[] args){
        (new Solution()).run();
    }
}
