import java.io.*;
import java.util.*;

public class Solution {
    private static final char[] DIRECTIONS = {'A', 'S', 'N', 'E', 'W'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        
        int testCases = in.nextInt();
        for (int tc = 1; tc <= testCases; tc++) {
            int startX = in.nextInt();
            int startY = in.nextInt();
            String moves = in.next();
            int moveCount = moves.length();
            
            Pair[] intersections = new Pair[moveCount + 1];
            intersections[0] = new Pair(startX, startY);
            for (int i = 0; i < moveCount; i++) {
                intersections[i + 1] = getNextPosition(moves.charAt(i), intersections[i]);
            }
            
            Queue<Info> queue = new LinkedList<>();
            int result = -1;
            queue.add(new Info(new Pair(0, 0), 0));
            
            while (!queue.isEmpty()) {
                Info current = queue.poll();

                if (arePairsEqual(current.position, intersections[current.time])) {
                    result = current.time;
                    break;
                }

                for (char direction : DIRECTIONS) {
                    if (current.time < moveCount) {
                        queue.add(new Info(getNextPosition(direction, current.position), current.time + 1));
                    }
                }
            }

            out.print("Case #" + tc + ": ");
            if (result == -1) {
                out.println("IMPOSSIBLE");
            } else {
                out.println(result);
            }
        }
        out.close();
    }

    private static boolean arePairsEqual(Pair p1, Pair p2) {
        return p1.x == p2.x && p1.y == p2.y;
    }

    private static Pair getNextPosition(char direction, Pair current) {
        int x = current.x, y = current.y;
        switch (direction) {
            case 'A': return current;
            case 'S': return new Pair(x, y - 1);
            case 'N': return new Pair(x, y + 1);
            case 'E': return new Pair(x + 1, y);
            case 'W': return new Pair(x - 1, y);
            default: throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }

    static class Info {
        Pair position;
        int time;

        Info(Pair position, int time) {
            this.position = position;
            this.time = time;
        }
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}