
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        //String inFile = "sample.in";
        //Scanner sc = new Scanner(Solution.class.getResource(inFile).openStream());
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        sc.nextLine();
        for (int test=1; test<=tests; test++) {
            String str = sc.nextLine();
            System.out.println("Case #" + test + ": " + doit(str));
        }
    }

    private static String doit(String str) {
        int ret = str.length();

        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            int times = ch - '0';
            for  (int i = 0; i < times; i++) {
                sb.append('(');
            }
            sb.append(ch);
            for  (int i = 0; i < times; i++) {
                sb.append(')');
            }
        }
        boolean found = true;
        String str2 = sb.toString();
        while (found) {
            found = false;
            StringBuilder sb2 =  new StringBuilder();
            for (int i = 0; i < str2.length(); i++) {
                if (str2.charAt(i) == ')' && i+1 < str2.length() && str2.charAt(i+1) == '(') {
                    i++;
                    found = true;
                } else {
                    sb2.append(str2.charAt(i));
                }
            }
            str2 = sb2.toString();
        }
        return str2;
    }
}
