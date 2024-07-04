import java.util.*;

class Solution
{
    public static void main(String [] args)
    {
    Scanner kb = new Scanner(System.in);
    int T = kb.nextInt();
    int N,k,r,c;
    boolean check;
    
    for(int i=0;i<T;i++)
    {
    N = kb.nextInt();
    int [][] arr = new int [N][N];
    k=0;
    r=0;
    c=0;
    
    for(int a=0;a<N;a++)
    {
        for(int b=0;b<N;b++)
        {
            arr[a][b] = kb.nextInt();
            if(a==b)
            {
            k += arr[a][b];
            }
        }
    }
    
    for(int x=0;x<N;x++)
    {
        check=true;
        for(int a=0;a<N;a++)
        {
            for(int b=a+1;b<N;b++)
            {
                if(arr[x][a]==arr[x][b])
                {
                check = false;
                break;
                }
            }   
        }
        if(check==true)
        {
            r++;
        }
    }
    
    for(int x=0;x<N;x++)
    {
        check=true;
        for(int a=0;a<N;a++)
        {
            for(int b=a+1;b<N;b++)
            {
                if(arr[a][x]==arr[b][x])
                {
                check = false;
                break;
                }
            }   
        }
        if(check==true)
        {
            c++;
        }
    }
    
    System.out.println("Case #"+(i+1)+": "+k+" "+(N-r)+" "+(N-c));
    }
    
    
    }
}