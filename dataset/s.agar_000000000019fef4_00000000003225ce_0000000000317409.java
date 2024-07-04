import java.io.*;
import java.util.*;
class Solution{
    public static void main() throws Exception{
     try{    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int r=0;
        while(T--!=0){
            r++;
            StringTokenizer str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            String m = str.nextToken();
            System.out.println(m);
            int len = m.length();
            int my_x = 0;
            int my_y = 0;
            int ans =-1;
            /*System.out.println("x is - "+x);
            System.out.println("y is - "+y);
            System.out.println("my_x is - "+my_x);
            System.out.println("my_y is - "+my_y);*/
            for(int i=0; i<len; i++)
            {
                if(x==my_x && y==my_y){
                    ans = i;
                    break;
                }
                char ch = m.charAt(i);
                if(ch=='E'){
                    if(x>my_x){
                        x=x+1;
                        my_x=my_x+1;
                    }
                    else if(x==my_x){
                        x=x+1;
                        my_y=my_y+1;
                    }
                    /*System.out.println("x is - "+x);
                    System.out.println("y is - "+y);
                    System.out.println("my_x is - "+my_x);
                    System.out.println("my_y is - "+my_y);*/
                }
                else if(ch=='N'){
                    if(y>my_y){
                        y=y+1;
                        my_y=my_y+1;
                    }
                    else if(y==my_y){
                        y=y+1;
                        my_x=my_x+1;
                    }
                    /*System.out.println("x is - "+x);
                    System.out.println("y is - "+y);
                    System.out.println("my_x is - "+my_x);
                    System.out.println("my_y is - "+my_y);*/
                }
                else if(ch=='S'){
                    if(x==my_x && y-1!=my_y){
                        y=y-1;
                        my_y = my_y+1;
                    }
                    else if(x==my_x && y-1==my_y){
                        y=y-1;
                    }
                  
                    else if(x>my_x && y-1>=my_y){
                        y=y-1;
                        my_x= my_x+1;
                    }
                    else if(x>my_x && y-1<my_y){
                        y=y-1;
                        my_y=my_y-1;
                    }
                    /*System.out.println("x is - "+x);
                    System.out.println("y is - "+y);
                    System.out.println("my_x is - "+my_x);
                    System.out.println("my_y is - "+my_y);*/
                }
                else if(ch=='W'){
                    if(y==my_y && x-1!=my_x){
                        x=x-1;
                        my_x = my_x+1;
                    }
                    else if(y==my_y && x-1==my_x){
                        x=x-1;
                    }
                    else if(y>my_y && x-1>=my_x){
                        x=x-1;
                        my_y= my_y+1;
                    }
                    else if(y>my_y && x-1<my_x){
                        x=x-1;
                        my_x=my_x-1;
                    }
                    /*System.out.println("x is - "+x);
                    System.out.println("y is - "+y);
                    System.out.println("my_x is - "+my_x);
                    System.out.println("my_y is - "+my_y);*/
                }
            }
            if(ans!=-1){
                System.out.println("Case #"+r+": "+ans);
            }
            else if(x==my_x && y==my_y){
                 System.out.println("Case #"+r+": "+len);
            }
            else{
                System.out.println("Case #"+r+": IMPOSSIBLE");
            }
        }
     }
     catch(Throwable Exception){
         return;
     }
    }
}