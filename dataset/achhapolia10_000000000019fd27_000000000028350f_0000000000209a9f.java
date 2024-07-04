import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            StringBuilder res = new StringBuilder();
            for (int j = 0; j < s.length(); ) {
                StringBuilder temp = new StringBuilder();
                char a = s.charAt(j);
                for (; j < s.length() && s.charAt(j) == a; j++) {
                    temp.append(a);
                }
                int n = Integer.parseInt("" + a);
                for (int k = 0; k < n; k++) {
                    temp = new StringBuilder("(" + temp + ")");
                }
                res.append(temp);
            }
            System.out.println(res);
        }
    }
}