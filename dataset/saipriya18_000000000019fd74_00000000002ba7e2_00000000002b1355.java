import java.util.*;
class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0)
        {
            int r=sc.nextInt(),c=sc.nextInt();
            int[][] a=new int[r][c];
            for(int i=0;i<r;i++)
                for(int j=0;j<c;j++)
                    a[i][j]=sc.nextInt();
            if(r==1 && c==1)
                System.out.println(a[0][0]);
        }
    }
}