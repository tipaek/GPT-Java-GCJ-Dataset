import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        for(int i=1; i<=t; i++){
            String input = scanner.nextLine();
            String output = "";
            int cnt = 0;
            for(int j = 0; j<input.length();j++){
                int c = Integer.parseInt(""+input.charAt(j));
                output = parentheses(output,c+"",c-cnt);
                cnt = c;
            }

                System.out.println("Case #" + i + ": " + output);
        }
        scanner.close();


    }

    private static String parentheses(String string, String c, int cnt){
        if(cnt<0){
            StringBuilder stringBuilder = new StringBuilder(string);
            for (int i = 0; i > cnt; i--) {
                stringBuilder.append(")");
            }
            string = stringBuilder.toString();
        }
        if(cnt>0) {
            StringBuilder stringBuilder = new StringBuilder(string);
            for (int i = 0; i < cnt; i++) {
                stringBuilder.append("(");
            }
            string = stringBuilder.toString();
        }
        string+=c;
        return string;
    }

}
