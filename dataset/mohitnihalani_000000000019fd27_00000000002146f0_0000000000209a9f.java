import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            in.nextLine();
            char[] a = in.next().toCharArray();
            int j = 0;
            StringBuilder builder = new StringBuilder();
            int bal = 0;
            while(j < a.length){
                int num = Integer.parseInt(String.valueOf(a[j]));
                int diff = (bal == 0) ? 0 : Math.abs(num - bal);
                while(diff > 0){
                    builder.append(')');
                    bal--;
                    diff--;
                }
                diff = num - bal;
                while(diff > 0){
                    builder.append('(');
                    bal++;
                    diff--;
                }
                builder.append(num);
                j++;
            }
            while(bal > 0){
                bal--;
                builder.append(')');
            }
            System.out.println("Case #" + i + " " + builder.toString());
        }
    }
}