import java.util.*;
	class Solution
	{
		public static void main(String args[])
		{
			int T, N;
			
			Scanner sc = new Scanner(System.in);
			T = sc.nextInt();
			int rw=0,cl=0,flag,flag1,m,i,j,x=1;
			while(T>0)
			{
				N = sc.nextInt();
				int M[][] = new int[N][N];
				//Matrix input
				for(i=0;i<N;i++)
				{
					for(j=0; j<N; j++)
					{
						M[i][j] = sc.nextInt();
					}
				}
				int k1 =0, r=0, c=0;
				
                 for(j=0;j<N;j++){
					for(int k=0;k<N;k++){
						//sum of diagonal
						if(j==k){
							k1 += M[j][k];
						}
						//row repeat
						if(rw==0){
							flag = M[j][k];
							for(m=0;m<N;m++){
								if((flag==M[j][m])&&(m!=k)){
									r++;
									rw=1;
									break;
								}
							}
						}
						//column repeat
						if(cl==0)
						{
							flag1=M[k][j];
							for(m=0;m<N;m++){
								if((flag1==M[m][j])&&(m!=k)){
									c++;
									cl=1;
									break;
								}
							}
						}
					}
					rw=0;
					cl=0;
				}
				//printing
				System.out.println("Case #"+x+": "+k1+" "+r+" "+c);
				k1=0;
				r=0;
				c=0;
				flag=-999;
				flag1=-999;
						
						T--;
						x++;
					}
					
				}
	}