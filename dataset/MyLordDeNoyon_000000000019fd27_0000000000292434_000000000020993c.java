import java.util.Scanner;

public class Solution {

    public static void main(String args[])
    {

        Scanner in = new Scanner(System.in);

        String buff;
        int T, N;

        T = in.nextInt();

        for(int t = 0 ; t < T; t++)
        {
            N = in.nextInt();

            Matrice m = new Matrice(N);

            int pos = 0;
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    m.setCell(i, j, Integer.parseInt(in.next()));
                }
            }

            System.out.println("Case #"+(t+1)+": "+m.get_k()+" "+m.get_r()+" "+m.get_c());
        }

    }

}

class Matrice
{
    protected int cell[][];
    protected int N;

    public Matrice(int N)
    {
        this.N = N;
        this.cell = new int[N][N];
    }

    protected int get_k()
    {
        int sum = 0;
        for(int i = 0; i < this.N; i++)
            sum += this.cell[i][i];
        return sum;
    }

    protected int get_r()
    {
        int total = 0;
        int i, j, a, s;

        for(i = 0; i < this.N; i++)
        {
            j = 0;
            s = 0;
            while(j < this.N && s == 0)
            {
                a = j+1;
                while(a < this.N && s == 0) {
                    if (this.cell[i][j] == this.cell[i][a])
                        s++;
                    a++;
                }

                j++;
            }

            if(s > 0)
                total++;
        }

        return total;
    }

    protected int get_c()
    {
        int total = 0;
        int i, j, a, s;

        for(i = 0; i < this.N; i++) {
            j = 0;
            s = 0;
            while (j < this.N && s == 0) {
                a = j + 1;
                while (a < this.N && s == 0) {
                    if (this.cell[j][i] == this.cell[a][i])
                        s++;
                    a++;
                }

                j++;
            }

            if (s > 0)
                total++;
        }

        return total;
    }

    protected void setCell(int i, int j, int value)
    {
        this.cell[i][j] = value;
    }

    protected int getCell(int i, int j)
    {
        return this.cell[i][j];
    }
}
