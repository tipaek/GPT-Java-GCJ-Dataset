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
                int c = 0;
                try {
                     c = Integer.parseInt(""+input.charAt(j));
                }catch (Exception e){
                    c=0;
                }
                try {
                    output = parentheses(output,c+"",c-cnt);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                cnt = c;
            }
            try {
                System.out.println("Case #" + i + ": " + output);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        scanner.close();


    }

    private static String parentheses(String string, String c, int cnt) throws Exception{
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
