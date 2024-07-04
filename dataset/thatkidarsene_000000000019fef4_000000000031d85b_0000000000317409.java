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
   public static String solve(Solution s){
       for(int i=0;i<s.path.length();i++){
           if(s.path.charAt(i)=='N'){s.y++;}
           if(s.path.charAt(i)=='S'){s.y--;}
           if(s.path.charAt(i)=='E'){s.x++;}
           if(s.path.charAt(i)=='W'){s.x--;}
           if(s.x+s.y<=(i+1)){return Integer.toString(i+1);}
           
           
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
            s.next();
        String path = s.nextLine();
        tab[i] = new Solution(x,y,path);
        }
        for(int i=0;i<T;i++){
        System.out.println("Case #"+i+": "+solve(tab[i]));
        }
    }
}