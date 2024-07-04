import java.util.Arrays;
import java.util.Scanner;

public class PatternMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++)
        {
            int n = sc.nextInt();
            System.out.println("Case #" + i + ":");
            test(n);
        }
    }
    public static void test(int n)
    {
        int start = 1;
        int index = 1;
        int curtotal= 0;
        while (true)
        {
            if (curtotal+start>n)
                break;
            for (int i = 1; i <= index; i++)
            {
                if (index % 2 == 1)
                    System.out.println(index + " " + i);
                else
                    System.out.println(index + " " + (index - i + 1));
            }
            curtotal += start;
            index++;
            start *= 2;
        }

        for (int i = index; i < n - curtotal + index; i++)
        {
            if (index % 2 == 0)
                System.out.println(i + " " + i);
            else
                System.out.println(i + " " + 1);

        }

    }
}
