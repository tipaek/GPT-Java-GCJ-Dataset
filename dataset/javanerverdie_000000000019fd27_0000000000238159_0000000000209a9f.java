import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try {
            InputStream is = System.in;
            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)));
            // int t = scanner.nextInt();
            // scanner.nextLine();
            int t = Integer.parseInt(scanner.nextLine());

            for (int i = 1; i <= t; ++i) {
                System.out.print("Case #");
                System.out.print(i);
                System.out.print(": ");
                solve(scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void solve(Scanner scanner) {
        char[] str = ("0" + scanner.nextLine() + "0").toCharArray();
//        Stack<Character> dst = new Stack<>();
        StringBuilder dst = new StringBuilder();
        for (int i = 1; i < str.length; i++) {
            char current = str[i];
            char prev = str[i - 1];
            int diff = current - prev;

            if (diff > 0) {
                for (int j = 0; j < diff; j++)
                    dst.append('(');
                dst.append(current);
            } else {
                for (int j = 0; j < diff * (-1); j++)
                    dst.append(')');
                dst.append(current);
            }
        }
        dst.deleteCharAt(dst.length()-1);
//        for (int i = 0; i < dst.size() - 1; i++)
//            System.out.print((char) dst.get(i));

        System.out.println(dst.toString());
    }
}
