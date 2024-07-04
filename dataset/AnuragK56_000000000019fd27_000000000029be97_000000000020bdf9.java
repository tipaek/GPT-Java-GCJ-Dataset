import java.util.Scanner;
public class Solution{
   
    public static void main(String args[]) {
      int test,
		i,
		j,
		k = 0;
        Scanner sc=new Scanner(System.in);
 
		test = sc.nextInt();
		for (k = 0; k < test; k++)
		{
		    int n=sc.nextInt();
		    int time[][]=new int[n][2];
		    for(i=0;i<n;i++)
		    {
		        time[i][0]=sc.nextInt();
		        time[i][1]=sc.nextInt();
		    }
		  //  for(i=0;i<n;i++)
		  //  {
		        
		  //        System.out.println(time[i][0]+"  "+time[i][1]);
		        
		  //  }
		    int temp;
		     for ( i = 1; i <n; i++) 
		     {
                for ( j = i; j > 0; j--)
                {
                    if (time[j][0] < time [j - 1][0]) 
                    {
                        temp = time[j][1];
                        time[j][1] = time[j - 1][1];
                        time[j - 1][1] = temp;
                        temp = time[j][0];
                        time[j][0] = time[j - 1][0];
                        time[j - 1][0] = temp;
                    }
                }
            }
            String ans1="";
	        StringBuilder ans=new StringBuilder(ans1); 
            int Jend=0,Cend=0;
            for(i=0;i<n;i++)
            {
                if(Cend<=time[i][0])
                {
                    ans.append('C');
                    Cend=time[i][1];
                }
                else if(Jend<=time[i][0])
                 {
                    ans.append('J');
                    Jend=time[i][1];
                }
                else
                {
                    ans=new StringBuilder("IMPOSSIBLE"); 
                }
            }
    //         for(i=0;i<n;i++)
		  //  {
		        
		  //        System.out.println(time[i][0]+"  "+time[i][1]);
		  //  }
		   System.out.println("Case #"+(k+1)+":"+" "+ans);
		}
    }
}