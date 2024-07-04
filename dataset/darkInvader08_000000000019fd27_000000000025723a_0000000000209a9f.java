import java.io.*;
class Check
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String fop="";
		for(int g=1;g<=n;g++)
		{
			String s=br.readLine();
			String a[]=s.split("");
			String op="";
			int d=0,d1=0;
			for(int i=0;i<s.length();i++)
			{
				
				d1=Integer.parseInt(a[i]);

				while(d1>d)
				{
					d++;
					op=op+"(";
					
				}
				while(d1<d)
				{
					d--;
					op=op+")";
				}
				op=op+a[i];

			}
			while(d>0)
			{
				d--;
				op=op+")";
			}
			fop=fop+"Case #"+g+": "+op+"\n";

		}
		System.out.print(fop);
		
	}

}