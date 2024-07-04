
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t =0; t<T; t++){
            String s = in.next();
            solve(s);
        }
        return;
    }

    public static void solve(String s){
        int d = 0; // depth
        for(char c : s.toCharArray()){
            int n = c - '0';
            if(n>d){
                while(n>d){
                    System.out.print("(");
                    d++;
                }
            }
            if(n<d){
                while(n<d){
                    System.out.print(")");
                    d--;
                }
            }
            System.out.print(c);
        }
        while(d>0){
            System.out.print(")");
            d--;
        }
    }
}