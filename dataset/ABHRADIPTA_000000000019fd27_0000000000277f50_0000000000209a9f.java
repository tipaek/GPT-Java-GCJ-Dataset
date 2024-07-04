import java.io.*;
class Solution
{
    public static void main(String args[])throws IOException
    {
        InputStreamReader read =new InputStreamReader(System.in);
        BufferedReader in =new BufferedReader(read);
        int n,i,a,c=1,j;
        //System.out.println("Enter The Number Of Test Cases.");
        n=Integer.parseInt(in.readLine());
        String result[] =new String[n];
        for(a=0;a<n;a++)
        {
            //System.out.println("Enter The String.");
            String s=in.readLine();
            s=s+" ";
            i=0;
            String ans="";
            do
            {
                char ch=s.charAt(i);
                char ch1=s.charAt(i+1);
                if(ch==ch1)
                {
                    c++;
                    i++;
                }
                else
                {
                    String ch2=""+ch;
                    int no=Integer.parseInt(ch2);
                    if(no>0)
                    {
                        for(int k=1;k<=no;k++)
                        {
                            ans=ans+'(';
                        }
                    }
                    for(int k=1;k<=c;k++)
                    {
                        ans=ans+no;
                    }
                    if(no>0)
                    {
                        for(int k=1;k<=no;k++)
                        {
                            ans=ans+')';
                        }
                    }
                    i+=c;
                    c=1;
                }
            }while(i<s.length()-1);
            result[a]=ans;
        }
        for(a=0;a<n;a++)
        {
            System.out.println("Case #"+(a+1)+": "+result[a]);
        }
    }
}