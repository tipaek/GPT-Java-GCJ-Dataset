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
		    int time[][]=new int[n][4];

		    for(i=0;i<n;i++)
		    {
		        time[i][0]=sc.nextInt();
		        time[i][1]=sc.nextInt();
		        time[i][2]=i+1;
		        time[i][3]=-1;
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
                         temp = time[j][2];
                        time[j][2] = time[j - 1][2];
                        time[j - 1][2] = temp;
                    }
                }
            }
            String ans1="";
	        StringBuilder ans=new StringBuilder(ans1); 
            int Jend=0,Cend=0;
            int flag=1;
            for(i=0;i<n;i++)
            {
                if(Cend<=time[i][0])
                {
                    Cend=time[i][1];
                    time[i][3]=0;
                }
                else if(Jend<=time[i][0])
                 {
                    Jend=time[i][1];
                     time[i][3]=1;
                }
                else
                {
                    flag=0;
                    ans=new StringBuilder("IMPOSSIBLE");
                    System.out.println("Case #"+(k+1)+":"+" "+ans);
                    break;
                }
            }
             for ( i = 1; i <n; i++) 
		     {
                for ( j = i; j > 0; j--)
                {
                    if (time[j][2] < time [j - 1][2]) 
                    {
                        temp = time[j][1];
                        time[j][1] = time[j - 1][1];
                        time[j - 1][1] = temp;
                        temp = time[j][0];
                        time[j][0] = time[j - 1][0];
                        time[j - 1][0] = temp;
                         temp = time[j][3];
                        time[j][3] = time[j - 1][3];
                        time[j - 1][3] = temp;
                        temp = time[j][2];
                        time[j][2] = time[j - 1][2];
                        time[j - 1][2] = temp;
                    }
                }
            }
    //         System.out.println();
    //         for(i=0;i<n;i++)
		  //  {
		        
		  //        System.out.println(time[i][0]+"  "+time[i][1]+" "+time[i][2]+" "+time[i][3]);
		  //  }
		    if(flag!=0)
		    {
		        ans=new StringBuilder(ans1); 
		        for(i=0;i<n;i++){
		            if(time[i][3]==0)
		            ans.append('C');
		            else
		            ans.append('J');
		        }
		        System.out.println("Case #"+(k+1)+":"+" "+ans);
		    }
		}
    }
}