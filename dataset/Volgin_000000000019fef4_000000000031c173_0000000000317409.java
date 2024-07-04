import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static final BufferedReader reader = submission();

    private static BufferedReader submission() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static BufferedReader playGround() {
        try {
            return new BufferedReader(new FileReader("C:/temp/codejam/testInput.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Wrong File path", e);
        }
    }

    private static String formatResult(int caseId, String result) {
        return "Case #" + caseId + ": " + result;
    }

    public static void main(String... args) throws IOException {
        String[] mainEntry = reader.readLine().split(" ");
        int T = Integer.parseInt(mainEntry[0]);
        for (int i = 0; i < T; i++) {
            mainLoop(i + 1, reader, mainEntry);
        }
    }

    private static void mainLoop(int caseId, BufferedReader reader, String[] globalEntry) throws IOException {
        String[] input = reader.readLine().split(" ");
        int x = Integer.valueOf(input[0]);
        int y = Integer.valueOf(input[1]);
        String path = input[2];
        int distance = Math.abs(x) + Math.abs(y);
        int minutes = 0;
        if (minutes == distance) {
            System.out.println(formatResult(caseId, "" + minutes));
            return;
        }
        for (char c : path.toCharArray()) {
            minutes ++;
            if (c == 'S' || c == 'N') {
                y += c == 'S' ? -1 : 1;
            } else {
                x += c == 'W' ? -1 : 1;
            }
            distance = Math.abs(x) + Math.abs(y);
            if (minutes >= distance) {
                System.out.println(formatResult(caseId, "" + minutes));
                return;
            }
        }
        System.out.println(formatResult(caseId, "IMPOSSIBLE"));
    }
}
