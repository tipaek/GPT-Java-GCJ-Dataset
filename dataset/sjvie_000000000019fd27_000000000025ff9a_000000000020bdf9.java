import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountCases = scanner.nextInt();

        for (int currentCase = 1; currentCase <= amountCases; currentCase++) {
            System.out.print("Case #" + currentCase + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();


        int[][] times = new int[n][3];

        for (int i = 0; i < n; i++) {
            times[i][0] = scanner.nextInt();
            times[i][1] = scanner.nextInt();
            times[i][2] = i;
        }

        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

        int c = 0;
        int j = 0;
        char[] res = new char[n];

        for (int i = 0; i < n; i++) {
            if (times[i][0] < c && times[i][0] < j) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            if(c < j){
                c = times[i][1];
                res[times[i][2]] = 'C';
            }else{
                j = times[i][1];
                res[times[i][2]] = 'J';
            }
        }
        System.out.println(new String(res));

    }
}