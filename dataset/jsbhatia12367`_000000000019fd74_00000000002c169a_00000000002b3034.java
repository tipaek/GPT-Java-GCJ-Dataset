import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		//
		int c =0;
		while(T-->0)
		{
		    StringBuilder answer = new StringBuilder();
		    int flag=0;
		    int s=Integer.MIN_VALUE;
		    String cur = "";
		    int n = Integer.parseInt(br.readLine());
		    String[] str = new String[n];
		    for(int i=0;i<n;i++)
		    {
		        str[i] = br.readLine();
		    }
		    //String[] str = br.readLine().split("\\s+");
		    ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
		    //String[][] ar = new 
		    for(int i=0;i<n;i++)
		    {
		      /*String[] temp = str[i].split("*");
		      arr.add(new ArrayList<String>(Arrays.asList(temp)));*/
		      
		      ArrayList<String> temp = new ArrayList<String>();
		      while(str[i].indexOf('*')>=0)
		      {
		          if(str[i].indexOf('*')==0)
		          temp.add("");
		          else
		          temp.add(str[i].substring(0,str[i].indexOf('*')));
		          if(str[i].indexOf('*')+1<str[i].length())
		          str[i]=str[i].substring(str[i].indexOf('*')+1);
		          else
		          str[i]="";
		         
		      }
		      temp.add(str[i]);
		      arr.add(temp);
		    }
		    for(int i=0;i<n;i++)
		    {
		       ArrayList<String> temp = arr.get(i);
		       if(temp.get(0).length()>s)
		       {
		         cur=temp.get(0);
		         s=temp.get(0).length();
		       }
		       
		    }
		    answer.append(cur);
		    for(int ii=0;ii<n;ii++)
		    {
		      ArrayList<String> temp = arr.get(ii);
		      String str1 = temp.get(0);
		      String str2 = temp.get(1);
		      int i;
		      for(i=0;i<str1.length();i++)
		      {
		          if(str1.charAt(i)!=cur.charAt(i))
		          {
		              flag=1;
		              answer.setLength(0);
		              answer.append("*");
		              break;
		          }
		      }
		      
		      
		      if(flag==1)
		      {
		         break; 
		      }
		      int skip=0;
		      if(i<cur.length())
		      {
		          int k=0;
		          while(i<cur.length() && k<str2.length())
		          {
		           if(cur.charAt(i)==str2.charAt(k)) 
		           {
		               while(cur.charAt(i)==str2.charAt(k) && (i<cur.length() && k<str2.length()))
		               {
		                  skip=k+1; 
		                   i++;
		                    k++;
		                   
		               }
		               break;
		           }
		              i++;
		              k++;
		          }
		      }
		      temp.set(1,str2.substring(skip));
		      arr.set(ii,temp);
		      
		     
		      
		    }
		    
		    
		    
		     s= Integer.MIN_VALUE;
		      cur="";
		      for(int i=0;i<n;i++)
		    {
		       ArrayList<String> temp = arr.get(i);
		       if(temp.get(1).length()>s)
		       {
		         cur=temp.get(1);
		         s=temp.get(1).length();
		       }
		       
		    }
		    
		    
		    answer.append(cur);
		    for(int ii=0;ii<n;ii++)
		    {
		     ArrayList<String> temp = arr.get(ii);
		     String str2 = temp.get(1);
		     for(int i=0;i<str2.length();i++)
		     {
		         if(str2.charAt((str2.length()-1)-i)!=cur.charAt((cur.length()-1)-i))
		         {
		             flag=1;
		             answer.setLength(0);
		             answer.append("*");
		         }
		     }
		      if(flag==1)
		      break;
		    }
		    
		    
		    
		    
		    
		    c++;
		   System.out.println("Case #"+c+": "+answer); 
		    
		}
	}
}
