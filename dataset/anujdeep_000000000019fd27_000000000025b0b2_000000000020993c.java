import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++){
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            int r=0,c=0,trace=0;
            int status=0;
            
            for(int i=0;i<n;i++){
                status=0;
                HashSet<Integer> h=new HashSet<>();
                for(int j=0;j<n;j++){
                    a[i][j]=sc.nextInt();
                    if(h.contains(a[i][j])){
                        status=1;
                        
                    }
                    else{
                        h.add(a[i][j]);
                    }
                    
                    if(i==j){
                        trace+=a[i][j];
                    }
                }
                if(status==1)
                    r++;
                
            }
            
            for(int i=0;i<n;i++){
                status=0;
                HashSet<Integer> h=new HashSet<>();
                for(int j=0;j<n;j++){
                    if(h.contains(a[j][i])){
                        status=1;
                        break;
                    }
                    else{
                        h.add(a[j][i]);
                    }
                    
                }
                if(status==1)
                    c++;
            }
            System.out.println("Case #"+k+": "+ trace+" "+r+" "+c);
            
        }
    }
}