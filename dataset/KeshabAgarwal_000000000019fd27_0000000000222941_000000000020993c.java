import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Solution{
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] Arr = new int[n][n];
            for(int j = 0; j<n; ++j){
                for(int k = 0; k<n; ++k){
                    Arr[j][k] = in.nextInt();
                }
            }
            int trace = 0;
            for(int j = 0; j<n; ++j){
                trace+=Arr[j][j];
            }
            int r=0, c=0;
            for(int j = 0; j<n; ++j){
                List<Integer> l = Arrays.asList(Arr[j]);
                for(int k=1; k<=n; ++k){
                    if(l.indexOf(k)==-1){
                        ++r; 
                        break;
                    }
                }
            }
            for(int j = 0; j<n; ++j){
                List<Integer> l = new ArrayList<Integer>();
                for(int s = 0; s<n; ++s){
                    l.add(Arr[s][j]);
                }
                for(int k=1; k<=n; ++k){
                    if(l.indexOf(k)==-1){
                        ++c; 
                        break;
                    }
                }
            }
            System.out.println("Case #"+i+": "+k+" "+r+" "+c);
        }
    }
}