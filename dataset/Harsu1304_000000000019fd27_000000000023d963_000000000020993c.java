import java.util.*;
class Vestgium{
    
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int t=0;
	    int number=1;
        int diagonal_value=0;
        int count=0,count1=0;
	    int init=0;
	    int set=0;
        t=scan.nextInt();
        
        while(t>0){
            
            int n=scan.nextInt();
            if(n>=2 && n<=100){
            int a[][] = new int[n+1][n+1];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    
                    a[i][j]=scan.nextInt();
                }
            }
            
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    
                    if(i==j)
                    {
                      diagonal_value=diagonal_value+a[i][j];   
                    }
                    
                }
            }
        
            for(int i=0;i<n;i++)
            {     set=0;
                for(int j=0;j<n;j++)
                {    init=a[j][i];
			
			for(int k=j+1;k<n;k++)
			{ 
                        
                    if(init==a[k][i])
                    {
                        
			            count++;
			            set=1;
                        break;
                    }
			}
			        if(set==1)
                        { break;
                            }
                    
                }
            }

             for(int i=0;i<n;i++)
            {     set=0;
                for(int j=0;j<n;j++)
                {   init=a[i][j]; 
                    for(int k=j+1;k<n;k++)
			{
                    if(init== a[i][k])
                    {

                        count1++;
			set=1;
                        break;

                    }
			}
			        if(set==1)
                        {   break;
                           }
                }
            }
            System.out.println("Case #"+number+": "+diagonal_value+" "+count1+" "+count);
            number++;
            diagonal_value=0;
            count=0;
            count1=0;
            }
		    t--;
        }
        
        }
    
    
}