import java.util.*;
class Solution{
    public static  void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        for(int ii=1;ii<=t;ii++){
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            int trac=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                    if(i==j)
                        trac+=arr[i][j];
                }
            }

            int row=0,col=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int x=arr[i][j];
                    int f=0;
                    for(int k=j+1;k<n;k++){
                        if(arr[i][k]==x){
                            f=1;
                            break;
                        }
                    }
                    if(f==1)
                    {
                        row++;
                        break;
                    }
                }
            }

            for(int j=0;j<n;j++){
                for(int i=0;i<n;i++)
                {
                    int x=arr[i][j];
                    int f=0;
                    for(int k=i+1;k<n;k++){
                        if(arr[k][j]==x){
                            f=1;
                            break;
                        }
                    }
                    if(f==1){
                        col++;
                        break;
                    }
                }
            }

            sb.append("Case #");
            sb.append(ii+": ");
            sb.append(trac+" "+row+" "+col);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}