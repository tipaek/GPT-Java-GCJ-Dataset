import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int T = in.nextInt();
        for(int t =1; t<T+1; t++){
            String s = in.next();
            solve(s, t);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
       

    public static void solve(String s, int t){
        int d = 0; // depth
        String ans = "";
        for(char c : s.toCharArray()){
            int n = c - '0';
            if(n>d){
                while(n>d){
                    ans += ("(");
                    d++;
                }
            }
            if(n<d){
                while(n<d){
                    ans += (")");
                    d--;
                }
            }
            ans += (c);
        }
        while(d>0){
            ans += (")");
            d--;
        }
        System.out.println(String.format("Case #%d: %s", t, ans));
    }
}