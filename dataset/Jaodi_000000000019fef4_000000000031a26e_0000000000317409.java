import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();
            String[] parts = line.split(" ");
            int x = Integer.parseInt(parts[0], 10);
            int y = Integer.parseInt(parts[1], 10);
            String moves = parts[2];
            int result = 0;
            for (int j = 0; j < moves.length(); j++) {
                Character c = moves.charAt(j);
                switch (c) {
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
                    default:
                        break;
                }
                if (j + 1 >= Math.abs(x) + Math.abs(y)) {
                    result = j + 1;
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + ((result > 0) ? result : "IMPOSSIBLE"));
        }
        in.close();
    }

}