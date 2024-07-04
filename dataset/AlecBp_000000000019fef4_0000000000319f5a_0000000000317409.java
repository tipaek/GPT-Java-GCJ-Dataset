public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        int _x = 0;
        int _y = 0;
        int distance, x, y;
        boolean solved;
        for (int i = 1; i <= t; ++i) {
            x = in.nextInt();
            y = in.nextInt();
            String M = in.next();
            solved = false;

            for (int j = 0; j < M.length(); j++) {

                if (M.charAt(j) == 'N') {
                    y++;
                } else if (M.charAt(j) == 'S') {
                    y--;
                } else if (M.charAt(j) == 'W') {
                    x--;
                } else if (M.charAt(j) == 'E') {
                    x++;
                }

                distance = Math.abs(x) + Math.abs(y);
                if (distance <= j + 1) {
                    System.out.println(j + 1);
                    solved = true;
                    break;
                }
            }
            
            if (!solved) {
                System.out.println("IMPOSSIBLE");
            }

        }
    }
}