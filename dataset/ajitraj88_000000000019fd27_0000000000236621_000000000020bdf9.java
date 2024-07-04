import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String ag[])
    {
        Scanner sc=new Scanner(System.in);
        int i,j,k,l;
        int T=sc.nextInt();
        l=1;
        while(T-- >0)
        {
            int N=sc.nextInt();
            int arr[][]=new int[N][2];
            Pair A[]=new Pair[2*N];
            j=0;
            for(i=0;i<N;i++)
            {
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
                A[j]=new Pair(0,arr[i][0],i);
                j++;
                A[j]=new Pair(1,arr[i][1],i);
                j++;
            }
            Arrays.sort(A,new Tcomp());
            int B[]=new int[2*N];
            for(i=0;i<2*N;i++)
            {
                if(A[i].flag==0)
                B[i]=1;
                else 
                B[i]=-1;
            }
            boolean go=true;
            for(i=1;i<2*N;i++)
            {
                B[i]+=B[i-1];
                if(B[i]>2)
                {
                    go=false;
                    break;
                }
            }
            String str="";
            int s=-1;
            int e=-1;
            char prev=' ';
            char BB[]=new char[N];
            
            for(i=0;i<2*N;i++)
            {
                int y=A[i].id;
                j=arr[y][0];
                k=arr[y][1];
                if(A[i].flag==0)
                {
                    int id=A[i].id;
                    //System.out.println(s+" "+e);
                    if(s==-1&&e==-1)
                    {
                        BB[id]='C';
                        prev='C';
                    }
                    else if(prev=='C'&&(k<=s||j>=e))
                    {
                        BB[id]='C';
                        prev='C';
                    }
                    else if(prev=='J'&&(k<=s||j>=e))
                    {
                        BB[id]='J';
                        prev='J';
                    }
                    else if(prev=='C')
                    {
                        BB[id]='J';
                        prev='J';
                    }
                    else if(prev=='J')
                    {
                        BB[id]='C';
                        prev='C';
                    }
                    s=j;
                    e=k;
                }
            }
            for(i=0;i<N;i++)
            str+=BB[i];
            if(!go)
            System.out.println("Case #"+l+": IMPOSSIBLE");
            else 
            System.out.println("Case #"+l+": "+str);
            l++;
        }
    }
}
class Pair
{
    int flag;
    int t;
    int id;
    Pair(int f,int T,int i)
    {
        flag=f;
        t=T;
        id=i;
    }
}
class Tcomp implements Comparator<Pair>
{
     public int compare(Pair P,Pair Q)
    {
        return P.t-Q.t;
    }
}