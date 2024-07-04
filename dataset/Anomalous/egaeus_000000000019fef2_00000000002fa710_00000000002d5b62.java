import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();
        TreeSet<Long> powersOfTwo = new TreeSet<>();
        
        for (long i = 0, power = 1; i < 60; i++, power *= 2) {
            powersOfTwo.add(power);
        }
        
        for (int t = 1; t <= testCases; t++) {
            result.append("Case #").append(t).append(": ");
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            long X = Long.parseLong(tokenizer.nextToken());
            long Y = Long.parseLong(tokenizer.nextToken());
            long absX = Math.abs(X);
            long absY = Math.abs(Y);
            
            if (absX % 2 == absY % 2) {
                result.append("IMPOSSIBLE");
            } else {
                boolean foundSolution = false;
                if ((absX & absY) == 0 && powersOfTwo.contains((absX | absY) + 1)) {
                    foundSolution = true;
                    for (int i = 0; i < Long.bitCount(absX | absY); i++) {
                        if (((1L << i) & absX) != 0) {
                            result.append(X > 0 ? "E" : "W");
                        } else if (((1L << i) & absY) != 0) {
                            result.append(Y > 0 ? "N" : "S");
                        }
                    }
                } else if (absX % 2 == 1) {
                    absX += 2;
                    if ((absX & absY) == 0 && powersOfTwo.contains((absX | absY) + 1)) {
                        foundSolution = true;
                        result.append(X < 0 ? "E" : "W");
                        for (int i = 1; i < Long.bitCount(absX | absY); i++) {
                            if (((1L << i) & absX) != 0) {
                                result.append(X > 0 ? "E" : "W");
                            } else if (((1L << i) & absY) != 0) {
                                result.append(Y > 0 ? "N" : "S");
                            }
                        }
                    }
                } else {
                    absY += 2;
                    if ((absX & absY) == 0 && powersOfTwo.contains((absX | absY) + 1)) {
                        foundSolution = true;
                        result.append(Y < 0 ? "N" : "S");
                        for (int i = 1; i < Long.bitCount(absX | absY); i++) {
                            if (((1L << i) & absX) != 0) {
                                result.append(X > 0 ? "E" : "W");
                            } else if (((1L << i) & absY) != 0) {
                                result.append(Y > 0 ? "N" : "S");
                            }
                        }
                    }
                }
                if (!foundSolution) {
                    result.append("IMPOSSIBLE");
                }
            }
            result.append("\n");
        }
        System.out.print(result.toString());
    }
}