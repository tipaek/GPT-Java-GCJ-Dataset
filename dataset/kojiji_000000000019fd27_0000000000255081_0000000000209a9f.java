
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            final String input = in.next();
            int current_number = 0;
            System.out.print("Case #"+i+": ");
            for (char c : input.toCharArray()) {
                int count = c - '0';
                if(current_number > count){
                    for (int j = 0; j < current_number - count; j++) {
                        System.out.print(")");
                    }
                } else if (current_number < count) {
                    for (int j = 0; j < count - current_number; j++) {
                        System.out.print("(");
                    }
                }
                current_number = count;
                System.out.print(c);
            }
            if (current_number > 0) {
                for (int j = 0; j < current_number; j++) {
                    System.out.print(")");
                }
            }
            System.out.println();
        }
    }
}
