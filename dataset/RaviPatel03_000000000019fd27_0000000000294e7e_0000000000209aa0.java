import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int i=0;i<test;i++){
            int N=sc.nextInt();
            int K=sc.nextInt();
            boolean flag=false;
            int j=0;
            for(;j<N;j++){
                if(N*(j+1) ==K){
                    flag=true;
                    break;
                }
            }
            if(flag){
                int temp=j+1;
                System.out.println("Case #"+(i+1)+": POSSIBLE");
                for(int k=0;k<N;k++){
                   for(int l=0;l<N;l++){
                       if(temp > N){
                           temp=1;
                       }
                       System.out.print(temp+" ");
                       if(l!=N-1){
                           temp=temp+1;
                       }
                   }
                   System.out.println();
                }
            }else{
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            }
        }
    }
}
