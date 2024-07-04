import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Solution solution = new Solution();
        for (int i = 1; i <= t; i++) {
            solution.solve(i, br);
        }
    }

    private void solve(int caseNumber, BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        String path = input[2];
        int steps = 0;
        boolean reached = false;

        if (Math.abs(x) + Math.abs(y) <= steps) {
            reached = true;
        } else {
            for (char direction : path.toCharArray()) {
                steps++;
                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                if (Math.abs(x) + Math.abs(y) <= steps) {
                    reached = true;
                    break;
                }
            }
        }

        if (reached) {
            System.out.println("Case #" + caseNumber + ": " + steps);
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }
}