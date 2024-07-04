
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            char[] str = s.toCharArray();
            int counter = 0;
            String out = "";
            int lastNum = -1;
            for (int j = 0; j < str.length; j++) {

                int num = str[j] - '0';
                while (num > counter) {

                    out += "(";
                    counter++;

                }
                if (num == counter) {
                    out += num;
                    continue;
                }
                while (num < counter) {

                    out += ")";
                    counter--;

                }
                if (num == counter) {
                    out += num;
                }
            }
            while (counter > 0) {
                out += ")";
                counter--;
            }
            System.out.println("Case #"+(i+1)+": "+out);
        }
    }

}
