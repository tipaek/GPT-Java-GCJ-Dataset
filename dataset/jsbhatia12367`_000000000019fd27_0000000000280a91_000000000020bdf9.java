import java.util.*;
import java.lang.*;
import java.io.*;

class node
{
    int fin;
    int number;
    node(int f,int n)
    {
        fin=f;
        number=n;
    }
}
public class Solution
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int ii=0;
        while(T-->0)
        {
            int flag=0;
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer,node> slot = new TreeMap<Integer,node>();
            int finish_1=0,finish_2=0;
            StringBuilder answer = new StringBuilder();
            char[] ans = new char[n];
            for(int i=0;i<n;i++)
            {
             int[] arr = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
             slot.put(arr[0],new node(arr[1],i));  
            }
            Iterator itr = slot.entrySet().iterator();
            while(itr.hasNext())
            {
                Map.Entry entry = (Map.Entry)itr.next();
                if(finish_1<=(int)entry.getKey())
                {
                 finish_1= ((node)entry.getValue()).fin;
                 ans[((node)entry.getValue()).number]='C';
                 //answer.append("C");
                }
                else if(finish_2<=(int)entry.getKey())
                {
                  finish_2= ((node)entry.getValue()).fin;
                 ans[((node)entry.getValue()).number]='J'; 
                }
                else
                {
                    flag=1;
                  answer = new StringBuilder("IMPOSSIBLE");
                  break;
                }
                
            }
            if(flag==0)
            {
              for(int i=0;i<n;i++)
            {
               answer.append(ans[i]); 
            }  
            }
            
            
            
                 System.out.println("Case #"+ii+": "+answer);
        }
	}
}

