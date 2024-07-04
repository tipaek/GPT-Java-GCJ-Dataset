import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; ++t) {
            sb.append("Case #" + t + ": ");
            char[] chars = new char[10];
            for(int i = 0; i < 10; ++i) chars[i] = '0';
            int u = in.nextInt();
            in.nextLine();
            Set<Character> myset = new HashSet<>();
            for(int k = 1; k <= 10000; ++k) {
                String[] input = in.nextLine().split(" ");
                long m = Long.valueOf(input[0]);
                String response = input[1];
                for (int i = 0; i < response.length(); ++i) {
                    char ch = response.charAt(i);
                    if(myset.contains(ch)) continue;
                    for (int j = (i == 0 ? 1 : 0); j <= 9; ++j) {
                        if (chars[j] == '0') {
                            chars[j] = ch;
                            myset.add(ch);
                            break;
                        }
                    }
                }
                //            long value = 0;
                //            for(int i = 0; i < response.length(); ++i) {
                //                for(int j = 0; j <= 9; ++j) {
                //                    if(chars[j] == response.charAt(i)) {
                //                        value += (chars[j] - '0') * Math.pow(10, response.length() - 1 - i);
                //                    }
                //                }
                //            }
            }
            StringBuilder output = new StringBuilder();
            for(int i = 0; i <= 9; ++i) output.append(chars[i]);
            sb.append(output + "\n");
        }
        System.out.print(sb.toString());
    }
}
