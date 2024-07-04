import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int i=0; i<t; i++){
            int N = Integer.parseInt(sc.nextLine());
            int[][] time = new int[N][4];
            for(int j=0; j<N; j++){
                String[] input = sc.nextLine().split(" ");
                time[j][0] = Integer.parseInt(input[0]);
                time[j][1] = Integer.parseInt(input[1]);
                time[j][2] = j;
            }
            String output = "Case #" + (i+1) + ": ";
            Arrays.sort(time, new Comparator<int[]>() { 
                @Override              
                public int compare(final int[] entry1, final int[] entry2) { 
                    if (entry1[0] > entry2[0]) 
                        return 1; 
                    else
                        return -1; 
                  } 
            });
            int c = 0, k = 0, imp = 0;
            String[] slot = new String[N];
            for(int j=0; j<N; j++){
                if(c == 0 || c <= time[j][0]){
                    c = time[j][1];
                    time[j][3] = 0;
                }else if(k == 0 || k <= time[j][0]){
                    k = time[j][1];
                    time[j][3] = 1;
                }else{
                    System.out.println(output + "IMPOSSIBLE");
                    imp = 1;
                    break;
                }
            }

            if(imp == 0){
                Arrays.sort(time, new Comparator<int[]>() { 
                    @Override              
                    public int compare(final int[] entry1, final int[] entry2) { 
                        if (entry1[2] > entry2[2]) 
                            return 1; 
                        else
                            return -1; 
                      } 
                });
                for(int j=0; j<N; j++) {
                    if(time[j][3] == 0){
                        output +="C";
                    }else{
                        output +="J";
                    }
                }
                System.out.println(output);
            }
        }
    }
}