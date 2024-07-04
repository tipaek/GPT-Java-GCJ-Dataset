import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String one = br.readLine();
        int test = Integer.parseInt(one);
        int caseno = 1;
        while(test-->0){
            boolean possible = true;
            String two = br.readLine();
            int tasks = Integer.parseInt(two);
            StringBuilder sb = new StringBuilder();
            int[] J = new int[2000];
            int[] C = new int[2000];
            while(tasks-->0){
                String[] time = br.readLine().split(" ");
                int start = Integer.parseInt(time[0]);
                int end = Integer.parseInt(time[1]);
                boolean Jfree = true;
                boolean Cfree = true;
            //     for(int i = start; i < end; i++){
            //         if(J[i] != 0 && Jfree){
            //             Jfree = false;
            //         }
            //         if(C[i] != 0 && Cfree){
            //             Cfree = false;
            //         }
            //     }
                
            //     if(Jfree){
            //         sb.append('J');
            //         for(int i = start; i < end; i++){
            //             J[i] = 1;
            //         }
            //     } else if (Cfree){
            //         sb.append('C');
            //         for(int i = start; i < end; i++){
            //             C[i] = 1;
            //         }
            //     } else {
            //         possible = false;
            //         break;
            //     }
            }
            if(possible){
                System.out.println("Case #" + caseno++ + ": JC");
            } else {
                System.out.println("Case #" + caseno++ + ": IMPOSSIBLE");
            }
            sb = new StringBuilder();
        }
    }
}