import java.util.*;
class Solution{
    Scanner sc = new Scanner(System.in);
    void main(){
        int testcases = sc.nextInt();
        if(testcases>=1 && testcases<=100){
            for(int i=0; i<testcases; i++){
                int n = sc.nextInt();
                int a[][] = new int[n][2];
                //now accept start and end times
                for(int j=0; j<n; j++){
                    int m1 = sc.nextInt();
                    int m2 = sc.nextInt();
                    if (m1<m2 && m1>=0 && m2<=(24*60)){
                        a[j][0] = m1;
                        a[j][1]	= m2;
                    }
                    else
                    	System.exit(0);
                }
                int count=0;
                for(int j=0; j<n-1; j++){
                    if(a[j][1] > a[j+1][0]){
                        count++;
                    }
                }
                if(count==(n-1)){
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    System.exit(0);
                }
                String opt = "CJ";
                int activeind = 0;
                char active = opt.charAt(activeind);
                String fin = "C";
                boolean ab = false;
                for(int j=0; j<n-1; j++){
                    if(a[j][1] > a[j+1][0])
                        ab = true;
                        
                    if(ab) {
                        active = opt.charAt(opt.length() - 1 - activeind);
                        fin += active;
                    }
                    else
                        fin += active;
                    ab = false;
                }
                System.out.println("Case #" + (i+1) + ": " + fin);
            }
        }
    }
}