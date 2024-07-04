import java.util.Scanner;
public class Matrix{
  public static void main(String[] args){
     Scanner sc=new Scanner(System.in);
     int t=sc.nexInt();
     while(t-->0){
         int n=sc.nextInt();
         int[][] mat=new int[n][n];
         int i=0,j=0,p=1;
         for(i=0;i<n;i++)
           for(j=0;j<n;j++)
              mat[i][j]=sc.nexInt();
        int sum=0,row=0,column=0;
        for(i=0;i<n;i++){
            int[] arr1=new int[n];
            int[] arr2=new int[n];
            for(j=0;j<n;j++){
                sum+=mat[i][i];
                arr1[mat[i][j]-1]++;
                arr2[mat[i][j]-1]++;
            }
            int r=0,c=0;
            for(int k=0;k<n;k++){
                if(arr1[k]>1&&r<2)
                  r++;
                if(arr2[k]>1&&c<2)
                  c++;
            }
            row+=r;
            column+=c;
    System.out.println("Case #"+p+" :"+sum+" "+row+" "+column);
    p++;    }
     }
  }
}

        
        
            
                
            
             
     
     






