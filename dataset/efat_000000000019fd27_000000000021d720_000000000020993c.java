import java.util.*;
class Main {
  public static void main (String[] args){
    
    Scanner sc= new Scanner(System.in);
    
    int test=sc.nextInt();
    
    for(int i=1;i<=test;i++){
      int n=sc.nextInt();
      int[][] array= new int[n][n];
      boolean[] row =new boolean[n];
      boolean[] col= new boolean[n];
      
      for(int ii=0;ii<array.length;ii++){
        for(int j=0;j<array[ii].length;j++){
          array[ii][j]=sc.nextInt();
          
        }
        
        
      }
      for(int r=0;r<array.length;r++){
        for(int j=0;j<array[r].length;j++){
          
          if(row[r]==true){
            break;
          }
          else{
            int x= array[r][j];
            for(int k=j+1;k<array[r].length;k++){
              if(array[r][k]==x){
                row[r]=true;
                break;
              }
            }
          }
        }
      }
      
      for(int c=0;c<n;c++){
        for(int r=0;r<n;r++){
          if(col[c]==true){
            break;
          }else{
            
            int x= array[r][c];
            for(int j=r+1;j<n;j++){
              if(array[j][c]==x)
              {
                col[c]=true;
                break;
              }
              
            }
            
          }
          
          
          
        }
      }
      
      
      int c=0,r=0,sum=0;
      for(int k=0;k<n;k++){
        if(row[k]==true){
          r++;
        }
        if(col[k]==true){
          c++;
        }
        sum+=array[k][k];
      }
      
      
      System.out.println("Case #"+i+": "+ sum+" "+r+" "+c);
    }
  }
}