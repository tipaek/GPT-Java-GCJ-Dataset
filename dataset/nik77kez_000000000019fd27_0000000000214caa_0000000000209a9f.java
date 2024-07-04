import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testNum = scanner.nextInt();
        String input;
        StringBuilder res;
        int opened;
        int currentDigit;
        for (int i = 1; i <= testNum; i++) {
            opened = 0;
            input = scanner.next();
            res = new StringBuilder("");
            for (int reader = 0; reader < input.length(); reader++) {
                currentDigit = Integer.parseInt(String.valueOf(input.charAt(reader)));
                if (opened > currentDigit) {
                    while (opened != currentDigit) {
                        res.append(")");
                        opened--;
                    }
                } else if (opened < currentDigit) {
                    while (opened != currentDigit) {
                        res.append("(");
                        opened++;
                    }
                }
                res.append(currentDigit);
            }
            while (opened != 0) {
                res.append(")");
                opened--;
            }
            System.out.println(res);
        }
    }
}
