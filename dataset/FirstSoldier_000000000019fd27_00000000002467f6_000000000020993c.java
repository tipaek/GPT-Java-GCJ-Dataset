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

public class Mod1
{
    public static void main(String[] args)
    {
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
           System.out.println("Case #"+i+": "+sum[i]+" "+mod2[i].getCount()[0]+" "+mod2[i].getCount()[1]);
       }

//       System.out.println(sum[0]);
//       System.out.println(sum[1]);
//       System.out.println(sum[2]);










    }


    public int[] checkRepeats(int[][] A)
    {
        int[]count=new int[2];
        count[0]=0;
        count[1]=0;
        int s=A.length;
        int flag=0;

                for (int i = 0; i < s; i++)
                {
                    for (int k = 0; k < s-1; k++)
                    {
                        if (A[i][k] == A[i][k +1]) flag = 1;
                    }
                    if (flag == 1) count[0]++;
                }

            for (int i = 0; i < s; i++)
            {
                for (int k = 0; k < s-1; k++)
                {
                    if (A[k][i] == A[k + 1][i]) flag = 1;
                }
                if (flag == 1) count[1]++;
            }
        return count;

    }
}
