import java.util.*;
class pattern{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
       
       for(int x=1;x<=tc;x++){
       	int n=0;
       	n=sc.nextInt();
       	 int k=0,r=0,c=0;
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
        
        
            System.out.println("Case #"+x+": "+k+" "+r+" "+c);
        
       } 
    }
}

