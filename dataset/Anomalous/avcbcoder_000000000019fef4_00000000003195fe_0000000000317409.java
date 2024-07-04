import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            solve(br);
        }
    }

    public static void solve(BufferedReader br) throws IOException {
        String[] ip = br.readLine().split(" ");
        int x = -Integer.parseInt(ip[0]);
        int y = -Integer.parseInt(ip[1]);
        String moves = ip[2];

        int time = 0;
        for (int i = 0; i < moves.length(); i++) {
            time++;
            switch (moves.charAt(i)) {
                case 'N':
                    y--;
                    break;
                case 'S':
                    y++;
                    break;
                case 'E':
                    x--;
                    break;
                case 'W':
                    x++;
                    break;
            }
            int t = Math.abs(x) + Math.abs(y);
            if (t <= time) {
                System.out.println(time);
                return;
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}