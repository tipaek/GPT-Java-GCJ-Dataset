import java.util.*;

class Solution {
  public static void main(String[] args) {
    Scanner x = new Scanner(System.in);
    int t = x.nextInt();
    int n = 0;
    String ans= "";
    for(int z=0; z<t; z++){
      n = x.nextInt();
      if(n==2){
        System.out.println("Case #"+(z+1)+": CJ");
        continue;
      }
      ans = "";
      ArrayList<Integer> s = new ArrayList<>();
      ArrayList<Integer> e = new ArrayList<>();
      // int s[] = new int [n];
      // int e[] = new int [n];
      for(int i=0; i<n; i++){
        s.add( x.nextInt() );
        e.add( x.nextInt() );
      }
      boolean c=false,j=false;
      boolean first = true , continue_flag=false;
      ArrayList<String> a = new ArrayList<String>(1000); 
      String ab[] = new String[1000];
      // System.out.println(s);
      // System.out.println(e);
      for(int time=0;time<1440;time++){
        continue_flag=false;

        if(e.contains(time)){
          // s.indexOf(  s.get( e.indexOf(time) )  );
          // System.out.println(" C="+c+" J="+j+" time="+time+" e.index="+e.indexOf(time));

          if( ab[e.indexOf(time)].equals("C") ){
            c=false;
          } else if( ab[e.indexOf(time)].equals("J") ){
            j=false;
          } else {
            System.out.println("Error here");
          }
        }

        if(s.contains(time)){
          // System.out.println(" C="+c+" J="+j+" time="+time+" s.index="+s.indexOf(time));
          if(first){
            c=true;
            // System.out.println(" time="+time+" s.contains="+s.contains(time)+" "+s.indexOf(time));
            ab[s.indexOf(time)] = "C";
            // a.add( s.indexOf(time) , "C");
            first= false;
            continue;
          }
          if(c && j) {
            System.out.println("Case #"+(z+1)+": IMPOSSIBLE");
            continue_flag=true;
            break;
          } else if(c && !j) {
            j=true;
            ab[s.indexOf(time)] = "J";
            // a.add( s.indexOf(time) , "J" );
          } else if(!c && j) {
            c=true;
            ab[s.indexOf(time)] = "C";
            // a.add( s.indexOf(time) , "C" ); 
          } else {
            c=true;
            ab[s.indexOf(time)] = "C";
            // a.add( s.indexOf(time) , "C");
          }
        }


      }
      if(continue_flag){
        continue;
      }
      // System.out.println(" "+a+"\n");
      System.out.print("Case #"+(z+1)+": ");
      for(int i=0;i<n;i++){
        System.out.print(""+ab[i]);
      }
      System.out.println("");
      // System.out.println("Case #"+z+": "+ans);
    }
    x.close();
  }
}

