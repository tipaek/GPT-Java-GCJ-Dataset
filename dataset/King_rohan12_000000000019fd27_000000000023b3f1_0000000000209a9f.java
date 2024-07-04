import java.io.*;
import java.util.*;
public class Solution
{
    String addPara(String strNum)
    {
        int cnt=0;
        String strPara="",str="";
        if(strNum.length()==1&&!strNum.equals("0"))
        {
            strPara = "("+strNum+")";
            return strPara;
        }
        for(int i=0;i<strNum.length(); i++)
        {
            str = strNum.charAt(i)+"";
            if(!str.equals("0")&&cnt==0)
            {
                strPara += "(";
                strPara += str;
                cnt=1;
            }
            else if(str.equals("0")&&cnt==1)
            {
                strPara+=")";
                strPara+=str;
                cnt=0;
            }
            else
                strPara+=str;
        }
        if(!str.equals("0"))
            strPara+=")";
        return strPara;
    }
    public static void main(String args[])
    {
        Solution cj = new Solution();
        Scanner sc =new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String strNum;
        int tcase = sc.nextInt();
        for(int t=1;t<=tcase;t++)
        {
            strNum = sc.next();
            System.out.println("Case #"+t+": "+cj.addPara(strNum));
        }
    }
}