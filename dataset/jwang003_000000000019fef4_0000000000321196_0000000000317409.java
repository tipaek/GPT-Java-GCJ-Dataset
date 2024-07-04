import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();
        in.nextLine();
        for (int i = 0; i< cases; i++) {
            String[] info = in.nextLine().split(" ");
            int x = Integer.parseInt(info[0]);
            int y = Integer.parseInt(info[1]);
            String path = info[2];
            boolean possible = false;
            for (int j = 0; j < path.length(); j++) {
                String nextMove = path.substring(j, j+1);
                switch (nextMove) {
                    case "N":
                        y++;
                        break;
                    case "S":
                        y--;
                        break;
                    case "E":
                        x++;
                        break;
                    case "W":
                        x--;
                        break;
                }
                if (Math.abs(x)+Math.abs(y) <= (j+1)) {
                    possible = true;
                    System.out.println("Case #" + (i+1) + ": " + (j+1));
                    break;
                } else {
                    continue;
                }
            }
            if (!possible) System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
        }
    }

}
