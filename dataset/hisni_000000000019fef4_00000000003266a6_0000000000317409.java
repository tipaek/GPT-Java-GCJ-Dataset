import java.util.*;

public class Solution{

    public static int findY( char[] a, int YD){        
        for(int j=1;j<=a.length;j++){
            if( a[j-1] == 'N' ){
                YD++;
            }
            else if( a[j-1] == 'S' ){
                YD--;
            }
        }

        return Math.abs(YD);
    }

    public static int findX( char[] a, int XD){        
        for(int j=1;j<=a.length;j++){
            if( a[j-1] == 'E' ){
                XD++;
            }
            else if( a[j-1] == 'W' ){
                XD--;
            }
        }

        return Math.abs(XD);
    }
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        s.nextLine();
        for(int i=1; i<=t;i++){
            
            String[] arr = s.nextLine().split(" ");
            int XD = Integer.parseInt(arr[0]);
            int YD = Integer.parseInt(arr[1]);
            char[] a = arr[2].toCharArray();

            int N = 0; int S = 0; int E = 0; int W = 0;
            int minX = XD; int minXT = 0;
            int minY = YD; int minYT = 0;

            for(int j=1;j<=a.length;j++){
                if( a[j-1] == 'N' ){
                    YD++;
                    N++;
                }
                else if( a[j-1] == 'S' ){
                    YD--;
                    S++;
                }
                else if( a[j-1] == 'E' ){
                    XD++;
                    E++;
                }
                else{
                    XD--;
                    W++;
                }

                if( Math.abs(XD) < minX ){
                    minX = Math.abs(XD);
                    minXT = j;
                }
                if( Math.abs(YD) < minY ){
                    minY = Math.abs(YD);
                    minYT = j;
                }
            }

            int minT = Math.max(minXT, minYT);
            int minD = minX + minY;
            
            if( minD > minT ){
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }else{
                int res;
                int time;
                if( minX >= minY ){
                    res = minX;
                    char[] carr = arr[2].substring(0,res).toCharArray();
                    time = findY( carr,Integer.parseInt(arr[1]) );
                }else{
                    res = minY;
                    char[] carr = arr[2].substring(0,res).toCharArray();
                    time = findX(carr,Integer.parseInt(arr[0]));
                }
               
                res += (int)Math.ceil( (double)time/2 );

                System.out.println("Case #" + i + ": "+res);
            }

            // System.out.println("******"+N+" "+S+" "+E+" "+W);
            // System.out.println("Case #" + i + ": " + res);
            
        }
       
    }
}