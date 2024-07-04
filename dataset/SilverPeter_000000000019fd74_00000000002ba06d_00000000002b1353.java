import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static ArrayList<int[]> tri= new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int testcase = 1; testcase<=T;testcase++)
        {
            StringBuilder result = new StringBuilder();
            int N = sc.nextInt();
            tri = new ArrayList<>(N);
            for (int i = 0; i<N;i++)
            {
                tri.add(new int[i+1]);
            }
            //forming the pascal triangle
//            for (int i = 0; i<N;i++)
//            {
//                for(int j = 0; j<N;j++)
//                {
//                    if (j==0 || j==i)
//                    {
//                        tri.get(i)[j]=1;
//                    }
//                    else
//                    {
//                        tri.get(i)[j]= tri.get(i-1)[j-1] + tri.get(i-1)[j];
//                    }
//                }
//            }
            System.out.printf("Case #%d:\n",testcase);
            for(int i =1; i<=N;i++)
            {
                System.out.println(i + " 1");
            }
        }
    }
}
