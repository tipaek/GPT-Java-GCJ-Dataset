import java.lang.*;
import java.util.*;
class vestigium{
    int x=0;
    int roi=-1;
    int coi=-1;
    int ro=0;
    int co=0;
    int sum=0;
    void check(int ar[][],int n){
        int left=-1,right=-1,top=-1,down=-1;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                       x=ar[i][j];
                       left=j-1;
                       right=j+1;
                       top=i-1;
                       down=i+1;
                       for(int k=left;k>=0;k--){
                           if(ar[i][left]==x&&roi!=i){
                               ro++;
                           }
                       } 
                       for(int k=right;k<n;k++){
                           if(ar[i][k]==x&&roi!=i){
                               ro++;
                           }
                       }
                       for(int k=top;k>=0;k--){
                            if(ar[k][j]==x&&coi!=j){
                                co++;
                                break;
                            }

                        } 
                        for(int k=down;k<n;k++){
                            if(ar[k][j]==x&&coi!=j){
                                co++;
                                break;
                            }

                        }
                        if(i==j){
                            sum=sum+ar[i][j];
                        }
                            
                  }
                  
            }
            System.out.println("row"+ro+"col"+co+"sum"+sum);

    }





    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        vestigium v=new vestigium();
        for(int t=0;t<tc;t++){
            int n=sc.nextInt();
            int ar[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    ar[i][j]=sc.nextInt();
                }
            }
            v.check(ar,n);
        }
    }
}