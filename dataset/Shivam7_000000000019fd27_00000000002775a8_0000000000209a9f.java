import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        for(int t=1;t<=test;t++){
            String s = scanner.next();
            StringBuilder ans = new StringBuilder();
            int open = 0;
            for(int i=0;i<s.length();i++){
                int val = s.charAt(i)-'0';

                while(open < val){
                    ans.append("(");
                    open++;
                }
                while( open > val){
                    ans.append(")");
                    open--;
                }
                ans.append(s.charAt(i));
            }
            while(open > 0){
                ans.append(")");
                open--;
            }
            System.out.println(String.format("Case #%d: %s",t,ans));
        }
    }
}