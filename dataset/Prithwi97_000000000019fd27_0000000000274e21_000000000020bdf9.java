import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt(),tno=0;
        while(T-->0)
        {
            int N=sc.nextInt();
            String schedule="";
            boolean impossible=false;
            List<int[]> l=new ArrayList<int[]>();
            for(int i=0;i<N;i++)
            {
                int a[]=new int[2];
                a[0]=sc.nextInt()%1441;
                a[1]=sc.nextInt()%1441;
                l.add(a);
            }
            List<int[]> jamie=new ArrayList<int[]>();
            List<int[]> cameron=new ArrayList<int[]>();
            char turn='C';
            for(int i=0;i<N;i++)
            {
                int a[]=l.get(i);
                boolean added=false;
                if(added==false)
                {
                    int size=cameron.size();
                    if(size==0)
                    {
                        cameron.add(a);
                        schedule=schedule+'C';
                        continue;
                    }
                    boolean conflict=false;
                    for(int j=0;j<size;j++)
                    {
                        int c[]=cameron.get(j);
                        if((c[0]>=a[0] && c[1]<=a[1]) || (a[0]>c[0] && a[0]<c[1]) || (a[1]>c[0] && a[1]<c[1]))
                        {
                            conflict=true;
                            break;
                        }
                    }
                    if(conflict==false)
                    {
                        cameron.add(a);
                        schedule=schedule+'C';
                        added=true;
                    }
                }
                if(added==false)
                {
                    int size=jamie.size();
                    if(size==0)
                    {
                        jamie.add(a);
                        schedule=schedule+'J';
                        continue;
                    }
                    boolean conflict=false;
                    for(int j=0;j<size;j++)
                    {
                        int jam[]=jamie.get(j);
                        if((jam[0]>=a[0] && jam[1]<=a[1]) || (a[0]>jam[0] && a[0]<jam[1]) || (a[1]>jam[0] && a[1]<jam[1]))
                        {
                            conflict=true;
                            break;
                        }
                    }
                    if(conflict==false)
                    {
                        jamie.add(a);
                        schedule=schedule+'J';
                        added=true;
                    }
                }
                if(added==false)
                {
                    impossible=true;
                    break;
                }
            }
            if(impossible==true)
                System.out.println("Case #"+(++tno)+": IMPOSSIBLE");
            else
                System.out.println("Case #"+(++tno)+": "+schedule);
        }
    }
}