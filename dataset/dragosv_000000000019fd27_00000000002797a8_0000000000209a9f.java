import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for(int t = 1; t <= tests; t++) {
            String s = sc.next();
            StringBuilder sol = new StringBuilder("");
            char[] characters = s.toCharArray();
            int counter = 0;
            for(char c: characters) {
                int shouldHave = c-'0';
                while(shouldHave < counter) {
                    counter--;
                    sol.append(')');
                }
                while(shouldHave > counter) {
                    counter++;
                    sol.append('(');
                }
                sol.append(c);
            }
            while(counter > 0) {
                counter--;
                sol.append(')');
            }
            System.out.print("Case #" + t + ": ");
            System.out.println(sol.toString());
        }

    }
}
