import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        int count = 0;
        while (t-- > 0){
            count++;
            String s = sc.next();
            calculate(s, count);
        }
    }

    private static void calculate(String s, int count) {
        String temp = "";
        for (int i=0;i<s.length();i++){
            if (i == 0){
                if (s.charAt(i) == '1'){
                    temp += "(1";
                } else {
                    temp += "0";
                }
            } else {
                if (s.charAt(i) == '1' && s.charAt(i-1) == '1') {
                    temp += "1";
                    continue;
                }
                if (s.charAt(i) == '1' && s.charAt(i-1) == '0') {
                    temp += "(1";
                    continue;
                }
                if (s.charAt(i) == '0' && s.charAt(i-1) == '1') {
                    temp += ")0";
                    continue;
                }
                if (s.charAt(i) == '0' && s.charAt(i-1) == '0') {
                    temp += "0";
                    continue;
                }
            }
        }
        if (temp.charAt(temp.length()-1) == '1'){
            temp += ')';
        }
        System.out.println("Case #" + count + ": " + temp);
    }
}
