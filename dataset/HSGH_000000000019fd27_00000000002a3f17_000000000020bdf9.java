import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int i=0; i<t; i++){
            int N = Integer.parseInt(sc.nextLine());
            int[][] time = new int[N][2];
            for(int j=0; j<N; j++){
                String[] input = sc.nextLine().split(" ");
                time[j][0] = Integer.parseInt(input[0]);
                time[j][1] = Integer.parseInt(input[1]);
            }
            String output = "Case #" + (i+1) + ": ";
            int[][] timeS = new int[N][2];
            for(int j = 0; j<N; j++){
                timeS[j][0] = time[j][0];
                timeS[j][1] = time[j][1];
            }
            Arrays.sort(time, new Comparator<int[]>() { 
                @Override              
                public int compare(final int[] entry1, final int[] entry2) { 
                    if (entry1[0] > entry2[0]) 
                        return 1; 
                    else
                        return -1; 
                  } 
            });
            int c = 0, k = 0;
            String[] slot = new String[N];
            for(int j=0; j<N; j++){
                if(c == 0 || c <= time[j][0]){
                    c = time[j][1];
                    slot[j] = "C";
                }else if(k == 0 || k <= time[j][0]){
                    k = time[j][1];
                    slot[j] = "J";
                }else{
                    slot[0] = "IMPOSSIBLE";
                    break;
                }
            }
            if(slot[0] == "IMPOSSIBLE"){
                output += "IMPOSSIBLE";
            }
            else{
                for(int j=0; j<N; j++){
                    for(int l=0; l<N; l++){
                        if(timeS[j][0] == time[l][0] && timeS[j][1] == time[l][1]){
                            output += slot[l];
                        }
                    }
                }
            }
            System.out.println(output);
        }
    }
}