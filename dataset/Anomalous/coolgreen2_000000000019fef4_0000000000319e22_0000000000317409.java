import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int testCases = Integer.parseInt(bufferedReader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            System.out.print("Case #" + caseNumber + ": ");
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            String directions = stringTokenizer.nextToken();

            boolean possible = false;
            for (int i = 0; i < directions.length(); i++) {
                char direction = directions.charAt(i);
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
                if (Math.abs(x) + Math.abs(y) <= i + 1) {
                    System.out.println(i + 1);
                    possible = true;
                    break;
                }
            }

            if (!possible) {
                System.out.println("IMPOSSIBLE");
            }
        }

        printWriter.close();
    }
}