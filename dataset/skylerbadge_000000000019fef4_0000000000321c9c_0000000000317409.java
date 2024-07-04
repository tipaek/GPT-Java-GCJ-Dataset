/*package Coding;*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Solution {

    public static void main(String[] args) throws IOException {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            int n,i,j,ctr,x,y;
            String s,ans;
            
            for(int z = 1; z<=t;z++){
                String a[] = br.readLine().split(" ");
                s=a[2];
                x=Integer.parseInt(a[0]);y=Integer.parseInt(a[1]);

                
                int min = x+y;
                ctr=0;
                int time = 0;
                int xc[]=new int[s.length()+1];
                int yc[]=new int[s.length()+1];
                xc[0]=x;yc[0]=y;
                for(char ch:s.toCharArray()){
                    ctr++;
                    if(ch=='S'){
                        if(min>=Math.abs(x)+Math.abs(--y)){
                            min = Math.abs(x)+Math.abs(y);  
                            time = ctr;
                        }
                    } else if(ch=='N'){
                        if(min>=Math.abs(x)+Math.abs(++y)){
                            min = Math.abs(x)+Math.abs(y);  
                            time = ctr;
                        }
                    }else if(ch=='E'){
                        if(min>=Math.abs(++x)+Math.abs(y)){
                            min = Math.abs(x)+Math.abs(y);  
                            time = ctr;
                        }
                    }else if(ch=='W'){
                        if(min>=Math.abs(--x)+Math.abs(y)){
                            min = Math.abs(x)+Math.abs(y);  
                            time = ctr;
                        }
                    }
                    xc[ctr]=x;yc[ctr]=y;
                    
                }

                
                if(min>s.length()){
                    System.out.println("Case #"+z+": IMPOSSIBLE");                    
                    continue;
                }
                if(xc[min]==xc[time] && yc[min]==yc[time]){
                    System.out.println("Case #"+z+": "+min);
                    continue;
                }

                ctr=min;
                boolean flag=false;
                for(i=min;i<=s.length()-1;i=i+2){
                    if(xc[i+1]==xc[time]&&yc[i+1]==yc[time]){
                        ctr++;
                        flag=true;
                        break;
                    } else if(i+2<=s.length()&&xc[i+2]==xc[time]&&yc[i+2]==yc[time]){
                        ctr++;
                        flag=true;
                        break;
                    } else{
                        ctr++;
                    }
                }
                if(flag)
                    System.out.println("Case #"+z+": "+ctr);
                else
                    System.out.println("Case #"+z+": IMPOSSIBLE");
            }
        } catch(Exception e){
            return;
        }
    }
}
