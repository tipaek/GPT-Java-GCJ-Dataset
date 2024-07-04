import java.util.Scanner;

public class Solution {
private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int len = scanner.nextInt();
        scanner.nextLine();
        StringBuilder report = new StringBuilder();
        for(int i = 0; i < len ;i++)
        {
            char[] str = scanner.nextLine().toCharArray();
            StringBuilder sb = new StringBuilder();

             for(int j = 0; j < str.length ; j++)
             {

                 if(j == 0 || (str[j] -48) == 0)
                 {
                     addPar(sb,str[j] - 48);
                 }
                 else if((str[j] -48) <= (str[j-1] - 48))
                 {
                     shifting(sb,str[j] -48);
                 }
                 else if((str[j] -48) > (str[j-1] - 48))
                 {
                     StringBuilder ssb = new StringBuilder();
                     final int count =(str[j] - 48) - (str[j - 1] - 48);

                    for(int k = 0; k < count ; k++) sb.append("(");

                     sb.append((str[j] -48));

                     for(int k = 0; k < count ; k++) sb.append(")");

                     sb.insert(sb.length() - (str[j-1] - 48),ssb);
                 }

             }


            report.append("Case #").append(i + 1).append(": ").append(sb.toString()).append("\n");

        }
        System.out.println(report.toString());

    }

    public  static void addPar(StringBuilder sb,int num)
    {
        for(int k = 0; k < num ; k++) sb.append("(");

       sb.append(num);

        for(int k = 0; k < num ; k++) sb.append(")");


    }

    public  static void shifting(StringBuilder sb,int num)
    {
        sb.insert(sb.length() - num,num);
    }

}