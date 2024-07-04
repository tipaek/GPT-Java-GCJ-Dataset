import java.util.Collections;
import java.util.Scanner;

public class Solution {
    static Scanner sc;
    static int tests;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        tests = Integer.parseInt(sc.nextLine());

        for (int test = 1; test <= tests; test++) {
            test(test);
        }
    }

    private static void test(int test) {
        String S = sc.nextLine().trim();
        String[] getallen = S.split("");
        for(int i = 0 ; i < S.length() ; i++){
            int getal = Integer.parseInt(getallen[i]);
            getallen[i] = repeat(getal,"(") + getallen[i] + repeat(getal,")");
        }
        String S2 = String.join("", getallen);

        while (S2.contains(")(")) {
            S2 = S2.replace(")(", "");
        }

        System.out.printf("Case #%d: %s\n", test, S2);
    }

    private static String repeat(int getal, String string){
        return String.join("", Collections.nCopies(getal, string));
    }
}