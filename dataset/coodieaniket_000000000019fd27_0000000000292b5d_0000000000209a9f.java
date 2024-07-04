import java.util.ArrayList;
import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int e = 1;
        while (e <= t) {
            String s = sc.next();
            ArrayList<Character> res = new ArrayList<>();
            int prev = 0;
            for (char c : s.toCharArray()) {
                int r = Character.getNumericValue(c);
                // System.out.println(r);
                if (r > prev) {
                    int x = r - prev;
                    while (x-- != 0)
                        res.add('(');
                    res.add(Character.forDigit(r, 10));
                    prev = r;
                } else {
                    int x = prev - r;
                    while (x-- != 0)
                        res.add(')');
                    res.add(Character.forDigit(r, 10));
                    prev = r;
                }
            }
            while (prev-- != 0)
                res.add(')');
            System.out.print("Case #" + (e++) + ": ");
            for (Character character : res) {
                System.out.print(character);
            }
            System.out.println();

        }
        sc.close();
    }
}