import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            boolean reverseX = x < 0;
            boolean reverseY = y < 0;
            x = Math.abs(x);
            y = Math.abs(y);

            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int pos = 1; pos <= 32; pos++) {
                int powerOfTwo = (1 << (pos - 1));
                if (powerOfTwo > x && powerOfTwo > y) {
                    break;
                }

                if (((x & powerOfTwo) ^ (y & powerOfTwo)) == 0) {
                    possible = false;
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    break;
                } else {
                    if ((x & powerOfTwo) != 0) {
                        if ((x & (powerOfTwo << 1)) == 0 || (y & (powerOfTwo << 1)) == 0) {
                            result.append(reverseX ? 'W' : 'E');
                        } else {
                            result.append(reverseX ? 'E' : 'W');
                            while ((x & powerOfTwo) != 0 && (y & powerOfTwo) != 0) {
                                result.append(reverseY ? 'S' : 'N');
                                pos++;
                                powerOfTwo <<= 1;
                            }
                            if ((x & powerOfTwo) != 0 || (y & powerOfTwo) != 0) {
                                possible = false;
                                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                                break;
                            } else {
                                result.append(reverseX ? 'W' : 'E');
                            }
                        }
                    } else {
                        if ((y & (powerOfTwo << 1)) == 0 || (x & (powerOfTwo << 1)) == 0) {
                            result.append(reverseY ? 'S' : 'N');
                        } else {
                            result.append(reverseY ? 'N' : 'S');
                            while ((x & powerOfTwo) != 0 && (y & powerOfTwo) != 0) {
                                result.append(reverseX ? 'W' : 'E');
                                pos++;
                                powerOfTwo <<= 1;
                            }
                            if ((x & powerOfTwo) != 0 || (y & powerOfTwo) != 0) {
                                possible = false;
                                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                                break;
                            } else {
                                result.append(reverseY ? 'S' : 'N');
                            }
                        }
                    }
                }
            }

            if (possible) {
                System.out.println("Case #" + caseNumber + ": " + result.toString());
            }
        }
    }
}