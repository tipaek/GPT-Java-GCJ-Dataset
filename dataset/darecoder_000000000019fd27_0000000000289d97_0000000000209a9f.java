import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int testCase = 1;
        while (t-- > 0){
            String str = s.next();
            String res = balanceParanthesis(str);
            System.out.println("Case #" + testCase++ + ": " + res);
        }
    }

    public static String balanceParanthesis(String str) {
        int braceCnt = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)-'0' == 0) {
                for(int j = 0; j < braceCnt; j++){
                    res.append(')');
                }
                braceCnt=0;
                res.append('0');
            } else if (i == 0) {
                for (int j = 0; j < str.charAt(i) - '0'; j++) {
                    res.append('(');
                }
                res.append(str.charAt(i));
                braceCnt+=str.charAt(i)-'0';
            } else {
                int diff=braceCnt-(str.charAt(i)-'0');
                if(diff>0){
                    for(int j = 0; j < diff; j++){
                        res.append(')');
                    }
                    braceCnt-=diff;
                    res.append(str.charAt(i));
                }else{
                    int add =(str.charAt(i)-'0')-braceCnt;
                    for(int j = 0; j < add; j++){
                        res.append('(');
                    }
                    res.append(str.charAt(i));
                    braceCnt += add;
                }
            }
        }
        res.append(")".repeat(Math.max(0, braceCnt)));
        
        return res.toString();
    }
}
