import java.util.*;
public class Main {
	public static void main(String[] args) {
		System.out.println("Hello, World");
		Scanner sc= new Scanner(System.in);
		int t= sc.nextInt();
		for(int m=1;m<=t;m++)
		{
			String str= sc.next();
			str="0"+str+"0";
			String res="";
			//System.out.println(str);
			for(int i=1;i<str.length();i++)
			{int j=Integer.valueOf(str.charAt(i));
				int k=Integer.valueOf(str.charAt(i-1));
				int l=j-k;
				//System.out.println(l);
				if(l>0){
				for(int c=0;c<l;c++)
				{
					res=res+"(";
				}
				if(i<str.length()-1)
				{
					res=res+str.charAt(i);
				}}
				else if(l<0)
				{l=0-l;
					//System.out.println("sdsd");
					for(int c=0;c<l;c++)
				{
					res=res+")";
				}
				if(i<str.length()-1)
				{
					res=res+str.charAt(i);
				}}
				else{
				if(i<str.length()-1)
				{
					res=res+str.charAt(i);
				}
				}
				}
				//System.out.println(res);
				System.out.println("Case #"+m+": "+res);
			}
		}
		
	}

