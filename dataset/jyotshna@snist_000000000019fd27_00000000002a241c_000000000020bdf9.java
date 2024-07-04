import java.util.*;
class sol
{
	public static void main(String ar[])
	{
		Scanner scan= new Scanner(System.in);
		int test=scan.nextInt();
		int x=0;
		while(x++<test)
		{
			int n=scan.nextInt();
			ArrayList<Integer> arrive= new ArrayList<Integer>();
			ArrayList<Integer> depart= new ArrayList<Integer>();
			ArrayList<Integer> arrivesort=new ArrayList<Integer>();
			for(int i=0;i<n;i++)
			{
				int xx=scan.nextInt();
				arrive.add(xx);
				arrivesort.add(xx);
				depart.add(scan.nextInt());

			}
			Collections.sort(arrivesort);
			int departc=depart.get(arrive.indexOf(arrivesort.get(0))),departj=-1;
			boolean flagc=false,flagj=true;
			StringBuilder sb= new StringBuilder("C");
			for(int i=1;i<n;i++)
			{
				if(departc<=arrivesort.get(i))
					flagc=true;
				if(departj<=arrivesort.get(i))
					flagj=true;
				if(flagc==true)
				{
					departc=depart.get(arrive.indexOf(arrivesort.get(i)));
					flagc=false;
					sb.append("C");

				}
				else if(flagj==true)
				{
					departj=depart.get(arrive.indexOf(arrivesort.get(i)));
					flagj=false;
					sb.append("J");

				}
				else
				{
					sb=new StringBuilder("IMPOSSIBLE");
					break;
				}
			}
			System.out.println("Case #"+x+": "+sb.toString());
		}
	}
}
