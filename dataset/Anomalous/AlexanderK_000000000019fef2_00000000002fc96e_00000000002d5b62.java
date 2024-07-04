package google.jam.b1;

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

    static class Input {
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

    static class Output {
        String dirs;

        public Output(String dirs) {
            this.dirs = dirs;
        }

        @Override
        public String toString() {
            return dirs == null ? "IMPOSSIBLE" : dirs;
        }
    }

    public static void process(BufferedReader reader) throws IOException {
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve(new Input(reader)));
        }
    }

    static final String[][] SOLUTIONS = new String[201][201];
    static final int OFFSET = 100;

    static class Position {
        int x, y, step;
        String dirs;

        public Position(int x, int y, int step, String dirs) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.dirs = dirs;
        }
    }

    static String replace(String dirs, String from, String to) {
        char[] chars = dirs.toCharArray();
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
                if (pos.step > SOLUTIONS.length) continue;
            } else {
                if (SOLUTIONS[i][j] != null) continue;
                
                SOLUTIONS[i][j] = pos.dirs;
                SOLUTIONS[-pos.x + OFFSET][j] = replace(pos.dirs, "EW", "WE");
                SOLUTIONS[i][-pos.y + OFFSET] = replace(pos.dirs, "SN", "NS");
                SOLUTIONS[-pos.x + OFFSET][-pos.y + OFFSET] = replace(pos.dirs, "SNEW", "NSWE");
                SOLUTIONS[pos.y + OFFSET][pos.x + OFFSET] = replace(pos.dirs, "SNEW", "WENS");
                SOLUTIONS[-pos.y + OFFSET][pos.x + OFFSET] = replace(pos.dirs, "SNEW", "EWNS");
                SOLUTIONS[pos.y + OFFSET][-pos.x + OFFSET] = replace(pos.dirs, "SNEW", "WESN");
                SOLUTIONS[-pos.y + OFFSET][-pos.x + OFFSET] = replace(pos.dirs, "SNEW", "EWSN");
            }

            int step = pos.step * 2;
            queue.add(new Position(pos.x + step, pos.y, step, pos.dirs + "E"));
            queue.add(new Position(pos.x - step, pos.y, step, pos.dirs + "W"));
            queue.add(new Position(pos.x, pos.y + step, step, pos.dirs + "N"));
            queue.add(new Position(pos.x, pos.y - step, step, pos.dirs + "S"));
        }
    }

    static Output solve(Input input) {
        if (-100 <= input.x && input.x <= 100 && -100 <= input.y && input.y <= 100) {
            return new Output(SOLUTIONS[input.x + OFFSET][input.y + OFFSET]);
        }
        return new Output(null);
    }
}