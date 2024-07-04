import java.io.*;
import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int T=1;
        while(T<=t){
            int n=sc.nextInt();
            int k=0,r=0,c=0,cols;
            int row[]=new int[n];
            int []col=new int[n];
            int m[][]=new int[n][n];
            
            for(int i=0;i<n;i++){
                cols=0;
                for(int j=0;j<n;j++){
                    m[i][j]=sc.nextInt();
                    if(i==j) k+=m[i][j];
                    cols+=m[i][j];
                    col[j]+=m[i][j];
                }
                row[i]=cols;
            }
            for(int i=0;i<n;i++){
                if(col[i]==n*(n+1)/2){
                	HashSet<Integer> h=new HashSet<>();
                    for(int j=0;j<n;j++){
                        
                        if(h.contains(m[j][i])){c+=1; break;}
                        else h.add(m[j][i]);}}
                else c+=1;
            }
            for(int i=0;i<n;i++){
                if(row[i]==n*(n+1)/2){
                	HashSet<Integer> h=new HashSet<>();
                    for(int j=0;j<n;j++){
                        if(h.contains(m[i][j])){r+=1; break;}
                        else h.add(m[i][j]);}}
                else r+=1;
            }
            System.out.println("Case #"+T+": "+k+" "+r+" "+c);
            T++;
        }
        sc.close();
    }
}
