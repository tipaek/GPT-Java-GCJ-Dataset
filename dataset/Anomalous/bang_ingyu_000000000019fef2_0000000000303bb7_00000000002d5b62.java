import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();
        StringTokenizer tokenizer;

        int testCaseCount = parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            output.append(String.format("Case #%d:", testCase));
            tokenizer = new StringTokenizer(reader.readLine());
            int inputX = parseInt(tokenizer.nextToken());
            int inputY = parseInt(tokenizer.nextToken());
            boolean isNegativeX = (inputX < 0);
            boolean isNegativeY = (inputY < 0);

            int absX = Math.abs(inputX);
            int absY = Math.abs(inputY);

            if (((absX + absY + 1) & (absX + absY)) == 0) {
                int step = 1;
                while ((absX + absY) > 0) {
                    if ((absX & step) > 0) {
                        output.append(isNegativeX ? "W" : "E");
                        absX -= (absX & -absX);
                    } else {
                        output.append(isNegativeY ? "S" : "N");
                        absY -= (absY & -absY);
                    }
                    step <<= 1;
                }
            } else if (absX > absY) {
                if (((-absX + absY + 1) & (-absX + absY)) == 0) {
                    int step = 1;
                    while ((absX + absY) > 0) {
                        if ((absX & step) > 0) {
                            if (((absX - 1) & absX) != 0) {
                                output.append(isNegativeX ? "E" : "W");
                                absX -= (absX & -absX);
                            } else {
                                absX -= (absX & -absX);
                            }
                        } else {
                            output.append(isNegativeY ? "S" : "N");
                            absY -= (absY & -absY);
                        }
                        step <<= 1;
                    }
                    output.append(isNegativeX ? "W" : "E");
                }
            } else if (absX < absY) {
                if (((absX - absY + 1) & (absX - absY)) == 0) {
                    int step = 1;
                    while ((absX + absY) > 0) {
                        if ((absX & step) > 0) {
                            output.append(isNegativeX ? "W" : "E");
                            absX -= (absX & -absX);
                        } else {
                            if (((absY - 1) & absY) != 0) {
                                output.append(isNegativeY ? "N" : "S");
                                absY -= (absY & -absY);
                            } else {
                                absY -= (absY & -absY);
                            }
                        }
                        step <<= 1;
                    }
                    output.append(isNegativeY ? "S" : "N");
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