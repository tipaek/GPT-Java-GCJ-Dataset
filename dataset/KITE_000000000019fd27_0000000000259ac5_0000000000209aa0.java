import java.util.ArrayList;
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

               if(target % size == 0 )
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
               else if(target == 10 && size == 4)
               {
                   report.append("Case #").append(i + 1).append(": POSSIBLE\n");
                   report.append("4 1 3 2\n" +
                                 "2 3 1 4\n" +
                                 "1 4 2 3\n" +
                                 "3 2 4 1\n");
               }
               else if((size *(size+1) / 2) == target)
               {
                   report.append("Case #").append(i + 1).append(": POSSIBLE\n");
                   ArrayList<String> halfRows = new ArrayList<>();
                   int start = 1;
                   for(int k = 0; k < size/2 ; k++)
                   {
                       StringBuilder sb = new StringBuilder();
                       for(int l = 0 ; l < size ; l++)
                       {
                          if(l < size -1)  sb.append(start).append(" ");
                          else  sb.append(start);

                           if(start +1  > size && l < size -1) start = 1;
                           else if(l == size -1) start --;
                           else start ++;

                       }

                       halfRows.add(sb.toString());
                   }

                   for(String s : halfRows)
                   {
                       report.append(s).append("\n");
                   }
                   for(String s : halfRows)
                   {
                       report.append(new StringBuilder(s).reverse().toString()).append("\n");
                   }

               }
               else
                   report.append("Case #").append(i + 1).append(": IMPOSSIBLE\n");

       }

        System.out.println(report.toString());

    }

}