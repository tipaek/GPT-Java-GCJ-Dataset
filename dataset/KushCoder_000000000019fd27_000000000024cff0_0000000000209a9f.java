import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            String ss = scan.next();
            char ch[] = ss.toCharArray();
            System.out.print("Case #" + (i + 1) + ": ");
            int flag = 0;

            for (int j = 0; j < ch.length; j++) {
                flag = flag - Integer.parseInt(ch[j] + "");

                if (flag < 0) {
                    flag = -flag;
                    for (int j1 = 0; j1 < flag; j1++) {
                        System.out.print("(");
                    }
                } else if (flag > 0) {
                    for (int j1 = 0; j1 < flag; j1++) {
                        System.out.print(")");
                    }
                }
                System.out.print(ch[j]);
                flag = Integer.parseInt(ch[j] + "");

            }
            flag = Integer.parseInt(ch[ch.length - 1] + "");
            for (int j1 = 0; j1 < flag; j1++) {
                System.out.print(")");
            }
            System.out.println();
        }
    }
}
