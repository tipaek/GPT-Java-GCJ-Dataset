import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            String str = sc.next();
            String ans = "";
            int depth = 0;
            for(int i=0;i<str.length();i++){
                int digit = str.charAt(i)-'0';
                if(digit>depth){
                    ans = ans + addBracket(digit-depth,"(")+digit;
                    depth = digit;
                }
                else if(digit<depth){
                    ans = ans + addBracket(depth-digit,")")+digit;
                    depth = digit;
                }
                else{
                    ans = ans + digit;
                }
            }
            ans = ans+addBracket(depth, ")");
            System.out.println("Case #"+t+": "+ans);
        }
    }
        public static String addBracket(int no, String br){
            String res = "";
            for(int i=0;i<no;i++){
                res = res+br;
            }
            return res;
        }
    
}