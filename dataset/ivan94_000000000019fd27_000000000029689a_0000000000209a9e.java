import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void solve(int B, Scanner in) {
        int[] base = new int[B];
        Arrays.fill(base, -1);
        int basePointer = 0;

        boolean discovery = true;
        int queriesToFluct = 10;
        for (int q = 0; q < 75; q++) {
            if (discovery) {
                System.out.println(basePointer + 1);
                System.out.flush();
                base[basePointer] = in.nextInt();
                System.out.println(B - basePointer);
                System.out.flush();
                base[B - basePointer - 1] = in.nextInt();
                queriesToFluct -= 2;
                basePointer++;
                if (basePointer >= B / 2) {
                    StringBuilder result = new StringBuilder();
                    for (int bit : base) {
                        result.append(bit);
                    }
                    System.out.println(result.toString());
                    System.out.flush();
                    in.next();
                    return;
                }
                if (queriesToFluct == 0) {
                    queriesToFluct = 10;
                    discovery = false;
                }
            } else {
                int equalIndex = 0;
                int differentIndex = 0;
                for (int i = 0; i < basePointer; i++) {
                    if (base[i] == base[B - i - 1]) {
                        equalIndex = i;
                    }
                    if (base[i] != base[B - i - 1]) {
                        differentIndex = i;
                    }
                }
                System.out.println(equalIndex + 1);
                System.out.flush();
                int value1 = in.nextInt();
                System.out.println(differentIndex + 1);
                System.out.flush();
                int value2 = in.nextInt();
                boolean swapEqual = value1 != base[equalIndex];
                boolean swapDifferent = value2 != base[differentIndex];
                for (int i = 0; i < basePointer; i++) {
                    if (base[i] == base[B - i - 1] && swapEqual) {
                        base[i] = (base[i] + 1) % 2;
                        base[B - i - 1] = (base[B - i - 1] + 1) % 2;
                    }
                    if (base[i] != base[B - i - 1] && swapDifferent) {
                        base[i] = (base[i] + 1) % 2;
                        base[B - i - 1] = (base[B - i - 1] + 1) % 2;
                    }
                }
                queriesToFluct -= 2;
                discovery = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int B = in.nextInt();
        for (int t = 0; t < T; t++) {
            solve(B, in);
        }
        in.close();
    }
}