import java.util.*;

public class Solution {

     public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        
        int T,N,K,R,C,flag;
        int [][] square;
        
        HashSet<Integer> found = new HashSet<Integer>(); 
        
        T=scan.nextInt();
        for(int t=0;t<T;t++){
            K=0;
            R=0;
            C=0;
            
            N=scan.nextInt();
            
            square=new int[N][N];
            for(int r=0;r<N;r++){
                for(int c=0;c<N;c++){
                    square[r][c]=scan.nextInt();
                }
            }
            
            //calc
            //K
            for(int r=0;r<N;r++){
                K+=square[r][r];
            }
            System.out.print("Case #"+(t+1)+": "+K+" ");
            
            //R
            for(int r=0;r<N;r++){
                found.clear(); 
                flag=0;
                for(int c=0;c<N;c++){
                    if ((found.contains(square[r][c]))) {
                        flag=1;
                        break;
                    }
                    found.add(square[r][c]); 
                }
                if(flag==1) R++;
            }
            System.out.print(R+" ");
            
            //C
            for(int c=0;c<N;c++){
                found.clear(); 
                flag=0;
                for(int r=0;r<N;r++){
                    if ((found.contains(square[r][c]))) {
                        flag=1;
                        break;
                    }
                    found.add(square[r][c]); 
                }
                if(flag==1) C++;
            }
            System.out.println(C+" ");
            //System.out.println(" ");
        }
     }
}