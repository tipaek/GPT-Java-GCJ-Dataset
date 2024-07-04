import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int f = 0;
        while (f++ < t){
            int n = scan.nextInt();
            int[][] ar = new int[n][3];
            for (int i = 0; i < n; i++) {
                ar[i][0] = scan.nextInt();
                ar[i][1] = scan.nextInt();
                ar[i][2] = i;
            }

            Arrays.sort(ar, Comparator.comparingInt(o->o[0]));
            int[] l = new int[2];
            Arrays.fill(l,Integer.MAX_VALUE);
            String[] c = new String[2];
            c[0] = "C";
            c[1] = "J";
            boolean isImpossible = false;
            String[] result = new String[n];
            for (int i = n-1; i >=0 ; i--) {
                int x = 0;
                int y = 1;
                if(l[x] > l[y]){
                    int temp = x;
                    x = y;
                    y = temp;
                }
                if(ar[i][1] <= l[x]){
                    result[ar[i][2]]=c[x];
                    l[x] = ar[i][0];
                }else if(ar[i][1] <= l[y]){
                    result[ar[i][2]]=c[y];
                    l[y] = ar[i][0];
                }else{
                    isImpossible = true;
                    break;
                }
            }

            String rr = isImpossible?"IMPOSSIBLE": String.join("", result);
            System.out.println("Case #"+f+": " + rr);
        }
    }
}
