import java.util.*;
class Pair implements Comparable<Pair>{
	int s1;
	int e1;
	public int compareTo(Pair o)
	{
		return this.s1-o.s1;
	}
}

public class Solution{
  private static Scanner s;
  public static String helper(int st[],int end[],int n)
  {
	  Pair arr[]=new Pair[n];
	  HashMap<Pair,Integer> map=new HashMap<>();
	  for(int i=0;i<n;i++)
	  {
		  arr[i]=new Pair();
		  arr[i].s1=st[i];
		  arr[i].e1=end[i];
		  map.put(arr[i],i);
	  }
	  Arrays.sort(arr);
	  for(int i=0;i<n;i++)
	  {
		  System.out.println(map.get(arr[i]));
	  }
	  int cs=arr[0].s1;
	  int ce=arr[0].e1;
	  int js=0;
	  int je=0;
	  String ans="C";
	  for(int i=1;i<n;i++)
	  {
		  int start=arr[i].s1;
		  int ending=arr[i].e1;
		  if(start<ce && start>=je)
		  {
			  js=start;
			  je=ending;
			  ans+="J";
		  }
		  else if(start>=ce && start<je)
		  {
			  cs=start;
			  ce=ending;
			  ans+="C";
		  }
		  else if(start<ce && start<je)
		  {
			  return "IMPOSSIBLE";
		  }
		  else if(start>=ce && start>=je)
		  {
			  cs=start;
			  ce=ending;
			  ans+="C";
		  }
	  }
	  char carr[]=new char[n];
	  for(int i=0;i<n;i++)
	  {
		  int index=map.get(arr[i]);
		  carr[index]=ans.charAt(index);
	  }
	  String answer="";
	  for(int i=0;i<n;i++)
	  {
		  answer+=carr[i];
	  }
	  return answer;
  }
  
  public static void main(String[] args)
  {
	  s=new Scanner(System.in);
	  int t=s.nextInt();
	  ArrayList<String> ans=new ArrayList<>();
	  
	  for(int i=0;i<t;i++)
	  {
		  int n=s.nextInt();
		  int st[]=new int[n];
		  int end[]=new int[n];
		  for(int j=0;j<n;j++)
		  {
			  st[j]=s.nextInt();
			  end[j]=s.nextInt();
		  }
		  ans.add(helper(st,end,n));
	  }
	  for(int i=0;i<ans.size();i++)
	  {
		  System.out.println("Case #"+(i+1)+": "+ans.get(i));
	  }
  }
}
