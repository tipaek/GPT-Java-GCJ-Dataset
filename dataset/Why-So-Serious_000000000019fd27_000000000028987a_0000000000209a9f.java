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
            long len = str.length();
            StringBuilder sb1  = new StringBuilder(str);
            msb.append("Case #" + count +": ");
            msb.append( printPara(sb1, len) ); 
            msb.append("\n");
        }
        sc.close();
        System.out.print(msb);
    }

    private static StringBuilder printPara(StringBuilder str, long n) 
    {
        boolean startFound = false;
        for(int i = 0; i < str.length(); i++)
        {
            if( str.charAt(i) == '1' &&  !startFound)
            {
                startFound = true;
                str.insert(i, '(');
                continue;
            }
            if(startFound && str.charAt(i) != '1')
            {
                startFound = false;
                str.insert(i, ')');
            }
        }
        if(str.charAt(str.length()-1) == '1')
            str.append(')');
        return str;
    }
}
