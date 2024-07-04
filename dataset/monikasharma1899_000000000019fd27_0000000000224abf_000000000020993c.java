class Solution{
    public static void vestigium(int matrix[][], int n){
        
        int d_sum=0;
        int max1=0;
        for(int i=0;i<n;i++){
            int c_arr[]=new int[n+1];
            int m=0;
            for(int j=0;j<n;j++){
                if(i==j){
                    dsum+=matrix[i][j];
                }
                c_arr[matrix[i][j]]++;
                if(c_arr[matrix[i][j]]>m){
                    m=c_arr[matrix[i][j]];
                }
            }
            if(m>max1){
                max1=m;
            }
        }
        int max2=0;
        for(int i=0;i<n;i++){
            int c_arr[]=new int[n+1];
            int m=0;
            for(int j=0;j<n;j++){
                c_arr[matrix[j][i]]++;
                if(c_arr[matrix[j][i]]>m){
                    m=c_arr[matrix[j][i]];
                }
            }
            if(m>max2){
                max2=m;
            }
        }
        if(max1==1){
            max1=0;
        }
        if(max2==1){
            max2=0;
        }
        System.out.println(d_sum+" "+max1+" "+max2);
    }
    
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int T= sc.nextInt();
        for(int t=1;t<=T;t++){
            int n= sc.nextInt();
            int matrix[][]= new int[n][n];
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j]=sc.nextInt();
                }
            }
            System.out.print("Case #1: ");
            vestigium(matrix,n);
            
        }
    }
}