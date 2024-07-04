import java.util.*;
class google
{
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        int t,n,i,j,k,c=0,r=0,b=0,s=0,l;
        t=sc.nextInt();
        ArrayList<Integer> al=new ArrayList<>();
        ArrayList<Integer> bl=new ArrayList<>();
        ArrayList<Integer> cl=new ArrayList<>();
        for(k=0;k<t;k++)
        {
            n=sc.nextInt();
            int a[][]=new int[n][n];
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                    if(i==j)
                    {
                        b+=a[i][j];
                    }
                }
            }
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    al.add(a[j][i]);
                    bl.add(a[i][j]);
                }
                Collections.sort(al);
                Collections.sort(bl);
                // System.out.println(al);
                // System.out.println(bl);
                for(l=0;l<n-1;l++)
                {
                    if(bl.get(l).equals(bl.get(l+1)))
                    {
                        r++;
                        break;
                    }
                }
                for(l=0;l<n-1;l++)
                {
                    if(al.get(l).equals(al.get(l+1)))
                    {
                        c++;
                        break;
                    }
                }
                al.clear();
                bl.clear();
            }
            cl.add(b);cl.add(r);cl.add(c);
            //System.out.println(b+" "+r+" "+c);
            b=0;r=0;c=0;
        }
        s=cl.size();
        r=1;
        System.out.print("Case "+"#"+r+": ");
        for(i=0;i<s;i++)
        {
            System.out.print(cl.get(i)+" ");
            if((i+1)%3==0 && i<s-1)
            {
                System.out.println();
                r++;
                System.out.print("Case "+"#"+r+": ");
            }
        }
    }
}