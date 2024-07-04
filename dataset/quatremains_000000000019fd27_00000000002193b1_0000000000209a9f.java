import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            String input = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            String result = "";
            input = "0"+input+"0";
            for (int j = 0; j < input.length()-1; j++) {
                int gap = input.charAt(j+1) - input.charAt(j);
                sb.append(input.charAt(j));
                if (gap > 0) {
                    while (gap!=0) {
                        sb.append("(");
                        gap--;
                    }
                }
                else if (gap < 0) {
                    while (gap!=0) {
                        sb.append(")");
                        gap++;
                    }
                }
                else {
                }
            }
            result = sb.toString().substring(1);
            System.out.println("Case #"+(T+1)+": "+result);
        }
    }
}
