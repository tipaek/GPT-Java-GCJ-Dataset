import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountCases = scanner.nextInt();

        for(int currentCase = 1; currentCase <= amountCases; currentCase ++){
            System.out.print("Case #" + currentCase + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner){
        int n = scanner.nextInt();


        int[][] times = new int[n][2];

        for (int i = 0; i < n; i++) {
            times[i][0] = scanner.nextInt();
            times[i][1] = scanner.nextInt();
        }

        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

        StringBuilder sb = new StringBuilder();
        int c = 0;
        int j = 0;

        boolean impossible = false;
        for (int i = 0; i < n; i++) {
            if(c < j){
                if(c <= times[i][0]){
                    c = times[i][1];
                    sb.append('C');
                }else{
                    if(j > times[i][0]){
                        impossible = true;
                        break;
                    }else{
                        j = times[i][1];
                        sb.append('J');
                    }
                }
            }else{
                if(j <= times[i][0]){
                    j = times[i][1];
                    sb.append('J');
                }else{
                    if(c > times[i][0]){
                        impossible = true;
                        break;
                    }else{
                        c = times[i][1];
                        sb.append('C');
                    }
                }
            }
        }

        if(impossible){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(sb.toString());
        }

    }
}