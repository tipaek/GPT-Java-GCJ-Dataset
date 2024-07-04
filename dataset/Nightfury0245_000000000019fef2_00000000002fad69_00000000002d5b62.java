import java.io.*;
class fun
{
    public static void main()
    {
        Scanner s=new Scanner(System.in);
        int test=s.nextInt();
        for(int q=1;q<=test;q++)
        {
            int rex=s.nextInt();
            int rey=s.nextInt();
            jump(rex,rey);
        }
    }
}