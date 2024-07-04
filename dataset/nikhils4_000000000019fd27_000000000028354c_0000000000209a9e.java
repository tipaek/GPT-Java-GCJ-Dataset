import java.util.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int by = sc.nextInt();
        while(test-->0)
        {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 10; j++)
            {
                System.out.println(j + 1);
                char c = sc.next().charAt(0);
                sb.append(c);
            }
            System.out.println(sb);
            char l = sc.next().charAt(0);
            if(l == 'N' || l == 'n'){
                break;
            }
        }
    }
}