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
            int[][] q = new int[m][3];
                for (int j = 0; j < m; j++){
                    //System.out.println(m);
                    String[] qItems = scanner.nextLine().split(" ");
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    for (int k = 0; k < 3; k++){
                        if(k==2){
                            q[j][k]=j;
                            continue;
                        }
                        int qItem = Integer.parseInt(qItems[k]);
                        //System.out.println(qItem);
                        q[j][k] = qItem;
                    }
                }
                for (int c1=0;c1<m;c1++){
                    for (int c2=c1+1;c2<m;c2++){
                        int temp1;
                        int temp2;
                        int temp3;
                        if(q[c1][0]>q[c2][0]){
                            temp1=q[c1][0];
                            temp2=q[c1][1];
                            temp3=q[c1][2];
                            q[c1][0]=q[c2][0];
                            q[c1][1]=q[c2][1];
                            q[c1][2]=q[c2][2];
                            q[c2][0]=temp1;
                            q[c2][1]=temp2;
                            q[c2][2]=temp3;
                        }

                    }
                }
                int[] jamie = new int[]{-1,-1};
                int[] cameron = new int[]{-1,-1};
                String[] sch = new String[m];
                System.out.print("Case #"+(i+1)+": "); 
                int flag =0;
                
                for (int j = 0; j < m; j++){
                    // first assign cameron
                    /*if(j==0){
                        cameron[0] = q[j][0];
                        cameron[1] = q[j][1];
                        sch[j] = "C";
                        continue;
                    }*/
                    //check if cameron is busy
                    if((q[j][0]>cameron[0]&&q[j][0]<cameron[1])||(q[j][1]>cameron[0]&&q[j][1]<cameron[1])){
                        // if cameron is check if jamie is busy
                        if((q[j][0]>jamie[0]&&q[j][0]<jamie[1])||(q[j][1]>jamie[0]&&q[j][1]<jamie[1])){
                            flag=1;
                            break;
                        }else{
                            //jamie is free assign him
                            jamie[0] = q[j][0];
                            jamie[1] = q[j][1];
                            sch[q[j][2]] = "J";
                            continue;
                        }
                    }else{
                        //cameron is free assign him
                        cameron[0] = q[j][0];
                        cameron[1] = q[j][1];
                        sch[q[j][2]] = "C";
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
