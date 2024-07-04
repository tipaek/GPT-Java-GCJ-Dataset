import java.io.*;
import java.util.*;
public class Solution{

    public static void main(String[] args) throws IOException
    {
        Scanner r = new Scanner(System.in);
        int cases = Integer.parseInt(r.nextLine());
        for(int i = 1; i <= cases; i++)
        {
            String s = r.nextLine();
            ArrayList<Character> out = new ArrayList<Character>();
            char[] dig = s.toCharArray();
            int offset = 0;
            for(char c : dig)
            {
                out.add(c);
            }
            for(int j = 0; j < dig.length; j++)
            {
                if(Character.getNumericValue(dig[j]) > nd(out, j + offset))
                {
                    while(Character.getNumericValue(dig[j]) > nd(out, j + offset))
                    {
                        out.add(j+offset, '(');
                        offset++;
                    }
                }
                else
                {
                    while(Character.getNumericValue(dig[j]) < nd(out, j + offset))
                    {
                        out.add(j+offset, ')');
                        offset++;
                    }
                }
            }
            while(nd(out, out.size()) > 0)
            {
                out.add(')');
            }
            String output = "";
            for(char c : out)
            {
                output = output + c;
            }
            System.out.println("Case #" + i + ": " + output);
        }
        
    }
    
    public static int nd(ArrayList<Character> in, int index)
    {
        int out = 0;
        for(int i = 0; i < index; i++)
        {
            if(in.get(i) == '(') out++;
            if(in.get(i) == ')') out--;
        }
        return out;
    }
    
}