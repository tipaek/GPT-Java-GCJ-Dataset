import java.util.*;

class Solution{
    
    
    public static void main(String... args){
        
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=1;t<=T;t++){
            
            
            int n = in.nextInt();
            int a[][] = new int[n][n];
            int sum = 0;
            
            
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    
                    a[i][j] = in.nextInt();
                    if(i==j){
                        sum+=a[i][j];
                    }
                }
            }
            
           
            HashSet<Integer> hs = new HashSet<Integer>();
           
            int row=0;
           
            //check row
            for(int i=0;i<n;i++){
                hs.clear();
                for(int j=0;j<n;j++){
                    
                    if(hs.contains(a[i][j])){
                        row++;
                        break;
                    }
                    
                    hs.add(a[i][j]);
                }
            }
            
            
            
            int cols=0;
           
            //check cols
            for(int i=0;i<n;i++){
                hs.clear();
                for(int j=0;j<n;j++){
                    
                    if(hs.contains(a[j][i])){
                        cols++;
                        break;
                    }
                    
                    hs.add(a[j][i]);
                }
            }
            
            
            System.out.println("Case #"+t+": "+sum+" "+row+" "+cols);
            
        }
        
    }
    
}