import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        
        for (int n = 1; n <= cases; n++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            if (x == 0 && y == 0) {
                System.out.println("Case #" + n + ": ");
                continue;
            }
            
            char xDir = x < 0 ? 'W' : 'E';
            char yDir = y < 0 ? 'S' : 'N';
            int bigger = Math.max(Math.abs(x), Math.abs(y));
            int lower = Math.min(Math.abs(x), Math.abs(y));
            char lowerDir = lower == Math.abs(x) ? xDir : yDir;
            char biggerDir = lowerDir == xDir ? yDir : xDir;
            char changedDir = getOppositeDirection(biggerDir);
            
            boolean changed = false;
            boolean possible = true;
            int changePoint = -1;
            String binaryLower = Integer.toBinaryString(lower);
            int acc = calculateAcc(binaryLower);
            int pow = binaryLower.length();
            
            while (acc < bigger) {
                int add = (int) Math.pow(2, pow);
                if (add + acc > bigger) {
                    if (changed) {
                        possible = false;
                        break;
                    }
                    acc = Math.abs(acc - add);
                    changed = true;
                    changePoint = pow;
                    if (acc > bigger) possible = false;
                } else {
                    acc += add;
                }
                pow++;
            }
            
            String result = possible ? buildResult(binaryLower, pow, changed, changePoint, lowerDir, biggerDir, changedDir) : "IMPOSSIBLE";
            System.out.println("CASE #" + n + ": " + result);
        }
    }
    
    private static char getOppositeDirection(char direction) {
        switch (direction) {
            case 'N': return 'S';
            case 'S': return 'N';
            case 'E': return 'W';
            case 'W': return 'E';
            default: return ' ';
        }
    }
    
    private static int calculateAcc(String binaryLower) {
        int acc = 0;
        for (int i = binaryLower.length() - 1; i >= 0; i--) {
            if (binaryLower.charAt(i) == '1') continue;
            acc += (int) Math.pow(2, (binaryLower.length() - 1) - i);
        }
        return acc;
    }
    
    private static String buildResult(String binaryLower, int pow, boolean changed, int changePoint, char lowerDir, char biggerDir, char changedDir) {
        StringBuilder builder = new StringBuilder(pow);
        String reversedBinary = new StringBuilder(binaryLower).reverse().toString();
        
        for (int i = 0; i < pow; i++) {
            if (i >= reversedBinary.length()) {
                builder.append(changed && i < changePoint ? changedDir : biggerDir);
            } else {
                if (reversedBinary.charAt(i) == '1') {
                    builder.append(lowerDir);
                } else {
                    builder.append(changed && i < changePoint ? changedDir : biggerDir);
                }
            }
        }
        
        return builder.toString();
    }
}