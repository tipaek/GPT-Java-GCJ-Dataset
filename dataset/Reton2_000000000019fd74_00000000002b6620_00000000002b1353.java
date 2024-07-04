import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().solution();
    }

    void solution()
    {
        Scanner scanner = new Scanner(System.in);

        int times = scanner.nextInt();
        for (int i = 0; i < times; i ++)
        {
            
            turn(scanner, i);
        }

    }

    void turn(Scanner scanner, int i)
    {
        System.out.println("Case #" + (i + 1) + ":");
        int number = scanner.nextInt();
        int r = 1;
        int rc = 1;
        number --;
        System.out.println("1 1");
        while (number != 0)
        {
            if (number >= r) {
                number -= r;
                System.out.println((r + 1) + " "  + r);
                r ++;
                rc = r;
            } else {
                if (rc > 250) {
                    number --;
                    System.out.println((r + 1) + " " + (r + 1));
                    r --;
                } else {
                    number --;
                    System.out.println((r + 1) + " " + (r + 1));
                    r ++;
                }
            }
        }

    }

}