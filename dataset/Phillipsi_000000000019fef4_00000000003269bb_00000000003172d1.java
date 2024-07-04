import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        try{
        
		      //BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for(int i = 1; i<=t; i++){
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                st = new StringTokenizer(br.readLine());
                long[] slice = new long[n];
                for(int j = 0; j<n; j++){
                  slice[j]=Long.parseLong(st.nextToken());
                }
                if(d == 2){
                  boolean noCut= false;
                  for(int j = 0; j<n; j++){
                     for(int k = 0; k<n; k++){
                        if(k != j && slice[j]==slice[k]){
                           noCut = true;
                        }
                     }
                  }
                  if(noCut)
                     System.out.println("Case #" + i + ": " + 0);
                  else
                     System.out.println("Case #" + i + ": " + 1); 
                }else{
                  boolean noCut= false;
                  boolean oneCut = false;
                  boolean flag = false;
                  for(int j = 0; j<n; j++){
                     int twoCounter = 0;
                     boolean hasBigger = false;
                     for(int k = 0; k<n; k++){
                        if(k != j && slice[j]==slice[k]){
                           twoCounter++;
                        }
                        if(slice[k]>slice[j]){
                           hasBigger = true;
                        }
                        if(slice[k]==slice[j]*2){
                           oneCut = true;
                        }
                     }
                  }  
                  
                  if(noCut)
                     System.out.println("Case #" + i + ": " + 0);
                  else if(oneCut)
                     System.out.println("Case #" + i + ": " + 1); 
                  else
                     System.out.println("Case #" + i + ": " + 2); 
                     

                }
            }
        }catch(IOException e){
            return;
        }
    }
    
}