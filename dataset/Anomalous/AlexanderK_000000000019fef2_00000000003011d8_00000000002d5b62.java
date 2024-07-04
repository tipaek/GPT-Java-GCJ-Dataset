import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            handleInput(reader);
        }
    }

    static class InputData {
        int x, y;

        public InputData(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public InputData(BufferedReader reader) throws IOException {
            String[] parts = reader.readLine().split(" ");
            x = Integer.parseInt(parts[0]);
            y = Integer.parseInt(parts[1]);
        }

        @Override
        public String toString() {
            return "InputData{" + "x=" + x + ", y=" + y + '}';
        }
    }

    static class OutputData {
        String directions;

        public OutputData(String directions) {
            this.directions = directions;
        }

        @Override
        public String toString() {
            return directions == null ? "IMPOSSIBLE" : directions;
        }
    }

    public static void handleInput(BufferedReader reader) throws IOException {
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + findSolution(new InputData(reader)));
        }
    }

    static final String[][] SOLUTIONS = new String[201][201];
    static final int OFFSET = 100;

    static class Position {
        int x, y, step;
        String directions;

        public Position(int x, int y, int step, String directions) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.directions = directions;
        }
    }

    static String transformDirections(String directions, String from, String to) {
        char[] chars = directions.toCharArray();
        Map<Character, Character> charMap = new HashMap<>(from.length());
        for (int i = 0; i < from.length(); i++) {
            charMap.put(from.charAt(i), to.charAt(i));
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i] = charMap.getOrDefault(chars[i], chars[i]);
        }
        return new String(chars);
    }

    static {
        Queue<Position> queue = new PriorityQueue<>(Comparator.comparingInt(position -> position.step));
        queue.add(new Position(1, 0, 1, "E"));
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            int i = position.x + OFFSET, j = position.y + OFFSET;
            if (i < 0 || i >= SOLUTIONS.length || j < 0 || j >= SOLUTIONS[0].length) {
                if (position.step > 2 * SOLUTIONS.length) {
                    continue;
                }
            } else {
                if (SOLUTIONS[i][j] == null) {
                    SOLUTIONS[i][j] = position.directions;
                    SOLUTIONS[-position.x + OFFSET][j] = transformDirections(position.directions, "EW", "WE");
                    SOLUTIONS[i][-position.y + OFFSET] = transformDirections(position.directions, "SN", "NS");
                    SOLUTIONS[-position.x + OFFSET][-position.y + OFFSET] = transformDirections(position.directions, "SNEW", "NSWE");
                    SOLUTIONS[position.y + OFFSET][position.x + OFFSET] = transformDirections(position.directions, "SNEW", "WENS");
                    SOLUTIONS[-position.y + OFFSET][position.x + OFFSET] = transformDirections(position.directions, "SNEW", "EWNS");
                    SOLUTIONS[position.y + OFFSET][-position.x + OFFSET] = transformDirections(position.directions, "SNEW", "WESN");
                    SOLUTIONS[-position.y + OFFSET][-position.x + OFFSET] = transformDirections(position.directions, "SNEW", "EWSN");
                }
            }
            int nextStep = position.step * 2;
            queue.add(new Position(position.x + nextStep, position.y, nextStep, position.directions + "E"));
            queue.add(new Position(position.x - nextStep, position.y, nextStep, position.directions + "W"));
            queue.add(new Position(position.x, position.y + nextStep, nextStep, position.directions + "N"));
            queue.add(new Position(position.x, position.y - nextStep, nextStep, position.directions + "S"));
        }
    }

    static OutputData findSolution(InputData input) {
        if (input.x >= -100 && input.x <= 100 && input.y >= -100 && input.y <= 100) {
            return new OutputData(SOLUTIONS[input.x + OFFSET][input.y + OFFSET]);
        }
        return new OutputData(null);
    }
}