import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            System.out.println("Case #" + i + ": ");
            System.out.println(pascalSum(n));
        }
    }

    public static String pascalSum(int n){
        if(n == 1) {
            return "1 1";
        } else if(n == 2) {
            String str = "2 1\n";
            str += "2 2";
            return str;
        } else {
            String str = n + " 1\n";
            str += n + " 2";
            return str;
        }
    }

}
