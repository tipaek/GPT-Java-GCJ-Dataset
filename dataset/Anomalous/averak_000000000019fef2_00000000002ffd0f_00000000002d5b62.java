import java.util.Scanner;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= t; i++) {
            String[] input = scanner.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            
            if (Math.abs(x + y) % 2 == 0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                boolean isXEven = x % 2 == 0;
                int p = 0;
                int xs = 0, ys = 0;
                StringBuilder result = new StringBuilder();
                
                while (true) {
                    int powerOfTwo = (int) Math.pow(2, p);
                    
                    if (p == 0) {
                        if (!isXEven) {
                            handleInitialNonEvenX(x, y, result);
                            if (result.length() > 0) break;
                            xs = x % 2;
                            result.append(xs == 1 ? "E" : "W");
                        } else {
                            handleInitialNonEvenY(x, y, result);
                            if (result.length() > 0) break;
                            ys = y % 2;
                            result.append(ys == 1 ? "N" : "S");
                        }
                    } else {
                        boolean moveMade = false;
                        moveMade = makeMove(x, y, powerOfTwo, result, xs, ys);
                        
                        if (!moveMade) {
                            if (x < 0) {
                                xs -= powerOfTwo;
                                result.append("W");
                            } else {
                                xs += powerOfTwo;
                                result.append("E");
                            }
                        }
                    }
                    
                    if (xs == x && ys == y) break;
                    p++;
                }
                
                System.out.println("Case #" + i + ": " + result.toString());
            }
        }
    }

    private static void handleInitialNonEvenX(int x, int y, StringBuilder result) {
        if (x == 3 && y == 0) {
            result.append("EE");
        } else if (x == -3 && y == 0) {
            result.append("WW");
        }
    }

    private static void handleInitialNonEvenY(int x, int y, StringBuilder result) {
        if (y == 3 && x == 0) {
            result.append("NN");
        } else if (y == -3 && x == 0) {
            result.append("SS");
        }
    }

    private static boolean makeMove(int x, int y, int powerOfTwo, StringBuilder result, int xs, int ys) {
        boolean moveMade = false;
        
        if (xs != x) {
            if (xs + powerOfTwo == x) {
                result.append("E");
                xs += powerOfTwo;
                moveMade = true;
            } else if (xs - powerOfTwo == x) {
                result.append("W");
                xs -= powerOfTwo;
                moveMade = true;
            }
        } else if (ys != y) {
            if (ys + powerOfTwo == y) {
                result.append("N");
                ys += powerOfTwo;
                moveMade = true;
            } else if (ys - powerOfTwo == y) {
                result.append("S");
                ys -= powerOfTwo;
                moveMade = true;
            }
        }
        
        return moveMade;
    }
}