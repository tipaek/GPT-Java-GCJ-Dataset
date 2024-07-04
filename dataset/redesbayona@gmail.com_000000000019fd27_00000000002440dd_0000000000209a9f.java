import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    protected static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int cases = Integer.parseInt(in.nextLine());
        for (int caso = 0; caso < cases; caso++) {
            String cadena = in.nextLine();
            StringBuffer sb = new StringBuffer();

            sb.append("(");
            for (int i = 0; i < cadena.length(); i++) {
                sb.append(cadena.charAt(i));
                if (i < cadena.length() - 1) {
                    if (cadena.charAt(i) != cadena.charAt(i + 1)) {
                        sb.append(")(");
                    }
                }
            }
            sb.append(")");
            System.out.printf("Case #%d: %s", caso + 1, sb.toString());
            System.out.println();
        }
    }
}