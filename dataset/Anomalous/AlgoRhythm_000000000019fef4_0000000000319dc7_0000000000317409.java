import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            String directions = tokenizer.nextToken();
            int time = -1;

            for (int j = 0; ; j++) {
                if (Math.abs(x) + Math.abs(y) <= j) {
                    time = j;
                    break;
                }
                if (j == directions.length()) {
                    break;
                }
                char direction = directions.charAt(j);
                switch (direction) {
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
                }
            }

            if (time == -1) {
                System.out.println("Case " + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case " + caseNumber + ": " + time);
            }
        }
    }
}