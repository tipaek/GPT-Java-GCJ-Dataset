import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static ArrayList<int[]> tri= new ArrayList<>();


    public static int calcRow(int index)
    {
        //send index starting from 0;
        int result = 0;
        for (int j=0;j<=index;j++)
            result+= tri.get(index)[j];


        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int testcase = 1; testcase<=T;testcase++)
        {
            int N = sc.nextInt();
            tri = new ArrayList<>(N);
            for (int i = 0; i<N;i++)
            {
                tri.add(new int[i+1]);
            }
            //forming the pascal triangle
            for (int i = 0; i<N;i++)
            {
                for(int j = 0; j<=i;j++)
                {
                    if (j==0 || j==i)
                    {
                        tri.get(i)[j]=1;
                    }
                    else
                    {
                        tri.get(i)[j]= tri.get(i-1)[j-1] + tri.get(i-1)[j];
                    }
                }
            }
            System.out.printf("Case #%d:\n",testcase);

            boolean limit = false;
            boolean left = true;
            int i = 1;
            int row = 0;
            while (N>0)
            {
                if (limit)
                {
                    N--;
                    if (left)
                        System.out.println(i + " 1");
                    else
                        System.out.println(i+ " " + i);
                    i++;
                }
                else
                if ((row =calcRow(i-1))>N)
                {
                    limit = true;
                }
                else
                {
                    if (left)
                    {
                        for(int j = 1;j<=i;j++)
                            System.out.println(i + " " + j);
                    }
                    else
                    {
                        for(int j = i;j>0;j--)
                        System.out.println(i + " " + j);
                    }
                    left = !left;
                    N-= row;
                    i++;
                }
            }





            //testset 1
//            int i = 1;
//            if (N<10)
//            for(; i<=N ;i++)
//            {
//                System.out.println(i + " 1");
//            }
//            else
//            {
//                for(; i<=3;i++)
//                {
//                    System.out.println(i + " 1");
//                }
//                System.out.println("3 2");
//                System.out.println("3 3");
//                N-=3;
//                for(;i<=N;i++)
//                {
//                    System.out.println(i+" "+i);
//                }
//            }
        }
    }
}
