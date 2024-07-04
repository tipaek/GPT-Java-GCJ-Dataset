import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; ++t) {
            String input = in.nextLine();
            int b = 0;
            StringBuilder output = new StringBuilder();
            for(int i = 0; i < input.length(); ++i) {
                int digit = input.charAt(i) - '0';
                int diff = digit - b;
                if(diff == 0) {
                    output.append((char)(digit + '0'));
                } else {
                    for(int d = 0; d < Math.abs(diff); ++d) {
                        output.append(diff < 0 ? ')' : '(');
                    }
                    output.append((char)(digit + '0'));
                }

                b += diff;
            }
            while(b != 0) {
                output.append(')');
                --b;
            }
            sb.append("Case #" + t + ": ");
            sb.append(output + "\n");
        }
        System.out.println(sb.toString());
    }
}
