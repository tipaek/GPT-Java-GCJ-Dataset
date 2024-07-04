import java.util.Scanner;
public class Solution {
    public static void main(String[] args){
        new Solution().runApp(args);
    }

    private void runApp(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = Integer.parseInt(in.nextLine());
        String[] output = new String[num];

        for(int i = 0; i < num; i++){
            String s = in.nextLine();
            String result = getOutput(s);
            output[i] = result;
        }

        for(int i = 0; i < output.length; i++){
            System.out.println("Case #" + (i+1) + ": " + output[i]);
        }
    }

    private String getOutput(String s){
        String result = "";
        for(int i = 0; i < s.length(); i++){
            int ch = Character.getNumericValue(s.charAt(i));
            int num = openNum(result);
            
            if(ch == 0){
                for (int j = 0; j < num; j++) {
                    result += ")";
                }
                result += "0";
                continue;
            }

            if(ch <= num){
                for(int k = 0; k < num - ch; k++)
                    result += ")";
                result += s.charAt(i);
            }else {
                for (int j = 0; j < ch - num; j++) {
                    result += "(";
                }
                result += s.charAt(i);
            }

            if(i == s.length()-1) {
                for (int j = 0; j < ch; j++) {
                    result += ")";
                }
            }
        }
        return result;
    }

    private int openNum(String r){
        int num = 0;
        if(r.length() == 0)
            return 0;

        for(int i = 0; i < r.length(); i++){
            if(r.charAt(i) == '(')
                num++;
            else if(r.charAt(i) == ')')
                num--;
        }
        return num;
    }
}
