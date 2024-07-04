import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int l=0;l<t;l++){
            int n=sc.nextInt();
            int[][] a=new int[n][n];
            int trace=0;
            int dr=0,dc=0,flag;
            for(int i=0;i<n;i++){
                HashSet<Integer> h=new HashSet<>();
                flag=0;
                for(int j=0;j<n;j++){
                    a[i][j]=sc.nextInt();
                    
                    if(h.contains(a[i][j])) flag=1;
                    else h.add(a[i][j]);
                    if(i==j)
                      trace+=a[i][j];
                }
                if(flag==1) dr++;
            }
            
            for(int j=0;j<n;j++){
                HashSet<Integer> h=new HashSet<>();
                for(int i=0;i<n;i++){
                    if(h.contains(a[i][j])){
                        dc++;break;
                    }
                    else h.add(a[i][j]);
                }
            }
            System.out.println("Case #"+(l+1)+": "+trace+" "+dr+" "+dc);
            
        }
    }
}