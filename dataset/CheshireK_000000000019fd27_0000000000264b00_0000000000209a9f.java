import java.io.BufferedInputStream;
import java.util.Scanner;

class Solution {
    public static String convert(String number){
        int prefix = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<number.length(); i++){
            char c = number.charAt(i);
            int n = Integer.parseInt(String.valueOf(c));
            prefix =  prefix-n;
            if (prefix<0){
                for (int a=0; a<Math.abs(prefix); a++){
                    sb.append("(");
                }
            }else {
                for (int a=0; a<Math.abs(prefix); a++){
                    sb.append(")");
                }
            }
            sb.append(n);
            prefix = n;

        }
        for (int a=0; a<prefix; a++){
            sb.append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++){
            String numStr = in.next();
            String s = convert(numStr);
            System.out.println("Case #" + i + ": " + s);
        }
    }
}