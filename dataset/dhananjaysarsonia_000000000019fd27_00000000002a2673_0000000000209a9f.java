
import java.util.*;
public class Solution {
    private static Scanner scanner;
    private static int cases=1;

    public static void main(String args[]) {
        scanner = new Scanner(System.in);
        int testcase = scanner.nextInt();
        scanner.nextLine();

        while (testcase > 0) {
            testcase--;
            String string = scanner.nextLine();
            char[] ch = string.toCharArray();
            StringBuilder builder = new StringBuilder();
            int temp = 0;
            int balance = 0;

            int start = Character.getNumericValue(ch[0]);
            temp = start;
            balance = start;

            for (int i = 0; i < start; i++) {
                builder.append('(');
            }
            builder.append(start);

            for (int i = 1; i < ch.length; i++) {
                int inner = Character.getNumericValue(ch[i]);

                if (inner == temp) {
                    builder.append(inner);
                } else if (inner > temp) {
                    int dif = inner - temp;
                    for (int j = 0; j < dif; j++) {
                        builder.append('(');
                        balance++;
                    }

                    builder.append(inner);
                } else {
                    int differ = temp - inner;
                    for (int j = 0; j < differ; j++) {
                        builder.append(')');
                        balance--;
                    }
                    builder.append(inner);
                }
                temp = Character.getNumericValue(ch[i]);
            }

            while(balance-->0){
                builder.append(')');
            }


            System.out.println("Case #" + (cases++)+": "+builder.toString());

        }
    }
}
