import java.util.*;
class Matrix{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int v=0;v<t;v++){
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j]=sc.nextInt();
                }
            }
            int sum=0;
            for(int l=0;l<n;l++){
                sum=sum+a[l][l];
            }
            int c=0;
            int d=0;
                      break;
                   for(int m=0;m<n;m++){
                for(int p=0;p<n;p++){
                    int b=a[m][p];
                    for(int k=0;k<n;k++){
                        if(j!=k&&a[m][k]==b){
                          c++;
                          break;
                        }
                    }
                    if(c>d){
                        d=c;
               }
                }
            }
            int e=0;
            int f=0;
            
                  for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int g=a[j][i];
                    for(int k=0;k<n;k++){
                        if(j!=k&&a[k][i]==g){
                          e++;
                          break;
                        }
                    }
                    if(e>f){
                        f=e;
               }
                }
            }
            System.out.println("Case #1: "+sum+" "+d+" "+f);
        }
    }
}