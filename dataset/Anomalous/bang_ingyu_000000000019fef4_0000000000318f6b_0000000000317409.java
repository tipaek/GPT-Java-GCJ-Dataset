import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static int parseStringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder output = new StringBuilder();
            StringTokenizer tokenizer;

            int testCaseCount = parseStringToInt(reader.readLine());

            for (int i = 1; i <= testCaseCount; ++i) {
                output.append(String.format("Case #%d: ", i));
                tokenizer = new StringTokenizer(reader.readLine());
                int x = parseStringToInt(tokenizer.nextToken());
                int y = parseStringToInt(tokenizer.nextToken());
                char[] moves = tokenizer.nextToken().toCharArray();
                int time = -1;

                if (x == 0 && y == 0) {
                    time = 0;
                }

                for (int j = 0; time < 0 && j < moves.length; j++) {
                    char direction = moves[j];
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
                    if (Math.abs(x) + Math.abs(y) <= j + 1) {
                        time = j + 1;
                    }
                }

                if (time < 0) {
                    output.append("IMPOSSIBLE\n");
                } else {
                    output.append(time).append("\n");
                }
            }

            writer.write(output.toString());
            writer.flush();
        }
    }
}