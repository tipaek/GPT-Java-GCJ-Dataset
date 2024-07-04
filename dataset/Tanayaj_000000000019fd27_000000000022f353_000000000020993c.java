import java.util.*;
class Solution{
    public static int FindTrace(int m[][],int n){
        int sum=0;
        for(int i=0;i<n;i++)
        sum+=m[i][i];
        return sum;
    }
    public static int RepeatedColumn(int m[][],int n){
        int count=0;
        for(int i=0;i<n;i++){
            Set<Integer> check = new HashSet<>();
            for(int j=0;j<n;j++){
                
            check.add(m[j][i]);
            
            if(check.size()<(j+1)){
                count++;
                break;
            }
        }
        
        
    }
    return count;
    }
    public static int RepeatedRow(int m[][],int n){
        int count=0;
        for(int i=0;i<n;i++){
            Set<Integer> check = new HashSet<>();
            for(int j=0;j<n;j++){
                
            check.add(m[i][j]);
            
            if(check.size()<(j+1)){
                count++;
                break;
            }
        }
        }
        return count;
        
        
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        for(int v=1;v<=t;v++){
            int n=sc.nextInt();
            int m[][]=new int[n][n];
            for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            m[i][j]=sc.nextInt();
            
            
            int trace= FindTrace(m,n);
            int column=RepeatedColumn(m,n);
            int row=RepeatedRow(m,n);
            
            System.out.println("Case #"+v+": "+trace+" "+row+" "+column);
            
        }
    }
}
