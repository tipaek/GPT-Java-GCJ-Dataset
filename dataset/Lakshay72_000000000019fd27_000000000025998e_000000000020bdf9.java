import java.util.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner cin=new Scanner(System.in);
        int test,n,s,e,imp=0;
        test=cin.nextInt();
        char ch;
        for(int t=1;t<=test;t++)
        {
            char arr[]=new char[1440];
            n=cin.nextInt();
            int sarr[]=new int[n];
            TreeMap<Integer,Integer> tmap=new TreeMap<>();
            for(int i=0;i<n;i++)
            {
                s=cin.nextInt();
                e=cin.nextInt();
                sarr[i]=s;
                tmap.put(s,e);
            }
            imp=0;
            for(Integer sa:tmap.keySet())
            {
                s=sa;
                e=tmap.get(s);
                //sort according to s first 
                ch='C';
                for(int j=s;j<e;j++)
                {
                    if(arr[j]==0)
                    {
                        arr[j]=ch;
                    }
                    else if(arr[j]=='C')
                    {
                        arr[j]='B';
                        ch='J';
                    }
                    else if(arr[j]=='J')
                    {
                        arr[j]='D';
                        ch='C';
                    }
                    else
                    {
                        imp=1;
                        break;
                    }
                }
                if(imp==1)
                {
                    break;
                }

            }

            //Printing
            System.out.print("Case #"+t+": ");
            if(imp==1)
            {
                System.out.println("IMPOSSIBLE");
            }
            else
            {
                for(int i=0;i<n;i++)
                {
                    if(arr[sarr[i]]=='J'||arr[sarr[i]]=='B')
                    {
                        System.out.print("J");
                    }
                    else
                    {
                        System.out.print("C");
                    }
                }
                System.out.println();
            }

        }
    }
}