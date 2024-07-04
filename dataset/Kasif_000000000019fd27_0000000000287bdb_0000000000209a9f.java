import java.util.*;
import java.io.*;
class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int k=0;k<T;k++)
        {
            String s=br.readLine();
            int n=s.length();
            int i=0;
            char c[]=s.toCharArray();
            
            ArrayList<Character> ar=new ArrayList<Character>();
            //System.out.println(c[0]);
            
                    for(int j=0;j<c[0]-48;j++)
                    ar.add('(');
                
                ar.add(c[0]);
                
                
            
            
            
               int b=0; 
            while(i<n-1)
            {
                
                
                
                if((c[i+1]==c[i])&&(i<n-1))
                {
                   // System.out.println(c[i+1]);
                    i++;
                    ar.add(c[i]);
                   
                }
                
                
                
                
               
                else if((i<n-1)&&(c[i+1]>c[i]))
                {
                    b=c[i+1]-c[i];
                     //System.out.println(c[i+1]+" "+b);
                    while(b!=0)
                    {
                        
                        ar.add('(');
                        b=b-1;
                        
                    }
                    i++;
                    ar.add(c[i]);
                   
                }
                
                
                else //((c[i+1])<(c[i])&&(i<n-1))
                {
                    b=c[i]-c[i+1];
                    //System.out.println(c[i+1]+" "+b);
                    while(b!=0)
                    {
                        ar.add(')');
                        b=b-1;
                    }
                    i++;
                    ar.add(c[i]);
                    
                }
                
                
            }
            for(int j=0;j<c[n-1]-48;j++)
                {
                    ar.add(')');
                }
            
            
            int siz=ar.size();
            String ne="";
            for(int sa=0;sa<siz;sa++)
            ne=ne+ar.get(sa);
            System.out.println("Case #"+(k+1)+": "+ne);
        }
       
    }
}
