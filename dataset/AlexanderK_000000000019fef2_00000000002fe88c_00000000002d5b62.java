import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author alexk
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            process(r);
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
            x = Integer.parseInt(line[0]);
            y = Integer.parseInt(line[1]);
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
            if (dirs == null) {
                return "IMPOSSIBLE";
            }            
            return dirs;
        }
    }

    public static void process(BufferedReader r) throws IOException {
        int t = Integer.parseInt(r.readLine());
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve(new Input(r)));
        }
    }
    
    static final String[][] SOLUTIONS = new String[201][201];
    static final int OFFSET = 100;
    
    static class Pos {
        int x, y, step;
        String dirs;

        public Pos(int x, int y, int step, String dirs) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.dirs = dirs;
        }
        
    }
    
    static String replace(String dirs, String from, String to) {
        char[] c = dirs.toCharArray();
        Map<Character, Character> m = new HashMap<>(from.length());
        for (int i = 0; i < from.length(); i++) {
            m.put(from.charAt(i), to.charAt(i));
        }
        for (int i = 0; i < c.length; i++) {
            c[i] = m.getOrDefault(c[i], c[i]);
        }
        return String.valueOf(c);
    }
    
    static {
        Queue<Pos> q = new PriorityQueue<>(Comparator.comparingInt((p) -> p.step));
        // start in one direction to avoid 4x search
        q.add(new Pos(1,0,1,"E"));
        SOLUTIONS[OFFSET][OFFSET] = "";
        while (!q.isEmpty()) {
            Pos p = q.poll();
            int i = p.x + OFFSET, j = p.y + OFFSET;
            if (i < 0 || i >= SOLUTIONS.length || j < 0 || j >= SOLUTIONS[0].length) {
                // Might be a better way to break this iteration
                if (p.step > SOLUTIONS.length) {
                    continue;
                }
            } else {
                if (SOLUTIONS[i][j] != null) {
                    continue;
                }
                SOLUTIONS[i][j] = p.dirs;
                SOLUTIONS[-p.x + OFFSET][j] = replace(p.dirs, "EW", "WE");
                SOLUTIONS[i][-p.y + OFFSET] = replace(p.dirs, "SN", "NS");
                SOLUTIONS[-p.x + OFFSET][-p.y + OFFSET] = replace(p.dirs, "SNEW", "NSWE");
                SOLUTIONS[p.y + OFFSET][p.x + OFFSET] = replace(p.dirs, "SNEW", "WENS");
                SOLUTIONS[-p.y + OFFSET][p.x + OFFSET] = replace(p.dirs, "SNEW", "EWNS");
                SOLUTIONS[p.y + OFFSET][-p.x + OFFSET] = replace(p.dirs, "SNEW", "WESN");
                SOLUTIONS[-p.y + OFFSET][-p.x + OFFSET] = replace(p.dirs, "SNEW", "EWSN");
            }
            int step = p.step * 2;
            q.add(new Pos(p.x + step, p.y, step, p.dirs + "E"));
            q.add(new Pos(p.x - step, p.y, step, p.dirs + "W"));
            q.add(new Pos(p.x, p.y + step, step, p.dirs + "N"));
            q.add(new Pos(p.x, p.y - step, step, p.dirs + "S"));
        }
    }

    static Output solve(Input in) {
//        System.err.println("Input: " + in);
        if (-100 <= in.x && in.x <= 100 && 
                -100 <= in.y && in.y <= 100) {
            return new Output(SOLUTIONS[in.x + OFFSET][in.y + OFFSET]);
        }
        return new Output(null);
    }
}
