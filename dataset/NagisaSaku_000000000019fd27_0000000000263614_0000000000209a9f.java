import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner scanner;
    static  int tolLine = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        scanner.nextLine();
        while (line-- > 0){
            GetSolve();
        }

    }

    private static void GetSolve() {
        String s = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int num = 0;
        int brackets = 0;
        int first = Character.getNumericValue(chars[0]);
        num = first;
        brackets = first;
        for (int i = 0; i < first ; i++) {
            sb.append('(');
        }
        sb.append(first);

        for (int i = 1; i < chars.length ; i++) {
            int n = Character.getNumericValue(chars[i]);
            if (n == num){
                sb.append(n);
            } else if (n > num) {
                int diff = n - num;
                for (int j = 0; j < diff; j++) {
                    sb.append('(');
                    brackets++;
                }
                sb.append(n);
            }else {
                int diff = num - n;
                for (int j = 0; j < diff; j++) {
                    sb.append(')');
                    brackets--;
                }
                sb.append(n);
            }
            num = Character.getNumericValue(chars[i]);

        }
        while (brackets-- > 0){
            sb.append(')');
        }
        System.out.println("Case #" + (tolLine++) + ": " + sb.toString());
    }
}
