import java.io.*;
import java.util.*;
import java.lang.*;
public class Solution
{
	public static void main(String[] args) {

Scanner sc = new Scanner (System.in);


int t,ts=1;

t = sc.nextInt();
int i,j,k,l,u;


for(i=0;i<t;i++)
{
    
    int n;
   
    n = sc.nextInt();
    int inc=0;
    int inj = 0;
    int[][] arr=new int[n][2];
   
    String str = "";
    for(j=0;j<n;j++)
    {
        
        for(k=0;k<2;k++)
        {
            
            arr[j][k] = sc.nextInt();
            
        }
        
    }
     int[] c = new int[99999];
     int[] h = new int[99999];
Arrays.fill(c, -1);
Arrays.fill(h, -1);
    int x=0;
    int y=0;
    int imp=0;
    for(j=arr[0][0];j<arr[0][1];j++)
    {
        c[x] = j ;
        x++;
    }
    str = str + 'C';
    
    
       
    for(j=1;j<n;j++)
    {
        
        for(k=0;k<c.length;k++)
        {
            for(u=arr[j][0];u<arr[j][1];u++)
             {
                     if(u == c[k])
                         {
                                  inc++; 
                           }
                           if(u == h[k])
                          {
                            inj++ ; 
                 
                          }
              }
       //   if(j==1){
    //System.out.println(h[k]+" "+inj + " "+ arr[j][0] +" "+arr[j][1]+ " " +inc +" "+c[k]) ;
     //     }
    //       
        }
        
        
     
        
        if(inc>0 && inj==0)
        {
            str =str +'J';        
                  for(l=arr[j][0];l<arr[j][1];l++)
                 {
                       h[y++] = l ;
                     
                      
                         
                 }
        }
          if(inc==0 && inj>0)
        {
            str =str +'C';        
                  for(l=arr[j][0];l<arr[j][1];l++)
                 {
                       c[x++] = l ;
                    
                 }
        }
        if(inc==0 && inj ==0){
             str =str +'J';        
                  for(l=arr[j][0];l<arr[j][1];l++)
                 {
                       c[x++] = l ;
                    
                 }
        }
        if(inc>0 && inj>0) { imp++; break; }
        inc=0;inj=0;imp=0;
        
        
        
        
        
        
        
    }
    
    
    
   
    
    
    
    if(imp>0){      System.out.printf("Case #"+ts+": "+"IMPOSSIBLE");
	        ts++;
	        
	          System.out.printf("\n");    imp=0;            }
    else{System.out.printf("Case #"+ts+": "+str);
	        ts++;
	        
	          System.out.printf("\n");
   }
}



	}
}