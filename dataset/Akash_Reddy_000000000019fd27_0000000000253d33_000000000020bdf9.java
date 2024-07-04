import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) throws IOException{
       BufferedReader rs = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(rs.readLine());
       int nn = 1;
       while(T>0){
           int n = Integer.parseInt(rs.readLine());
           int endc=0,endj=0;
           int startc=0,startj=0;
           String[] ss;
           String order="";
           boolean flag=false;
           for(int i=0;i<n;i++){
                ss = rs.readLine().split(" ");
                int a = Integer.parseInt(ss[0]);
                int b = Integer.parseInt(ss[1]);
//                System.out.println("YAYAY");
                if(!flag){
                if(a>=endc || b<=startc){
                    startc = a;
                    endc = b;
                    order+="C";
                    continue;
                }
                if(a>=endj || b<=startj){
                    startj = a;
                    endj = b;
                    order+="J";
                    continue;
                }
                if(a<endc && a<endj){
//                    System.out.println(endc+" "+endj);
                    flag=true;
                    continue;
                }
                }
               
           } 
           if(flag){
                    System.out.println("Case #"+nn+": "+"IMPOSSIBLE");
           }else{
                    System.out.println("Case #"+nn+": "+order);
           }
           nn++;
           T--;
       }
    }
}
