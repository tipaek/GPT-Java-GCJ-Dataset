import java.util.Scanner;
class Solution{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int T=input.nextInt();
        for(int i=0;i<T;i++){
            int N=input.nextInt();
            int[][] A=new int[N][N];
            int trace=0;
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    A[j][k]=input.nextInt();
                    if(j==k)
                        trace+=A[j][k];
                }
            }
            int a=0;
            int b=0;
            for(int j=0;j<N;j++){
                int[] count=new int[200];
                for(int k=0;k<N;k++){
                    if(count[A[j][k]]==1){
                        a+=1;
                        break;
                    }
                    else
                        count[A[j][k]]++;
                }
            }
            for(int j=0;j<N;j++){
                int[] count=new int[100];
                for(int k=0;k<N;k++){
                    if(count[A[k][j]]==1){
                        b+=1;
                        break;
                    }
                    else
                        count[A[k][j]]++;
                }
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+a+" "+b);
        }
    }
}