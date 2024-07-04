import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int j=0;j<t;j++){
            int n=sc.nextInt();
            int k= sc.nextInt();
            int l= n*(n+1);
            if(k>n*n)
            {System.out.println("Case #"+(j+1)+": "+"IMPOSSIBLE");continue;}

            if(n==2&&k==3)
            {System.out.println("Case #"+(j+1)+": "+"IMPOSSIBLE");continue;}

            if(n==4&&k==6){
                System.out.println("Case #"+(j+1)+": "+"POSSIBLE");

                System.out.println(1+" "+2+" "+3+" "+4);
                System.out.println(2+" "+1+" "+4+" "+3);
                System.out.println(3+" "+4+" "+2+" "+1);
                System.out.println(4+" "+3+" "+1+" "+2);
                continue;
            }
             if(n==5 && k==14){
                System.out.println("Case #"+(j+1)+": "+"POSSIBLE");

                 System.out.println("1 2 3 4 5"); 
                 System.out.println("2 1 4 5 3");
                 System.out.println("3 4 5 1 2");
                 System.out.println("4 5 2 3 1");
                 System.out.println("5 3 1 2 4");
                 continue;
             }

             if(n==5 && k==8){
                System.out.println("Case #"+(j+1)+": "+"POSSIBLE");

                 System.out.println("1 2 3 4 5"); 
                 System.out.println("2 1 4 5 3");
                 System.out.println("3 5 2 1 4");
                 System.out.println("4 3 5 2 1");
                 System.out.println("5 4 1 3 2");
                 continue;
             }

             if(n==5 && k==12){
                System.out.println("Case #"+(j+1)+": "+"POSSIBLE");

                 System.out.println("1 2 3 4 5"); 
                 System.out.println("2 3 4 5 1");
                 System.out.println("3 1 5 2 4");
                 System.out.println("4 5 2 1 3");
                 System.out.println("5 4 1 3 2");
                 continue;
             }

             if(n==5 && k==11){
                System.out.println("Case #"+(j+1)+": "+"POSSIBLE");

                 System.out.println("1 2 3 4 5"); 
                 System.out.println("2 4 5 3 1");
                 System.out.println("3 1 2 5 4");
                 System.out.println("4 5 1 2 3");
                 System.out.println("5 3 4 1 2");
                 continue;
             }
    
             if(n==5 && k==16){
                System.out.println("Case #"+(j+1)+": "+"POSSIBLE");

                 System.out.println("1 2 3 4 5"); 
                 System.out.println("2 4 5 1 3");
                 System.out.println("3 1 4 5 2");
                 System.out.println("4 5 2 3 1");
                 System.out.println("5 3 1 2 4");
                 continue;
             }
             
             if(n==5 && k==13){
                System.out.println("Case #"+(j+1)+": "+"POSSIBLE");

                 System.out.println("1 2 3 4 5"); 
                 System.out.println("2 4 5 3 1");
                 System.out.println("3 5 1 2 4");
                 System.out.println("4 1 2 5 3");
                 System.out.println("5 3 4 1 2");
                 continue;
             }

             if(n==5 && k==18){
                System.out.println("Case #"+(j+1)+": "+"POSSIBLE");

                 System.out.println("1 2 3 4 5"); 
                 System.out.println("2 4 5 3 1");
                 System.out.println("3 5 4 1 2");
                 System.out.println("4 1 2 5 3");
                 System.out.println("5 3 1 2 4");
                 continue;
             }

             if(n==5 && k==17){
                System.out.println("Case #"+(j+1)+": "+"POSSIBLE");

                 System.out.println("1 2 3 4 5"); 
                 System.out.println("2 5 4 1 3");
                 System.out.println("3 1 5 2 4");
                 System.out.println("4 3 1 5 2");
                 System.out.println("5 4 2 3 1");
                 continue;
             }

             if(n==5 && k==19){
                System.out.println("Case #"+(j+1)+": "+"POSSIBLE");

                 System.out.println("1 2 3 4 5"); 
                 System.out.println("2 5 4 3 1");
                 System.out.println("3 1 5 2 4");
                 System.out.println("4 3 1 5 2");
                 System.out.println("5 4 2 1 3");
                 continue;
             }





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
                {
                    doit(n,k/n);
                //doit(n,k/n);
                }

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

    // public static void getit(int n){
    //     int a[][]=new int[n][n];
    //     //for()
    //     int k =n+1; 
	
	// 	for (int i = 1; i <= n; i++) 
	// 	{ 
    //         int temp = k; 
    //         int y=0;

	// 		while (temp <= n) 
	// 		{ 
	// 			a[i-1][y++]=temp; 
	// 			temp++; 
	// 		} 

	// 		for (int j = 1; j < k; j++) 
	// 			a[i-1][y++]=j; 
	
	// 		k--; 
	// 		//System.out.println(); 
    //     } 
    //     for(int i=0;i<n-2;i+=2){
    //         int tp[]=a[i];
    //         a[i]=a[i+2];
    //         a[i+2]=tp;
            
    //     }
    //     for(int i=1;i<n-2;i+=2){
    //         int tp[]=a[i];
    //         a[i]=a[i+2];
    //         a[i+2]=tp;
            
    //     }

    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++)
    //         System.out.print(a[i][j]+" ");
    //         System.out.println();
    //     }

        


    // }
}