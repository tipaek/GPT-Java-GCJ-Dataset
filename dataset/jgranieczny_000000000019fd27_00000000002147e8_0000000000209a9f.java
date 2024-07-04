import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();//test cases
        for (int i = 0; i < T; i++) {
            String s = scanner.next();//string
            System.out.print("Case #"+(i+1)+": ");
            System.out.println(transform(s));
        }
    }

    private static String transform(String s) {
        s+="0";
        String result = "";
        for(int i=0;i<s.length();i++) {
            int val = Integer.parseInt(String.valueOf(s.charAt(i)));
            if(i==0) {
                for (int j = 0; j < val; j++) {
                    result += "(";
                }
            } else{
                int diff =val- Integer.parseInt(String.valueOf(s.charAt(i-1)));
                if(diff>0){
                    for (int j = 0; j < diff; j++) {
                        result += "(";
                    }
                } else{
                    for (int j = 0; j < -diff; j++) {
                        result += ")";
                    }
                }
            }
            result+=s.charAt(i);

        }
        return result.substring(0,result.length()-1);
    }

   
}