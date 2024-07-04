import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();

        String []results = new String[cases];
        for (int i = 1; i <= cases; i++) {
            String s = in.next();
            results[i-1] = "Case #"+i+": "+ getRes(s);
        }
        in.close();
        for(String r: results) {
            System.out.println(r);
        }
    }

    public static String getRes(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                stringBuilder.append('(');
                while(i < s.length() && s.charAt(i)=='1') {
                    stringBuilder.append(s.charAt(i));
                    i++;
                }
                stringBuilder.append(')');
                i--;
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
