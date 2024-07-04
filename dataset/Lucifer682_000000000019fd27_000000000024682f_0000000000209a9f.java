import java.util.Scanner;

public class Solution {

    public static String computeParenthesis(String s){
        int n = s.length();
        String res = "";
        for(int i=0;i<n;i++){
            int num = s.charAt(i) - '0';
            if(num==0){
                res += "0";
            }else if(i>=1){
                if(res.charAt(res.length()-1)=='0'){
                    res += "(1)";
                }else{
                    int cnt = 0;
                    while(cnt+1 < res.length() && (res.charAt(cnt)!=')' || res.charAt(cnt+1)=='0')){cnt++;}
                    res = res.substring(0,cnt) + "1" + res.substring(cnt);
                }
            }else{
                res += "(1)";
            }
            //System.out.println(res);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int cnt = 1;
        while(cnt <= t){
            String s = sc.next();
            System.out.println("Case #"+cnt+ ": " + computeParenthesis(s));
            cnt++;
        }
    }
}
