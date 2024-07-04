import java.util.*;
class Vestigium{
    static int findTrace(int M[][], int N){
        int k = 0; //trace
        for(int i=0;i<N;i++)
          k +=M[i][i];
        return k;
    }
    static int countIdenticalRows(int M[][], int N){
        int r=0; //row count
        for(int i=0;i<N;i++){
            HashSet<Integer> hs = new HashSet<>();
            for(int j=0;j<N;j++){
                hs.add(M[i][j]);
            }
            if(hs.size()==1)
              r=r+2;
        }
        return r;
    }
    static int countIdenticalColumns(int M[][], int N){
        int c = 0; //column count
        for(int i=0;i<N;i++){
            HashSet<Integer> hs=new HashSet<>();
            for(int j=0;j<N;j++){
                hs.add(M[j][i]);
            }
            if(hs.size()==1)
              c=c+2;
        }
        return c;
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); //test cases
        int N = in.nextInt(); //size of matrix
        int M[][] = new int[N][N];
        for(int i=0;i<N;i++){
            for(int k=0;k<N;k++){
                M[i][k]=in.nextInt();
            }
        }
        for(int j=1;j<=T;j++){
            System.out.print("Case #"+j+": "+findTrace(M,N));
            System.out.print(" "+countIdenticalRows(M,N));
            System.out.print(" "+countIdenticalColumns(M,N));
            System.out.println();
        }
    }
}