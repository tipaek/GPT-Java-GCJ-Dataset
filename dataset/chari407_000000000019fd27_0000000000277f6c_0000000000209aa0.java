import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int test = 1; test <= t; test++) {

            int n = sc.nextInt();
            int k = sc.nextInt();

            if(k%n != 0)
            {
                System.out.printf("Case #%d: IMPOSSIBLE\n", test);
            }
            else
            {
                System.out.printf("Case #%d: POSSIBLE\n", test);
                int start = k/n;
                for(int i=0;i<n;i++)
                {
                    if(start == 0)
                    {
                        start = n;
                    }
                    int next = start;
                    for(int j=0;j<n;j++,next++)
                    {
                        if(next>n)
                        {
                            next =1;
                        }
                        System.out.print(next +" ");
                    }
                    start--;
                    System.out.println();
                }
            }
        }
    }
}
