import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream in = System.in;
        InputReader scan = new InputReader(in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            if ((x + y) % 2 == 0) {
                System.out.println("IMPOSSIBLE");
            } else {
                ArrayList<ArrayList<Interval>> dp = new ArrayList<>();
                ArrayList<Interval> initialRow = new ArrayList<>();
                initialRow.add(new Interval(0, 0));
                dp.add(initialRow);

                int row = 0;
                boolean found = false;
                Interval result = new Interval(-1, -1);
                while (!found) {
                    ArrayList<Interval> currentRow = dp.get(row);
                    dp.add(new ArrayList<>());

                    for (Interval element : currentRow) {
                        int move = (int) Math.pow(2, row);
                        if (checkAndAdd(dp, row + 1, element.x + move, element.y, x, y, result, row + 1)) {
                            found = true;
                            break;
                        }
                        if (checkAndAdd(dp, row + 1, element.x - move, element.y, x, y, result, row + 1)) {
                            found = true;
                            break;
                        }
                        if (checkAndAdd(dp, row + 1, element.x, element.y + move, x, y, result, row + 1)) {
                            found = true;
                            break;
                        }
                        if (checkAndAdd(dp, row + 1, element.x, element.y - move, x, y, result, row + 1)) {
                            found = true;
                            break;
                        }
                    }
                    row++;
                }

                StringBuilder res = new StringBuilder();
                while (result.x > 0) {
                    int direction = result.y % 4;
                    result.y /= 4;
                    res.append(getDirection(direction));
                    result.x--;
                }
                System.out.println(res.reverse().toString());
            }
        }
    }

    private static boolean checkAndAdd(ArrayList<ArrayList<Interval>> dp, int row, int newX, int newY, int x, int y, Interval result, int newRow) {
        if (newX == x && newY == y) {
            result.x = newRow;
            result.y = dp.get(newRow).size();
            return true;
        } else {
            dp.get(newRow).add(new Interval(newX, newY));
            return false;
        }
    }

    private static char getDirection(int direction) {
        switch (direction) {
            case 0: return 'E';
            case 1: return 'W';
            case 2: return 'N';
            case 3: return 'S';
            default: throw new IllegalArgumentException("Invalid direction");
        }
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static class Interval {
        int x, y;

        Interval(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}