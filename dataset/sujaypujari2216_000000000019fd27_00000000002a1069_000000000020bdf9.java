import java.io.*;
import java.util.*;
class Solution
{
	public static void main(String a[])
	{
		//try
		{
			Scanner sc=new Scanner(System.in);
			int t=sc.nextInt();
			for(int lmo=1;lmo<=t;lmo++)
			{
			int cnt=sc.nextInt();
			int start=0, end=0;
			String op="";
			//System.out.println(start+" "+end);
			
			//int[][] task={{0,1440},{1,3},{2,4}};//,{2,5},{150,250}};
			int[][] jam=new int[cnt][2];
			int[][] cam=new int[cnt][2];
			int jp=0,cp=0,al=0;
			for(int i=0;i<cnt;i++)
			{
				start=sc.nextInt();//=task[i][0];
				end=sc.nextInt();//=task[i][1];
				al=0;
				//System.out.println("\n"+i+": "+start+" "+end);
				for(int j=0;j<=jp;j++)
				{
					//System.out.println("Jam array: "+jam[j][0]+" "+jam[j][1]);
					//System.out.println(i+":"+j+((start<jam[j][0])?"T":"F") + ((start>jam[j][1])?"T":"F") + ((end<jam[j][0])?"T":"F") + ((end>jam[j][1])?"T":"F"));
					if((start<jam[j][0] || start>=jam[j][1]) && (end<=jam[j][0] || end>jam[j][1]))
					{
						jam[jp][0]=start;
						jam[jp++][1]=end;
						//System.out.println("Jam"+j+": "+start+" "+end+jam[jp-1][0]+" "+jam[jp-1][1]);
						al=1;
						op+="J";
						
					}
					break;
				}
				if(al==0)
				{
					for(int j=0;j<=cp;j++)
				{
					//System.out.println("Cam array: "+cam[j][0]+" "+cam[j][1]);
					//System.out.println(i+":"+j+((start<cam[j][0])?"T":"F") + ((start>cam[j][1])?"T":"F") + ((end<cam[j][0])?"T":"F") + ((end>cam[j][1])?"T":"F"));
					if((start<cam[j][0] || start>=cam[j][1]) && (end<=cam[j][0] || end>cam[j][1]))
					{
						cam[cp][0]=start;
						cam[cp++][1]=end;
						al=1;
						op+="C";
						
					}
					break;
				}
				}
				if(al==0)
				{
					op="Impossible";
					break;
				}
			}
			/*System.out.println("\n\n Jam");
			for(int i=0;i<cnt;i++)
				System.out.println(jam[i][0]+" "+jam[i][1]);
			System.out.println("\n\n Cam");
			for(int i=0;i<cnt;i++)
				System.out.println(cam[i][0]+" "+cam[i][1]);*/
			System.out.println("Case #"+lmo+": "+op);
			}
			
		}
		//catch(IOException e)
		{
			//System.out.println(op);
		}
	}
}