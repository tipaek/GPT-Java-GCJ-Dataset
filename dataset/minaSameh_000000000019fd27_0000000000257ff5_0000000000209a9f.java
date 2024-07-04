import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        s.nextLine();
        for(int i=1;i<=T;i++) {
            String line = s.nextLine();
            String out = "";
            int level = 0;
            for(int j=0;j<line.length();j++) {
                int num = line.charAt(j) - '0';

                if (num == level) {
                    out += num;
                } else if (num < level) {
                    level--;
                    out += ")";
                    j--;
                } else {
                    level++;
                    out += "(";
                    j--;
                }
            }
            while(level > 0) {
                out += ")";
                level--;
            }
            System.out.printf("Case #%d: %s\n", i, out);
        }
    }
}
