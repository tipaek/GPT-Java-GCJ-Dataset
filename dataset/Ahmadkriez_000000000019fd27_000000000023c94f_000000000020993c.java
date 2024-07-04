import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner("input.in");
        File inFile = new File(args[0]);
        Scanner sc = new Scanner(inFile);

        int T = sc.nextInt();
        int N;
        
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            int k = 0;
            int r = 0;
            int c = 0;
            //int rcomp = 0;
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                    if(i == j)
                        k = M[i][j] + k;

                    //System.out.print(M[i][j]+" ");
                }
                //System.out.println();
            }
            for (int s = 0; s < N; s++) {
                out1:
                for (int i = 0; i < N; i++) {
                    for (int j = i + 1; j < N; j++) {
                        if (M[s][i] == M[s][j]) {
                            r = r + 1;
                            break out1;
                        } 
                    }
                }

                out2:
                for (int i = 0; i < N; i++) {
                    for (int j = i + 1; j < N; j++) {
                        if (M[i][s] == M[j][s]) {
                            c = c + 1;
                            break out2;
                        } 
                    }
                }
                
            }
            
            
            System.out.printf("Case #%d: %d %d %d\n",t,k, r, c);
        }

        sc.close();
    }
}