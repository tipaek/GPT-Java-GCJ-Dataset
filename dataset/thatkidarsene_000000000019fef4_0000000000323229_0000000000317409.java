import java.util.*;
class Solution{
   int x;
   int y;
   String path;
   public Solution(int x,int y,String path){
       this.x=x;
       this.y=y;
       this.path=path;
   }
   static int abs(int n){
    return (int)Math.abs(n);
   }
   public static String solve(Solution s){
   //System.out.println("x : "+s.x+" y : "+s.y+"LENGTH : "+s.path.length()+" path : "+s.path);
       for(int i=0;i<s.path.length();i++){
           if(s.path.charAt(i)=='N'){s.y++;}
           if(s.path.charAt(i)=='S'){s.y--;}
           if(s.path.charAt(i)=='E'){s.x++;}
           if(s.path.charAt(i)=='W'){s.x--;}
          //System.out.println("x : "+s.x+" y : "+s.y+"i : "+i);
           if(abs(s.x)+abs(s.y)<=(i+1)){return Integer.toString(i+1);}
       }
       return "IMPOSSIBLE";
   }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
    Solution[] tab = new Solution[T];
        for(int i=0;i<T;i++){
            int x = s.nextInt();
            int y = s.nextInt();
            s.skip(" ");
         // s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String path = s.nextLine();
       // System.out.println(path);
        tab[i] = new Solution(x,y,path);
       // System.out.println(tab[i].path);
        }
        for(int i=0;i<T;i++){
        System.out.println("Case #"+i+": "+solve(tab[i]));
        }
    }
}