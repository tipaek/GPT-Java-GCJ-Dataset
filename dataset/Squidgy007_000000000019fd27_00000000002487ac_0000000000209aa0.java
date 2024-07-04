import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int T=scn.nextInt();
        for(int t=1;t<=T;t++){
            int N=scn.nextInt();
            int K=scn.nextInt();
            int[][] A=new int[N][N];
            boolean impossibleFlag=false;
            Queue<Integer> queue=new LinkedList<>();
            int temp=-1;
            if(K%N!=0){
                impossibleFlag=true;
            }
            else{
                for(int i=1;i<=N;i++){
                    if(K/N!=i){
                        queue.add(i);
                    }
                }
                A[0][0]=K/N;
                for(int i=1;i<N;i++){
                    temp=queue.poll();
                    A[0][i]=temp;
                    queue.add(temp);
                }
                temp=queue.poll();
                queue.add(temp);
                for(int i=1;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(i==j){
                            A[i][j]=A[0][0];
                        }
                        else{
                            temp=queue.poll();
                            A[i][j]=temp;
                            queue.add(temp);
                        }
                    }
                    temp=queue.poll();
                    queue.add(temp);
                }
            }
            if(impossibleFlag==true){
                System.out.println("Case #" + t +": "+ "IMPOSSIBLE");
            }
            else{
                System.out.println("Case #" + t +": "+ "POSSIBLE");
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        System.out.print(A[i][j]+" ");
                    }
                    System.out.println( );
                }
            }
        }
    }
}
