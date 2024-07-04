import java.io.*;
import java.util.*;

public class Vestigium
{
	
	public static void main(String arg[])
	{
		Scanner sc=new Scanner(System.in); 
		int t,size;
		t=sc.nextInt();
		int rc[]=new int[t];
		int dc[]=new int[t];
		int cc[]=new int[t];
		for(int i1=0;i1<t;i1++)
		{
			int dc1=0,rc1=0,cc1=0;
			size=sc.nextInt();
			sc.nextLine();
			int arr[][]=new int[size][size];
			int x = 0;
			for(int j=0;j<size;j++)
			{
            String line = sc.nextLine();
            String[] lineI = line.split(" ");

            for (int k=0;k<lineI.length;k++) 
			{
                arr[x][k]=Integer.parseInt(lineI[k]);
            }
            x++;
			}
			for(int d=0;d<size;d++)
			{
				dc1+=arr[d][d];
			}
			dc[i1]=dc1;
			int c=0;
			for (int r=0;r<size;r++)
			{
				 for (int i = 0; i < size; i++) 
				{ 
					for(int j=i+1;j<size;j++)
					{
						if(arr[r][i]==arr[r][j])
						{
							c++;
						System.out.println(c+""+arr[r][i]);
							break;
						}
					}
					if(c==1)
						break;
				}
					if(c==1)
					{
						rc1++;
						c=0;
					}	
			}
			rc[i1]=rc1;
			int c2=0;
			for (int c1=0;c1<size;c1++)
			{
				 for (int i = 0; i < size; i++) 
				{ 
					for(int j=i+1;j<size;j++)
					{
						if(arr[i][c1]==arr[j][c1])
						{
							c2++;
							break;
						}
					}
					if(c2==1)
						break;
				}
					if(c2==1)
					{
						cc1++;
						c2=0;
					}	
			}
			cc[i1]=cc1;
		}
		for (int i=0;i<t;i++)
		System.out.println("case #"+(i+1)+" "+dc[i]+" "+rc[i]+" "+cc[i]);
	}
}