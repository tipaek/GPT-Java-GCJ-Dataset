import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class solution{

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int notc = in.nextInt();
        for(int i=0 ; i<notc ;i++){
            in.nextLine();

            int N = in.nextInt();
            int K = in.nextInt();
            int case_no = i+1;
            int arr[][]= new int[N][N];
            if(K%N==0){
                System.out.print("\n Case #"+case_no+": POSSIBLE\n");
                for(int j = 0;j<N;j++)
                {
                    arr[j][j]=K/N;
                }
                for(int c =0;c<N;c++) {

                    int m = 0;
                    for (int d = c + 1; d < N; d++) {
                        int sub = N-m;
                        if(sub==K/N){
                            m++;
                            sub=N-m;
                        }
                        arr[c][d] = sub;
                         sub = N-m;
                        if(sub==K/N){
                            m++;
                            sub=N-m;
                        }
                        arr[d][c] = sub;
                        m++;
                    }
                }

                for(int y = 0;y<N;y++)
                {
                    for(int z =0;z<N;z++){
                        System.out.print(arr[y][z]);
                    }
                    System.out.print("\n");

                }




            }
            else{System.out.print(" Case #"+case_no+": IMPOSSIBLE\n");}

        }
    }
}
