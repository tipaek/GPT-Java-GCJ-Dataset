
/**
 *
 * @author Tanmay Deshpande (KIT College Of Engineering, Kolhapur)
 */
import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String ar[]) throws Throwable
    {
        int T,z;
        MyScanner sc = new MyScanner(); 	// use it just like normal scanner object.
        PrintWriter pw = new PrintWriter(System.out);  //use it as pw.print() or pw.println();
        
        T=sc.nextInt();

        for(z=1;z<=T;z++)
        {
            int N = sc.nextInt();
            ArrayList<String> arr = new ArrayList<String>();
            for(int i=0;i<N;i++)
            {
                String p = sc.nextLine();
                arr.add(p);
            }
            boolean flag = false;
            StringBuilder beginning= new StringBuilder("");
            
            for(int i=0;i<arr.size();i++)
            {
                String p = arr.get(i);
                if(p.charAt(0)!='*'){
                    
                    for(int j = 0; j<p.length();j++)
                    {
                       if(p.charAt(j)=='*')
                           break;
                       if(p.charAt(j)!='*')
                       {
                           if(beginning.length()<=j)
                           {
                               beginning.append(p.charAt(j));
                           }
                           else{
                               if(beginning.charAt(j)==p.charAt(j))
                               {
                                   
                               }
                               else
                               {
                                   flag = true;
                                   break;
                               }
                           }
                       }//if
                    } //for 
                   
                    
                }//if
            }//for   beginning
            //System.out.println("Beg "+beginning);
            
            
            // for ending
            StringBuilder ending= new StringBuilder("");
            for(int i=0;i<arr.size();i++)
            {
                String p = arr.get(i);
                if(p.charAt(p.length()-1)!='*'){
                    int ind = 0;
                    for(int j = p.length()-1; j>=0;j--)
                    {
                        
                       if(p.charAt(j)=='*')
                           break;
                       if(p.charAt(j)!='*')
                       {
                           if(ending.length()<=ind)
                           {
                               ending.insert(0,p.charAt(j));
                           }
                           else{
                               if(ending.charAt(ending.length()-1-ind)==p.charAt(j))
                               {
                                  
                               }
                               else
                               {
                                   flag = true;
                                   break;
                               }
                           }
                       }//if
                       ind++;
                    } //for 
                }//if
            }//for ending.
            //System.out.println("End "+ending);
            
            if(flag==true)
            {
                System.out.println("Case #"+z+": "+"*");
            }
            else
            {
                String inbetween="";
                for(int i = 0;i<arr.size();i++)
                {
                    String p = arr.get(i);
                    String sp[] = p.split("\\*");
                    if(p.charAt(0)=='*' && p.charAt(p.length()-1)=='*')
                    {
                        for(int j=0;j<sp.length; j++)
                        {
                            inbetween = inbetween +sp[j];
                        }
                    }
                    else if(p.charAt(0)=='*')
                    {
                        for(int j=0;j<sp.length-1; j++)
                        {
                            inbetween = inbetween +sp[j];
                        }
                    }
                    else if(p.charAt(p.length()-1)=='*')
                    {
                        for(int j=1;j<sp.length; j++)
                        {
                            inbetween = inbetween +sp[j];
                        }
                    }
                    else
                    {
                        for(int j=1;j<sp.length-1; j++)
                        {
                            inbetween = inbetween +sp[j];
                        }
                    }
                    
                }
                System.out.println("Case #"+z+": "+beginning+inbetween+ending);
            }
            
            
            

        }//T

    }
    
    // Fast input output stuff
    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
