import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String path = in.next();

            int result = -1;

            for (int j = 0; j < path.length(); j++){
                if (j >= Math.abs(x) + Math.abs(y)){
                    result = j;
                    break;
                }
                
                if (path.charAt(j) == 'N') {
                    y++;
                }
                if (path.charAt(j) == 'S') {
                    y--;
                }
                if (path.charAt(j) == 'E') {
                    x++;
                }
                if (path.charAt(j) == 'W') {
                    x--;
                }
            }

            if (result == -1){
                if (path.length() >= Math.abs(x) + Math.abs(y)) {
                    result = path.length();
                }
            }

            if (result == -1){
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }
}
