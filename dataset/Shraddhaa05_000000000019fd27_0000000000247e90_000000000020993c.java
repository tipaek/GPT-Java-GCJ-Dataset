import java.util.*;
class matrix{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        String s[]=new String[tc];         
     
       for(int x=0;x<tc;x++){
         s[x]="";
         int k=0,r=0,c=0;
         int n;
         n=sc.nextInt();
       
         int arr[][]=new int[n][n];

         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
         }
        
       
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    k=arr[i][j]+k;
                }
            }
        }

        for(int i=0;i<n;i++){
           int q=0;
            for(int j=0;j<n-1;j++){
                for(int p=j+1;p<n;p++){
                    if(arr[i][j]==arr[i][p]){
                        q++;
                        if(q>1){
                            q--;
                        }
                    }
                }
            }
            r=r+q;
            
        }
        for(int j=0;j<n;j++){
           int w=0;
            for(int i=0;i<n-1;i++){
                for(int p=i+1;p<n;p++){
                    if(arr[i][j]==arr[p][j]){
                        w++;
                        if(w>1){
                            w--;
                        }
                    }
                }
            }
            c=c+w;
        }
        s[x]=x+1+": "+k+" "+r+" "+c;
      

    } 
             
     for(int i=0;i<tc;i++){
        System.out.println("Case #"+s[i]);
     }
      
    }
}


