import java.util.Scanner;

public class Solution {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();
        for (int remon=0; remon<T;remon++)
        {
            StringBuilder roke = new StringBuilder("");
            for(int j=1;j<=B;j++) {
                System.out.println(j);
                roke.append(sc.next());
            }
            System.out.println(roke);
            String s= sc.next();
            if(s.equals("Y")) {
                continue;
            }else {
                break;
            }
        }
    }


}