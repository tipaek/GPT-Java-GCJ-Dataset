import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();
        for (int x = 1; x <= t; x++) {
            String n = scan.nextLine();
            int cb = 0;
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n.length(); i++) {
                String tmp = "";
                char a = n.charAt(i);
                tmp = tmp + a;
                int cn = Integer.parseInt(tmp);
                int req = cb - cn;
                if (req < 0) {
                    for (int j = req; j < 0; j++)
                        ans.append("(");
                    ans.append(cn);
                } else if (req > 0) {
                    for (int j = 1; j <= req; j++)
                        ans.append(")");
                    ans.append(cn);
                } else
                    ans.append(cn);
                cb = cn;
            }
            if (cb > 0)
                for (int i = cb; i > 0; i--)
                    ans.append(")");
            System.out.println("Case #" + x + ": " + ans.toString());
        }
    }
}