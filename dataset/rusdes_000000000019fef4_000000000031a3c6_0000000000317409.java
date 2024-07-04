import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = reader.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int X = reader.nextInt(), Y = reader.nextInt();
            String S = reader.next();
            if (X == 0 && Y == 0){
                System.out.println("Case #" + i + ": 0");
                continue;
            }
            int time = 0;
            boolean done= false;
            for (int j = 1; j <= S.length(); j++){
                time++;
                if (S.charAt(j - 1) == 'N')
                    Y++;
                else if (S.charAt(j - 1) == 'S')
                    Y--;
                else if (S.charAt(j - 1) == 'E')
                    X++;
                else
                    X--;

                if (Math.abs(X) + Math.abs(Y) <= time){
                    System.out.println("Case #" + i + ": " + time);
                    done = true;
                    break;
                }
            }

            if (!done){
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}