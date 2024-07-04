import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int tt = 1; tt <= T; tt++)
        {
            String ans = "";
            int N = in.nextInt();
            String st = "";
            String ed = "";
            ArrayList<String> mid = new ArrayList<String>(); 
            boolean fine = true;
            for(int x = 0; x < N; x++)
            {
                String crit = in.next();
                int si = crit.indexOf("*");
                int li = crit.lastIndexOf("*");
                //System.out.println(si + " " + li);
                int b = crit.length();
                boolean md = false;
                String temp = "";
                for(int y = 0; y < li; y++)
                {
                    String see = crit.substring(y, y+1);
                    if(see.equals("*"))
                    {   
                        if(!temp.equals(""))
                            mid.add(temp);
                        temp = "";
                        md = true;
                    }
                    else
                    {
                        if(md)
                        {
                            temp += see;
                        }
                        else
                        {
                            if(st.length() < y+1)
                                st += see;
                            else if(st.substring(y, y+1).equals(see))
                                continue;
                            else
                            {
                                ans = "*";
                                fine = false;
                                break;
                            }
                        }
                            
                    }
                }
                for(int y = b-1; y >= li; y--)
                {
                    String see = crit.substring(y, y+1);
                    //System.out.println(ed + " " + see);
                    if(see.equals("*"))
                        break;
                    else
                    {
                        if(ed.length() < b-y)
                            ed = see + ed;
                        else if(ed.substring(ed.length()-(b-y), ed.length()-(b-y) + 1).equals(see))
                            continue;
                        else
                        {
                            ans = "*";
                            fine = false;
                            break;
                        }
                    }
                }
            }
            if(fine)
            {
                //System.out.println("st: " +st);
                ans = st;
                for(String z: mid)
                {
                    ans += z;
                    //System.out.println("mid: " + z);
                }
                //System.out.println("end: " + ed);
                ans += ed;
            }
            System.out.println("Case #" + tt + ": " + ans);
        }
    }
}