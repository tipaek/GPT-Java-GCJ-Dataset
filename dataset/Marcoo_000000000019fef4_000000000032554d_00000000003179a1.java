import java.util.*;

public class Solution {
    Scanner scanner = new Scanner(System.in);

    private void exe() {
        int test = scanner.nextInt();
        for (int z = 0; z < test; z++) {
            int u = scanner.nextInt();
            scanner.nextLine();
            Recordd[] enc = new Recordd[10000];
            int[] high = new int[26];
            for (int i = 0; i < high.length; i++) {
                high[i] = Integer.MAX_VALUE;
            }
            for (int i = 0; i < 10000; i++) {
                String s = scanner.nextLine();
                String[] input = s.split(" ");
                //enc[i] = new Recordd(Integer.parseInt(input[0]), input[1]);

                if (input[1].length() < input[0].length()) {
                    continue;
                }
                char letter = input[1].charAt(0);
                int maxValue = Character.getNumericValue(input[0].charAt(0));
                if (high[letter - 65] > maxValue || high[letter - 65] == 0) {
                    high[letter - 65] = maxValue;
                }

                for (int j = 0; j < input[1].length(); j++) {
                    char letterp = input[1].charAt(j);
                    if (high[letterp - 65] == Integer.MAX_VALUE) {
                        high[letterp - 65] = 0;
                    }
                }
            }
            int a = z + 1;
            System.out.print("Case #" + a + ": ");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 26; j++) {
                    if (high[j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (high[j] == i) {
                        System.out.print((char) (j + 65));
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution iss = new Solution();
        iss.exe();
    }
}

class Recordd {
    int input;
    String output;

    public Recordd (int input, String output) {
        this.input = input;
        this.output = output;
    }
}
