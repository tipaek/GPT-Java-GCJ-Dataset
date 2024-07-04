import java.util.*;
// Java program to print all permutations of a 
// given string. 
public class Solution 
{ 
    public static int flag;
    
    public static void main(String[] args) 
    { 
        Scanner scan = new Scanner(System.in);
        int T,N,K;
        int [] arr = {1,2,3}; 
        int n = arr.length; 
        Permutation permutation = new Permutation(); 
        //permutation.permute(arr, 0, n-1,swapHistory); 
        T=scan.nextInt();
        for(int t=0;t<T;t++){
            N=scan.nextInt();
            K=scan.nextInt();
            flag=0;
            
            arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=i+1;
            }
            
            permutation.permute(arr, 0, N-1,N,K,t); 
            
            if(flag==0){
                System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
            }
        }
        
        
    } 
  
    /** 
     * permutation function 
     * @param str string to calculate permutation for 
     * @param l starting index 
     * @param r end index 
     */
    private void permute(int [] arr, int l, int r,int N, int K,int t) 
    { 
        int traceAttempt;
        int [][]mat=new int[N][N];
        if (l == r) {
            traceAttempt=0;
            mat=new int[N][N];
            
            for(int i=0;i<arr.length;i++){
                //System.out.print(arr[i]+" "); 
            }

                //determine if among the permutations, any matching trace can be found
                for(int j=0;j<N*2;j=j+2){
                    traceAttempt+=arr[j%N];
                }
                
                if(traceAttempt==K){
                    if(flag==0){
                        System.out.println("Case #"+(t+1)+": POSSIBLE");
                        
                        //create matrix grid
                        //top diagonal
                        for(int start=0;start<N;start++){
                            for(int cont=0;cont<=start;cont++){
                                mat[start-cont][0+cont]=arr[start];
                            }
                        }
                        
                        //bottom diagonal
                        for(int start=1;start<N;start++){
                            for(int cont=0;cont<N-start;cont++){
                                mat[N-1-cont][start+cont]=arr[start-1];
                            }
                        }
    

                    
                        //print
                        for(int row=0;row<N;row++){
                            for(int col=0;col<N;col++){
                                System.out.print(mat[row][col]+" ");
                            }
                            System.out.println();
                        }
                        flag=1;
                    }
                }
            
        }else
        { 
            for (int i = l; i <= r; i++) 
            { 
                arr = swap(arr,l,i); 

                permute(arr, l+1, r,N,K,t); 
                
                arr = swap(arr,l,i); 
            } 
        } 
    } 

    public int [] swap(int [] g, int i, int j) 
    { 
        int temp; 
        
        int[] h = new int[g.length];
        System.arraycopy(g, 0, h, 0, h.length);
        
        temp=h[i];
        h[i]=h[j];
        h[j]=temp;
        
        return h;
    } 
  
} 
