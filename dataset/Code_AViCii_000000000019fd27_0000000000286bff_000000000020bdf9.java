import java.util.*;
import java.io.*;

public class Solution
{
	public static void main(String[] args)throws IOException
	{
		Scanner sc=new Scanner(System.in);
		//Scanner sc=new Scanner(new File("inp.txt"));
		
		int p,t,i,j,n,cbusy,jbusy,a[][];
        boolean impos;
        String s;
        StringBuilder sb;
        ArrayList<Pair> lst;

		p=t=sc.nextInt();

		while(t-->0)
		{
			n=sc.nextInt();
            a=new int[n][3];
            impos=false;
            
            for(i=0;i<n;i++)
            {
                a[i][0]=sc.nextInt();
                a[i][1]=sc.nextInt();
                a[i][2]=i;
            }

            Arrays.sort(a,(int ax[],int bx[])->{
                return ax[0]-bx[0];
            });

            lst=new ArrayList<Pair>();
            lst.add(new Pair('C',a[0][2]));
            cbusy=a[0][1];
            jbusy=0;
            
            for(i=1;i<n;i++)
            {
                if(a[i][0]>=cbusy)
                {
                    cbusy=a[i][1];
                    lst.add(new Pair('C',a[i][2]));
                }
                else if(a[i][0]>=jbusy)
                {
                    jbusy=a[i][1];
                    lst.add(new Pair('J',a[i][2]));
                }
                else
                {
                    System.out.println("Case #"+(p-t)+": IMPOSSIBLE");
                    impos=true;
                    break;
                }
            }

            if(impos)
                continue;

            Collections.sort(lst,(Pair ax,Pair bx)->(ax.pos-bx.pos));
            
            sb=new StringBuilder();
            for(i=0;i<n;i++)
                sb.append(lst.get(i).cc);

            System.out.println("Case #"+(p-t)+": "+sb);
		}
	}
}
class Pair
{
    char cc;
    int pos;
    Pair(char a,int b)
    {
        cc=a;
        pos=b;
    }
}