import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        for (int i=1; i<=t; i++) {
            StringBuilder out = new StringBuilder(b);
            out.setLength(b);

            for (int j=0; j<b; j++) {
                System.out.println(j+1);
                out.setCharAt(j, in.next().charAt(0));
            }
            System.out.println(out);
            // Reading N / Y
            in.next().charAt(0);
        }
    }
}
