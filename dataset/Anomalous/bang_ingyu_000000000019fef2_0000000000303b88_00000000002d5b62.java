import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    
    private static int parseStringToInt(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();
        
        int testCases = parseStringToInt(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            output.append(String.format("Case #%d: ", i));
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int input1 = parseStringToInt(tokenizer.nextToken());
            int input2 = parseStringToInt(tokenizer.nextToken());
            
            boolean isXNegative = (input1 < 0);
            boolean isYNegative = (input2 < 0);
            
            int x = Math.abs(input1);
            int y = Math.abs(input2);

            if (((x + y + 1) & (x + y)) == 0) {
                int j = 1;
                while ((x + y) > 0) {
                    if ((x & j) > 0) {
                        output.append(isXNegative ? "W" : "E");
                        x -= (x & (-x));
                    } else {
                        output.append(isYNegative ? "S" : "N");
                        y -= (y & (-y));
                    }
                    j <<= 1;
                }
            } else if (x > y) {
                if (((-x + y + 1) & (-x + y)) == 0) {
                    int j = 1;
                    while ((x + y) > 0) {
                        if ((x & j) > 0) {
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
                        j <<= 1;
                    }
                    output.append(isXNegative ? "W" : "E");
                }
            } else if (x < y) {
                if (((x - y + 1) & (x - y)) == 0) {
                    int j = 1;
                    while ((x + y) > 0) {
                        if ((x & j) > 0) {
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
                        j <<= 1;
                    }
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