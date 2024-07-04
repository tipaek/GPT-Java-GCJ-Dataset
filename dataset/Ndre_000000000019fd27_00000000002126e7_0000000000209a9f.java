import java.util.Scanner;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1;i<=t;i++){
            String s = sc.next();
            String res = "";
            int open = 0;
            for(int k=0;k<s.length();k++){
                int curr = Integer.parseInt(s.charAt(k)+"");
                int now = curr-open;
                for(int h=0;h<now;h++) res+="(";
                for(int h=now;h<0;h++) res+=")";
                res+=curr;
                open+=now;
            }
            for(int h=0;h<open;h++) res+=")";
            System.out.println("Case #"+i+": "+res);
        }
    }
}