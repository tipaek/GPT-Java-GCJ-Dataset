import java.util.Scanner;

public class Solution {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();
        for (int testcase=0; testcase<T;testcase++)
        {
            StringBuilder sb = new StringBuilder("");
            for(int j=1;j<=B;j++) {
                System.out.println(j);
                sb.append(sc.next()+"");
            }
            System.out.println(sb);
            String s= sc.next();
            if(s.equals("Y")) {
                continue;
            }else {
                System.out.println("Ento 7omar");
                break;
            }
        }
    }


}
