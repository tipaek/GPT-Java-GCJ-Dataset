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
           int[] ars = new int[n];
           int[] are = new int[n];  
           int[] aroa = new int[n];
           int[] arob = new int[n];
           String[] ss;
           String order="";
           boolean flag=false;
           int endc = 0,endj=0,startc=0,startj=0;
          for(int i=0;i<n;i++){
                ss = rs.readLine().split(" ");
                ars[i] = Integer.parseInt(ss[0]);
                are[i] = Integer.parseInt(ss[1]);
                aroa[i] = ars[i];
                arob[i] = are[i];
//                aro[i] = i;
           } 
          for (int i = 0; i < n-1; i++){ 
            for (int j = 0; j < n-i-1; j++){
                if (are[j] > are[j+1]) 
                { 
                    int temp = are[j]; 
                    are[j] = are[j+1]; 
                    are[j+1] = temp; 
                    
                    temp = ars[j]; 
                    ars[j] = ars[j+1]; 
                    ars[j+1] = temp;
                    
//                    temp = aro[j]; 
//                    aro[j] = aro[j+1]; 
//                    aro[j+1] = temp;
                } 
            }
          }
          
          for(int i=0;i<n;i++){
              if(!flag){
                 if(ars[i]>=endc){
                  endc = are[i];
                  order+="C";
                  continue;
                }
                if(ars[i]>=endj){
                  endj = are[i];
                  order+="J";
                  continue;
                }
                if(ars[i]<endc && ars[i]<endj){
                    flag = true;
                    break;
                }
              }
              
          }
//          endc = 0;
//          endj=0;
//          if(!flag){
//             for(int i=0;i<n;i++){
//              if(!flag){
//                if(aroa[i]>=endc || arob[i]<=startc){
//                    startc = aroa[i];
//                    endc = arob[i];
//                    order+="C";
//                    continue;
//                }
//                if(aroa[i]>=endj || arob[i]<=startj){
//                    startj = aroa[i];
//                    endj = arob[i];
//                    order+="C";
//                    continue;
//                }
//                if(aroa[i]<endc && aroa[i]<endj){
//                    flag=true;
//                    break;
//                }
//              }
//              
//          } 
//          }
          
          
//        System.out.println(Arrays.toString(aroa)+" "+Arrays.toString(arob));
            if(flag){
                    System.out.println("Case #"+nn+": "+"IMPOSSIBLE");
           }else{
                    System.out.println("Case #"+nn+": "+order+" ");
           }
           nn++;
           T--;
       }
    }
}
