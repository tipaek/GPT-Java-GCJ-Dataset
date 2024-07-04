import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        sc.nextLine();
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for(int k=1;k<=t;++k)
        {
            String s=sc.nextLine();
            String str="";
            if(s.length()==1)
            {
                System.out.println("Case #" + k + ":" + " "+"("+s+")");
                continue;
            }
            for(int j=0;j<Character.getNumericValue(s.charAt(0));j++)
            //System.out.println(Character.getNumericValue(s.charAt(0)));
            {
                str+='(';
            }
            for(int i=0;i<s.length()-1;i++)
            {
                int temp=Character.getNumericValue(s.charAt(i));
                int next=Character.getNumericValue(s.charAt(i+1));
                str+=s.charAt(i);
                if(temp<next)
                {
                    for(int j=0;j<next-temp;j++)
                    {
                        str+='(';
                    }
                }


                if(temp>next)
                {
                    for(int j=0;j<temp-next;j++)
                    {
                        str+=')';
                    }
                }
            }
            str+=s.charAt(s.length()-1);
            for(int l=0;l<(Character.getNumericValue(s.charAt(s.length()-1)));++l)
            {
                str+=')';
            }
            System.out.println("Case #" + k + ":" + " "+str);
        }
        //sc.close();
    }
}
