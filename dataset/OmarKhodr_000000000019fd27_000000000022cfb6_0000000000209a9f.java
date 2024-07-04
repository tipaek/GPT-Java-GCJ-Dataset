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

            char last = s.charAt(0);

            int i = 0;
            while (i<len) {
                while (i<len && s.charAt(i)>=last) {
                    nums.append(s.charAt(i));
                    last = s.charAt(i);
                    i++;
                }
                int max = last-'0';
                while (i<len && s.charAt(i)<=last) {
                    nums.append(s.charAt(i));
                    last = s.charAt(i);
                    i++;
                }
                int nlen = nums.length();
                int j = 0;
                while (j<nlen && nums.charAt(j) == '0') {
                    curr.append('0');
                    j++;
                }
                for (int k=1; k<=max; k++) {
                    curr.append('(');
                    while (j<nlen && nums.charAt(j)-'0' == k) {
                        curr.append(k);
                        j++;
                    }
                }
                for (int k=max; k>=1; k--) {
                    while (j<nlen && nums.charAt(j)-'0' == k) {
                        curr.append(k);
                        j++;
                    }
                    curr.append(')');
                }
                while (j<nlen && nums.charAt(j) == '0') {
                    curr.append('0');
                    j++;
                }
                res.append(curr);
                curr = new StringBuilder();
                nums = new StringBuilder();
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
