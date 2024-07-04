
import java.util.Scanner;

public class Solution{

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());

        for (int test = 1; test <= cases; test++) {
        	int N=Integer.parseInt(sc.nextLine());
        	int starting[]=new int[N];
        	int ending[]=new int[N];
        	int index[]=new int[N];
        	for(int i=0;i<N;i++)
        	{
        		String a[]=sc.nextLine().split("\\s");
        		starting[i]=Integer.parseInt(a[0]);
        		ending[i]=Integer.parseInt(a[1]);
        		index[i]=i;
        	}
        	
        	//sorting the three arrays
        	for (int i = 0; i < N; i++) 
            {
                for (int j = i + 1; j < N; j++) { 
                    if (starting[i] > starting[j]) 
                    {
                        int temp = starting[i];
                        starting[i] = starting[j];
                        starting[j] = temp;
                        
                        temp=ending[i];
                        ending[i]=ending[j];
                        ending[j]=temp;
                        
                        temp=index[i];
                        index[i]=index[j];
                        index[j]=temp;
                    }
                }
            }
        	
        	
        	int activity=0;
        	String assignedActivity[]=new String[N];
        	int J=0;
        	int C=0;
        	for(int i=0;i<N;i++)
        	{
//        	
        		
        		if(i==1)
        		{
        			if(starting[i]>=ending[C])
        			{
        				assignedActivity[i]="C";
            			C=i;
            			continue;
        			}
        			else
        			{
        				assignedActivity[i]="J";
            			J=i;
            			continue;
        			}
        			
        		}
        		
        		if(i==0)
        		{
        			assignedActivity[i]="C";
        			C=i;
        			continue;
        		}
        		else
        		{
        			if(starting[i]>=ending[C])
        			{
        				assignedActivity[i]="C";
        				C=i;
        			}
        			else if(starting[i]>=ending[J])
        			{
        				assignedActivity[i]="J";
        				J=i;
        			}
        			else
        			{
        				assignedActivity[i]="-1";
        			}
        		}
        	}
        	
        	//sorting the three arrays
        	for (int i = 0; i < N; i++) 
            {
                for (int j = i + 1; j < N; j++) { 
                    if (index[i] > index[j]) 
                    {
                        int temp = index[i];
                        index[i] = index[j];
                        index[j] = temp;
                        
                        String tem=assignedActivity[i];
                        assignedActivity[i]=assignedActivity[j];
                        assignedActivity[j]=tem;
                        
                    }
                }
            }
        	
        	boolean flag=true;
        	for(int i=0;i<N;i++)
        	{
        		if(assignedActivity[i]=="-1")
        		{
        			flag=false;
        		}
        		
        	}
        	String result="";
        	if(flag)
        	{
        		for(int i=0;i<N;i++)
        		{
        			result=result+assignedActivity[i];
        		
        		}
        	}
        	if(flag)
        	{
        		System.out.println("Case #"+test+": "+result);
        	}
        	else
        	{
        		System.out.println("Case #"+test+": "+"IMPOSSIBLE");;
        	}
        	

        }
    }
}