import java.util.Scanner;

public class Solution 
{
    static StringBuilder msb  = new StringBuilder();
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);    
        int t = sc.nextInt();
        sc.nextLine();
        for(int count = 1; count <= t; count++)
        {
            String str = sc.nextLine();
            msb.append("Case #" + count +": ");
            msb.append( printPara(str.toCharArray()) ); 
            msb.append("\n");
        }
        sc.close();
        System.out.print(msb);
    }
    private static StringBuilder printPara(char ch[]) {
        StringBuilder sb = new StringBuilder();
        int i, j, len = ch.length;
        char ob = '(', cb = ')';
        int prev, cur, diff ;
        prev = Character.getNumericValue(ch[0]);
        for(i = 0; i < prev; i++)
            sb.append(ob);
        sb.append(ch[0]);
        for(i = 1; i < len; i++)
        {
            cur = Character.getNumericValue(ch[i]);
            diff = cur - prev;
            if(diff < 0)
            {
                diff = Math.abs(diff);
                for(j = 0; j < diff; j++)
                    sb.append(cb);
            }
            else if(diff > 0)
            {
                for(j = 0; j < diff; j++ )
                    sb.append(ob);
            }
            sb.append(ch[i]);
            prev = cur;
        }
        cur = Character.getNumericValue(ch[len-1]);
        for(i = 0; i < cur; i++)
            sb.append(cb);
        
        return sb;
    }

    
}