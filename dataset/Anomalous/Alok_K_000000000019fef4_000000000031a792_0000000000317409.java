import java.io.*;

class Solution {

    private static BufferedReader reader;
    private static BufferedWriter writer;

    private static void initializeIO() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static String readLine() throws IOException {
        String line = "";
        while (line.isEmpty()) {
            line = reader.readLine();
        }
        return line;
    }

    private static int parseInt(String str) {
        return Integer.parseInt(str);
    }

    private static long parseLong(String str) {
        return Long.parseLong(str);
    }

    private static int[] readIntArray() throws IOException {
        String[] tokens = readLine().split(" ");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseInt(tokens[i]);
        }
        return array;
    }

    private static long[] readLongArray() throws IOException {
        String[] tokens = readLine().split(" ");
        long[] array = new long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = parseLong(tokens[i]);
        }
        return array;
    }

    public static void main(String[] args) throws IOException {
        initializeIO();
        int testCases = parseInt(readLine());
        int caseNumber = 1;

        while (testCases-- > 0) {
            String[] input = readLine().split(" ");
            int x = parseInt(input[0]);
            int y = parseInt(input[1]);
            String path = input[2];

            int steps = 0;
            boolean reached = false;

            for (int i = 0; i < path.length(); i++) {
                if (Math.abs(x) + Math.abs(y) <= steps) {
                    reached = true;
                    break;
                }

                char direction = path.charAt(i);
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
                steps++;
            }

            if (Math.abs(x) + Math.abs(y) <= steps) {
                reached = true;
            }

            writer.write("Case #" + caseNumber + ": ");
            if (!reached) {
                writer.write("IMPOSSIBLE\n");
            } else {
                writer.write(steps + "\n");
            }
            caseNumber++;
        }
        writer.flush();
    }
}