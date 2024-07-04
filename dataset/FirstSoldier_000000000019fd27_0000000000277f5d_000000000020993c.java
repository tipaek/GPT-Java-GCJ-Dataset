import java.util.ArrayList;
import java.util.Scanner;
class Mod2
{
    private int A[][];
    private int count[]=new int[2];

    public int[] getCount() {
        return count;
    }

    public void setCount(int[] count) {
        this.count = count;
    }

    public Mod2(int a) {
        A = new int[a][a];
    }

    public int[][] getA() {
        return A;
    }

    public void setA(int[][] a) {
        A = a;
    }
}

 class Mod1
{
    public static void main(String[] args)  throws java.lang.Exception
    {
        try {
            Scanner in=new Scanner(System.in);
            int testCases= in.nextInt();
            Mod2[] mod2= new Mod2[testCases];

            int [] sum=new int[testCases];
            for (int i=0;i<testCases;i++)
            {
                mod2[i]=new Mod2(in.nextInt());
                int dig=0;
                for (int k=0;k<mod2[i].getA().length;k++)
                {

                    for (int n=0;n<mod2[i].getA().length;n++)
                    {
                        mod2[i].getA()[k][n]=in.nextInt();
                        if (n==k)
                        {
                            dig=mod2[i].getA()[k][n]+dig;
                        }
                    }
                    sum[i]=dig;
                }
            }
            Mod1 mod1=new Mod1();
            for (int i=0;i<testCases;i++)
            {
                mod2[i].setCount(mod1.checkRepeats(mod2[i].getA()));
            }

            for (int i=0;i<testCases;i++)
            {
                System.out.println("Case #"+(i+1)+": "+sum[i]+" "+mod2[i].getCount()[0]+" "+mod2[i].getCount()[1]);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
       

    }


    public int[] checkRepeats(int[][] A)
    {
        int[]count=new int[2];
        count[0]=0;
        count[1]=0;
        //int s=A.length;
        int flag=0;

        ArrayList <Integer> arr1=new ArrayList<>();
        ArrayList <Integer> arr2;
        for (int i=0;i<A.length;i++)
        {
            for (int k=0;k<A.length;k++)
            {
                arr1.add(A[i][k]);
            }
            arr2=arr1;

            flag=0;
            for (int m=0;m<arr1.size();m++)
            {

                for (int n=m+1;n<arr1.size();n++)
                {
                    if (arr1.get(m)==arr2.get(n)) flag=1;
                }

            }
            if (flag==1) count[0]++;
            arr1.clear();
            arr2.clear();
        }

        for (int i=0;i<A.length;i++)
        {
            for (int k=0;k<A.length;k++)
            {
                arr1.add(A[k][i]);
            }
            arr2=arr1;
            flag=0;
            for (int m=0;m<arr1.size();m++)
            {

                for (int n=m+1;n<arr1.size();n++)
                {
                    if (arr1.get(m)==arr2.get(n)) flag=1;
                }
            }
            if (flag==1) count[1]++;
            arr1.clear();
            arr2.clear();

        }
        return count;
    }
}
