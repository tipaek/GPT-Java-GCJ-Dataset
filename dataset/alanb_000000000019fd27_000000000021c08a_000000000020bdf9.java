import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Solution {//Rename to Solution
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i < t; i++){
            int n = scan.nextInt();
            int[][] times = new int[n][3];
            for(int j = 0; j<n; j++){
                times[j][0] = scan.nextInt();
                times[j][1] = scan.nextInt();
                times[j][2] = j;
            }
            Arrays.sort(times, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[0], b[0]);
                }
            });
            int e1 = 0;
            int e2 = 0;
            boolean impos = false;
            char[] s = new char[n];
            for(int j = 0; j < n; j++){
                if(times[j][0] >= e1) {
                    e1 = times[j][1];
                    s[times[j][2]] = 'C';
                }
                else if(times[j][0] >= e2){
                    e2 = times[j][1];
                    s[times[j][2]] = 'J';
                }
                else{
                    impos = true;
                    break;
                }
            }
            if (impos){
                System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            }
            else {
                StringBuilder str = new StringBuilder();
                for(char c : s)
                    str.append(c);
                System.out.println("Case #" + (i + 1) + ": " + str.toString());
            }
        }
        scan.close();
    }
}