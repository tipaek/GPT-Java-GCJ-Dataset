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

            char last = s.charAt(0);
            int count = 0;
            int i = 0;
            while (i<=len) {
                char c;
                if (i == len) {
                    c = '#';
                }
                else {
                    c = s.charAt(i);
                }
                if (c == last) {
                    count++;
                }
                else {
                    int num = last-'0';
                    for (int j=0; j<num; j++) {
                        curr.append('(');
                    }
                    for (int j=0; j<count; j++) {
                        curr.append(last);
                    }
                    for (int j=0; j<num; j++) {
                        curr.append(')');
                    }
                    res.append(curr);
                    curr = new StringBuilder();
                    last = c;
                    count = 0;
                    i--;
                }
                i++;
            }
            int k =x+1;
            System.out.println("Case #"+ k + ": " + res);
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
