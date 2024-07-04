
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int bits = sc.nextInt();
        for (int c=0;c<cases;c++) {
            char[] res = new char[bits];
            for (int bit=1;bit<=bits;bit++) {
                System.out.println(bit);
                System.out.flush();
                res[bit-1] = sc.next().charAt(0);
            }
            String r = new String(res);
            System.out.println(r);
        }

    }
}
