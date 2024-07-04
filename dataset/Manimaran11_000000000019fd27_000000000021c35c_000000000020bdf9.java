

import java.io.*;
import java.util.*;

public class codejam1{
    public static void main(String[] args)  throws Exception{

    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    int y=1;
    while(t>0){
        System.out.print("Case #"+y+": ");
        int n = Integer.parseInt(br.readLine());
        int [][]arr = new int[n][2];
        for(int i=0;i<n;i++){
            String []s = br.readLine().split(" ");
            arr[i][0]=Integer.parseInt(s[0]);
            arr[i][1]=Integer.parseInt(s[1]);
        }
        Arrays.sort(arr,((i1,i2)->i1[0]-i2[0]));
        int ce,je=0;
        ce = arr[0][1];
        StringBuilder sb = new StringBuilder();
        sb.append("C");
        for(int i=1;i<n;i++){
            if(ce<=arr[i][0]){
                ce = arr[i][1];
                sb.append("C");
            }
            else if(je<=arr[i][0]){
               je = arr[i][1];
                sb.append("J"); 
            }
            else{
                sb.setLength(0);
                sb.append("IMPOSSIBLE");
                break;
            }
        }
        System.out.print(sb.toString());
        System.out.println();
        t--;
        y++;
    }
}

}