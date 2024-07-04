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
                    //System.out.println(m);
                    String[] qItems = scanner.nextLine().split(" ");
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    for (int k = 0; k < 2; k++){
                        int qItem = Integer.parseInt(qItems[k]);
                        //System.out.println(qItem);
                        q[j][k] = qItem;
                    }   
                }
                int[] jamie = new int[1440];
                int[] cameron = new int[1440];
                String[] sch = new String[m];
                System.out.print("Case #"+(i+1)+": "); 
                int flag =0;
                for(int iInt=0; iInt<1440;iInt++){
                    jamie[iInt] = 0;
                }
                for(int iInt=0; iInt<1440;iInt++){
                    cameron[iInt] = 0;
                }
                for(int j=0;j<m;j++){
                    int start = q[j][0];
                    int stop = q[j][1];
                    int cbusy =0;
                    int jbusy =0;
                    if(start==stop){
                        flag=1;
                        break;
                    }

                    if (start>stop){
                        //check schedule clear in jamie
                        for(int sec=start;sec<1440;sec++){
                            if(jamie[sec]!=0){
                                jbusy =1;
                                break;
                            }
                        }
                        if(jbusy!=1){
                            for(int sec=0;sec<stop;sec++){
                                if(jamie[sec]!=0){
                                    jbusy =1;
                                    break;
                                }
                            }
                        }
                        
                        //if jamie free assign jamie
                        if(jbusy==0){
                            for(int sec=start;sec<1440;sec++){
                                jamie[sec]=1;
                            }
                            for(int sec=0;sec<stop;sec++){
                                jamie[sec]=1;
                            }
                            sch[j]="J";
                            continue;
                        }
                        if(jbusy==1){
                            //check schedule clear in cameron
                            for(int sec=start;sec<1440;sec++){
                                if(cameron[sec]!=0){
                                    cbusy =1;
                                    break;
                                }
                            }
                            if(cbusy!=1){
                                for(int sec=0;sec<stop;sec++){
                                    if(cameron[sec]!=0){
                                        cbusy =1;
                                        break;
                                    }
                                }
                            }
                            //if cameron free assign cameron
                            if(cbusy==0){
                                for(int sec=start;sec<1440;sec++){
                                    cameron[sec]=1;
                                }
                                for(int sec=0;sec<stop;sec++){
                                    cameron[sec]=1;
                                }
                                sch[j]="C";
                                continue;
                            }
                            if(cbusy==1){
                                flag =1;
                                break;
                            }
                        }
                    }
                    //check schedule clear in jamie
                    for(int sec=start;sec<stop;sec++){
                        if(jamie[sec]!=0){
                            jbusy =1;
                            break;
                        }
                    }
                    //if jamie free assign jamie
                    if(jbusy==0){
                        for(int sec=start;sec<stop;sec++){
                            jamie[sec]=1;
                        }
                        sch[j]="J";
                        continue;
                    }
                    if(jbusy==1){
                        //check schedule clear in cameron
                        for(int sec=start;sec<stop;sec++){
                            if(cameron[sec]!=0){
                                cbusy =1;
                                break;
                            }
                        }
                        //if cameron free assign cameron
                        if(cbusy==0){
                            for(int sec=start;sec<stop;sec++){
                                cameron[sec]=1;
                            }
                            sch[j]="C";
                            continue;
                        }
                        if(cbusy==1){
                            flag =1;
                            break;
                        }
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
