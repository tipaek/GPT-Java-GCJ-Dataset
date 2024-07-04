import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        // sc.next();
        int case_no = 1;
        while(case_no<=t) {
            int curr_nest = 0;
            String ans = "";
            String num = sc.next();
            for(int i = 0; i<num.length(); i++)
            {
                int d = num.charAt(i) - '0';
                while(curr_nest<d) {
                    curr_nest++;
                    ans = ans+"(";
                }
                while(curr_nest>d) {
                    curr_nest--;
                    ans = ans+")";
                }
                ans = ans + num.charAt(i);
            }
            while(curr_nest>0) {
                curr_nest--;
                ans = ans+")";
            }
            System.out.println("Case #"+(case_no++)+": "+ans);
        }
        
    }
}