import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            solve(br);
        }
    }

    public static void solve(BufferedReader br) throws Exception {
        String[] input = br.readLine().split(" ");
        int x = -Integer.parseInt(input[0]);
        int y = -Integer.parseInt(input[1]);
        String directions = input[2];

        int time = 0;
        for (char direction : directions.toCharArray()) {
            time++;
            switch (direction) {
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
            int distance = Math.abs(x) + Math.abs(y);
            if (distance <= time) {
                System.out.println(time);
                return;
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}