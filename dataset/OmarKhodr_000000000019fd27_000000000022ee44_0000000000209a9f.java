import java.util.*;

class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int x=0; x<t; x++) {
            String s = in.nextLine();
            int len = s.length();

            StringBuilder res = new StringBuilder();
            StringBuilder curr = new StringBuilder();
            StringBuilder nums = new StringBuilder();

            char last = '0';

            int i = 0;
            while (i<len) {
                char c = s.charAt(i);
                int amount = c-last;
                if (amount>0) {
                    for (int j=0; j<amount; j++) {
                        res.append('(');
                    }
                    res.append(s.charAt(i));
                }
                else if (amount==0) {
                    res.append(s.charAt(i));
                }
                else {
                    amount = -amount;
                    for (int j=0; j<amount; j++) {
                        res.append(')');
                    }
                    res.append(s.charAt(i));
                }
                i++;
                last = c;
            }
            if (last != '0')  {
                last-='0';
                for (int j=0; j<last;j++) {
                    res.append(')');
                }
            }
            int cases =x+1;
            System.out.println("Case #"+ cases + ": " + res);
        }

    }
}

/*
4
0000
101
111000
1


* */
