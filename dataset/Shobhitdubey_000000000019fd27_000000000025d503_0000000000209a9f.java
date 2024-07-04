import java.util.*;
import java.io.*;

public class Solution {
     public static void main(String[] args) throws Exception{
                    Scanner y = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                  int T=y.nextInt();
                  String result[]=new String[T];
                  y.nextLine();
               for(int po=0;po<T;po++)
               {
                int a,b,n;
                String p="",s=y.nextLine();
                char c[]=s.toCharArray();
                n=c.length;
                a=Integer.parseInt(c[0]+"");
                if(p=="")
                {
                    for (int u=0;u<a ;u++ )p="("+p;
                    p=p+a;
                }
                if(n==1)
                {
                    for (int u=0;u<a ;u++ )p=p+")";
                        result[po]=p;
                        continue;
                }
              for(int i=0;i<n-1;i++)
              {
                a=Integer.parseInt(c[i]+"");
                b=Integer.parseInt(c[i+1]+"");
                
                if(a==b&&a!=0){
                    p=p+a;
                    i=i+1;
                    if(c[i]!=c[i-1])
                           for (int u=n-a;u>=0 ;u-- )
                            if(c[i-1]==c[u])
                            p=p+")";

                }
                 else if(a>b&&b!=0)
                        {
                           for (int u=0;u<a ;u++ )p=p+")";
                            for (int u=0;u<b ;u++ )p=p+"(";
                            p=p+b;
                           for (int u=0;u<b ;u++ )p=p+")";
                                
                        }
                    else if(a<b&&b!=0)
                        {
                        
                            for (int u=0;u<b ;u++ )p=p+"(";
                            p=p+b;
                           for (int u=0;u<b ;u++ )p=p+")";
                                for (int u=0;u<a ;u++ )p=p+")";   
                        }
                 if(b==0)
                    {
                                for (int u=0;u<a ;u++ )p=p+")";   
                                    p=p+b;
                    }

              }
              result[po]=p;

                }
                for(int i=0;i<T;i++)System.out.println("Case #"+(i+1)+": "+result[i]);
               }
            }