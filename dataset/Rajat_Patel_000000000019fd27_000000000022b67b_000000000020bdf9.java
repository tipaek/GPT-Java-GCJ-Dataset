import java.util.*;
import java.io.*;
/**
 * CODJAM20_3_1
 */
class Solution {
    static class FastReader 
        { 
            BufferedReader br; 
            StringTokenizer st; 
      
            public FastReader() 
            { 
                br = new BufferedReader(new
                         InputStreamReader(System.in)); 
            } 
      
            String next() 
            { 
                while (st == null || !st.hasMoreElements()) 
                { 
                    try
                    { 
                        st = new StringTokenizer(br.readLine()); 
                    } 
                    catch (IOException  e) 
                    { 
                        e.printStackTrace(); 
                    } 
                } 
                return st.nextToken(); 
            } 
      
            int nextInt() 
            { 
                return Integer.parseInt(next()); 
            } 
      
            long nextLong() 
            { 
                return Long.parseLong(next()); 
            } 
      
            double nextDouble() 
            { 
                return Double.parseDouble(next()); 
            } 
      
            String nextLine() 
            { 
                String str = ""; 
                try
                { 
                    str = br.readLine(); 
                } 
                catch (IOException e) 
                { 
                    e.printStackTrace(); 
                } 
                return str; 
            } 
        } 
    public static void main(String[] args) {
        FastReader sc=new FastReader();
        int t=sc.nextInt();
        for(int w=1;w<=t;w++){
            int n=sc.nextInt();
            Points points[]=new Points[n];
            for(int i=0;i<n;i++){
                int x=sc.nextInt();
                int y=sc.nextInt();
                points[i]=new Points(x, y);
           }
           List<List<Integer>> list=new ArrayList<>();
           char ans[]=new char[n];
           for(int i=0;i<n;i++){
               list.add(i,new ArrayList<>());
               for(int j=i+1;j<n;j++){
                   if(((points[i].x<points[j].x)&&(points[i].y>points[j].y))||
                   ((points[i].x<points[j].x)&&(points[i].y>points[j].x))||((points[i].x>points[j].x)
                   &&points[i].x<points[j].y)){
                        list.get(i).add(j);
                   }
               }
           }
          /* for(List<Integer> temp:list){
               System.out.println(temp);
           }*/
           boolean isbreak=false;
           for(int i=0;i<n;i++){
              if(list.get(i).size()==n-1){
                  isbreak=true;
                  break;
              }
              if(ans[i]!='C'&&ans[i]!='J'){
                  ans[i]='C';
              } 
              for(int j:list.get(i)){
                if(ans[i]=='C')
                    ans[j]='J';
                else
                    ans[j]='C';
              }
           }
           System.out.print("Case #"+w+": ");
           if(isbreak)
           System.out.println("IMPOSSIBLE");
           else
           System.out.println(String.valueOf(ans));
        }
    }
}
class Points{
    int x,y;
    Points(int x,int y){
        this.x=x;
        this.y=y;
    }
}