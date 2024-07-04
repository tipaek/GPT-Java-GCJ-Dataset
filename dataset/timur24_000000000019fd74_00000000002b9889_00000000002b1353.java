import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
 
public class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 1; i2 <= n; i2++) {
            	sb.append("\n").append(i2).append(" 1");
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
        in.close();
	}
}