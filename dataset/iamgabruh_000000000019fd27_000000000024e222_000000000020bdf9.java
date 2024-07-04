import java.util.*;
import java.io.*;
public class Solution{
	static class pair{
		int s,e;
		pair(int a,int b){
			s=a;
			e=b;
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine().trim());
		int test=1;
		while(t-->0)
		{
			int n=Integer.parseInt(br.readLine().trim());
			ArrayList<pair> c=new ArrayList<>();
			ArrayList<pair> j=new ArrayList<>();
			String ans="";
			for(int i=0;i<n;i++)
            {
				StringTokenizer tok=new StringTokenizer(br.readLine()," ");
				int s=Integer.parseInt(tok.nextToken());
				int e=Integer.parseInt(tok.nextToken());
				if(c.size()==0) {
					c.add(new pair(s,e));
					ans+="C";
				}
				else if(j.size()==0) {
					j.add(new pair(s,e));
					ans+="J";
				}
				else {
					boolean overlap=false;
					for(pair curr:c) {
						if(e<=curr.s || curr.e<=s) {
							continue;
						}
						else {
							overlap=true;
						}
						
					}
					if(!overlap) {
						c.add(new pair(s,e));
						overlap=false;
						ans+="C";
					}
					else {
						overlap=false;
						for(pair curr:j) {
							if(e<=curr.s || curr.e<=s) {
								continue;
							}
							else {
								overlap=true;
							}
							
						}
						if(!overlap) {
							ans+="J";
							j.add(new pair(s,e));
						}
						else {
							ans="IMPOSSIBLE";
							break;
						}
					}
				}
            }
			System.out.println("Case #"+test+++": "+ans);
	
		}
	}
}