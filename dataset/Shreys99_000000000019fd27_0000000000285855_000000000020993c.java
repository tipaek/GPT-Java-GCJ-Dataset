
import java.util.*;

class codjm1 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++){
            int n=s.nextInt();
            int A[][]=new int[n][n];
            int sum=0;
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    A[j][k]=s.nextInt();
                    if(j==k)
                        sum+=A[j][k];
                }
            }
            System.out.println("Case #"+(i+1)+":"+sum+" "+rep.rep(A)+" "+cop.cop(A));
            
        }
    }
    
}
class rep{
    static int rep(int h[][]){
        int p,r,row=0;
        for(p=0;p<h.length;p++){
           r=rowcep.recep(p, h);
           row+=r;
        }
        return row;
    }
}
class cop{
    static int cop(int h[][]){
        int q,c,col=0;
        for(q=0;q<h.length;q++){
           c=colcep.colce(q, h);
           col+=c;
        }
        return col;
    }
}
class rowcep{
    static int recep(int u,int k[][]){
        int er=u;
        int co=0;
        Di:
        for(er=0;er<k.length;er++){
        int y=k[u][er];
        
        for(int e=er+1;e<k.length;e++){
            if(k[u][e]==y){
                co++;
                break Di;
            }
        }
        }
        return co;
    }
    
}
class colcep{
    static int colce(int ni,int l[][]){
        int m=ni;
        int coro=0;
        Si:
                for(m=0;m<l.length;m++){
        int w=l[m][ni];
        
        for(int e=m+1;e<l.length;e++){
            if(l[e][ni]==w){
                coro++;
                break Si;
            }
        }
        }
        return coro;
    }
}