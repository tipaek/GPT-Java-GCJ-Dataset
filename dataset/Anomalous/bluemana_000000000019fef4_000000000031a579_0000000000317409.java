import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             Writer writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            processInput(reader, writer);
        }
    }
    
    private static void processInput(BufferedReader reader, Writer writer) throws Exception {
        int numberOfTests = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfTests; i++) {
            handleTestCase(i, reader, writer);
        }
    }

    private static void handleTestCase(int testCaseIndex, BufferedReader reader, Writer writer) throws Exception {
        String[] input = reader.readLine().split(" ");
        int startX = Integer.parseInt(input[0]);
        int startY = Integer.parseInt(input[1]);
        String movements = input[2];
        int minimumTime = calculateMinimumTime(startX, startY, movements);
        writer.write(String.format("Case #%d: %s", testCaseIndex + 1, minimumTime == -1 ? "IMPOSSIBLE" : String.valueOf(minimumTime)));
        writer.write("\n");
        writer.flush();
    }

    private static int calculateMinimumTime(int x, int y, String movements) {
        for (int minute = 1; minute <= movements.length(); minute++) {
            char move = movements.charAt(minute - 1);
            switch (move) {
                case 'N': y++; break;
                case 'E': x++; break;
                case 'S': y--; break;
                case 'W': x--; break;
            }
            if (Math.abs(x) + Math.abs(y) <= minute) {
                return minute;
            }
        }
        return -1;
    }
}