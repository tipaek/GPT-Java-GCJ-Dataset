import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i=1; i<=t; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String tour = in.nextLine().trim();

            // find smallest way point
            int dist = Math.abs(x)+Math.abs(y);
            int minJ =-1;
            for (int j = 0; j < tour.length(); j++) {
                if (tour.charAt(j) == 'S')
                    y -= 1;
                if (tour.charAt(j) == 'N')
                    y += 1;
                if (tour.charAt(j) == 'E')
                    x += 1;
                if (tour.charAt(j) == 'W')
                    x -= 1;

                int newDist = Math.abs(x)+Math.abs(y);
                if (newDist < dist && j+1 >= newDist) {
                    dist = newDist;
                    minJ = j+1;
                }
            }

            if (dist > tour.length() || minJ == -1 ) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            // entgegen gehen
            if (dist < minJ)
                minJ -= dist;

            System.out.println("Case #" + i + ": " + minJ);
        }
    }
}
