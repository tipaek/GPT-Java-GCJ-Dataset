import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < t; i++) {
            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[][] q = new int[m][2];
                for (int j = 0; j < m; j++){
                    String[] qItems = scanner.nextLine().split(" ");
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    for (int k = 0; k < 2; k++){
                        int qItem = Integer.parseInt(qItems[k]);
                        q[j][k] = qItem;
                    }   
                }
                int[] jamie = new int[]{-1,-1};
                int[] cameron = new int[]{-1,-1};
                String[] sch = new String[m];
                System.out.print("Case #"+(i+1)+": "); 
                int flag =0;
                
                for (int j = 0; j < m; j++){
                    // first assign cameron
                    if(j==0){
                        cameron[0] = q[j][0];
                        cameron[1] = q[j][1];
                        sch[j] = "C";
                        continue;
                    }
                    //check if cameron is busy
                    if((q[j][0]>cameron[0]&&q[j][0]<cameron[1])||(q[j][1]>cameron[0]&&q[j][1]<cameron[1])){
                        // if cameron not free check if jamie is busy
                        if((q[j][0]>jamie[0]&&q[j][0]<jamie[1])||(q[j][1]>jamie[0]&&q[j][1]<jamie[1])){
                            sch[j] = "IMPOSSIBLE";
                            flag=1;
                            break;
                        }else{
                            //jamie is free assign him
                            jamie[0] = q[j][0];
                            jamie[1] = q[j][1];
                            sch[j] = "J";
                            continue;
                        }
                    }else{
                        //cameron is free assign him
                        cameron[0] = q[j][0];
                        cameron[1] = q[j][1];
                        sch[j] = "C";
                        continue;
                    }      
                }
                if (flag==1){
                    System.out.println("IMPOSSIBLE");
                    flag =0;
                    continue;
                }else{
                    for(int k=0; k< m;k++){
                        System.out.print(sch[k]);
                    }
                    System.out.println("");
                }        
        }
        scanner.close();
    }
}
