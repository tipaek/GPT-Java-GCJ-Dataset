import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().solution();
    }

    void solution()
    {
        Scanner scanner = new Scanner(System.in);

        int times = scanner.nextInt();
        for (int i = 1; i <= times; i ++)
        {
            turn(scanner, i);
        }

    }

    void turn(Scanner scanner, int i)
    {
        StringBuilder answer = new StringBuilder("Case #" + i + ":");
        int number = scanner.nextInt();
        int r = 1;
        int rc = 1;
        number --;
        answer.append("1 1");
        while (number != 0)
        {
            if (number >= r) {
                number -= r;
                answer.append(r + 1).append(" ").append(r);
                r ++;
                rc = r;
            } else {
                if (rc > 250) {
                    number --;
                    answer.append(r + 1).append(" ").append(r + 1);
                    r --;
                } else {
                    number --;
                    answer.append(r + 1).append(" ").append(r + 1);
                    r ++;
                }
            }
        }
        System.out.println(answer.toString());
    }
}