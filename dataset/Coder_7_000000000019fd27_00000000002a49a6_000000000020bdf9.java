import java.util.*;


class Solution{
    static class Pair{
        int first;
        int second;
        int pos;
        String name;
    }
   public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int cases=Integer.parseInt(in.nextLine());
    int count=1;
    for(int i=0; i<cases; i++){
        int size=Integer.parseInt(in.nextLine());
        Pair []p=new Pair[size];
        for(int j=0; j<size; j++){
         String []next=in.nextLine().split(" ");
         int start=Integer.parseInt(next[0]);
         int end=Integer.parseInt(next[1]);
         Pair n=new Pair();
         n.first=start;
         n.second=end;
         n.pos=j;
         p[j]=n;
         
        }
        
      Arrays.sort(p, new Comparator<Pair>() {
      @Override
      public int compare(Pair p1, Pair p2) {
        if(p1.first>p2.first){return 1;}
        else if(p1.first<p2.first){return -1;}
        else{
          return 0;
        }
       }
       });
      
      int c=0;
      int j=0;
      String []result=new String[size];
      boolean done=true;
      for(int k=0; k<size; k++){
        Pair next=p[k];
        if(c<=next.first){
          c=next.second;
          result[next.pos]="C";
        }
        else if(j<= next.first){
          j=next.second;
          result[next.pos]="J";
          
        }
        else{
          done=false;
          break;
        }
      }
      
      if(done){
       System.out.print("Case #"+count+": ");
       for(int q=0; q<size; q++){
        System.out.print(result[q]);
       }
        System.out.println();
      }else{System.out.println("Case #"+count+": IMPOSSIBLE");}
      count++;
    }
    
  }
}