import java.util.*;

class Solution{

    static Scanner in = new Scanner(System.in);
    public static void main(String args[]){
        int nCases = Integer.parseInt(in.nextLine());
        for(int i=1;i<=nCases;i++) solve(i);
    }

    static void solve(int nCase){
        StringBuilder ans = new StringBuilder();
        String s = in.nextLine();
        int level = 0, value;
        for(char c:s.toCharArray()){
            value = c-'0';
            while(level<value){
                ans.append('(');
                level++;
            }
            while(level>value){
                ans.append(')');
                level--;
            }
            ans.append(c);
        }
        while(level-->0){
            ans.append(')');
        }

        System.out.printf("Case #%d: %s\n", nCase, ans.toString());
    }
}