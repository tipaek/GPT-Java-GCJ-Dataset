import java.util.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.stream.Collectors;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution {
    // final static int MAX_FACT = 20;
    // final static int MAX_CHAR = 26;
    // static long fact[] = new long[MAX_FACT];

    public static void main(String[] args) throws java.lang.Exception {
        Comparator<String> lengthComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length())
                {
                    return o1.compareTo(o2);
                }
                else {
                    return Integer.compare(o1.length(), o2.length());
                }

            }
        };
        FastReader sc = new FastReader();
        BufferedWriter w=new BufferedWriter(new PrintWriter(System.out));
        int t = sc.nextInt();
        for(int i=0;i<t;i++)
        {
           // System.out.println("enter the value of N");
            int n=sc.nextInt();
            String s[]=new String[n];
            //System.out.println("enter the Strings");
            for(int j=0;j<n;j++)
            {
                s[j]=sc.next();
            }
            Arrays.sort(s,lengthComparator);
            //System.out.println(Arrays.toString(s));
            boolean flag=true;
            for(int x=0;x<n;x++)
            {
                String s1=s[x].substring(1);
                //System.out.println(s1);
                for(int z=x+1;z<n;z++)
                {
                    String s2=s[z].substring(s[z].length()-s1.length());
                    //System.out.println("s2: "+s2);
                  if(!s2.equals(s1))
                  {
                      flag=false;
                     // System.out.println("s1 "+s1);
                      break;
                  }
                }
                if(!flag)
                {
                    break;
                }
            }
            if(!flag)
            {
                System.out.println("Case #"+(i+1)+": "+"*");
            }
            else
            {
                String temp=s[n-1].substring(1);
                System.out.println("Case #"+(i+1)+": "+temp);
            }
        }
       w.close();

    }
}
class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader() throws IOException {
        br = new BufferedReader(new
                InputStreamReader(System.in));

    }

    String next() throws NumberFormatException,IOException,NullPointerException
    {
        while (st == null || !st.hasMoreElements())
        {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt()throws NumberFormatException,IOException,NullPointerException
    {
        return Integer.parseInt(next());
    }

    long nextLong()throws NumberFormatException,IOException,NullPointerException
    {
        return Long.parseLong(next());
    }

    double nextDouble()throws NumberFormatException,IOException,NullPointerException
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}