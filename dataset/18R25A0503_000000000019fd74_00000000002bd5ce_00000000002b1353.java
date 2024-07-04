import java.io.*;
class Main
{
    public static void PrintPascal(int n)
    {
        for(int line=1;line<=n;line++)
        {
            int C=1;
            for(int i=2;i<=line;i++)
            {
                System.out.print(C+"");
                C=C*(line-i)/i;
            }
            System.out.println();
        }
    }
}