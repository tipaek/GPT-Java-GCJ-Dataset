import java.util.Scanner;

public class Solution {

    public static void Vestigium(int no, int N, int [][] input)
    {
        int trace = 0;
        int row = 0;
        int col = 0;

        int [] rowCount = new int[N+1];
        int [] colCount = new int[N+1];

        for(int i=0; i<N; i++)
        {
            trace += input[i][i];
            rowCount[i] = 0;
            colCount[i] = 0;
        }

        rowCount[N] = 0;
        colCount[N] = 0;

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                rowCount[input[i][j]]++;
                colCount[input[j][i]]++;
            }

            for(int k=1; k<=N; k++)
            {
                if(rowCount[k]>1)
                {
                    row++;
                    break;
                }
            }

            for(int k=1; k<=N; k++)
            {
                if(colCount[k]>1)
                {
                    col++;
                    break;
                }
            }

            for(int k=0; k<=N; k++)
            {
                rowCount[k] = 0;
                colCount[k] = 0;
            }
        }

        System.out.println("Case #"+no+": " + trace + " " + row + " " + col );

    }

    public static void main(String[] args) {

        int cases;
        Scanner s = new Scanner(System.in);
        cases = s.nextInt();

        for(int i=1; i<=cases; i++)
        {
            int N;
            N = s.nextInt();
            int [][] input = new int[N][N];

            for(int a=0; a<N; a++)
            {
                for(int b=0; b<N; b++)
                {
                    input[a][b] = s.nextInt();
                }
            }

            Vestigium(i,N,input);
        }
    }


}
