import java.util.*;

class Solution{

    // static String ans;
    
    
    public static void main(String... args){
        
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=1;t<=T;t++){

            int fx = in.nextInt();
            int fy = in.nextInt();


            int x=0;int y=0;
            HashSet<String> hs = new HashSet<>();
            //ans="IMPOSSIBLE";
            String ans = bfs(x,y,fx,fy);
            System.out.println("Case #"+t+": "+ ans);
        }
        
    }

    static class Node{
        int x; int y;
        String path;
        int i;
        public Node(int x, int y,String path, int i){
            this.x=x;
            this.y=y;
            this.path=path;
            this.i=i;
        }
    }

    public static String bfs(int x, int y, int fx, int fy){
        
        String ans="IMPOSSIBLE";

        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(0,0,"",0));
        HashSet<String> hs = new HashSet<>();
        while(q.size()>0){

            Node u = q.remove();
            int i = u.i;

            //System.out.println(u.x+" "+u.y+" "+i);
            hs.add(u.x+":"+u.y);

            if(u.x==fx && u.y == fy){
                return u.path;
            }
            if(u.x>50 || u.y>50 || u.x<-50 || u.y <-50){
                return ans;
            }

            x=u.x;
            y=u.y;
            if(!hs.contains(x+":"+(y-(1<<i))))
                q.add(new Node( x,y-(1<<i),u.path+"S",i+1  ));
            if(!hs.contains(x+":"+(y+(1<<i))))
                q.add(new Node( x,y+(1<<i),u.path+"N",i+1  ));
            if(!hs.contains((x-(1<<i))+":"+y))
                q.add(new Node( x-(1<<i),y,u.path+"W",i+1  ));
            if(!hs.contains((x+(1<<i))+":"+y))
                q.add(new Node( x+(1<<i),y,u.path+"E",i+1  ));



        }

        return ans;


        // if(x<-50 || y<-50 || x>50 || y>50){
        //     return;
        // }
        
        // if(x==fx && y==fy){
        //     ans = new String(curr);
        //     return;
        // }
        // if(hs.contains(x+":"+y)){
        //     return;
        // }
        
        // hs.add(x+":"+y);
        // //System.out.println(x+":"+y+" = "+i);
        // // if(x==2 && y==-1){
        // //     System.out.println("-------------------------------------------------");
        // //     System.out.println(i);
        // //     System.out.println(x+","+(y-(1<<i)));
        // //     System.out.println(x+","+(y+(1<<i)));
        // //     System.out.println((x-(1<<i))+","+y);
        // //     System.out.println((x+(1<<i))+","+y);
        // //     System.out.println("---");
        // // }

        // //go down
        // bfs(x,y-(1<<i),i+1,hs,fx,fy,curr+"S");
        
        // //go up
        // String ncurr = (curr.length()==0)?"N":(curr.charAt(curr.length()-1)=='N'? curr:curr+"N" );
        // bfs(x,y+(1<<i),i+1,hs,fx,fy,curr+"N");
        // //go left
        // bfs(x-(1<<i),y,i+1,hs,fx,fy,curr+"W");
        // //go right
        // bfs(x+(1<<i),y,i+1,hs,fx,fy,curr+"E");
        // hs.remove((x+":"+y));
    }
 
   
  
  

    
}