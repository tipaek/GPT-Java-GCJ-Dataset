import java.util.*;
class Example {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double trace =0;
        int rcntr=0;
        int ccntr=0;
        int T = sc.nextInt();
        for(int i=0;i<T;i++) {
            int N = sc.nextInt();
            double arr[][] = new double[N][N];
            for(int j=0;j<arr.length;j++) {
                for(int k=0;k<arr.length;k++) {
                    arr[i][j] = sc.nextDouble(); 
                }
            }
            for(int j=0;j<arr.length;j++) {
                for(int j=0;j<arr.length;j++) {
                    if(j==k) {
                        trace+=arr[j][k];
                    }
                    int num = arr[j][k];
	                for (int l = k + 1;l < arr.length;l++)
	                {
	                    if (num == arr[j][l])
	                    {
	                        rcntr++;
	                    }
	                }
	                for (int l = k + 1;l < arr.length;l++)
	                {
	                    if (num == arr[l][j])
	                    {
	                        ccntr++;
	                    }
	                }
                }    
            }   
        
            System.out.println("Case #"+ T +": "+trace+" "+rcntr+" "+ccntr);
        }
    }
}