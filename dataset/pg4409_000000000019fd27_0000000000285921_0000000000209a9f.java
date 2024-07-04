import java.util.*;
class Solution {

    static String parenthesis(String s){
        String ans = "";
        int o= 0;
        int c = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            int digit = s.charAt(i)-'0';
            if(o==0){
               for(int j=1;j<=digit;j++){
                    ans+="(";
                }
                ans+=digit;
                o+=digit;

            }
       
            else if(o>digit){
                 int extra = o-digit;
                
                for(int j=1;j<=extra;j++){
                ans+=")";}
                o-=extra;
                ans+=digit;
            }
            else{
                int extra=digit-o;
                for(int j=1;j<=extra;j++){
                    ans+="(";
                }
                o+=extra;
                ans+=digit;
            }
        }
        for(int j=1;j<=o;j++){
            ans+=")";
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        // int t=

        for(int x=1;x<=t;x++){
            String s = sc.next();
            System.out.println("Case #"+x+": "+parenthesis(s));
        }
    }
}

