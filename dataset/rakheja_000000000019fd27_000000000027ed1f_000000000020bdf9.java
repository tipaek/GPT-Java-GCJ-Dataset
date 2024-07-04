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
                int b[][] = new int[n][3];
                for(int j=0; j<n; j++){
                    b[j][2] = j;
                    for(int k=0; k<2; k++){
                        b[j][k] = a[j][k];
                    }
                }
                for(int j=0; j<n-1; j++){
                    for(int k=0; k<n-j-1; k++){
                        if(b[k][0] > b[k+1][0]){
                            int temp = b[k][0];
                            b[k][0] = b[k+1][0];
                            b[k+1][0] = temp;
                            temp = b[k][1];
                            b[k][1] = b[k+1][1];
                            b[k+1][1] = temp;
                            temp = b[k][2];
                            b[k][2] = b[k+1][2];
                            b[k+1][2] = temp; 	
                        }
                    }
                }
                System.out.println("");
                for(int j=0; j<n; j++){
                    for(int k=0; k<3; k++){
                        System.out.print(b[j][k] + "	");
                    }
                    System.out.println("");
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
                char fin[] = new char[n];
                fin[0] = 'C';
                String out = "";
                for(int j=0; j<n-1; j++){
                    boolean ab = false;
                    if((b[j][1] > b[j+1][0])||((j!=0)&&(b[j][0] < b[j-1][1])))
                        ab = true;
                    if(ab) {
                        activeind = 1 - activeind;
                        active = opt.charAt(activeind);
                        int x = b[j+1][2];
                        fin[x] = active;
                    }
                    else{
                        int x = b[j+1][2];
                        fin[x] = active;
                    }
                }
                for(int j=0; j<n; j++){
                    out += fin[j];
                }
                System.out.println("Case #" + (i+1) + ": " + out);
            }
        }
        else
            System.exit(0);
    }
}