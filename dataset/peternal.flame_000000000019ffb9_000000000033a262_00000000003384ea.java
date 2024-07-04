import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int tt = 1; tt<= t; tt++){
            long l = in.nextLong();
            long r = in.nextLong();
            int i = 0;
            while(i<=Math.max(l, r)-1){
                i++;
                if(l>=r){
                    l -= i;
                }else{
                    r -= i;
                }
            }
            System.out.println("Case #" + tt + ": " + i + " " + l + " " + r);
        }
    }

}
