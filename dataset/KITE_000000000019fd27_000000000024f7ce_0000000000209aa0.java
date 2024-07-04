import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int len= scanner.nextInt();
        scanner.nextLine();

        StringBuilder report = new StringBuilder();
       for(int i = 0; i < len ; i++)
       {
           String[] piece = scanner.nextLine().split(" ");
           int size = Integer.parseInt(piece[0]);
           int target = Integer.parseInt(piece[1]);

               if(target % size == 0  && size * size >= target)
               {
                   int start = target / size;
                   report.append("Case #").append(i + 1).append(": POSSIBLE\n");

                   for(int k = 0; k< size ; k++)
                   {
                       for(int l = 0; l < size ; l++)
                       {
                           report.append(start).append(" ");
                           if(l < size - 1)
                           {
                               if(start + 1 > size) start = 1;
                               else  start++;
                           }
                       }
                       report.append("\n");
                   }

               }
               else
                   report.append("Case #").append(i + 1).append(": IMPOSSIBLE\n");

       }

        System.out.println(report.toString());

    }

}
