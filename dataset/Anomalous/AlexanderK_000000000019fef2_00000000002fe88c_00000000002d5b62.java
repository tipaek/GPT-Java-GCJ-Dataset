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
            process(reader);
        }
    }

    private static class Input {
        int x, y;

        public Input(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Input(BufferedReader br) throws IOException {
            String[] line = br.readLine().split(" ");
            this.x = Integer.parseInt(line[0]);
            this.y = Integer.parseInt(line[1]);
        }

        @Override
        public String toString() {
            return "Input{" + "x=" + x + ", y=" + y + '}';
        }
    }

    private static class Output {
        String directions;

        public Output(String directions) {
            this.directions = directions;
        }

        @Override
        public String toString() {
            return directions == null ? "IMPOSSIBLE" : directions;
        }
    }

    private static void process(BufferedReader reader) throws IOException {
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve(new Input(reader)));
        }
    }

    private static final String[][] SOLUTIONS = new String[201][201];
    private static final int OFFSET = 100;

    private static class Position {
        int x, y, step;
        String directions;

        public Position(int x, int y, int step, String directions) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.directions = directions;
        }
    }

    private static String replaceDirections(String directions, String from, String to) {
        char[] chars = directions.toCharArray();
        Map<Character, Character> map = new HashMap<>(from.length());
        for (int i = 0; i < from.length(); i++) {
            map.put(from.charAt(i), to.charAt(i));
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i] = map.getOrDefault(chars[i], chars[i]);
        }
        return new String(chars);
    }

    static {
        Queue<Position> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.step));
        queue.add(new Position(1, 0, 1, "E"));
        SOLUTIONS[OFFSET][OFFSET] = "";
        
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int i = pos.x + OFFSET, j = pos.y + OFFSET;
            
            if (i < 0 || i >= SOLUTIONS.length || j < 0 || j >= SOLUTIONS[0].length) {
                if (pos.step > SOLUTIONS.length) {
                    continue;
                }
            } else {
                if (SOLUTIONS[i][j] != null) {
                    continue;
                }
                SOLUTIONS[i][j] = pos.directions;
                SOLUTIONS[-pos.x + OFFSET][j] = replaceDirections(pos.directions, "EW", "WE");
                SOLUTIONS[i][-pos.y + OFFSET] = replaceDirections(pos.directions, "SN", "NS");
                SOLUTIONS[-pos.x + OFFSET][-pos.y + OFFSET] = replaceDirections(pos.directions, "SNEW", "NSWE");
                SOLUTIONS[pos.y + OFFSET][pos.x + OFFSET] = replaceDirections(pos.directions, "SNEW", "WENS");
                SOLUTIONS[-pos.y + OFFSET][pos.x + OFFSET] = replaceDirections(pos.directions, "SNEW", "EWNS");
                SOLUTIONS[pos.y + OFFSET][-pos.x + OFFSET] = replaceDirections(pos.directions, "SNEW", "WESN");
                SOLUTIONS[-pos.y + OFFSET][-pos.x + OFFSET] = replaceDirections(pos.directions, "SNEW", "EWSN");
            }
            
            int nextStep = pos.step * 2;
            queue.add(new Position(pos.x + nextStep, pos.y, nextStep, pos.directions + "E"));
            queue.add(new Position(pos.x - nextStep, pos.y, nextStep, pos.directions + "W"));
            queue.add(new Position(pos.x, pos.y + nextStep, nextStep, pos.directions + "N"));
            queue.add(new Position(pos.x, pos.y - nextStep, nextStep, pos.directions + "S"));
        }
    }

    private static Output solve(Input input) {
        if (-100 <= input.x && input.x <= 100 && -100 <= input.y && input.y <= 100) {
            return new Output(SOLUTIONS[input.x + OFFSET][input.y + OFFSET]);
        }
        return new Output(null);
    }
}