import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int t1 = 0; t1 < t; t1++) {

            String s = scan.next();
            String a = "";
            int d = 0;
            System.out.print("\nCase #" + (t1 + 1) + ": " );
            for (int i = 0; i < s.length(); i++) {

                if(d<(s.charAt(i)-48)){
                    while(s.charAt(i)-48-d!=0)
                    {
                        System.out.print("(");
                        d++;
                    }
                    System.out.print(s.charAt(i));
                }
                else if(d == (s.charAt(i)-48)) System.out.print(s.charAt(i));
                else if(d>(s.charAt(i)-48)){
                    while(d+48-s.charAt(i)!=0)
                    {
                        System.out.print(")");
                        d--;
                    }
                    System.out.print(s.charAt(i));
                }
            }

            while(d!=0)
            {
                System.out.print(")");
                d--;
            }
            System.out.print("\n");
        }
    }
}
