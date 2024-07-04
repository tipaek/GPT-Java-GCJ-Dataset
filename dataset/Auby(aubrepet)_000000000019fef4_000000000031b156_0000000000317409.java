import java.util.Scanner;

/**
 *
 * @author peta
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        in.nextLine();
        for (int i = 0; i < tests; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            char[] path = in.nextLine().toCharArray();
            int round = 0;
            boolean catched = false;
            int wrongRounds = 0;
            while (!catched && round <= path.length - 1) {
                
                switch (path[round]) {
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                    default:
                        wrongRounds++;
                }
                
                round++;
                
                if (round - wrongRounds >= Math.abs(x) + Math.abs(y)) {
                    catched = true;
                }
                
                

            }
            round -= wrongRounds;
            System.out.println("Case #" + (i+1) + ": " + (catched ? round : "IMPOSSIBLE"));
        }
        

    }

}
