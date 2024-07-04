import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        for(int ii=1; ii <= t; ii++){

            int N = Integer.parseInt(s.nextLine());
            int[][] m = new int[N][N];
            for(int i=0; i < N; i++){
                String[] data = s.nextLine().split(" ");
                for(int j=0; j < N; j++){
                    m[i][j] = Integer.parseInt(data[j]);
                }
            }
            int trace = 0;
            for(int i=0; i < N; i++){
                trace = trace + m[i][i];
            }
            int r = 0;
            for(int i=0; i < N; i++){
                TreeSet ts = new TreeSet();
                for(int j=0; j < N; j++){
                    ts.add(m[i][j]);
                }
                if (ts.size() < N){
                    r++;
                }
            }
            int c= 0;
            for(int i=0; i < N; i++){
                TreeSet ts = new TreeSet();
                for(int j=0; j < N; j++){
                    ts.add(m[j][i]);
                }
                if (ts.size() < N){
                    c++;
                }
            }

            System.out.println("Case #" +  ii + ": " + trace + " " + r + " " + c);
        }
    }
}