import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int x=1;x<=t;x++)
        {
            int n=sc.nextInt();
            int ar[][]=new int[n][2];
            int b[][] = new int[n][2];
            for(int k=0;k<n;k++)
            {
                for(int l=0;l<2;l++)
                {
                    ar[k][l]=sc.nextInt();
                }
            }
            //if(ar.length==0)
            //return 0;

            for(int k=0;k<n;k++)
            {
                for(int l=0;l<2;l++)
                {
                    b[k][l]=ar[k][l];
                }
            }
      
        Arrays.sort(ar,new SortEnd());
        int c=0,j=-1;
        String s="C";
        String s1="";
        for(int k=1;k<n;k++)
        {
            if(ar[k][0]>=ar[k-1][1])
            {
                s=s+"C";
                c=k;
            }
            else
            {
                if(j==-1 || ar[j][1]<=ar[k][0])
                {
                    s=s+"J";
                    j=k;
                }
                else if(ar[c][1]<=ar[k][0])
                {
                    s=s+"C";
                    c=k;
                }
                else
                {
                    j=99;
                    break;
                }
            }
        }
        if(j==99)
        System.out.println("IMPOSSIBLE");
        else
        {
            for(int i=0;i<n;i++)
            {
                for(int y=0;y<n;y++)
                {
                    if(b[i][0]==ar[y][0])
                    {
                        s1=s1+s.charAt(y);
                    }
                }
            }
            System.out.println(s1);
        }
        
        
            
        }
    }
    
}
class SortEnd implements Comparator<int[]>{
        public int compare(int a[],int b[]){
            return a[1]-b[1];
        }
    }