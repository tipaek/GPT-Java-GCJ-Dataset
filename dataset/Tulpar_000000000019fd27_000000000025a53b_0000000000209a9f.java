import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            String s = in.next();
            String solution = solve(s);

            System.out.printf("Case #%d: %s\n", i,solution);
        }
    }

    private static String solve(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0; i<s.length();){
            if(s.charAt(i)=='1'){
                stringBuilder.append("(");
                while(i<s.length() && s.charAt(i)=='1'){
                    stringBuilder.append(s.charAt(i++));
                }
                stringBuilder.append(")");
            }else{
                stringBuilder.append(s.charAt(i++));
            }

        }
        return stringBuilder.toString();

    }
}
