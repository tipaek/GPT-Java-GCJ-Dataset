import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());
        String[] N;


        for(int a=0; a < T; a++) {
            N = scanner.nextLine().split(" ");
            int X = Integer.parseInt(N[0]);
            int Y = Integer.parseInt(N[1]);
            String M = N[2];

            String State = "IMPOSSIBLE";
            int Steps = 1001;

            char[] Mm = M.toCharArray();
            int i = 0;

            for (char m : Mm) {
                i += 1;
                switch (m) {
                    case 'N':
                        Y += 1;
                        break;
                    case 'E':
                        X += 1;
                        break;
                    case 'S':
                        Y -= 1;
                        break;
                    case 'W':
                        X -= 1;
                        break;
                }

                if (Math.abs(X)+Math.abs(Y) <= i && i < Steps) {
                    Steps = i;
                    State = Integer.toString(i);
                }
            }

            System.out.println("Case #"+(a+1)+": "+State);

        }
    }
}