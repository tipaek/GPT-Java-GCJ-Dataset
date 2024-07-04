import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static String openingParentheses[] = {"(","((","(((","((((","(((((","((((((","(((((((","((((((((","((((((((("};
    private static String closingParentheses[] = {")","))",")))","))))",")))))","))))))",")))))))","))))))))",")))))))))"};

    private static String includeParentheses(String str){
        String resultingStr = "";
        int depth = 0;
        String[]  strArrr = str.split("");
        for (String c: strArrr) {
            int n = Integer.parseInt(c);
            // first char of string
            if(depth < n){
                resultingStr += openingParentheses[(n - depth) - 1];
            } else if(depth > n){
                resultingStr += closingParentheses[(-n + depth) - 1];
            }
            depth = n;
            resultingStr += c;
        }

        if(depth > 0)
            resultingStr += closingParentheses[depth - 1];
        return resultingStr;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for(int i=1;i<=t;i++){
            String str = in.nextLine();
            System.out.printf("%s\n",includeParentheses(str));
        }
    }

}