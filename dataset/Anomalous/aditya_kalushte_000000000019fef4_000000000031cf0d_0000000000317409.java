import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String moves = sc.next();
            
            int xCurrent = x;
            int yCurrent = y;
            int minutesToReach = 0;
            boolean reached = false;

            for (int i = 0; i < moves.length; i++) {
                char move = moves.charAt(i);

                switch (move) {
                    case 'N':
                        yCurrent++;
                        break;
                    case 'S':
                        yCurrent--;
                        break;
                    case 'E':
                        xCurrent++;
                        break;
                    case 'W':
                        xCurrent--;
                        break;
                }

                if (xCurrent == 0 && yCurrent == 0) {
                    minutesToReach++;
                    reached = true;
                    break;
                }

                if (xCurrent > 0) {
                    xCurrent--;
                } else if (yCurrent > 0) {
                    yCurrent--;
                } else if (xCurrent < 0) {
                    xCurrent++;
                } else if (yCurrent < 0) {
                    yCurrent++;
                }

                minutesToReach++;

                if (xCurrent == 0 && yCurrent == 0) {
                    reached = true;
                    break;
                }
            }

            if (reached) {
                System.out.println("Case #" + t + ": " + minutesToReach);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
        
        sc.close();
    }
}