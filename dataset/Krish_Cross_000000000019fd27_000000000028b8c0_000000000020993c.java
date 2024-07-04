import java.util.*;
class main{

     public static void main(String []args){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++){
            int n=s.nextInt();
            int a[][]=new int[n][n];
            int cr[][]=new int[n][n];
            int sum=0;
            for(int x=0;x<n;x++)
            {
                for(int j=0;j<n;j++)
                {
                    a[x][j]=s.nextInt();
                    cr[x][j]=a[x][j];
                    if(x==j)
                    sum+=a[x][j];
                }
            }
            ;
            int flg=-1;
            int r=0,c=0;int fg[]=new int[n];
            for(int x=0;x<n;x++)
            {
                for(int y=0;y<n;y++)
                { 
                    
                    int chk=a[x][y];int cnt=0;
                    if(cr[x][y]<0)
                    continue;
                    for(int o=0;o<n;o++)
                    { if(chk<0)
                    continue;
                        if(chk==cr[x][o])
                        {
                            cnt+=1;
                            cr[x][o]=flg-1;
                        }
                    }
                    if(cnt>1)
                    {r=r+1;break;}
                }
               
                
            }
            
            for(int x=0;x<n;x++)
            {int ind=0;
                for(int y=0;y<n;y++)
                { 
                    fg[y]=a[y][x];
                }
                if(func(fg))
                c=c+1;
            }
            
            int jh=i+1;
            System.out.println("Case #"+jh+": "+sum+" "+r+" "+c);
            
            
            
            
            
            
            
        }
     }
     static boolean func(int []arr){
         
         
         for(int u=0;u<arr.length;u++)
         {
             for(int y=u+1;y<arr.length;y++)
             {
                 if(arr[u]==arr[y])
                 return true;
             }
         }
         return false;
     }
}
         
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    