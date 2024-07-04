import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Solution {//Rename to Solution
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i < t; i++){
            int n = scan.nextInt();
            int[][] times = new int[n][2];
            for(int j = 0; j<n; j++){
                times[j][0] = scan.nextInt();
                times[j][1] = scan.nextInt();
            }
            Arrays.sort(times, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[0], b[0]);
                }
            });
            int e1 = 0;
            int e2 = 0;
            boolean impos = false;
            StringBuilder s = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(times[j][0] >= e1) {
                    e1 = times[j][1];
                    s.append("J");
                }
                else if(times[j][0] >= e2){
                    e2 = times[j][1];
                    s.append("C");
                }
                else{
                    s = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + (i+1) + ": " + s.toString());
        }
        scan.close();
    }
}