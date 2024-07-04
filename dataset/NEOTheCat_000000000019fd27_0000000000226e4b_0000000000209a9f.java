import java.util.Scanner;

public class Solution {
    private static String PATTEN = "Case #%d: %s";

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int p =1;p<=t;p++){
            String s = sc.nextLine();
            int now =0;
            StringBuilder ans = new StringBuilder();
            for (int i=0;i<s.length();i++){
                int value = s.charAt(i)-'0';
                if (now>value){
                    for (int j =value;j<now;j++){
                        ans.append(')');
                    }
                } else if (now<value){
                    for (int j =now;j<value;j++){
                        ans.append('(');
                    }
                }
                now = value;
                ans.append(s.charAt(i));
            }

            for (int i=0;i<now;i++){
                ans.append(')');
            }
            System.out.println(String.format(PATTEN, p, ans.toString()));
        }
    }
}
