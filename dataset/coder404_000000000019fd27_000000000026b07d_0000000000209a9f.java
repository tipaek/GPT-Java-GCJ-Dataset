import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int i=0;i<test;i++){
            String s=sc.next();
            String m1="";
            for(int j=0;j<s.length();j++){
                if(j>0&&s.charAt(j)==s.charAt(j-1))
                m1+=s.charAt(j);
                else
                {
                    int tp=0;
                    if(j!=0)
                    while(tp++<s.charAt(j-1)-'0')
                    m1+=')';
                    tp=0;
                    while(tp++<s.charAt(j)-'0')
                    m1+='(';
                    m1+=s.charAt(j);

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
            int tk=0;
            while(tk++<s.charAt(s.length()-1)-'0')
            m1+=')';
            
            System.out.println("Case #"+(i+1)+": "+m1);
            
        }


        sc.close();
    }
    
}