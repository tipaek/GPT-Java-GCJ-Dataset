import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static int stringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();
        StringTokenizer tokenizer;

        int testCases = stringToInt(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            output.append(String.format("Case #%d: ", i));
            tokenizer = new StringTokenizer(reader.readLine());
            int xInput = stringToInt(tokenizer.nextToken());
            int yInput = stringToInt(tokenizer.nextToken());
            boolean isXNegative = (xInput < 0);
            boolean isYNegative = (yInput < 0);

            int x = Math.abs(xInput);
            int y = Math.abs(yInput);

            if (((x + y + 1) & (x + y)) == 0) {
                int step = 1;
                while ((x + y) > 0) {
                    if ((x & step) > 0) {
                        output.append(isXNegative ? "W" : "E");
                        x -= (x & (-x));
                    } else {
                        output.append(isYNegative ? "S" : "N");
                        y -= (y & (-y));
                    }
                    step <<= 1;
                }
            } else if (x > y && ((-x + y + 1) & (-x + y)) == 0) {
                int step = 1;
                while ((x + y) > 0) {
                    if ((x & step) > 0) {
                        if (((x - 1) & x) != 0) {
                            output.append(isXNegative ? "E" : "W");
                            x -= (x & (-x));
                        } else {
                            x -= (x & (-x));
                        }
                    } else {
                        output.append(isYNegative ? "S" : "N");
                        y -= (y & (-y));
                    }
                    step <<= 1;
                }
                output.append(isXNegative ? "W" : "E");
            } else if (x < y && ((x - y + 1) & (x - y)) == 0) {
                int step = 1;
                while ((x + y) > 0) {
                    if ((x & step) > 0) {
                        output.append(isXNegative ? "W" : "E");
                        x -= (x & (-x));
                    } else {
                        if (((y - 1) & y) != 0) {
                            output.append(isYNegative ? "N" : "S");
                            y -= (y & (-y));
                        } else {
                            y -= (y & (-y));
                        }
                    }
                    step <<= 1;
                }
                output.append(isYNegative ? "S" : "N");
            } else if (((-x - y + 1) & (-x - y)) == 0) {
                int step = 1;
                while ((x + y) > 0) {
                    if ((x & step) > 0) {
                        if (((x - 1) & y) != 0) {
                            output.append(isXNegative ? "E" : "W");
                            x -= (x & (-x));
                        } else {
                            x -= (x & (-x));
                        }
                    } else {
                        if (((y - 1) & y) != 0) {
                            output.append(isYNegative ? "N" : "S");
                            y -= (y & (-y));
                        } else {
                            y -= (y & (-y));
                        }
                    }
                    step <<= 1;
                }
                if (x > y) {
                    output.append(isYNegative ? "S" : "N");
                    output.append(isXNegative ? "W" : "E");
                } else {
                    output.append(isXNegative ? "W" : "E");
                    output.append(isYNegative ? "S" : "N");
                }
            } else {
                output.append("IMPOSSIBLE");
            }

            output.append("\n");
        }
        writer.write(output.toString());
        writer.flush();
        writer.close();
    }
}