import java.util.Scanner;

class NestDepth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int t = 1; t <= T; t++) {
            String digits = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            int curBalance = 0;
            for (int i = 0; i < digits.length(); i++) {
                int d = digits.charAt(i) - '0';
                if (curBalance < d) {
                    int dif = d - curBalance;
                    for (int j = 0; j < dif; j++) {
                        sb.append('(');
                        curBalance ++;
                    }
                } else if (curBalance > d) {
                    int dif = curBalance - d;
                    for (int j = 0; j < dif; j++) {
                        sb.append(')');
                        curBalance --;
                    }
                }
                sb.append(digits.charAt(i));
            }
            while (curBalance > 0) {
                sb.append(')');
                curBalance --;
            }

            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}
