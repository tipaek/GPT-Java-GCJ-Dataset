import java.util.HashSet;
import java.util.Scanner;
import java.util.sot;
public class solution
{
    private static Scanner sc;
    static int tn=1;
    public static void main(String[] args)
    {
        src=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextline();
        while(t -- >0)
        {
            solve();
        }
    }
    private static void solve()
    {
        int size=sc.nextint();
        int[][] mat=new int[size][size];
        
        int k=0;
        
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                mat[i][j]=sc.nextInt();
                if(i==j)
                    k+=mat[i][j];
            }
        }
        int r=get(mat);
        int c=get(mat);
        
        System.out.println("case #"+(tn++)+":"+k+""+r+""+c);
        

    }
    private static int getr(int[][] mat)
    {
        int res=0;
        for(int i=0;i<mat.length;i++)
        {
            set<Integer> set = new Hashset<>();
            for(int j=0;j<mat[i].length;j++)
            {
                if(set.contains(mat[i][j]))
                {
                    res++;
                    break;
                }
                set.add(mat[i][j]);
            }
        }
        return res;
    }
    private static int getc(int[][] mat)
    {
        int res = 0;
        for(int i=0;i<mat.length;i++)
        {
            set<Integer> set = new Hashset<>();
            for(int j=0;j<mat[i].length;j++)
            {
                if(set.contains(mat[i][j]))
                {
                    res++;
                    break;
                }
                set.add(mat[i][j]);
            }
        }
        return res;
    }
}