 

import java.util.*;
public class Solution {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		
		for(int i=0;i<t;i++)
		{
			
			int size=0,trace=0;
			int n=0;
			
			size=sc.nextInt();
		    trace=sc.nextInt();
			n=size;
                        
                        
                        if(trace<=size*size)
                        {
                            
                            int arr[] = new int[size];
                            int sum=0;
                            for(int j=0;j<n;j++)
                            {
                                arr[j]=trace/size;
                                sum=sum+arr[j];
                            }
                            if(sum<trace)
                            {
                                int j=0;
                                while(sum!=trace)
                                {
                                    arr[j]=arr[j]+1;
                                    sum=sum+1;
                                    j++;
                                }
                            }
                            int res[][]=new int[n][n];
                            int resrev[][]=new int[n][n];
                            for(int j=0;j<n;j++)
                            {
                                for(int k=0;k<n;k++)
                                {
                                    if(k==j)
                                    {
                                        res[j][k]=arr[j];
                                        resrev[n-1-j][n-1-k]=arr[j];
                                    }
                                    else
                                    if(k>j)
                                    
                                    {
                                        res[j][k]=(arr[j]+k-j)%size;
                                        resrev[n-1-j][n-1-k]=(arr[j]+k-j)%size;
                                    }
                                    else
                                    {
                                        if((arr[j]-j+k)%size<0)
                                            
                                        {
                                            res[j][k]=((arr[j]-j+k)%size) + size;
                                            resrev[n-1-j][n-1-k] =((arr[j]-j+k)%size) + size;
                                        }
                                        else
                                        {
                                            res[j][k]=(arr[j]-j+k)%size;
                                             resrev[n-1-j][n-1-k]=(arr[j]-j+k)%size;
                                        }
                                    }
                                        
                                }
                                //System.out.print(arr[j]);
                            }
                            
                            
                            
                            
                            int sumCol=0;
                            int sumCol2=0;
                            int flag=0;
                            int flag2=0;
                            for(int j=0;j<n;j++)
                            {
                                sumCol=0;
                                sumCol2=0;
                                for(int k=0;k<n;k++)
                                {
                                    if(res[k][j]==0)
                                    {
                                        sumCol=sumCol+size;
                                        sumCol2=sumCol2+size;
                                    }
                                    else
                                    {
                                        sumCol=sumCol+res[k][j];
                                         sumCol2=sumCol2+resrev[k][j];
                                    }
                                }
                               // System.out.println(sum);
                                if(sumCol!=n*(n+1)/2)
                                {
                                    flag=1;
                                }
                                if(sumCol2!=n*(n+1)/2)
                                {
                                    flag2=1;
                                }
                                
                            }
                            
                            if(flag==1&&flag2==1)
                            {
                                
                                
                                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                            }
                            else
                            {
                                if(flag==0)
                               
                                {
                                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                                    for(int j=0;j<n;j++)
                                 {
                                for(int k=0;k<n;k++)
                                {
                                    if(res[j][k]==0)
                                        System.out.print(size+" ");
                                    else
                                    System.out.print(res[j][k]+" ");
                                }
                                
                                System.out.println();
                                }
                                }
                                else if(flag2==0)
                                {
                                    System.out.println("Case #"+(i+1)+": POSSIBLE");
                                    for(int j=0;j<n;j++)
                                 {
                                for(int k=0;k<n;k++)
                                {
                                    if(resrev[j][k]==0)
                                        System.out.print(size+" ");
                                    else
                                    System.out.print(resrev[j][k]+" ");
                                }
                                
                                System.out.println();
                                }
                                }
                                
                                
                            }
                            
                            
                            
                            
                        }
                        else
			{
                            System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                            
                        }
			
		}
	}

}

