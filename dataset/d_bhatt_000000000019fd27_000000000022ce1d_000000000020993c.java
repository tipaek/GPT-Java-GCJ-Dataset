import java.util.Scanner;
class Trace_matrix
{
	public static void main(String args[])
	{
		Scanner obj=new Scanner(System.in);
		int i,j,n,size,number,flag;
		int sum=0;
		int cll=0;
		int row=0;
		System.out.print("Enter number of array ");
		number=obj.nextInt();
		for(n=1;n<=number;n++)
		{
			System.out.print("Enter size of array ");
			size=obj.nextInt();
			int a[][]=new int[size][size];
			for(i=0;i<size;i++)
			{
				for(j=0;j<size;j++)
				{			
					a[i][j]=obj.nextInt();
				}
				
			}
			for(i=0;i<size;i++)
			{                   
				for(j=0;j<size;j++)
				{	
					System.out.print(a[i][j]+"\t");
				}
				System.out.println();
			}
			for(i=0;i<size;i++)
			{                
				for(j=0;j<size;j++)
				{	
					if(i==j)
						sum=sum+a[i][j];
				}
			}
			for(i=0;i<size;i++)
			{                
				flag=0;
				for(j=0;j<size;j++)
				{	
        					int rt=a[i][j];
                    					for(int jj=j+1;jj<size;jj++)
              				      	{
                        					if(rt==a[i][jj])
                        					flag=1;
                    					}
				}
				 if(flag==1)
             				 {
                    					row=row+1;
                				}
			}
			for(j=0;j<size;j++)
           	 		{
                				flag=0;
                				for(i=0;i<size;i++)
                				{
                    					int ct=a[i][j];
                    					for(int ii=i+1;ii<size;ii++)
                    					{
                        					if(ct==a[ii][j])
                        					flag=1;
                    					}
                				}
                				if(flag==1)
               				{
                    					cll=cll+1;
                				}
            			}
			System.out.println("Case #"+n+":  "+sum+" "+row+" "+cll);
		}
	}
}






	