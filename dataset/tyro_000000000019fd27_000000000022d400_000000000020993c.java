import java.util.*;
class Solution
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		 int t,i,j,l,x,y,z,n;
		 t=in.nextInt();
		 for(l=1;l<=t;l++)
		 {x=y=z=0;
		 	n=in.nextInt();
		 	int a[][]=new int[n][n];
		 	int r[]=new int[n];
		 	int c[]=new int[n];
		 	for(i=0;i<n;i++)
		 	{
		 		for(j=0;j<n;j++)
		 			a[i][j]=in.nextInt();
		 	}
		 	for(i=0;i<n;i++)
		 	{	z+=a[i][i];
		 		c=a[i].clone();
		 		for(j=0;j<n;j++)
		 			r[j]=a[j][i];
		 		x+=valid(r);
		 			y+=valid(c);
		 	}
		 	System.out.println("Case #"+l+": "+z+" "+y+" "+x);
		 }
	}
	public static int valid(int [] check){
		int i = 0,j=0;
    Arrays.sort(check);
    for (int number : check) {
        if (number != ++i)
            {j++;break;}
    }
    return j;
	}
}