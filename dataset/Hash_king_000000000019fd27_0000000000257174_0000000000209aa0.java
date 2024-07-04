import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int j=0;j<t;j++){
            int n=sc.nextInt();
            int k= sc.nextInt();
            int l= n*(n+1);
            if(n==2&&k==3)
            {System.out.println("Case #"+(j+1)+": "+"IMPOSSIBLE");continue;}
            if(k%n!=0&&k!=(l/2))
            System.out.println("Case #"+(j+1)+": "+"IMPOSSIBLE");
            else{
                System.out.println("Case #"+(j+1)+": "+"POSSIBLE");
                if(k==(l/2))
                {
                    if(n%2!=0)
                    get(n);
                    
                    if(n==4){
                        System.out.println(1+" "+4+" "+2+" "+3);
                        System.out.println(3+" "+2+" "+4+" "+1);
                        System.out.println(4+" "+1+" "+3+" "+2);
                        System.out.println(2+" "+3+" "+1+" "+4);



                    }
                    
                    
                }
                else
                doit(n,k/n);
                //doit(n,k/n);

            }
        }
    }
    public static void get(int n){
        int k =1; 
	
		for (int i = 1; i <= n; i++) 
		{ 
			int temp = k; 

			while (temp <= n) 
			{ 
				System.out.print(temp + " "); 
				temp++; 
			} 

			for (int j = 1; j < k; j++) 
				System.out.print(j + " "); 
	
			k++; 
			System.out.println(); 
		} 

    }

    public static void doit(int n, int k){
        k = n + k; 
	
      for(int j=1;j<=n;j++){
		for (int i = k-j; i < n+k-j; i++) 
		{	
				
				System.out.print((i%n+1) + " "); }
	
			
			System.out.println(); 
		} 

    }
}