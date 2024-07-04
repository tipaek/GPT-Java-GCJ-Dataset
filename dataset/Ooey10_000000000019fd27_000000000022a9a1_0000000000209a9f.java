import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String [] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        
        int repeat = input.nextInt();
        input.nextLine();
        ArrayList<Integer> list;
        String base;
        String str;
        int val;
        int dif;
        for(int x = 0; x < repeat; x++)
        {
            base = input.nextLine();
            list = new ArrayList<>();
            val = 0;
            for(int i = 0; i < base.length(); i++)
            {
                list.add(Integer.parseInt(base.substring(i, i + 1)));
            }
            str = "";
            for(int i = 0; i < list.size(); i++)
            {
                dif = list.get(i) - val;
                if(dif > 0)
                {
                    for(int k = 0; k < dif; k++)
                    {
                        str += "(";
                    }
                }
                if(dif < 0)
                {
                    for(int k = 0; k < Math.abs(dif); k++)
                    {
                        str += ")";
                    }
                }
                str += list.get(i);
                val = list.get(i);
            }
            dif = val;
            for(int k = 0; k < dif; k++)
                {
                    str += ")";
                }
            System.out.println("Case #" + (x + 1) + ": " + str);
        }
        input.close();
    }
}