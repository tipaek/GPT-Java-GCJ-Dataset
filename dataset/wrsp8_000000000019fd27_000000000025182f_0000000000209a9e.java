import java.util.*;
public class Solution{
    static Scanner in;
    static int bits;
    static int[] sol;
    public static void main(String[] args){
        in = new Scanner(System.in);
        int cases = in.nextInt();
        bits = in.nextInt();
        for(int i = 0; i < cases; i++){
            solve();
            in.nextLine();
            String resp = in.nextLine();
            if(resp.equals("N")){
                System.exit(0);
            }
        }
    }
    public static void solve(){
        sol = new int[bits];
        fill(sol);
        int tries = 1;
        boolean ready = false;
        boolean fullref = false;
        int refdb = -1;
        int refmb = -1;
        int dis = 0;
        
        while(!ready){
            
            if(tries%10==1&&tries!=1){
                if(fullref){
                    System.out.println(refdb+1);
                    System.out.flush();
                    tries++;
                    int tdb = in.nextInt();
                    System.out.println(refmb+1);
                    System.out.flush();
                    tries++;
                    int tmb = in.nextInt();
                    if(tdb==sol[refdb]&&tmb==sol[refmb]){
                        ;//igual
                    } else if (tdb!=sol[refdb]&&tmb==sol[refmb]){
                        reverse(sol);
                    } else if (tdb==sol[refdb]&&tmb!=sol[refmb]){
                        negate(sol);
                        reverse(sol);
                    } else if (tdb!=sol[refdb]&&tmb!=sol[refmb]){
                        negate(sol);
                    }
                } else if (refdb!=-1){
                    System.out.println(refdb+1);
                    System.out.flush();
                    tries++;
                    int tdb = in.nextInt();
                    System.out.println(1);//waste 
                    System.out.flush();
                    tries++;
                    int tmb = in.nextInt();
                    if(tmb!=sol[refmb]){
                        negate(sol);
                    }
                } else {
                    System.out.println(1);//waste
                    System.out.flush();
                    tries++;
                    int tdb = in.nextInt();
                    System.out.println(refmb+1); 
                    System.out.flush();
                    tries++;
                    int tmb = in.nextInt();
                    if(tdb!=sol[refdb]){
                        negate(sol);
                    }
                }
            }
            System.out.println(dis+1);
            System.out.flush();
            tries++;
            sol[dis]=in.nextInt();
            System.out.println(bits-dis);
            System.out.flush();
            tries++;
            sol[bits-dis-1]=in.nextInt();
            
            if(!fullref){
                if(sol[dis]==sol[bits-dis-1]){
                    refmb = dis;
                } else {
                    refdb = dis;
                }
                if(refmb!=-1&&refdb!=-1){
                    fullref = true;
                }
            }
            dis++;
            if(dis*2>=bits){
                ready = true;
            }
        }
        for(int i = 0; i < bits; i++){
            System.out.print(sol[i]);
        }
        System.out.flush();
    }
    
    public static void fill(int[] m){
        for(int i=0; i<m.length;i++){
            m[i] = -1;
        }
    }
    
    public static void negate(int[] m){
        for(int i=0; i<m.length; i++){
            if(m[i]==1){
                m[i] =0;
            } else if (m[i]==0) {
                m[i] =1;
            }
        }
    }
    public static void reverse(int[] m){
        for(int i=0; i<m.length/2; i++){
            int temp = m[i];
            m[i] = m[bits-1-i];
            m[bits-1-i]= temp;
        }
    }
}