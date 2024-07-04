import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static BufferedReader in;
    static List<Input> inputs = new ArrayList<>();

    public static void main(String[] args) {
        readInput();

        int i = 1;

        for (Input input : inputs) {
            processNumber(input, i);
            i++;
        }
    }

    private static void processNumber(Input input, int testcaseId) {

        char[] moves = input.moves.toCharArray();

        int targetPosX = input.x;
        int targetPosY = input.y;

        for (int i = 0; i < moves.length; i++) {
            if (calcDistance(0, 0, targetPosX, targetPosY) <= i) {
                System.out.println("Case #" + testcaseId + ": " + i);
                return;
            }

            char move = moves[i];

            switch (move) {
                case 'N':
                    targetPosY++;
                    break;
                case 'S':
                    targetPosY--;
                    break;
                case 'E':
                    targetPosX++;
                    break;
                case 'W':
                    targetPosX--;
                    break;
            }
        }

        if (calcDistance(0, 0, targetPosX, targetPosY) <= moves.length) {
            System.out.println("Case #" + testcaseId + ": " + moves.length);
        } else {
            System.out.println("Case #" + testcaseId + ": IMPOSSIBLE");
        }
    }

    private static int calcDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static void readInput() {
        in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();

            int numberOfTestCases = Integer.parseInt(line);

            for (int i = 0; i < numberOfTestCases; i++) {
                line = in.readLine();

                String[] fractals = line.split(" ");

                Input input = new Input();
                input.x = Integer.parseInt(fractals[0]);
                input.y = Integer.parseInt(fractals[1]);
                input.moves = fractals[2];

                inputs.add(input);
            }
        } catch (IOException e) {
            System.out.println("something went wrong during reading input");
        }
    }

    private static class Input {
        int x;
        int y;
        String moves;
    }
}
