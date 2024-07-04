import java.util.Scanner;

public class Solution {
    static final int LIMIT = (int) 1e9;

    static class SuccessException extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }

    static class Coord {
        int x, y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    static Scanner in;
    static int T, A, B;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        T = in.nextInt();
        A = in.nextInt();
        B = in.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            new Solution().solve(testCase);
        }

        in.close();
    }

    void solve(int testCase) {
        try {
            Coord seed = scan();
            Coord guess = new Coord(seed.x, seed.y);

            Coord left = binarySearch(seed, new Coord(seed.x - 2 * B, seed.y));
            Coord right = binarySearch(seed, new Coord(seed.x + 2 * B, seed.y));
            Coord up = binarySearch(seed, new Coord(seed.x, seed.y + 2 * B));
            Coord down = binarySearch(seed, new Coord(seed.x, seed.y - 2 * B));

            guess.x = (right.x + left.x) / 2;
            guess.y = (up.y + down.y) / 2;

            send(guess);
        } catch (SuccessException ignored) {
        }
    }

    Coord scan() {
        Coord guess = new Coord(0, 0);

        for (int i = -LIMIT + A / 2; i < LIMIT; i += A) {
            for (int j = -LIMIT + A / 2; j < LIMIT; j += A) {
                guess.x = i;
                guess.y = j;
                if (send(guess).equals("HIT")) {
                    return guess;
                }
            }
        }

        return null;
    }

    String send(Coord c) {
        if (c.x < -LIMIT || c.y < -LIMIT || c.x > LIMIT || c.y > LIMIT) {
            return "MISS";
        } else {
            System.out.println(c.x + " " + c.y);
            String response = in.next();

            if (response.equals("WRONG")) {
                System.exit(0);
            }

            return response;
        }
    }

    Coord binarySearch(Coord start, Coord end) {
        Coord ib = new Coord(start.x, start.y);
        Coord ob = new Coord(end.x, end.y);
        Coord guess = new Coord(-1, -1);

        while (Math.abs(ib.x - ob.x) + Math.abs(ib.y - ob.y) > 1) {
            guess.x = (ib.x + ob.x) / 2;
            guess.y = (ib.y + ob.y) / 2;

            switch (send(guess)) {
                case "CENTER":
                    throw new SuccessException();
                case "MISS":
                    ob.x = guess.x;
                    ob.y = guess.y;
                    break;
                case "HIT":
                    ib.x = guess.x;
                    ib.y = guess.y;
                    break;
            }
        }

        return ib;
    }
}