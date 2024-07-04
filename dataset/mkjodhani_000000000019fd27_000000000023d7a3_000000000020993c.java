import java.util.Scanner;

public class Main02
{
    public static void main(String[] args)
    {
        int cases;
        Scanner scanner = new Scanner(System.in);
        cases=scanner.nextInt();
        Matrix[] matrices=new  Matrix[cases];
        for(int i=0;i<cases;i++)
        {
            int n;
            n=scanner.nextInt();
            matrices[i]=new Matrix(n);
            matrices[i].input();
        }
        for(int i=0;i<cases;i++)
        {
            System.out.println("Case #"+(i+1)+": "+matrices[i].trace()+" "+matrices[i].rowcount()+" "+matrices[i].colcount());
        }
    }
}
class Matrix
{
    Integer arr[][];
    int size;
    Matrix(int n)
    {
        size =n;
        arr=new Integer[n][n];
    }
    public void input()
    {
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                arr[i][j]=scanner.nextInt();
            }
        }
    }
    public  int rowcount()
    {
        int result=0;
        for(int i=0;i<size;i++)
        {
            int row=i;
            for(int x=0;x<size;x++)
            {
                for(int y=0;y<size;y++)
                {
                    if(x==y)
                        continue;
                    if(arr[row][x]==arr[row][y])
                    {
                        result++;
                        x=size;
                        break;
                    }
                }
            }
        }
        return result;
    }
    public  int colcount()
    {
        int result=0;
        for(int i=0;i<size;i++)
        {
            int col=i;
            for(int x=0;x<size;x++)
            {
                boolean flag=false;
                for(int y=0;y<size;y++)
                {
                    if(x==y)
                        continue;
                    if(arr[x][col]==arr[y][col])
                    {
                        System.out.println(x+" "+" "+y+" "+i);
                        result++;
                        flag=true;
                        break;
                    }
                }
                if(flag)
                    break;
            }
        }
        return result;
    }
    public int trace()
    {
        int t=0;
        for(int i=0;i<size;i++)
        {
            t+=arr[i][i];
        }
        return  t;
    }
}