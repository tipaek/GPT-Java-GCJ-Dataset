
import java.util.*;
import java.lang.*;
import java.io.*;


public class Solution
{
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
    
    static int depth(String x)
    {
        int count = 0;
        for(int j =0;j<x.length();j++)
        {
            if(x.charAt(j)=='(')
            count++;
            if(x.charAt(j)==')')
            count--;
        }
        return count;
    }
    
    static String para(char ch,char x)
    {
        switch(ch)
        {
            case '0':
                return "0";
                //break;
            case '1':
                return "("+x+")";
                //break;
            case '2':
                return "(("+x+"))";
                //break;
            case '3':
                return "((("+x+")))";
                //break;
            case '4':
                return "(((("+x+"))))";
                //break;
            case '5':
                return "((((("+x+")))))";
                //break;
            case '6':
                return "(((((("+x+"))))))";
                //break;
            case '7':
                return "((((((("+x+")))))))";
                //break;
            case '8':
                return "(((((((("+x+"))))))))";
                //break;
            case '9':
                return "((((((((("+x+")))))))))";
                //break;
        }
        return "";
    }

//    static PrintWriter pw = new PrintWriter(System.out);
    
	public static void main (String[] args) throws java.lang.Exception
	{

	  //FastReader s = new FastReader();
	  Scanner s =new Scanner(System.in);
		int t = s.nextInt();
		//System.out.println("hi2");
		for(int i=1;i<=t;i++)
		{

		  String str = s.next();
		  String strhat = "";
		  int j;
		  for(j=0;j<str.length();j++)
		  {
		      char ch = str.charAt(j);
		      if(Character.isDigit(ch))
		      {
		          if(j == 0)
		          strhat+=para(ch,ch);
		          else
		          {
		              int prech = str.charAt(j-1);
		              if (Character.getNumericValue(prech)==Character.getNumericValue(ch))
		              {
		                  strhat = strhat.substring(0,strhat.lastIndexOf(ch)+1)+ch+strhat.substring(strhat.lastIndexOf(ch)+1);
		              }
		              else if(Character.getNumericValue(prech)>Character.getNumericValue(ch))
		              {
		                  int diff = Character.getNumericValue(prech) - Character.getNumericValue(ch);
		                  strhat = strhat.substring(0,strhat.lastIndexOf(prech)+1+diff)+ch+strhat.substring(strhat.lastIndexOf(prech)+1+diff);
		              }
		              else
		              {
		                  int deep = depth(strhat.substring(0,strhat.lastIndexOf(prech)+1));
		                  //System.out.println(deep);
		                  int diff = Character.getNumericValue(ch) - deep;
		                  String nu = para(Character.forDigit(diff,10),ch);
		                  //System.out.println(nu);
		                  strhat = strhat.substring(0,strhat.lastIndexOf(prech)+1)+nu+strhat.substring(strhat.lastIndexOf(prech)+1);
		              }
		              
		          }
		          
		      }
		  }
		  System.out.println("Case #"+i+": "+strhat);
		}
		s.close();
	}
}
