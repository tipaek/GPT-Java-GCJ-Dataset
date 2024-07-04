import java.util.*;
import java.io.*;
public class Solution{

     public static void main(String []args){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        int count = 1;
        while(t-->0){
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            
            int count1 = 0;
            int count2 = 0;
            int trace = 0;
            
            for(int i=0; i<N; i++){
                boolean found = false;
                int[] Arr = new int[N+1];
                for(int j=0; j<N; j++){
                    arr[i][j] = sc.nextInt();
                    trace = (i==j) ? trace+arr[i][j] : trace;
                    if(!found){
                        if(Arr[arr[i][j]]==0){
                            Arr[arr[i][j]]++;
                        }else if(Arr[arr[i][j]]==1){
                            count1++;
                            found = true;
                        }
                    }
                }
            }
            
            for(int j=0; j<N; j++){
                int[] Arr = new int[N+1];
                boolean found = false;
                for(int i=0; i<N; i++){
                    if(!found){
                        if(Arr[arr[i][j]]==0){
                            Arr[arr[i][j]]++;
                        }else if(Arr[arr[i][j]]==1){
                            count2++;
                            found = true;
                        }
                    }
                }
            }
            
        System.out.println("Case #"+count+":"+" "+trace+" "+count1+" "+count2);
        count++;
        }
     }
}