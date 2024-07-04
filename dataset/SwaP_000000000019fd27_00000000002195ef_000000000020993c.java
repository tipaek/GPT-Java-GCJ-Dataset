import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    public static void main(String a[])
    {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = scan.nextInt();


        for(int t = 1; t<=testCase;t++) {
            int N= scan.nextInt();
            int matrics[][] = new int[N][];
            for (int i = 0; i < N; i++) {
                matrics[i] = new int[N];
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrics[i][j] = scan.nextInt();
                }
            }

            long sum = 0;
            int r = 0, c = 0;

            for (int i = 0; i < N; i++) {
                boolean rowflag = true;
                boolean colflag = true;
                for (int j = 0; j < N; j++) {
                  
                    int row = 0;
                    int col = 0;
                   

                    int rtemp = matrics[i][j];
                    int ctemp = matrics[j][i];
                   
                    for (int k = j + 1; k < N; k++) {
                        if ((rtemp == matrics[i][k]) && rowflag) {
                            rowflag = false;
                            r++;
                        }
                        if ((ctemp == matrics[k][i]) && colflag) {
                            colflag = false;
                            c++;
                        }
                        if ((rowflag==false && colflag==false)) {
                            break;
                        }
                    }
                    if ((rowflag==false && colflag==false)) {

                        break;
                    }

                }
                sum += matrics[i][i];
            }

            System.out.println("Case #" +t+": "+ sum+" "+r+" "+c);
            sum=0;
        }
    }
}
