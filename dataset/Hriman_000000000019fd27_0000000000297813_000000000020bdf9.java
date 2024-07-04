import java.util.Scanner;
class Solution{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int T=input.nextInt();
        for(int i=0;i<T;i++){
            int N=input.nextInt();
            String str="";
            int[][] A=new int[N][2];
            for(int j=0;j<N;j++){
                A[j][0]=input.nextInt();
                A[j][1]=input.nextInt();
            }
            if((A[0][1]>A[1][0])&&(A[1][1]>A[2][0]))
                str+="IMPOSSIBLE";
            else{
                str+="C";
                for(int j=0;j<N-1;j++){
                    if(A[j][1]>A[j+1][0])
                        str+="J";
                    else
                        str+="C";
                }
            }
            System.out.println("Case #"+(i+1)+": "+str);
        }
    }
}