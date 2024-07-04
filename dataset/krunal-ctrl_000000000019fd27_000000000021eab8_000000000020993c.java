import java.util.Scanner;

class Solution
{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=1;i<=n;i++){
            System.out.print("Case #"+i+": ");
            test(in);
        }
    }
    public static void test(Scanner in){
        int n=in.nextInt();
        int[][] a=new int[n][n];
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=in.nextInt();
                if(i==j){
                    sum+=a[i][j];
                }
            }
        }
        int row=0,col=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int dup=a[i][j];
                for(int k=i;k<n;k++){
                    if(a[i][k]==dup){
                        row++;
                    }
                    if(a[k][i]==dup){
                        col++;
                    }
                }
            }
        }
        System.out.print(sum+" "+row+col+"\n");
    }
}