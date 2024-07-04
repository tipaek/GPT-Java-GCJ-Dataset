import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
import java.util.*;
 
public class Solution 
{ 
   
   public static int col(int arr[][],int n){
       int c=0;
  for(int j=0;j<n;j++){
                        HashMap<Integer,Integer>h=new HashMap<>();
                        for(int k=0;k<n;k++){
                           
                            h.put(arr[k][j],1);
                                                   }
                        if(h.size()<n){
                            c++;
                        }}
   return c;
   }
    public static void main(String[] args) throws IOException 
    { 
  
       BufferedReader br = new BufferedReader( 
                              new InputStreamReader(System.in));
                
                int t = Integer.parseInt(br.readLine());
                for(int i=0;i<t;i++){
                    int n = Integer.parseInt(br.readLine());
                    int arr[][]=new int[n][n];
                    int trace=0;
                    int r=0;
                    for(int j=0;j<n;j++){
                        StringTokenizer st=new StringTokenizer(br.readLine());
                        HashMap<Integer,Integer>h=new HashMap<>();
                        for(int k=0;k<n;k++){
                            arr[j][k]=Integer.parseInt(st.nextToken());
                            h.put(arr[j][k],1);
                            if(j==k){
                                trace=trace+arr[j][k];
                            }
                        }
                        if(h.size()<n){
                            r++;
                        }
                    }
                int c= col(arr,n);
                System.out.println("Case #"+(i+1)+": "+trace+" "+r+" "+c);
                    
                }
                
                     
    }
    }