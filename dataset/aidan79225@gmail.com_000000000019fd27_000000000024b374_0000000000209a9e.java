import java.util.Scanner;

public class Solution {
    private static String output1 = "Case #%d: %s";
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            int b = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().getAnswer(caseNum, b, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int sameBit = -1;
    int diffBit = -1;
    public void getAnswer(int caseNum, int length, Scanner scanner) {
        boolean[] state = new boolean[length];
        int curBit = 0;
        int target = length/2;
        while(curBit < target) {
            int count = 10;
            boolean shouldComplement = false;
            boolean shouldReverse = false;
            if (hasSameBit()) {
                System.out.println(sameBit);
                System.out.flush();
                int x = scanner.nextInt();
                shouldComplement = x > 0 != state[sameBit];
                --count;
            }

            if (hasDifferentBit()) {
                System.out.println(diffBit);
                System.out.flush();
                int x = scanner.nextInt();
                shouldReverse = x > 0 != state[diffBit];
                --count;
            }
            
            if (shouldComplement) {
                for (int i = 0; i < length; ++i) {
                    state[i] = !state[i]; 
                }
            }
            
            if (shouldReverse) {
                int mid = length / 2;
                for (int i = 0; i < mid; ++i) {
                    boolean temp = state[i];
                    state[i] = state[length-i-1];
                    state[length-i-1] = temp;
                }
            }

            while (count > 1) {
                System.out.println(curBit);
                System.out.flush();
                int x = scanner.nextInt();
                state[curBit] = x > 0;

                System.out.println(length-curBit-1);
                System.out.flush();
                int y = scanner.nextInt();
                state[length-curBit-1] = y > 0;

                if (!hasSameBit() && x == y) {
                    sameBit = curBit;
                }

                if (!hasDifferentBit() && x != y) {
                    diffBit = curBit;
                }
                ++curBit;
                count -= 2;
            }
            if (count > 0) {
                System.out.println(length-curBit-1);
                System.out.flush();
                int x = scanner.nextInt();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (boolean cur: state) {
            sb.append(cur ? '1' : '0');
        }
        System.out.println(sb.toString());
        System.out.flush();
    }

    public boolean hasSameBit() {
        return sameBit > -1;
    }

    public boolean hasDifferentBit() {
        return diffBit > -1;
    }



}
