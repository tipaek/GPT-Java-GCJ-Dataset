import java.util.*;
import java.lang.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        short t= sc.nextShort();
        while(t-->0){
            short n = sc.nextShort();
            short tr = 0,dr = 0,dc = 0;
            boolean vis[] = new boolean[n];
            Object mat[] = new HashMap<Short,Short>[n+1];
            for(short i=0;i<n;i++){
                HashMap<Short,Short> hp = new HashMap<Short,Short>();
                
                for(short j=0;j<n;j++){
                    short x = sc.nextShort();
                    // trace
                    if(i==j) tr +=x;
                    
                    // dupli row
                    if(hp.containsKey(x)){
                        dr++;
                        break;
                    }
                    else hp.put(x,(short)1);
                    
                    // dupli col
                    if(!vis[j]){
                        if(mat[j].containsKey(x)){
                            vis[j] = true;
                            dc++;
                        }
                        else mat[j].put(x,(short)1);
                    }
                }
            }
            System.out.println(tr+" "+dr+" "+dc);
        }
    }
}