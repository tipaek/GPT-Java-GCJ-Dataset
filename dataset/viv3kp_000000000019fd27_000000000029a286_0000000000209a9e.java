
import java.io.*;
import java.util.*;

public class Solution {
	
	static int pos=0;
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		
		int test=sc.nextInt();
		
		int b=sc.nextInt();
		
	
		
		int ok=0;
		
		while(test-->0)
		{
			int bA[]=new int[b];
			
			if(b==10)
			{
				for(int i=1;i<=10;i++)
				{
					System.out.println(i);
					
					int a=sc.nextInt();
					
					bA[i-1]=a;
					
				}
				StringBuilder str=new StringBuilder("");
				for(int i=0;i<10;i++)
				str.append(bA[i]);
				
				System.out.println(str.toString());
				
				
				String s=sc.nextLine();
				s=sc.nextLine();
				
				if(s.contentEquals("Y"));
				
				else
					break;
				
			}
			else if(b==20)
			{
				Set<Character> set=new HashSet();
				
				for(int i=1;i<=5;i++)
				{
						
					
					System.out.println(i);
					
					int a=sc.nextInt();
					
					bA[i-1]=a;
					
					System.out.println(bA.length-i+1);
					
					a=sc.nextInt();
					
					bA[bA.length-i]=a;
					
					
				}
				
			
					
					System.out.println(1);
					
					int a=sc.nextInt();
					
					boolean x= bA[1-1]==a;
					
					System.out.println(bA.length-1+1);
					
					int b1=sc.nextInt();
					
					boolean y= bA[bA.length-1]==b1;
					char k;
					
					if( x & y  )
					{
						if(a==b1)
						{
							set.add('N');
							set.add('R');
							
							 k=which(2,set,bA);
							
							
							
						}
						else
						{
							set.add('N');
							set.add('B');
							k=which(2,set,bA);
							
						}
					}
					else
					{
						if(a==b1)
						{
							set.add('C');
							set.add('B');
							 k=which(2,set,bA);
						}
						else
						{
							set.add('C');
							set.add('R');
							k=which(2,set,bA);
							
							
						}
						
					}
					
					
					
					
					
				
				
				
				
				
			}
			else if(b==100)
			{
				
			}
		}
		
	}
	
	static char which(int pos,Set<Character> set,int bA[])
	{
		Scanner sc=new Scanner(System.in);
		
		for(int i=pos;i<=5;i++)
		{
			
			pos=i;
			
			System.out.println(i);
			
			int a=sc.nextInt();
			
			boolean x= bA[i-1]==a;
			
			System.out.println(bA.length-i+1);
			
			int b1=sc.nextInt();
			
			boolean y= bA[bA.length-i]==b1;
			
			if( x & y  )
			{
				if(a==b1)
				{
					if(set.contains('N') && !set.contains('R'))
						return 'N' ;
						
				
					if(set.contains('R') && !set.contains('N'))
						return 'R';
					
			
					
					
					
				}
				else
				{
					if(set.contains('N') && !set.contains('B'))
						return 'N' ;
						
				
					if(set.contains('B') && !set.contains('N'))
						return 'B';
					

					
					
				}
			}
			else
			{
				if(a==b1)
				{
					if(set.contains('C') && !set.contains('B'))
						return 'C' ;
						
				
					if(set.contains('B') && !set.contains('C'))
						return 'B';
					
				
				}
				else
				{
					if(set.contains('C') && !set.contains('R'))
						return 'C' ;
						
				
					if(set.contains('R') && !set.contains('C'))
						return 'R';
					
					
			
					
					
				}
				
			}
			
			
			
		}
		
		return 'D';
		
		
		
	}

}
