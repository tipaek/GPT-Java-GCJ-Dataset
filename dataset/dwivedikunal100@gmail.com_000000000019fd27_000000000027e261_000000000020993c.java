import java.util.*;
class Solution{
    
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        
        int t=in.nextInt();
       
        
        for(int z=1;z<=t;z++){
            int n=in.nextInt();
            int ar[][]=new int[n][n];
            int a=0,b=0,c=0;
            for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
            ar[i][j]=in.nextInt();
            if(i==j)a+=ar[i][j];
            }
            }
            //done with input and calculating a
            
            for(int i=0;i<n;i++)
            {
                 HashSet<Integer> set=new HashSet<>();
                for(int j=0;j<n;j++){
                    if(set.contains(ar[i][j])){
                        b++;break;
                    }
                    set.add(ar[i][j]);
                }
                
            }
            //done with rows
                       for(int i=0;i<n;i++)
            {
                 HashSet<Integer> set=new HashSet<>();
                for(int j=0;j<n;j++){
                    if(set.contains(ar[j][i])){
                        c++;break;
                    }
                    set.add(ar[j][i]);
                }
                
            }
            //done with columns
            
            
            
            
            System.out.println("Case #"+z+": "+a+" "+b+" "+c);
        }
        
    }
    
    
}