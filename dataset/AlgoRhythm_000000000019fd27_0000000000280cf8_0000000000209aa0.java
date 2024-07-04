import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int N=sc.nextInt();
            int K=sc.nextInt();
            if(K%N==0){
                System.out.println("Case #"+(i+1)+": POSSIBLE");
                int arr[][]=new int[N][N];
                int num[]=new int[N-1];
                int c=1;
                for(int j=0;j<N-1;j++){
                    if(c==K/N)c++;
                    num[j]=c++;
                }
                for(int j=0;j<N;j++){
                    for(int k=j;k<j+N;k++){
                        if(j==k)arr[j][k]=K/N;
                        else arr[j][k%N]=num[k-j-1];
                    }
                } 
                for(int j=0;j<N;j++){
                    for(int k=0;k<N;k++)System.out.print(arr[j][k]+" ");
                    System.out.println();
                }
            }
            else
            System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
        }
    }
}
