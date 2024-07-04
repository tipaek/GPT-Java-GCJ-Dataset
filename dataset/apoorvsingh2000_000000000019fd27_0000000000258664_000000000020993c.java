import java.util.*;
class easy{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int N=sc.nextInt();
        int k=0;int r=0;int c=0;
        int array[][] = new int[N][N];

        for (int i=0;i<N;i++){

            for (int j=0;j<N;j++){
                array[i][j]=sc.nextInt();

                if (i==j){
                    k+=array[i][j];
                }
            }
        }
        for (int m=0;m<N;m++){
            for (int n=0;n<N;n++){
                if (n+1!=N) {
                    if (array[m][n] == array[m][n + 1]) {
                        r += 1;
                    }
                }
                if (m+1!=N) {
                    if (array[m][n] == array[m + 1][n]) {
                        c += 1;
                    }
                }
            }
        }
        System.out.print(k);
        System.out.print(r);
        System.out.print(c);
    }
}