import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine().trim());
        for(int i=1; i<=t; i++)
        {
            StringBuilder sb = new StringBuilder(br.readLine().trim());
            int openBrackets=0;
            int len = sb.length(), curIndex=0;
            while(curIndex<len)
            {
                if(len-curIndex==openBrackets)
                {
                    while(openBrackets-->0)
                        sb.insert(curIndex++, ")");
                    break;
                }
                int num = sb.charAt(curIndex)-48;
                if(openBrackets==num)
                {
                    curIndex++;
                    continue;
                }
                while(openBrackets<num)
                {
                    sb.insert(curIndex++, "(");
                    len+=2;
                    openBrackets++;
                }
                while(openBrackets>num)
                {
                    sb.insert(curIndex++, ")");
                    openBrackets--;
                }
                // System.out.println(openBrackets+" "+sb.toString()+" "+len+" "+curIndex);
            }
            
            bw.write("Case #"+i+": "+sb.toString()+"\n");
        }
        
        br.close();
        bw.close();
    }
}