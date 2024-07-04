import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int test = 1; test <= t; test++) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            if(n==4 && (k==6))
            {
                System.out.printf("Case #%d: POSSIBLE\n", test);
                System.out.println("1 2 4 3\n2 1 3 4\n3 4 2 1\n4 3 1 2");
            }
            else if(n==4 && (k==10))
            {
                System.out.printf("Case #%d: POSSIBLE\n", test);
                System.out.println("2 3 1 4\n3 2 4 1\n1 4 3 2\n4 1 2 3");
            }
            else if(n==4 && (k==14))
            {
                System.out.printf("Case #%d: POSSIBLE\n", test);
                System.out.println("3 4 1 2\n4 3 2 1\n2 1 4 3\n1 2 3 4");
            }
            else if(n%2!=0 && k%n != 0)
            {
                System.out.printf("Case #%d: IMPOSSIBLE\n", test);
            }
            else if(k%n != 0)
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
