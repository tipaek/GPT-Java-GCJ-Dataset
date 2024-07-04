import java.util.Scanner;

public class Solution {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int matrix = in.nextInt();

        for(int i = 0; i < matrix; i++)
        {
            int size = in.nextInt();
            int[][] something = new int[size][size];
            for(int j = 0; j < size; j++)
            {
                for(int k = 0; k < size; k++)
                {
                    int var = in.nextInt();
                    something[j][k] = var;
                }
            }

            int countrow = 0;
            for(int col = 0; col < something.length; col++) {
                for (int y = 0; y < something.length - 1; y++) {
                    for (int z = y + 1; z < something.length; z++) {
                        if (something[y][col] == something[z][col]) {
                            countrow++;
                            break;
                        }
                    }
                    if(countrow > 0)
                        break;
                }
            }

            int countcol = 0;
            for(int col = 0; col < something.length; col++) {
                for (int y = 0; y < something.length - 1; y++) {
                    for (int z = y + 1; z < something.length; z++) {
                        if (something[col][y] == something[col][z]) {
                            countcol++;
                            break;
                        }
                    }
                    if(countcol > 0)
                        break;
                }
            }

            System.out.println("Case #" + (i+1) + ": " + trace(something) + " " + countcol + " " + countrow);
        }
        in.close();
    }

    public static int trace(int[][] n)
    {
        int sum = 0;
        for(int i = 0; i < n.length; i++)
        {
            sum += n[i][i];
        }
        return sum;
    }
}
