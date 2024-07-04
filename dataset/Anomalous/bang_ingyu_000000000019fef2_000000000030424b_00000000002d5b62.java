import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        StringTokenizer tokenizer;

        int testCases = parseInt(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            result.append(String.format("Case #%d: ", i));
            tokenizer = new StringTokenizer(reader.readLine());
            int xInput = parseInt(tokenizer.nextToken());
            int yInput = parseInt(tokenizer.nextToken());
            boolean isXNegative = (xInput < 0);
            boolean isYNegative = (yInput < 0);

            int x = Math.abs(xInput);
            int y = Math.abs(yInput);

            if (((x + y + 1) & (x + y)) == 0) {
                int step = 1;
                while ((x + y) > 0) {
                    if ((x & step) > 0) {
                        result.append(isXNegative ? "W" : "E");
                        x -= (x & (-x));
                    } else {
                        result.append(isYNegative ? "S" : "N");
                        y -= (y & (-y));
                    }
                    step <<= 1;
                }
            } else if (x > y) {
                if (((-x + y + 1) & (-x + y)) == 0) {
                    int step = 1;
                    while ((x + y) > 0) {
                        if ((x & step) > 0) {
                            if (((x - 1) & x) != 0) {
                                result.append(isXNegative ? "E" : "W");
                                x -= (x & (-x));
                            } else {
                                x -= (x & (-x));
                            }
                        } else {
                            result.append(isYNegative ? "S" : "N");
                            y -= (y & (-y));
                        }
                        step <<= 1;
                    }
                    result.append(isXNegative ? "W" : "E");
                }
            } else if (x < y) {
                if (((x - y + 1) & (x - y)) == 0) {
                    int step = 1;
                    while ((x + y) > 0) {
                        if ((x & step) > 0) {
                            result.append(isXNegative ? "W" : "E");
                            x -= (x & (-x));
                        } else {
                            if (((y - 1) & y) != 0) {
                                result.append(isYNegative ? "N" : "S");
                                y -= (y & (-y));
                            } else {
                                y -= (y & (-y));
                            }
                        }
                        step <<= 1;
                    }
                    result.append(isYNegative ? "S" : "N");
                }
            } else if (((-x - y + 1) & (-x - y)) == 0) {
                int step = 1;
                while ((x + y) > 0) {
                    if ((x & step) > 0) {
                        if (((x - 1) & y) != 0) {
                            result.append(isXNegative ? "E" : "W");
                            x -= (x & (-x));
                        } else {
                            x -= (x & (-x));
                        }
                    } else {
                        if (((y - 1) & y) != 0) {
                            result.append(isYNegative ? "N" : "S");
                            y -= (y & (-y));
                        } else {
                            y -= (y & (-y));
                        }
                    }
                    step <<= 1;
                }
                if (x > y) {
                    result.append(isYNegative ? "S" : "N");
                    result.append(isXNegative ? "W" : "E");
                } else {
                    result.append(isXNegative ? "W" : "E");
                    result.append(isYNegative ? "S" : "N");
                }
            } else {
                result.append("IMPOSSIBLE");
            }

            result.append("\n");
        }
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }
}