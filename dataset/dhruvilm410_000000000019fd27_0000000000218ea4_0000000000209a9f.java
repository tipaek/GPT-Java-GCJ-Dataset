package codejam;
import java.io.*;import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException {
     PrintWriter out=new PrintWriter(System.out);
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer str;
      //..........
        int t=Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            
        String s=br.readLine();
        char ca[]=s.toCharArray();
        ArrayList<Character> cl=new ArrayList<>();
        boolean opening=false,binary=true;
        for(char c:ca)
        {
            if(c=='0')
            {
                 if(opening==true)
                 {
                     cl.add(')');
                     opening=false;
                 }
                 cl.add(c);
            }
            else if(c=='1'){
                if(opening==false)
                {
                    cl.add('(');
                    opening=true;
                }
                cl.add(c);
            }
            else{
                binary=false;
                if(opening==false)
                {
                    cl.add('(');
                    opening=true;
                }
                cl.add(c);
            }
        }
        if(opening==true)
        {
            cl.add(')');
            opening=false;
        }
        if(binary==false){
            for(int j=1;j<=8;j++)
            {
                ArrayList<Character> temp=new ArrayList<>();
                  for(char c:cl)
                  {
                      if(c=='(')
                      {
                          temp.add('(');
                      }
                      else if(c==')')
                      {
                          temp.add(')');
                      }
                      else if(c<=(48+j))
                      {
                           if(opening==true)
                            {
                                temp.add(')');
                                opening=false;
                            }
                            temp.add(c);
                      }
                      else{
                          if(opening==false)
                          {
                            temp.add('(');
                            opening=true;
                          }
                          temp.add(c);
                      }
                  }
                  if(opening==true)
                  {
                      temp.add(')');
                      opening=false;
                  }
                  cl=temp;
                  
            }
        }
        StringBuffer sn=new StringBuffer();
        for(char c:cl)
        {
            sn.append(c);
        }
        out.println("#"+i+": "+sn);
        }
     //...........
      out.flush();
      out.close();
      
    } 
}
/*String s=br.readLine();
String s[]; s=br.readLine.split(" ");
int n=Integer.parseInt(br.readLine());
str=new StringTokenizer(br.readLine());
int n=Integer.parseInt(str.nextToken());
long n=Long.parseLong(str.nextToken());
int a[]=new int[n];
for(int i=0;i<n;i++)
{
    a[i]=Integer.parseInt(str.nextToken());
}
long a[]=new long[n];
for(int i=0;i<n;i++)
{
    a[i]=Long.parseLong(str.nextToken());
}
*/
