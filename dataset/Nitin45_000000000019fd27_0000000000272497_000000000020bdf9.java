import java.util.*;

class Time{
 int start;
 int end  ;
 int id   ;

 public Time(int start , int end , int id){
   this.start = start;
   this.end   = end;
   this.id    = id;
 }
 public String toString(){
    return start + " " + end;
 }
}

class Solution{
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int test = sc.nextInt();
    int start , end , cstart , jstart , cend , jend , n;
    char[] ans;
    boolean flag = true;
    int j ;
    PriorityQueue<Time> pq ;
    Comparator<Time> cmp = (t1 , t2)->{
       return t1.start > t2.start ? 1 : -1;
    };
    Time temp;

    for(int i = 1 ; i <= test ; i++){
      n = sc.nextInt();
      pq = new PriorityQueue(cmp);
      ans = new char[n];
      for(j = 0 ; j < n ; j++){
        start = sc.nextInt();
        end   = sc.nextInt();
        pq.add(new Time(start , end , j)) ;
      }
      temp = pq.remove();
      cstart = temp.start;
      cend   = temp.end;
      ans[temp.id] = 'C';
      jstart = jend = -1;
      flag = true;
      while(!pq.isEmpty()){
           temp = pq.remove();
           if(temp.end <= cstart || temp.start >= cend){
            ans[temp.id] = 'C';
            cstart = temp.start;
            cend   = temp.end;
           }
           else  if(temp.end <= jstart || temp.start >= jend){
              ans[temp.id] = 'J';
              jstart = temp.start;
              jend   = temp.end;
           }

           else{
             flag = false;
             break;
           }
      }
      if(flag)
        System.out.println("Case #" + test + ": "  +  ans);
      else
         System.out.println("Case #" + test + ": "  + "IMPOSSIBLE");
}
    }
  }