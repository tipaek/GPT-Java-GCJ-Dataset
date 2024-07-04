import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args)throws IOException
    {
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
      int T=Integer.parseInt(in.readLine());
      if(T>=1 && T<=100)
      {
        for(int i=1;i<=T;i++)
        {
					String schedule="";
					int c=0,j=0;
					List<Integer> Start=new ArrayList<>();
					List<Integer> End=new ArrayList<>();
					int N=Integer.parseInt(in.readLine());
					for (int k=1;k<=N;k++) 
					{
						String str[]=in.readLine().split(" ",2);
						Start.add(Integer.parseInt(str[0]));
						End.add(Integer.parseInt(str[1]));						
					}
					List<Integer> st = new ArrayList<>(Start);
					Collections.sort(st);
					List<Integer> en = new ArrayList<>();
					for (int s : st) 
					{
						en.add(End.get(Start.indexOf(s)));						
					}					
					schedule+="C";
					int lim=en.get(0);
					int crrend=0;
					c=1;
					for(int l=1;l<st.size();l++)
					{
						if(crrend>st.get(l))
						{
							schedule="";
							schedule="IMPOSSIBLE";
							break;
						}
						else
						{
							if(lim>=st.get(l) && lim>=en.get(l))
							{
								if(j==0){
									schedule+="J";}
								else{
									schedule+="C";
								}	
								crrend=en.get(l);
							}
							else if(lim>=st.get(l) && lim<=en.get(l))
							{
								if(c==1)
								{
									c=0;j=1;schedule+="J";
								}
								else
								{
									j=0;c=1;schedule+="C";
								}
								crrend=lim;
								lim=en.get(l);
							}
							else
							{
								schedule+="C";
								crrend=en.get(l);
							}
						}						
					}
					String sss="";
					if(schedule=="IMPOSSIBLE")
					{
						System.out.println("Case #"+i+": "+schedule);

					}
					else
					{
						for (int St: Start) 
					{
						sss+=schedule.charAt(st.indexOf(St));						
					}
					System.out.println("Case #"+i+": "+sss);
					}
				}
					
			}      
    }
}
