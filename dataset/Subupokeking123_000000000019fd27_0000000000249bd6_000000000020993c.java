import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int i=0;i<test;i++)
        {
            int trace=0,row=0,col=0;
            int N=sc.nextInt();
            int[][] arr=new int[N][N];
            for(int x=0;x<N;x++)
            {
                for(int y=0;y<N;y++)
                {
                    int temp=sc.nextInt();
                    if(x==y)
                    {
                        trace=trace+temp;
                    }
                    arr[x][y]=temp;
                }
            }
            for(int x=0;x<N;x++)
            {
                int[] t1=new int[N];
                for(int y=0;y<N;y++)
                {
                    int va=arr[x][y];
                    t1[va-1]++;
                    if(t1[va-1]>1)
                    {
                        row++;
                        break;
                    }
                }
            }
            for(int x=0;x<N;x++)
            {
                int[] t2=new int[N];
                for(int y=0;y<N;y++)
                {
                    int va=arr[y][x];
                    t2[va-1]++;
                    if(t2[va-1]>1)
                    {
                        col++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #"+(i+1)+": "+trace+" "+row+" "+col);
        }
	}
}
