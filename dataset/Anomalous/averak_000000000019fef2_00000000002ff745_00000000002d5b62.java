import java.util.Scanner;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= testCases; i++) {
            String[] input = scanner.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            
            if (Math.abs(x + y) % 2 == 0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                boolean xEven = x % 2 == 0;
                int p = 0;
                int currentX = 0, currentY = 0;
                
                while (true) {
                    int step = (int) Math.pow(2, p);
                    
                    if (p == 0) {
                        if (!xEven) {
                            if (x == 3 && y == 0) {
                                result.append("EE");
                                break;
                            } else if (x == -3 && y == 0) {
                                result.append("WW");
                                break;
                            } else {
                                currentX = x % 2;
                                result.append(currentX == 1 ? "E" : "W");
                            }
                        } else {
                            if (y == 3 && x == 0) {
                                result.append("NN");
                                break;
                            } else if (y == -3 && x == 0) {
                                result.append("SS");
                                break;
                            } else {
                                currentY = y % 2;
                                result.append(currentY == 1 ? "N" : "S");
                            }
                        }
                    } else {
                        if (currentX != x) {
                            if (currentX + step == x) {
                                result.append("E");
                                currentX += step;
                            } else if (currentX - step == x) {
                                currentX -= step;
                                result.append("W");
                            }
                        } else if (currentY != y) {
                            if (currentY + step == y) {
                                currentY += step;
                                result.append("N");
                            } else if (currentY - step == y) {
                                currentY -= step;
                                result.append("S");
                            }
                        }
                    }
                    
                    if (currentX == x && currentY == y) {
                        break;
                    }
                    p++;
                }
                System.out.println("Case #" + i + ": " + result.toString());
            }
        }
        scanner.close();
    }
}