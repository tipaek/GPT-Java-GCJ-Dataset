import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Harry on 5/16/20.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int n = in.nextInt();
            int[][] pos = new int[n][2];
            for(int i=0; i<n; i++){
                pos[i][0] = in.nextInt();
                pos[i][1] = in.nextInt();
            }
            boolean isVertical = false;
            HashSet<Double> ks = new HashSet<>();
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    int[] p1 = pos[i];
                    int[] p2 = pos[j];
                    int xDiff = p1[0]-p2[0];
                    int yDiff = p1[1]-p2[1];
                    if(xDiff==0){
                        isVertical = true;
                    }
                    else{
                       ks.add((double)yDiff/(double)xDiff);
                    }
                }
            }

            int max = 1;
            
            for(double k : ks){
                boolean[] visited = new boolean[n];
                HashMap<Integer, Integer> groups = new HashMap<>();
                for(int i=0; i<n; i++){
                    if(visited[i]){
                        continue;
                    }
                    int count = 1;
                    int[] p1 = pos[i];
                    double b = (double)p1[1]-k*p1[0];
                    for(int j=i+1; j<n; j++){
                        int[] p2 = pos[j];
                        if(Math.abs((double)p2[1]-k*p2[0]-b)<0.0000001){
                            count++;
                            visited[j] = true;
                        }
                    }
                    groups.put(count, groups.getOrDefault(count,0)+1);
                }
                int curRes = 0;
                for(int key : groups.keySet()){
                    if(key==1){
                        curRes+=Math.min(2, groups.get(key));
                    }
                    else{
                        curRes+=key*groups.get(key);
                    }
                }
                max = Math.max(max, curRes);
            }

            if(isVertical){
                boolean[] visited = new boolean[n];
                HashMap<Integer, Integer> groups = new HashMap<>();
                for(int i=0; i<n; i++){
                    if(visited[i]){
                        continue;
                    }
                    int count = 1;
                    int[] p1 = pos[i];
                    for(int j=i+1; j<n; j++){
                        int[] p2 = pos[j];
                        if(p1[0]==p2[0]){
                            count++;
                            visited[j] = true;
                        }
                    }
                    groups.put(count, groups.getOrDefault(count,0)+1);
                }
                int curRes = 0;
                for(int key : groups.keySet()){
                    if(key==1){
                        curRes+=Math.min(2, groups.get(key));
                    }
                    else{
                        curRes+=key*groups.get(key);
                    }
                }
                max = Math.max(max, curRes);
            }
            System.out.println("Case #"+t+": "+max);
        }
    }
}
