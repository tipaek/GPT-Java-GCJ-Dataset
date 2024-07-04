import java.util.Scanner;

public class Solution {
    private static Scanner in = new Scanner(System.in);
    public static void main(String args[]) {
        int t = in.nextInt();
        int b = in.nextInt();
        for(int i=0; i<t; i++) {
            solve(b);
        }
    }
    public static void solve(int b) {
        if(b!=10) {
            throw new UnsupportedOperationException("unsupported");
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++) {
            System.out.println(i+1);
            sb.append(in.next());
        }
        System.out.println(sb.toString());
        in.next();
    }
}
