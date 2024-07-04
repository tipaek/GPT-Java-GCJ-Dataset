import java.io.*;
class Solution
{
    
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
              for(int z=1;z<=t;z++)
              {
                  String s=br.readLine();
                  int c_0=0,c_1=0;
                  for(int i=0;i<s.length();i++)
                  {
                      if(s.charAt(i)=='0')c_0++;
                      else c_1++;
                  }
                  
                  if(c_0==s.length())//case 1=>all 0s
                  {
                        System.out.println("Case #"+z+": "+s);  
                  }
                  else if(c_1==s.length())//case 2=>all 1s
                  {
                          System.out.println("Case #"+z+": ("+s+")");
                  }
                  else
                  {
                      int x=0;
                      String ans="";
                      boolean doit=true;
                     while(x!=s.length())
                      {
                      
                         while(x!=s.length() && s.charAt(x)!='1')
                         {
                            ans+="0";
                            x++;
                         }
                         if(x==s.length())doit=false;
                         if(doit)
                        ans+="(";
                        while(x!=s.length() && s.charAt(x)!='0')
                        {
                          ans+="1";
                          x++;
                        }
                        if(doit)
                         ans+=")";
                     
                      }
                     
                     
                    System.out.println("Case #"+z+": "+ans);
                  }
                }
        
    }
}
    
    