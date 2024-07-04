import java.util.*;
public class Solution{
private static Scanner s;
public static String helper(int t,int arr[][],int n)
{
  if(n==0)
  {
	  String str="Case #"+(t+1)+": "+"0 0 0";
      return str;
  }
  int r=0;
  int c=0;
  int trsum=0;
  for(int i=0;i<n;i++)
  {
    trsum+=arr[i][i];
  }
  for(int i=0;i<n;i++)
  {
    HashMap<Integer,Integer> rows=new HashMap<>();
    HashMap<Integer,Integer> cols=new HashMap<>();
    rows.put(arr[i][i],1);
    cols.put(arr[i][i],1);
    for(int j=0;j<n;j++)
    {
      int temp=arr[i][j];
      if(j!=i)
      {
        if(rows.containsKey(temp))
        {  
           r++;
           j=n;
        }
        else
        {
           rows.put(temp,1);
        }
      }
    }
    for(int j=0;j<n;j++)
    {
      int temp=arr[j][i];
      if(j!=i)
      {
        if(cols.containsKey(temp))
        {  
          c++;
          j=n;
        }
        else
        {
          cols.put(temp,1);
        }
      }
    }
  }
  return "Case #"+(t+1)+": "+trsum+" "+r+" "+c;
}

public static void main(String[] args)
{
s=new Scanner(System.in);
int t=s.nextInt();
ArrayList<String> str=new ArrayList<>();

for(int i=0;i<t;i++)
 {
  int n=s.nextInt();
  int arr[][]=new int[n][n];
  for(int j=0;j<n;j++)
  {
    for(int k=0;k<n;k++)
    {
       arr[j][k]=s.nextInt();
    }
  }
  str.add(helper(i,arr,n));
 }
for(int i=0;i<str.size();i++)
{
	System.out.println(str.get(i));
}
}
}