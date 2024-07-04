import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution problem = new Solution();
        problem.run(in);
    }

    public void run(Scanner in) {
        int tests = in.nextInt();
        long A = in.nextLong();
        long B = in.nextLong();
        for ( int t = 1; t <= tests; t++) {
            solve(in, A, B);
        }
    }

    enum Status {
        CENTER,
        HIT,
        MISS,
        NONE
    }

    Status getStatus(String s) {
        if ( s.equals("CENTER")) return Status.CENTER;
        if ( s.equals("HIT")) return Status.HIT;
        if ( s.equals("MISS")) return Status.MISS;
        if ( s.equals("WRONG")) return Status.CENTER;
        return Status.NONE;
    }

    Status target(long x, long y, Scanner in)
    {
        System.out.printf("%d %d\n", x, y);
        System.out.flush();
        String s = in.next();
        return getStatus(s);
    }
    private void solve(Scanner in, long a, long b) {
        long step = 250_000_000;
        long currentX = 0, currentY = 0;
        boolean done = false;
        // first hit
        for ( long x = -750_000_000; x < 1_000_000_000 && !done; x += step)
            for ( long y = -750_000_000; y < 1_000_000_000 && !done; y += step) {
                Status status = target(x, y, in);
                if ( status == Status.CENTER ) return;
                if ( status == Status.HIT) {
                    currentX = x;
                    currentY = y;
                    done = true;
                }
            }
//        System.err.printf("current x %d y %d\n", currentX, currentY);
        long leftX = currentX;
        long lb = -1_000_000_000 - 1;
        while ( lb + 1 < leftX) {
            long midX = (lb + leftX)/2;
            Status status = target(midX, currentY, in);
            if ( status == Status.CENTER ) return;
            else if ( status == Status.HIT ) leftX = midX;
            else lb = midX;
        }
        long rightX = currentX;
        long ub = 1_000_000_000 + 1;
        while ( rightX + 1 < ub ) {
            long midX = (rightX + ub)/2;
            Status status = target(midX, currentY, in);
            if ( status == Status.CENTER ) return;
            else if ( status == Status.HIT ) rightX = midX;
            else ub = midX;
        }
//        System.err.printf("leftX = %d rightX = %d\n", leftX, rightX);
        currentX = (leftX + rightX)/2;
//        System.err.printf("currentX = %d\n", currentX);
        long bottomY = currentY;
        lb = -1_000_000_000 - 1;
        while ( lb + 1 < bottomY) {
            long midY = (lb + bottomY)/2;
            Status status = target(currentX, midY, in);
            if ( status == Status.CENTER ) return;
            else if ( status == Status.HIT ) bottomY = midY;
            else lb = midY;
        }
        long topY = currentY;
        ub = 1_000_000_000 + 1;
        while ( topY + 1 < ub ) {
            long midY = (topY + ub)/2;
            Status status = target(currentX, midY, in);
            if ( status == Status.CENTER ) return;
            else if ( status == Status.HIT ) topY = midY;
            else ub = midY;
        }
//        System.err.printf("bottomY = %d topY = %d\n", bottomY, topY);
        currentY = (bottomY + topY)/2;
//        System.err.printf("currentY = %d\n", currentY);
        Status status = target(currentX, currentY, in);
        if ( status != Status.CENTER) {
            System.err.println("mis geschoten...");
        }
    }

}
