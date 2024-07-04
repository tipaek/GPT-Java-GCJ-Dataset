import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 1; t <= T; t++) {
            int ans = 0;

            int X = in.nextInt();
            int Y = in.nextInt();
            char[] path = in.next().toCharArray();

            int[] dist = new int[path.length + 1];

            for(int i = 0; i < path.length; i++) {
                dist[i] = Math.abs(X) + Math.abs(Y);
                switch(path[i]) {
                    case 'N': Y++;
                        break;
                    case 'S': Y--;
                        break;
                    case 'E': X++;
                        break;
                    case 'W': X--;
                        break;
                }
            }

            dist[path.length] = Math.abs(X) + Math.abs(Y);

            boolean isFound = false;

            for(int i = 0; i < path.length + 1; i++) {
                if(i >= dist[i]) {
                    System.out.printf("Case #%d: %d\n", t, i);
                    isFound = true;
                    break;
                }
            }

            if(isFound) continue;
            System.out.printf("Case #%d: IMPOSSIBLE\n", t);
        }
    }
}