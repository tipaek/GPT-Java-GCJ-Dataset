import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for(int test = 1; test <= t; test++){
            String s = in.next();
            String ans = "";
            int depth = 0;
            for(char c : s.toCharArray()){
                int num = Integer.parseInt(c +"");
                if(depth < num){
                    for(int i = 0; i< num - depth; i++) ans += "(";
                    ans += num;
                    depth = num;
                }
                else if(depth > num){
                    for(int i = 0; i< depth- num; i++) ans += ")";
                    ans += num;

                    depth = num;
                }
                else{
                    ans += num;
                }


            }
            for(int i = depth; i> 0; i--){
                ans += ")";
            }


            System.out.println("Case " + test+ ": " + ans);
        }
    }
}
