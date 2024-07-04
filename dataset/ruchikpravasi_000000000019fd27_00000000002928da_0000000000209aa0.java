import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = 0;
        if (scanner.hasNextInt()) {
            numberOfTestCases = scanner.nextInt();
        }
        int [][]d=new int[numberOfTestCases][3];
        for (int x=0;x<numberOfTestCases;x++){
            if (scanner.hasNextInt()) {
                d[x][0] = scanner.nextInt();
                d[x][1] = scanner.nextInt();
            }
        }


        for (int c = 0; c < numberOfTestCases; c++) {
            int N = d[c][0], K = d[c][1];

            int [][]squarematrix=new int[N][N];
            int t=0,k=0,l=0;
            Boolean flag=true;
            if (K%N==0){

                for (int i=0;i<N;i++) {
                    for (int j = 0; j < N; j++) {
                        if (i == j) {
                            squarematrix[i][j] = K / N;
                        }
                    }
                }

                for (int i=0;i<N;i++){
                    for (int j=0;j<N;j++){
                        if (i<j){
                            t=squarematrix[i][j-1];
                            if (t<N) {
                                t=t+1;
                                squarematrix[i][j] = t;
                            }
                            else if (t>N){
                                t=t%N;
                                squarematrix[i][j]=t;
                            }
                            else {
                                t=t%N+1;
                                squarematrix[i][j]=t;
                            }
                        }
                        else if (i>j){
                            k=j+N;
                            l=k-i;
                            t=(squarematrix[i][i]+l)%N;
                            if (t==0) {
                                squarematrix[i][j] = N;
                            }
                            else {
                                squarematrix[i][j]=t;
                            }

                        }
                    }
                }

                System.out.println("Case #"+(c+1)+": POSSIBLE");
                for (int i=0;i<N;i++){
                    for (int j=0;j<N;j++){
                        System.out.print(squarematrix[i][j]+" ");
                    }
                    System.out.println();
                }
            }
            else {
                System.out.println("Case #"+(c+1)+": IMPOSSIBLE");
            }

        }

        scanner.close();
    }
}