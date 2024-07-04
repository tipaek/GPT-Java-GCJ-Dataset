import java.util.*;
import java.io.*;
class Solution
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine().trim());
        for(int i=1; i<=t; i++)
        {
            int u = Integer.parseInt(br.readLine().trim());
            int num = 10000;
            HashSet<Character> chars[] = new HashSet[10];
            HashSet<Character> nonZero = new HashSet<>();
            for(int j=0; j<10; j++)
                chars[j] = new HashSet<>();
            while(num-->0)
            {
                String in[] = br.readLine().trim().split("\\s+");
                long q = Long.parseLong(in[0]);
                int qLen = in[0].length();
                //in[1] is string R
                
                char c = in[1].charAt(0);
                int len = in[1].length();
                if(q!=-1 && len==1)
                {
                    if(chars[0].contains(c))
                    {
                        chars[0].remove(c);
                        nonZero.add(c);
                    }
                }
                else if(q!=-1 && len==qLen)
                {
                    int maxVal = in[0].charAt(0)-'0';
                    if(chars[0].contains(c) || (nonZero.contains(c) && chars[1].contains(c)) )
                    {
                        for(int j=1; j<=maxVal; j++)
                        {
                            if(!chars[j].contains(c))
                            {
                                maxVal = j-1;
                                break;
                            }
                        }
                    }
                    int j = nonZero.contains(c) ? 1 : 0;
                    for(; j<=maxVal; j++)
                        chars[j].add(c);
                    for(j=maxVal+1; j<=9; j++)
                    {
                        if(chars[j].contains(c))
                            chars[j].remove(c);
                        else
                            break;
                    }
                }
                else
                {
                    if(!chars[0].contains(c) && !nonZero.contains(c))
                        for(int j=0; j<=9; j++)
                            chars[j].add(c);
                    else if(nonZero.contains(c))
                        for(int j=1; j<=9; j++)
                            chars[j].add(c);
                }
                for(int j=1; j<len; j++)
                {
                    c = in[1].charAt(j);
                    int k = nonZero.contains(c) ? 1 : 0;
                    for(; k<=9; k++)
                    {
                        if(!chars[k].contains(c))
                            chars[k].add(c);
                        else
                            break;
                    }
                }
            }
            char[] ans = new char[10];
            HashSet<Character> used = new HashSet<>();
            
            for(int k=0; k<=9; k++)
            {
                for(int j=0; j<=9; j++)
                {
                    if(chars[j].size()==1)
                    {
                        Iterator itr = chars[j].iterator();
                        while(itr.hasNext())
                        {
                            char ch = (char)itr.next();
                            ans[j] = ch;
                            used.add(ch);
                        }
                        chars[j].clear();
                    }
                    else
                    {
                        chars[j].removeAll(used);
                    }
                }
            }
            
            for(int j=9; j>=0; j--)
            {
                if(ans[j]!='\u0000')
                    continue;
                char ch='?';
                Iterator itr = chars[j].iterator();
                while(itr.hasNext())
                {
                    ch = (char)itr.next();
                    if(!used.contains(ch))
                        break;
                }
                ans[j]=ch;
                used.add(ch);
            }
            bw.write("Case #"+i+": "+String.valueOf(ans)+"\n");
        }
        
        
        br.close();
        bw.close();
    }
}