        
import java.util.*;import java.io.*;import java.math.*;import java.lang.*;

class Solution
{
   
    static int k=1;
    public static void process()throws IOException
    {
           
           String s = nln();
           String ans = "";
           char p=s.charAt(0),q=s.charAt(0),last= s.charAt(0);
           int start=0,end=0,pos=0,current=0;
           current=0;
           while(current<s.length())
           {
                  p=s.charAt(current);
                  start = current;
                  end = current;
                  pos = current;
              //    System.out.println("ans = "+ans);

                  while(pos<s.length()-1)
                  {
          //               pn("Inner while");
                         if(s.charAt(pos+1)==p)
                         {
                               pos++;
                         }
                         else
                         {
                                break;
                         }
                  }
                  current=pos;
                  end=pos;
                  current++;
          //        pn("start = "+start);
          //        pn("end = "+end);
           
                   if(ans.length()==0)
                   {
          //               pn("If 1");
                         for(int i=0;i<(int)p-48;i++)
                         {
                               ans+="(";
                         }
                         for(int i=1;i<=(end-start+1);i++)
                         {
                              ans+=p;
                         }
                         for(int i=0;i<(int)p-48;i++)
                         {
                               ans+=")";
                         }
                         q=p;
                         last=q;
          //               pn(ans);
                   }
                   else
                   {
                           
                           if((int)p > (int)q && q!=last)
                           {
            //                      pn("If 2");
                                   int len = ans.length();
                                  String s1 = ans.substring(0,len-1);
                                  for(int i=0;i<(int)q-48;i++)
                                  {
                                       s1+="(";
                                  }
                                  // for(int i=0;i<(int)p-48;i++)
                                  // {
                                  //        ans+="(";
                                  // }

                                   for(int i=1;i<=(end-start+1);i++)
                                      {
                                           s1+=p;
                                      }
                                    for(int i=0;i<(int)p-48;i++)
                                    {
                                            s1+=")";
                                    }  
                                    ans="";
                                    ans+=s1;
                                  //for(int i=0;i<(int)p-48;i++)
                                  // {
                                  //        ans+=")";
                                  // }
                                  q=p;
                                  last=q;
              //                    pn(ans);


                           }
                           else if((int)p > (int)q && q==last)
                           { 
                                  int len = ans.length();
                                  String s1 = ans.substring(0,len-((int)last-48));
                                  for(int i=0;i<(int)p-(int)last;i++)
                                  {
                                         s1+="(";
                                  }
                                    for(int i=1;i<=(end-start+1);i++)
                                     {
                                          s1+=p;
                                    }
                                   for(int i=0;i<(int)p-(int)last;i++)
                                  {
                                         s1+=")";
                                  }  
                                  for(int i=0;i<(int)last-48;i++)
                                  {
                                         s1+=")";
                                  }
                                  ans="";
                                  ans+=s1;
                                  last=p;
                                  q=p;


                                   

                           }
                           else if((int)p > (int)last && (int)p < (int)q)
                           {
                                 int len = ans.length();
                                 String s1 = ans.substring(0,len-((int)last-48));
                                // pn("Sub : "+s1);
                                 for(int i=0;i<(int)p-(int)last;i++)
                                 {
                                        s1+="(";
                                 }
                                  for(int i=1;i<=(end-start+1);i++)
                                     {
                                          s1+=p;
                                    }
                                  for(int i=0;i<(int)p-(int)last;i++)
                                 {
                                        s1+=")";
                                 }  
                                 for(int i=0;i<(int)last-48;i++)
                                 {
                                        s1+=")";
                                 }
                                 ans="";
                                 ans+=s1;
                                 last=p;


                                   
                           }
                           else
                           {
                //                   pn("If 2");
                                   int len = ans.length();
                                   String s1 = ans.substring(0,len-((int)last-48));
                                 //  pn("sub = "+s1);
                                   
                                   
                                   for(int i=0;i<((int)last-(int)p);i++)
                                   {
                                         s1+=")";
                                   }
                                   for(int i=1;i<=(end-start+1);i++)
                                     {
                                          s1+=p;
                                    }
                                    for(int i=0;i<(int)p-48;i++)
                                    {
                                           s1+=")";
                                    }
                                    ans="";
                                    ans+=s1;
                                    last = p;
                                    if((int)p==48)
                                    {
                                          q=p;
                                          last=p;
                                    }
                  //                  pn(ans);



                           }
                   }
               }

           pn("Case #"+k+": "+ans);
           k++;
           


          





         
        
      
        
    }     

            
           
    




    static AnotherReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        out = new PrintWriter(System.out);
        sc=new AnotherReader();
        boolean oj = true;

        // oj = System.getProperty("ONLINE_JUDGE") != null;
        // if(!oj) sc=new AnotherReader(100);

     //   long s = System.currentTimeMillis();
         int t=ni();//test cases
         while(t-->0)
            process();
        out.flush();
        // if(!oj)
        //   System.out.println(System.currentTimeMillis()-s+"ms");
        System.out.close();  
    }

    static void pn(Object o){out.println(o);}
    static void p(Object o){out.print(o);}
    static void pni(Object o){out.println(o);System.out.flush();}
    static int ni()throws IOException{return sc.nextInt();}
    static long nl()throws IOException{return sc.nextLong();}
    static double nd()throws IOException{return sc.nextDouble();}
    static String nln()throws IOException{return sc.nextLine();}
    static long gcd(long a, long b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int bit(long n)throws IOException{return (n==0)?0:(1+bit(n&(n-1)));}
    static boolean multipleTC=false;



/////////////////////////////////////////////////////////////////////////////////////////////////////////

    static class AnotherReader
    {
        BufferedReader br; StringTokenizer st;
        AnotherReader()throws FileNotFoundException
        {
              br=new BufferedReader(new InputStreamReader(System.in));
        }
        AnotherReader(int a)throws FileNotFoundException
        {
              br = new BufferedReader(new FileReader("input.txt"));
        }
        String next()throws IOException
        {
              while (st == null || !st.hasMoreElements()) 
                {
                    try
                     {
                               st = new StringTokenizer(br.readLine());
                     }
                    catch (IOException  e)
                    {
                               e.printStackTrace(); 
                     }
                }
                return st.nextToken(); 
        }
        int nextInt() throws IOException
        {
                return Integer.parseInt(next());
        }
        long nextLong() throws IOException
        {  
                return Long.parseLong(next());
        }
        double nextDouble()throws IOException 
        { 
               return Double.parseDouble(next()); 
        }
        String nextLine() throws IOException
        { 
               String str = ""; 
               try
               {
                     str = br.readLine();
               }
               catch (IOException e)
               {
                          e.printStackTrace();
               } return str;
        }
    }
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
    
    
    
    