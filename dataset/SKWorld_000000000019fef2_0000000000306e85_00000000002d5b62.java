import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Expogo {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++)
		{
			String s=br.readLine();
			String s1[]=s.split(" ");
			int x=Integer.parseInt(s1[0]);
			int y=Integer.parseInt(s1[1]);
			int x1=x,y1=y;
			String result="";
			if(x<0)
				x1=-(x);
			if(y<0)
				y1=-(y);
			int sum=x1+y1;
			if(sum%2==0)
			{
				System.out.println("IMPOSSIBLE");
			}
			else
			{
				if(x==-1&&y==0)
				{
					System.out.println("W");
				}
				if(x==-3&&y==0)
				{
					System.out.println("WW");
				}
				if(x==1&&y==0)
				{
					System.out.println("E");
				}
				if(x==3&&y==0)
				{
					System.out.println("EE");
				}
				if(y==-1&&x==0)
				{
					System.out.println("S");
				}
				if(y==-3&&x==0)
				{
					System.out.println("SS");
				}
				if(y==1&&x==0)
				{
					System.out.println("N");
				}
				if(y==3&&x==0)
				{
					System.out.println("NN");
				}
				if(x==-1&&y==2)
				{
					System.out.println("WN");
				}
				if(x==-1&&y==4)
				{
					System.out.println("EWN");
				}
				if(x==-2&&y==1)
				{
					System.out.println("NW");
				}
				if(x==-2&&y==3)
				{
					System.out.println("SWN");
				}
				if(x==-3&&y==2)
				{
					System.out.println("ENW");
				}
				if(x==-3&&y==4)
				{
					System.out.println("WWN");
				}
				if(x==-4&&y==1)
				{
					System.out.println("SNW");
				}
				if(x==-4&&y==3)
				{
					System.out.println("NNW");
				}
				if(x==1&&y==2)
				{
					System.out.println("EN");
				}
				if(x==1&&y==4)
				{
					System.out.println("WEN");
				}
				if(x==2&&y==1)
				{
					System.out.println("NE");
				}
				if(x==2&&y==3)
				{
					System.out.println("SEN");
				}
				if(x==3&&y==2)
				{
					System.out.println("WNE");
				}
				if(x==3&&y==4)
				{
					System.out.println("EEN");
				}
				if(x==4&&y==1)
				{
					System.out.println("SNE");
				}
				if(x==4&&y==3)
				{
					System.out.println("NNE");
				}if(x==-1&&y==-2)
				{
					System.out.println("WS");
				}
				if(x==-1&&y==-4)
				{
					System.out.println("EWS");
				}
				if(x==-2&&y==-1)
				{
					System.out.println("SW");
				}
				if(x==-2&&y==-3)
				{
					System.out.println("NWS");
				}
				if(x==-3&&y==-2)
				{
					System.out.println("ESW");
				}
				if(x==-3&&y==-4)
				{
					System.out.println("WWS");
				}
				if(x==-4&&y==-1)
				{
					System.out.println("NSW");
				}
				if(x==-4&&y==-3)
				{
					System.out.println("SSW");
				}
				if(x==1&&y==-2)
				{
					System.out.println("ES");
				}
				if(x==1&&y==-4)
				{
					System.out.println("WES");
				}
				if(x==2&&y==-1)
				{
					System.out.println("SE");
				}
				if(x==2&&y==-3)
				{
					System.out.println("NES");
				}
				if(x==3&&y==-2)
				{
					System.out.println("WSE");
				}
				if(x==3&&y==-4)
				{
					System.out.println("EES");
				}
				if(x==4&&y==-1)
				{
					System.out.println("NSE");
				}
				if(x==4&&y==-3)
				{
					System.out.println("SSE");
				}
			}
		}
	}
}