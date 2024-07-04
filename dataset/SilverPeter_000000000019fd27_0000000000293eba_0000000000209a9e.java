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
                sb.append(sc.next().charAt(0));
            }
            System.out.println(sb);
            char s= sc.next().charAt(0);
            if(s == 'Y') {
                continue;
            }else {
                System.out.println("Ento 7omar");
                break;
            }
        }
    }


}
