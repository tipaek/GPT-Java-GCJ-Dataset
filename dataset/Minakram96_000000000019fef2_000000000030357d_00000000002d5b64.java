import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static List<String> y = new ArrayList<>();
    static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
//        int b = in.nextInt();
        for (int i = 0; i < cases; i++) {
            y = new ArrayList<>();
            int r = in.nextInt();
            int s = in.nextInt();
            solve(r, s);
            int temp = i + 1;
            System.out.println("Case #" + temp + ": " + y.size());
            printSolution();

//            System.out.println(y);
//            String reply = in.next();
//            if (reply.equals("N")) {
//                return;
//            }
        }
    }

    private static void printSolution() {
        for (int i = 0; i < y.size(); i++) {
            System.out.println(y.get(i));
        }
    }

    private static void solve(int ranksP, int suitsP) {
        int ranks = ranksP -1;
        for (int b = 0; b < ranksP - 1; b++ ){
            for (int a= 0; a < suitsP - 1; a++){
                String str = ((ranks+1) * (suitsP -1))-a + " " +ranks;
                y.add(str);
            }
            ranks--;
        }
    }
}
