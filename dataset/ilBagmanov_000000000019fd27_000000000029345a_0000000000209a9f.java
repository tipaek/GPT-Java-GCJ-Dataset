import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int w = 0; w < t; w++) {
            System.out.print("Case #" + (w + 1) + ": ");
            int status = 0;
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                int x = s.charAt(i) - '0';
                if (x > status) {
                    souter(x - status, '(');
                    status = x;
                    System.out.print(x);
                    continue;
                }
                if (x == status) {
                    System.out.print(x);
                    continue;
                }
                souter(status - x, ')');
                status = x;
                System.out.print(x);
            }
            souter(status, ')');
            System.out.println();
        }
    }

    public static void souter(int size, char type) {
        if (type == '(') {
            for (int i = 0; i < size; i++) System.out.print("(");
        } else {
            for (int i = 0; i < size; i++) System.out.print(")");
        }
    }
}
