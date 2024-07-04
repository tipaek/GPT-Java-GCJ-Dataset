import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
public class Solution{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i1 = 1; i1 <= t; ++i1) {
            int n = in.nextInt();
            int[][] num = new int[n][n];
            int sum=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    num[i][j] = in.nextInt();
                    if(i==j){
                        sum += num[i][j];
                    }
                }
            }
            int r=0;
            int c=0;
            HashSet<Integer> hashSetR = new HashSet<>();
            HashSet<Integer> hashSetC = new HashSet<>();
            for(int i=0;i<n;i++){
                hashSetC.clear();
                hashSetR.clear();
                boolean rRepeat = false;
                boolean cRepeat = false;
                for(int j=0;j<n;j++){
                    if(rRepeat && cRepeat){
                        break;
                    }
                    if(hashSetR.contains(num[i][j]) && !rRepeat){
                        r++;
                        rRepeat=true;
                    }else{
                        hashSetR.add(num[i][j]);
                    }
                    if(hashSetC.contains(num[j][i]) && !cRepeat){
                        c++;
                        cRepeat=true;
                    }else{
                        hashSetC.add(num[j][i]);
                    }
                }
            }
            System.out.println("Case #" + i1 + ": " + sum + " " + r + " " + c);
        }
    }
}