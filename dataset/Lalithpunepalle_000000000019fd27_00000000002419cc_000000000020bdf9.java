import java.util.*;
import java.io.*;

public class Solution{

     public static void main(String []args){
        Scanner inp = new Scanner(System.in);
        int t = inp.nextInt();
        
        for(int i=0;i<t;i++){
            String s = "";
        int a = 0;
        int b = 0;
        int c=0;
        int d=0;
        int p =0;
            int n = inp.nextInt();
            int[] a1 = new int[n];
            int[] a2 = new int[n];
            int[] b1 = new int[n];
            int[] b2 = new int[n];
            int[] c1 = new int[n];
            int[] c2 = new int[n];
            for(int j=0;j<n;j++){
                a1[j] = inp.nextInt();
                a2[j] = inp.nextInt();
            }
            
                int f= 0;
                int g=0;
                int h = 0;
                for(int k=0;k<n;k++){
                    
                    // for(int j=0;)
                    if(d<=a1[k]){
                        
                        c= a1[k];
                        d = a2[k];
                        s = s+"J";
                        b1[f] = k;
                        f++;
                        // System.out.println(s);
                    }
                    else if(b<=a1[k]){
                        a = a1[k];
                        b = a2[k];
                        s = s+ "C";
                        b2[g] = k;
                        g++;
                        // System.out.println(s);
                    }
                    // else{
                    //     System.out.println();
                    // }
                    else{
                        for(int j=0;j<f;j++){
                            if(a1[b1[j]] >= a2[k]){
                                h++;
                                
                                // f++;
                                // p++;
                                // break;
                            }
                        }
                        if(h==f){
                            c = a1[k];
                                d = a2[k];
                                s = s+ "J";
                                b1[f] = k;
                                f++;
                                p++;
                                h = 0;
                            
                        }
                        if(p==0){
                        for(int j=0;j<g;j++){
                            if(a1[b1[j]] >= a2[k]){
                                h++;
                                // break;
                            }
                        }
                        if(h==g){
                            // h++;
                                a = a1[k];
                                b = a2[k];
                                s = s+ "C";
                                b2[g] = k;
                                g++;
                                h=0;
                            
                        }
                        
                        }
                        p=0;
                    }
                    int x = i+1;
                    if(k == n-1){
                        if(s.length() == n){
                            System.out.println("Case #"+x+": "+s);
                        }
                        else{
                            System.out.println("Case #"+x+": "+"IMPOSSIBLE");
                        }
                    }
                }
            //     break;
            // }
        }
     }
}