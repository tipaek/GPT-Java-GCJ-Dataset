import java.util.ArrayList;
import java.util.Scanner;

class Solution {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		String[] ans = new String[t];
		
		for(int i=0;i<t;i++)
		{
			ArrayList<ArrayList<Integer>> cVal=new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> jVal=new ArrayList<ArrayList<Integer>>();
			StringBuilder sb=new StringBuilder();
			int m=sc.nextInt();
			sc.nextLine();
			int cInc=-1;
			int jInc=-1;
			int[][] matrix=new int[m][2];
			for(int k=0;k<m;k++)
			{
				/*System.out.println(cInc);
				System.out.println(jInc);
				System.out.println(cVal);
				System.out.println(jVal);*/
				String str=sc.nextLine();
				String[] st=str.split(" ");
				matrix[k][0]=Integer.parseInt(st[0]);
				matrix[k][1]=Integer.parseInt(st[1]);
				boolean cflag=false;
				boolean jflag=false;
				boolean impossible=false;
				
				if(k!=0)
				{
					for(int j=0;j<cVal.size();j++)
					{	
						int start=cVal.get(cInc).get(0);
						int end=cVal.get(cInc).get(1);
						if( ( (matrix[k][0] < start) && (matrix[k][1] > start && matrix[k][1] < end) ) || ( (matrix[k][0] > start && matrix[k][0] < end) && (matrix[k][1] > end) )|| (matrix[k][0] >= start && matrix[k][1] <= end) || (matrix[k][0] < start && matrix[k][1] > end)) 
						{
							if(jVal.isEmpty())
							{
								sb.append("J");
								jVal.add(new ArrayList<Integer>());
								jInc++;
								jVal.get(0).add(0,matrix[k][0]);
								jVal.get(0).add(1,matrix[k][1]);
							}
							else
							{
								for(int l=0;l<jVal.size();l++)
								{
									//System.out.println(jVal);
									int jStart=jVal.get(jInc).get(0);
									int jEnd=jVal.get(jInc).get(1);
									if( ( (matrix[k][0] < jStart) && (matrix[k][1] > jStart && matrix[k][1] < jEnd) ) || ( (matrix[k][0] > jStart && matrix[k][0] < jEnd) && (matrix[k][1] > jEnd) ) || (matrix[k][0] >= jStart && matrix[k][1] <= jEnd) || (matrix[k][0] < jStart && matrix[k][1] > jEnd)) 
									{
										impossible=true;
										break;
									}
									else
									{
										jflag=true;
										cflag=false;
									}
								}
							}
						}
						else
						{
							cflag=true;
							jflag=false;
						}
					}
					if(impossible)
					{
						sb=sb.delete(0, sb.length());
						sb=sb.append("IMPOSSIBLE");
						break;
					}
					else if(jflag)
					{
						sb.append("J");
						jVal.add(new ArrayList<Integer>());
						jInc++;
						jVal.get(jInc).add(0,matrix[k][0]);
						jVal.get(jInc).add(1,matrix[k][1]);
					}	
					else if(cflag)
					{
						//System.out.println("added");
						sb.append("C");
						cVal.add(new ArrayList<Integer>());
						cInc++;
						cVal.get(cInc).add(0,matrix[k][0]);
						cVal.get(cInc).add(1,matrix[k][1]);
						
					}
				}
				else
				{
					sb.append("C");
					cVal.add(new ArrayList<Integer>());
					cInc++;
					cVal.get(0).add(0,matrix[k][0]);
					cVal.get(0).add(1,matrix[k][1]);
				}
			}
			ans[i]=sb.toString();
		}
		for(int i=0;i<ans.length;i++)
		{
			int m=i+1;
			System.out.println("Case #"+ m +": "+ ans[i]);
		}
		sc.close();
	}
}
