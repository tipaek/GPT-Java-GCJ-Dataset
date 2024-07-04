import java.util.*;
public class Solution {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		for(int a=0;a<test;a++)
		{
			int n=sc.nextInt();
			int d=sc.nextInt();
			if(n==1)
			{
				System.out.println("Case #" + (a+1) + ": " + (d-1));
			}
			//System.out.println(d);
			long[] vals= new long[n];
			int[] freqlist= new int[n];
			int[] copy= new int[n];
			long tot=0;
			for(int x=0;x<n;x++)
			{
				vals[x]=sc.nextLong();
				tot+=vals[x];
			}
			Arrays.sort(vals);
			int occ=0;
			int startind=0;
			boolean repeat=false;
			int ind=0;
			int distinct=n;
			while(ind<n)
			{
				if(ind==n-1)
				{
					for(int x=startind;x<=ind;x++)
					{
						freqlist[x]=occ+1;
						copy[x]=occ+1;
					}
					break;
				}
				if(vals[ind]==vals[ind+1])
				{
					occ++;
					if(repeat==false)
					{
						startind=ind;
						repeat=true;
					}
					distinct--;
				}
				else
				{
					for(int x=startind;x<=ind;x++)
					{
						freqlist[x]=occ+1;
						copy[x]=occ+1;
					}
					occ=0;
					startind=ind+1;
					repeat=false;
				}
				ind++;
			}
			
			/*for(int x=0;x<n;x++)
			{
				System.out.println(vals[x]+ " " +freqlist[x]);
			}
			System.out.println(distinct);*/
			boolean done=true;
			for(int g=0;g<distinct;g++)
			{
				int maxind=0;
				int max=0;
				int total=0;
				int totcuts=0;
				for(int x=0;x<n;x++)
				{
					if(copy[x]>max)
					{
						max=copy[x];
						maxind=x;
					}
				}
				//System.out.println(max);
				total=max;
				if(max>=d)
				{
					System.out.println("Case #" + (a+1) + ": " + totcuts);
					done=false;
					break;
				}
				else
				{
					for(int x=n-1;x>=maxind;x+=0)
					{
						//System.out.println("occuring");
						int cuts=0;
						int curr=(int)(vals[x]/vals[maxind]);
						if(vals[x]%vals[maxind]==0)
						{
							cuts=curr-1;
						}
						else
						{
							cuts=curr;
						}
						curr*=freqlist[x];
						cuts*=freqlist[x];
						total+=curr;
						totcuts+=cuts;
						//System.out.println("tot"+ tot);
						if(total>d)
						{
							
							if(vals[x]%vals[maxind]==0)
							{
								totcuts-=(total-d-1);
								System.out.println("Case #" + (a+1) + ": " + totcuts);
								done=false;
							}
							else
							{
								
								for(int f=0;f<freqlist[x];f++)
								{
									totcuts-=2;
									total--;
									if(total==d)
									{
										System.out.println("Case #" + (a+1) + ": " + totcuts);
										done=false;
										break;
									}
								}
								if(done)
								{
									totcuts-=(total-d);
									System.out.println("Case #" + (a+1) + ": " + totcuts);

								}
							}
						}
						if(done==false)
						{
							break;
						}
						if(total==d)
						{
							System.out.println("Case #" + (a+1) + ": " + totcuts);
							done=false;
							//System.out.println("occured");
							break;

						}
						x-=freqlist[x];
					}
					if(done==false)
					{
						break;
					}
				}
				for(int f=maxind;f<maxind+freqlist[maxind];f++)
				{
					if(f>=n)
					{
						break;
					}
					copy[f]=0;
				}
			}
			if(done)
			{
				long max=vals[0];
				while(max>=0)
				{
					int total=0;
					int totcuts=0;
					for(int x=vals.length-1;x>0;x+=0)
					{
						int cuts=0;
						int curr=(int)(vals[x]/max);
						if(vals[x]%max==0)
						{
							cuts=curr-1;
						}
						else
						{
							cuts=curr;
						}
						curr*=freqlist[x];
						cuts*=freqlist[x];
						total+=curr;
						totcuts+=cuts;
						if(total>d)
						{
							
							if(vals[x]%max==0)
							{
								totcuts-=(total-d-1);
								System.out.println("Case #" + (a+1) + ": " + totcuts);
								done=false;
								break;
							}
							else
							{
								
								for(int f=0;f<freqlist[x];f++)
								{
									totcuts-=2;
									total--;
									if(total==d)
									{
										System.out.println("Case #" + (a+1) + ": " + totcuts);
										done=false;
										break;
									}
								}
								if(done)
								{
								totcuts-=(total-d);
								done=false;
								System.out.println("Case #" + (a+1) + ": " + totcuts);
								}
							}
						}
						if(done==false)
						{
							break;
						}
						if(total==d)
						{
							System.out.println("Case #" + (a+1) + ": " + totcuts);
							//System.out.println("occured");
							done=false;
							break;
						}
						vals[x]-=freqlist[x];
					}
					if(done==false)
					{
						break;
					}
					else
					{
						max--;
					}
				}
				
			}
			
				
		}
	}

}
