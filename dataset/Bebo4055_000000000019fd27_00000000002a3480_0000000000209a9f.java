import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in. nextInt();
        ArrayList<String> s = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            s.add(in.next());
        }

        for (int i = 0; i < n; i++) {
            String result = "";
            int num1 = s.get(i).charAt(0)-'0';
            int num2;
            for (int j = 0; j < num1; j++) {
                result += "(";
            }
            result += s.get(i).charAt(0);
            for (int j = 1; j < s.get(i).length(); j++) {
                num2 = s.get(i).charAt(j)-'0';
                if (num2 < num1) {
                    for (int k = 0; k < num1-num2; k++) {
                        result += ")";
                    }
                } else if (num2 > num1) {
                    for (int k = 0; k < num2-num1; k++) {
                        result += "(";
                    }
                }
                result += String.valueOf(num2);
                num1 = num2;
            }

            num2 = s.get(i).charAt(s.get(i).length()-1)-'0';
            for (int j = 0; j < num2; j++) {
                result += ")";
            }

            int index = i+1;
            System.out.println("Case #" + index + ": " + result);
        }

    }
}
