import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(in.readLine());
        
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(in.readLine());
            sb.append("Case #"+(i+1)+": ");
            int[] temp_c = new int[1441];
            int[] temp_j = new int[1441];
            
            StringBuilder sb_temp = new StringBuilder();
            
            outer:
            for(int j=0; j<n; j++) {
                String[] input = in.readLine().trim().split("\\s+");
                
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                
                boolean flag_c = true;
                boolean flag_j = true;
                
                for(int k=start+1; k<=end; k++) {
                    if(temp_c[k]==1) {
                        flag_c = false;
                        break;
                    }
                }
                
                if(flag_c) {
                    sb_temp.append("C");
                    for(int k=start+1; k<=end; k++) {
                        temp_c[k] = 1;
                    }
                    continue outer;
                }
                
                for(int k=start+1; k<=end; k++) {
                    if(temp_j[k]==1) {
                        flag_j = false;
                        break;
                    }
                }
                
                if(flag_j) {
                    sb_temp.append("J");
                    for(int k=start+1; k<=end; k++) {
                        temp_j[k] = 1;
                    }
                    continue outer;
                }
                else {
                    sb_temp = new StringBuilder("IMPOSSIBLE");
                }
            }
            
            sb.append(sb_temp.toString()+"\n");
        }
        
        System.out.println(sb.toString());
    }
}