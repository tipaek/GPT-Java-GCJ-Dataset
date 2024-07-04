import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int T = inputScanner.nextInt();
        for(int i = 0; i < T; i++){
            int N = inputScanner.nextInt();
            int[][] a = new int[N][4];
            for(int j = 0; j < N; j++){
                a[j][0] = inputScanner.nextInt();
                a[j][1] = inputScanner.nextInt();
                a[j][2] = j;
                a[j][3] = 0;
            }
            schedule(a, i);
        }
        inputScanner.close();
    }



    public static void schedule(int[][] a, int n){
        StringBuilder sb = new StringBuilder();
        // initialise case
        sb.append("Case #");
        sb.append(n+1);
        sb.append(": ");
        
        // lambda compare
        Arrays.sort(a, (x, y) -> x[0] - y[0]);
      
        int ac = 0, aj = 0;
        for(int i = 0; i < a.length; i++){
            int first = a[i][0];
            int last = a[i][1];
            if(first >= ac){
                ac = last;
                a[i][3] = 0;
            }else if(first >= aj){
                aj = last;
                a[i][3] = 1;
            }else{
                System.out.println(String.format("Case #%d: IMPOSSIBLE", n+1));
                return;
            }
        }
        Arrays.sort(a, (x, y) -> x[2] - y[2]);
        for(int i=0; i < a.length; i++){
            if(a[i][3] == 0) sb.append("C");
            else sb.append("J");
        }
        System.out.println(sb.toString());
        return;
    }

}
