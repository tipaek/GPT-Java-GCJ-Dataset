import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int tests = 0;
        while(total-- > 0) {
            tests++;
            String line = scanner.next();
            StringBuilder stringBuilder = new StringBuilder();
            int currentPara = 0;

            for (int i = 0; i < line.length(); i++) {
                int num = Integer.parseInt(line.charAt(i) + "");

                if(num > currentPara) {
                    while(num > currentPara) {
                        stringBuilder.append('(');
                        currentPara++;
                    }
                } else if (num < currentPara) {
                    while(num < currentPara) {
                        stringBuilder.append(')');
                        currentPara--;
                    }
                }
                stringBuilder.append(num);
            }
            while (currentPara > 0) {
                stringBuilder.append(')');
                currentPara--;
            }

            System.out.println("Case #" + tests + ": " + stringBuilder.toString());

        }
    }
    private static int getMax(int idx, String str) {
        int maxSoFar = 0;

        for (int i = idx; i < str.length(); i++) {
            if (Integer.parseInt(str.charAt(i) + "") > maxSoFar) {
                maxSoFar = Integer.parseInt(str.charAt(i) + "");
            }
        }
        return maxSoFar;
    }
}
