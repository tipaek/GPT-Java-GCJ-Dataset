import java.util.*;

public class Solution{
    static int x;
    static int y;
    public static void main(String args[]){
        
        Scanner s = new Scanner(System.in);
        int tc = s.nextInt();
        
        for(int t = 1;t<=tc;++t){
            
            int X = s.nextInt();
            int Y = s.nextInt();
            x = X;
            y = Y;
            String steps = Steps(0,0,"",1);
            if(steps.equals("")){
                steps = "IMPOSSIBLE";
            }
            
            System.out.println("Case #" + t +": "+ steps);
        }
    }
    private static String Steps(int m,int n,String ans,int i){
        
        if(m == x && n == y){
            return ans;
        }
       
        if(x > 0 && y > 0){
            if(m > 0 && n > 0){
                if(m > x || n > y){
                    return "";
                }
            }
            else if(m < 0 && n > 0){
                if( m < -x || n > y){
                    return "";
                }
            }
            else if(m < 0 && n < 0){
                if( m < -x || n < -y){
                    return "";
                }
            }
            else if(m > 0 && n < 0){
                if( m > x || n < -y){
                    return "";
                }
            }
           
        }
        else if(x < 0 && y > 0){
            if(m > 0 && n > 0){
                if(m > -x || n > y){
                    return "";
                }
            }
            else if(m < 0 && n > 0){
                if( m < x || n > y){
                    return "";
                }
            }
            else if(m < 0 && n < 0){
                if( m < x || n < -y){
                    return "";
                }
            }
            else if(m > 0 && n < 0){
                if( m > -x || n < -y){
                    return "";
                }
            }
        }
        else if(x < 0 && y < 0){
            if(m > 0 && n > 0){
                if(m > -x || n > -y){
                    return "";
                }
            }
            else if(m < 0 && n > 0){
                if( m < x || n > -y){
                    return "";
                }
            }
            else if(m < 0 && n < 0){
                if( m < x || n < y){
                    return "";
                }
            }
            else if(m > 0 && n < 0){
                if( m > -x || n < y){
                    return "";
                }
            }
        }
        else if(x > 0 && y < 0){
            if(m > 0 && n > 0){
                if(m > x || n > -y){
                    return "";
                }
            }
            else if(m < 0 && n > 0){
                if( m < -x || n > -y){
                    return "";
                }
            }
            else if(m < 0 && n < 0){
                if( m < -x || n < y){
                    return "";
                }
            }
            else if(m > 0 && n < 0){
                if( m > x || n < y){
                    return "";
                }
            }
        }
        
        int east = m + pow(2,i-1);
        int west = m - pow(2,i-1);
        int north = n + pow(2,i-1);
        int south = n - pow(2,i-1);
        
        String N = Steps(m,north,ans + "N",i+1);
        String E = Steps(east,n,ans + "E",i+1);
        String W = Steps(west,n,ans + "W",i+1);
        String S = Steps(m,south,ans + "S",i+1);
        
        int min = Integer.MAX_VALUE;
        String minString= "";
        if(N.length()<min){
            min = N.length();
            minString = N;
        }
        if(E.length()<min){
            min = E.length();
            minString = E;
        }
        if(W.length()<min){
            min = W.length();
            minString = W;
        }
        if(S.length()<min){
            min = S.length();
            minString = S;
        }
        
        return minString;
    }
    private static int pow(int x,int n){
        
        int ans  = 1;
        for(int i = 0;i<n;++i){
            ans*=x;
        }
        return ans;
    }
}