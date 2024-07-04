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
            ArrayList<HashMap<Short,Short>> mat = new ArrayList<HashMap<Short,Short>>(n);
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
                        if(mat.get(j).containsKey(x)){
                            vis[j] = true;
                            dc++;
                        }
                        else mat.get(j).put(x,(short)1);
                    }
                }
            }
            System.out.println(tr+" "+dr+" "+dc);
        }
    }
}