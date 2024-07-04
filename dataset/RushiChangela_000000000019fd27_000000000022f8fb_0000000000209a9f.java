import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int z=1;z<=t;z++)
        {
            String str=in.next();
            StringBuilder sb=new StringBuilder(str);
            int i=0;int j=0;
            int flag=0;
            char arr[]={0,1,2,3,4,5,6,7,8};
            sb.append("0");
            for(int c:arr)
            {
                flag=0;
                i=0;
                j=0;
                while(j<sb.length())
                {
                    
                    if(sb.charAt(j)=='(')  
                    {
                        i++;
                        j++;
                        continue;
                    }
                    else if(sb.charAt(j)==')')
                    {
                        if(flag==0)
                        {
                            j++;
                            continue;
                        }
                        else
                        {
                            sb.insert(j,")");
                            sb.insert(i,"(");
                            j+=3;
                            i=j;
                            flag=0;
                            continue;
                        }
                    }
                    if(j==sb.length()-1 && Integer.parseInt(sb.substring(j,j+1))>c)
                    {
                        sb.append(")");
                        sb.insert(i,"(");
                        break;
                    }
                    if( Integer.parseInt(sb.substring(j,j+1))<=c && flag==0)
                    {
                        j++;
                        i++;
                        continue;
                    }
                    else if(Integer.parseInt(sb.substring(j,j+1))>c)
                    {
                        j++;
                        flag=1;
                        continue;
                    }
                    if(Integer.parseInt(sb.substring(j,j+1))<=c && flag==1)
                    {
                        sb.insert(j,")");
                        sb.insert(i,"(");
                        j+=3;
                        i=j;
                        flag=0;
                    }
                    
                }
               
            }
            sb.delete(sb.length()-1,sb.length());
            
            System.out.println("Case #"+z+": "+sb);
        }
    }
}