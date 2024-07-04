
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            for (int k = 1; k <= t; ++k) {
                String [] s=br.readLine().split("");
                StringBuilder out=new StringBuilder();
                int currLevel=0;
                for(String s1:s)
                {
                    int val=Integer.parseInt(s1);
                    if(val>=currLevel){
                        for(int i=currLevel;i<val;i++)
                        {
                            out.append('(');
                            currLevel++;
                        }
                    }
                    else
                    {
                        for(int i=currLevel;i>val;i--)
                        {
                            out.append(')');
                            currLevel--;
                        }
                    }
                    out.append(val);
                }
                for(int j=currLevel;j>0;j--)
                    out.append(')');

                System.out.println("Case #" + k + ": " +out.toString());
            }


    }
}