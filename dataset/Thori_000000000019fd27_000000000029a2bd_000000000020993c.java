import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
         Scanner s = new Scanner(System.in);
         int t = s.nextInt();
         for(int i=0; i<t; i++){
             int n = s.nextInt();
             int[][] arr = new int[n][n];
             for(int j=0; j<n; j++){
                 for(int k=0; k<n; k++){
                     arr[j][k] = s.nextInt();
                 }
             }
             int trc=0;
             for(int j=0; j<n; j++){
                 trc = trc+arr[j][j];
             }
             //rows 
             int r=0;
             for(int j=0; j<n; j++){
                 int row =0;
                 for(int k=0; k<n; k++){
                     for(int l=0; l<n; l++){
                         if(arr[j][k]==arr[j][l] && k!=l){
                             row++;
                             break;
                         }
                     }
                     if(row==1){
                         r++;
                         break;
                     }
                 }
             }
             // cols 
             int c=0;
             for(int j=0; j<n; j++){
                 int row =0;
                 for(int k=0; k<n; k++){
                     for(int l=0; l<n; l++){
                         if(arr[k][j]==arr[l][j] && k!=l){
                             row++;
                             break;
                         }
                     }
                     if(row==1){
                         c++;
                         break;
                     }
                 }
             }
              
             
         //cols 
        
          System.out.print("Case #");
          System.out.println(+t+": "+trc+" "+r+" "+c);
         }
    }
    
    }
    
        
    