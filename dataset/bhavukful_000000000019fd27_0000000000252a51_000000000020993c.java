import java.util.Scanner;
import java.util.HashMap;


class solution{
   public static void main(String args[]){
    
    
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for(int i=0;i<T;i++){
        int N = in.nextInt();
        int matrix[][] = new int[N][N];
        int trace = 0;
        for(int j=0;j<N;j++){
            for(int k=0;k<N;k++){
                matrix[j][k] = in.nextInt();
                if(j==k)
                trace+=matrix[j][k];
            }
        }
        
        HashMap<Integer,Boolean> map = new Hashmap<>();
        int r = 0;
        for(int j=0;j<N;j++){
            for(int k=0;k<N;k++){
                if(map.containsKey(matrix[j][k])){
                    r++;
                    break;
                }
                else
                    map.put(matrix[j][k],true);
                
            }
            map.clear();
        }
        int c=0;
        for(int k=0;k<N;k++){
            for(int j=0;j<N;j++){
                if(map.containsKey(matrix[j][k])){
                    c++;
                    break;
                }
                else
                    map.put(matrix[j][k],true);
                
            }
            map.clear();
        }
        
        
        System.out.println("Case #"+i+": "+trace+" "+r+" "+c);
        
    }
    
    
    
    
} 
}



