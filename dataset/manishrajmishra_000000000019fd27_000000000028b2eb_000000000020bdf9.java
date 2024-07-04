import java.util.*;
import java.io.*;
class DataTypes
{
    Integer a;
	Integer b;
	Integer c;
	public DataTypes(Integer a, Integer b, Integer c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public DataTypes() {
		super();
	}
	
	
}
 class Solution {
	public static void main(String[] args)throws IOException {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			   Integer T = Integer.parseInt(br.readLine());
			   int x=0;
			   while(T-->0)
			   {
				   x+=1;
				   Integer N = Integer.parseInt(br.readLine());
				   List<DataTypes> list = new ArrayList<>();
				   for(int i=0;i<N;i++)
				   {
					   String str[] = br.readLine().trim().split("\\s+");
					   DataTypes t = new DataTypes(Integer.parseInt(str[0]),Integer.parseInt(str[1]),i);
					   list.add(t);
				   }
	            Collections.sort(list,(a1,a2)->a1.a-a2.a);
	              int cth=-1,jth=-1;
	              boolean flag=true;
	              char result[] = new char[N];
	              for(int i=0;i<N;i++)
	              {
	            	  if(cth<=list.get(i).a)
	            	  {
	            		  result[list.get(i).c]='C';
	            		  cth=list.get(i).b;
	            	  }
	            	  else if(jth<=list.get(i).a)
	            	  {
	            		  result[list.get(i).c]='J';
	            		  jth=list.get(i).b;
	            	  }
	            	  else
	            	  {
	            		  flag=false;
	            		  break;
	            	  }
	              }
				  StringBuffer sb=new StringBuffer();
				  for(int i=0;i<N;i++)
				  {
					  sb.append(result[i]);
				  }
				  if(flag)
				  {
					  System.out.println("Case #"+x+": "+sb.toString());
				  }
				  else
				  {
					  System.out.println("Case #"+x+": "+"IMPOSSIBLE");

				  }
			   }
	}
}