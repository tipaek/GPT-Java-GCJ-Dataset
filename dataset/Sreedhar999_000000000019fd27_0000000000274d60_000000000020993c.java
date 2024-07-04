import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int w=0;w<t;w++){
            int n=s.nextInt();
            int[][] ar=new int[n][n];
            int sum=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    ar[i][j]=s.nextInt();
                    if(i==j) sum+=ar[i][j];
                }
            }
            HashSet<Integer> h;
            int c=0;
            for(int i=0;i<n;i++){
                h=new HashSet<>();
                for(int j=0;j<n;j++){
                    if(h.contains(ar[i][j])){
                        c++;
                        break;
                    }
                    else{
                        h.add(ar[i][j]);
                    }
                }
            }
            int c2=0;
            for(int i=0;i<n;i++){
                h=new HashSet<>();
                for(int j=0;j<n;j++){
                    if(h.contains(ar[j][i])){
                        c2++;
                        break;
                    }
                    else{
                        h.add(ar[j][i]);
                    }
                }
            }
            
           System.out.println("Case #"+(w+1)+": "+sum+" "+c+" "+c2); 
        }
    }
}