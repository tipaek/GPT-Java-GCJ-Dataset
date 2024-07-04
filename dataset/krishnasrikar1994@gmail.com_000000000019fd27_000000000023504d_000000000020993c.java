import java.util.*;
class Solution{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int c = 1;
        while(t-- > 0){
            int n = sc.nextInt();
            
            int col[] = new int[n];
            int trace = 0;
            int row = 0;
            int colval = 0;
            int nxor = 0;
            for(int i = 1 ;i <= n ;i++){
                nxor = nxor^i; 
            }
            for(int i = 0 ;i < n ;i++){
                col[i] = nxor; 
            }
            for(int i = 0 ;i < n ;i++){
                int rowXor = nxor;
                for(int j = 0 ;j < n ;j++){
                    int x = sc.nextInt();
                    rowXor = x^rowXor;
                    col[j] = col[j]^x;
                    if(i == j){
                        trace += x;
                    }
                }
                if(rowXor != 0)
                    row++;
            }
            for(int i = 0 ;i < n ;i++){
                if(col[i] != 0 )
                    colval++;
            }
            System.out.println("Case #"+ c + ":" + " " + trace + " " + row + " " + colval);
            c++;
        }
    }
}