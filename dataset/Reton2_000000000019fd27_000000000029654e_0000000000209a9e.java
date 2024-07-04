import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int times = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < times; i++)
        {
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < times; j++)
            {
                System.out.println(j);
                result.append(scanner.nextInt());
            }
            System.out.println(result.toString());
        }

    }
    
}
