import java.util.Scanner;

public class Solution{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            String exp = in.next();
            int level = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < exp.length(); j++) {
                int number = exp.charAt(j) - '0';
                while(number > level){
                    sb.append('(');
                    level++;
                }
                while(number < level){
                    sb.append(')');
                    level--;
                }
                sb.append(exp.charAt(j));
            }

            while(level > 0){
                sb.append(')');
                level--;
            }

            System.out.printf("Case #%d: %s", i, sb.toString());
            System.out.println();

        }

    }
}
