import java.util.*;
class Vestgium{
    
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int t;
	int number=1;
        int diagonal_value=0;
        int count=0,count1=1;
        t=scan.nextInt();
        while(t>0){
            
            int n=scan.nextInt();
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
            
            for(int i=0;i<n-1;i++)
            {     
                for(int j=0;j<n-1;j++)
                {  
                    if(a[j][i]==a[j+1][i+1])
                    {
                        count++;
                        break;
                    }
                    
                }
            }
             for(int i=0;i<n-1;i++)
            {     
                for(int j=0;j<n-1;j++)
                {  
                    
                    if(a[i][j]== a[j+1][i+1])
                    {
                        count1++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+number+": "+diagonal_value+" "+count+" "+count1);
            number++;
		t--;
        }
        
        
    }
    
}