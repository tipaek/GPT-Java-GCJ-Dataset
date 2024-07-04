import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {


        Scanner input =
                new Scanner(System.in);
        try {
            int t = input.nextInt();
            A:for (int i = 1; i <= t; i++) {
                int n=input.nextInt();
                int c[][]=new int[1][2];
                int x[][]=new int[1][2];
                int a[][]=new int[n][2];
                for(int j=0;j<n;j++){
                    for(int k=0;k<2;k++){
                       a[j][k]=input.nextInt();
                    }
                }
                int b[]=new int[2];
                int k=0;

                String s="";

                    s+="C";
                    c[0][0]=a[0][0];
                    c[0][1]=a[0][1];


                for(int j=1;j<n;j++){


                        if(a[j][0]>c[0][0]){
                            if(a[j][0]<c[0][1]){

                                //b[1]=1;
                                if(a[j][0]<x[0][0]){
                                    if(a[j][1]<=x[0][0]){
                                        s+="J";
                                        x[0][0]=a[j][0];
                                        x[0][1]=a[j][1];
                                    }
                                    else {
                                        System.out.println("Case #"+i+": "+"IMPOSSIBLE");
                                        continue A;

                                    }
                                }
                                else{
                                        if(a[j][0]>=x[0][1]){
                                            s+="J";
                                            x[0][0]=a[j][0];
                                            x[0][1]=a[j][1];
                                        }
                                        else {
                                            System.out.println("Case #"+i+": "+"IMPOSSIBLE");
                                            continue A;
                                        }
                                }



                            }
                            else {


                                s+="C";
                                c[0][0]=a[j][0];
                                c[0][1]=a[j][1];
                            }
                        }
                        else {
                            if(a[j][1]<=c[0][0]){
                                s+="C";
                                c[0][0]=a[j][0];
                                c[0][1]=a[j][1];
                            }
                            else {
                                if (a[j][0] < x[0][0]) {
                                    if (a[j][1] <= x[0][0]) {
                                        s += "J";
                                        x[0][0] = a[j][0];
                                        x[0][1] = a[j][1];
                                    } else {
                                        System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
                                        continue A;

                                    }
                                } else {
                                    if (a[j][0] >= x[0][1]) {
                                        s += "J";
                                        x[0][0] = a[j][0];
                                        x[0][1] = a[j][1];
                                    } else {
                                        System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
                                        continue A;
                                    }
                                }
                            }

                    }
                }
                System.out.println("Case #"+i+": "+s);

            }
            }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
