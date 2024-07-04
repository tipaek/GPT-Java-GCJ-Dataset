import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            String s=br.readLine();
            ArrayList<Character> ans=new ArrayList<>();
            int ones=0;
            System.out.print("Case #"+(i+1)+": ");
            for(int j=0;j<s.length();j++)
            {
                if(s.charAt(j)=='1')
                {
                    if(ones==0)
                    {
                        System.out.print("(");
                    }
                    ones++;
                    System.out.print("1");
                    if(j==s.length()-1)
                    {
                        System.out.print(")");
                    }
                }
                else{
                    if(ones!=0)
                    {
                        ones=0;
                        System.out.print(")");
                    }
                    System.out.print("0");
                }
                
            }
            System.out.println();
        }
    }
}