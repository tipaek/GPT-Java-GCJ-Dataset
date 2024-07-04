import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for (int casen = 1; casen <= T; casen++) {
            int x = in.nextInt();
            int y = in.nextInt();
            boolean reverseX = x < 0;
            boolean reverseY = y < 0;
            x = Math.abs(x);
            y = Math.abs(y);
            boolean possible = true;
            StringBuilder ans = new StringBuilder(32);

            for (int pos = 1; pos <= 32; pos++) {
                int mask = (1 << (pos - 1));
                if (mask > x && mask > y) break;

                if ((x & mask) == (y & mask)) {
                    possible = false;
                    System.out.println("Case #" + casen + ": IMPOSSIBLE");
                    break;
                } else {
                    if ((x & mask) != 0) {
                        if (((x & (1 << pos)) != (y & (1 << pos))) || (mask << 1 > x && mask << 1 > y)) {
                            ans.append(reverseX ? 'W' : 'E');
                        } else {
                            ans.append(reverseX ? 'E' : 'W');
                            while (++pos <= 32 && (x & (1 << (pos - 1))) != 0 && (y & (1 << (pos - 1))) != 0) {
                                ans.append(reverseY ? 'S' : 'N');
                            }
                            if (pos > 32 || (x & (1 << (pos - 1))) != 0 || (y & (1 << (pos - 1))) != 0) {
                                possible = false;
                                System.out.println("Case #" + casen + ": IMPOSSIBLE");
                                break;
                            } else {
                                ans.append(reverseX ? 'W' : 'E');
                            }
                        }
                    } else {
                        if (((x & (1 << pos)) != (y & (1 << pos))) || (mask << 1 > x && mask << 1 > y)) {
                            ans.append(reverseY ? 'S' : 'N');
                        } else {
                            ans.append(reverseY ? 'N' : 'S');
                            while (++pos <= 32 && (x & (1 << (pos - 1))) != 0 && (y & (1 << (pos - 1))) != 0) {
                                ans.append(reverseX ? 'W' : 'E');
                            }
                            if (pos > 32 || (x & (1 << (pos - 1))) != 0 || (y & (1 << (pos - 1))) != 0) {
                                possible = false;
                                System.out.println("Case #" + casen + ": IMPOSSIBLE");
                                break;
                            } else {
                                ans.append(reverseY ? 'S' : 'N');
                            }
                        }
                    }
                }
            }
            if (possible) {
                System.out.println("Case #" + casen + ": " + ans.toString());
            }
        }
    }
}