import java.util.*;
class test{
    public static void main(String s[]){
        int t;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        int c=0;
        while(t-->0){
            int n=sc.nextInt();
            int arr[][],count=0,count1=0;
            
            
            arr=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            for(int i=0;i<n;i++){
                int a[];
                a=new int[n];
                for(int l=0;l<n;l++){
                    a[l]=0;
                }
                for(int j=0;j<n;j++){
                    int k=arr[i][j];
                    a[k-1]+=1;
                    if(a[k-1]>1){
                        count++;
                        break;
                    }
                }
                
                
            }
            for(int i=0;i<n;i++){
                int a[];
                a=new int[n];
                for(int l=0;l<n;l++){
                    a[l]=0;
                }
                for(int j=0;j<n;j++){
                    int k=arr[j][i];
                    a[k-1]+=1;
                    if(a[k-1]>1){
                        count1++;
                        break;
                    }
                    
                    
                    
                }
            }
            int sum=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j)
                    sum+=arr[i][j];
                }
            }
            System.out.println("Case #"+(++c)+": "+sum+" "+count+" "+count1);

        }
    }
}