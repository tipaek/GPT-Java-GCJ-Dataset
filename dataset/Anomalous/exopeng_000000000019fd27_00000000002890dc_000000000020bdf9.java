import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        int cases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < cases; i++) {
            int acts = Integer.parseInt(reader.readLine());
            Pair[] activities = new Pair[acts];

            for (int j = 0; j < acts; j++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                activities[j] = new Pair(start, end, j);
            }

            Arrays.sort(activities, Comparator.comparingInt(p -> p.x));
            Pair[] events = new Pair[acts * 2];
            int index = 0;

            for (int j = 0; j < acts; j++) {
                events[index++] = new Pair(activities[j].x, j, activities[j].orig);
                events[index++] = new Pair(activities[j].y, j, activities[j].orig);
            }

            Arrays.sort(events, Comparator.comparingInt(p -> p.x));
            boolean impossible = false;
            String[] result = new String[acts];
            int c = -1, j = -1;

            for (Pair event : events) {
                if (event.y == c) {
                    c = -1;
                } else if (event.y == j) {
                    j = -1;
                } else {
                    if (c == -1) {
                        c = event.y;
                        result[event.orig] = "C";
                    } else if (j == -1) {
                        j = event.y;
                        result[event.orig] = "J";
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }

            if (impossible) {
                writer.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                writer.println("Case #" + (i + 1) + ": " + String.join("", result));
            }
        }

        writer.close();
    }
}

class Pair {
    int x;
    int y;
    int orig;

    public Pair(int x, int y, int orig) {
        this.x = x;
        this.y = y;
        this.orig = orig;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}