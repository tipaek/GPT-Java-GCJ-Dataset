import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            int N = in.nextInt();
            int[][] array = new int[N][N];
            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    array[j][k] = in.nextInt();
                }
            }
            int sum = 0;
            for(int j=0; j<N; j++) {
                sum+=array[j][j];
            }
            int count = 0;
            for(int j=0; j<N; j++) {
                boolean[] bools = new boolean[N];
                for(int k=0; k<N; k++) {
                    bools[array[j][k]-1] = true;
                }
                boolean istrue = true;
                for(int k=0; k<N; k++) {
                    if(bools[k]==false) {
                        istrue = false;
                        break;
                    }
                }
                if(istrue==false) count++;
            }
            int count2 = 0;
            for(int k=0; k<N; k++) {
                boolean[] bools = new boolean[N];
                for(int j=0; j<N; j++) {
                    bools[array[j][k]-1] = true;
                }
                boolean istrue = true;
                for(int j=0; j<N; j++) {
                    if(bools[j]==false) {
                        istrue = false;
                        break;
                    }
                }
                if(istrue==false) count2++;
            }
            System.out.println("Case #" + (i+1)+": " + sum+" "+count+" "+count2);
        }
    }
}
