import java.util.*;

class Solution {

  static boolean countFreq(int arr[], int n) 
  { 
      Map<Integer, Integer> mp = new HashMap<>(); 
      for (int i = 0; i < n; i++) 
      { 
          if (mp.containsKey(arr[i]))  
          { 
              mp.put(arr[i], mp.get(arr[i]) + 1);
          }  
          else
          { 
              mp.put(arr[i], 1); 
          } 
      } 
      for (Map.Entry<Integer, Integer> entry : mp.entrySet()) 
      {
        if(entry.getValue()>= 3){
          return true;
        }
        // System.out.println(entry.getKey() + " " + entry.getValue() ); 
      } 
      return false;
  }

  public static void main(String[] args) throws Exception{
    Scanner x = new Scanner(System.in);
    int t = x.nextInt();
    int n = 0;
    for(int z=0; z<t; z++){
      n = x.nextInt();
      if(n==2){
        System.out.println("Case #"+(z+1)+": CJ");
        continue;
      }
      ArrayList<Integer> s = new ArrayList<>();
      ArrayList<Integer> e = new ArrayList<>();
      for(int i=0; i<n; i++){
        s.add( x.nextInt() );
        e.add( x.nextInt() );
      }

      int[] arr = s.stream().mapToInt(i -> i).toArray();
      // Object[] u = s.toArray();
      if(countFreq(arr, arr.length)){
        System.out.println("Case #"+(z+1)+": IMPOSSIBLE");
        continue;
      }
      boolean c=false,j=false;
      boolean first = true , continue_flag=false;
      String ab[] = new String[1000];

      // System.out.println(s);
      // System.out.println(e);
      for(int time=0;time<=1440;time++){
        continue_flag=false;

          if(e.contains(time)){
            // System.out.println("##1 C="+c+" J="+j+" time="+time+" e.index="+e.indexOf(time));

            if( ab[e.indexOf(time)].equals("C") ){
              c=false;
            } 
            if( ab[e.indexOf(time)].equals("J") ){
              j=false;
            }
            // System.out.println("##2 time="+time+" c="+c+" j="+j+" e.index="+e.indexOf(time)+" ab[]="+ab[e.indexOf(time)]);

            // s.remove(e.indexOf(time));
            // e.remove(e.indexOf(time));

            // System.out.println("\n"+s);
            // System.out.println(e);

            // ? Second check
              for(int k=e.indexOf(time)+1; k<e.size(); k++){
                  if(e.get(k).equals(time)){
                    if( ab[k].equals("C") ){
                      c=false;
                    }
                    if( ab[k].equals("J") ){
                      j=false;
                    }
                    // System.out.println("##2.5 time="+time+" c="+c+" j="+j+" e.get="+e.get(k)+" ab[]="+ab[e.indexOf(time)]);
                    // s.remove(e.indexOf(time));
                    // e.remove(e.indexOf(time));
        
                    // System.out.println("\n"+s);
                    // System.out.println(e);
                  }
              }
              // System.out.println(s);
              // System.out.println(e);
              // for(int i=0;i<n;i++){
              //   System.out.print(""+ab[i]);
              // }
              // System.out.println("");
        
          }

          if(s.contains(time)){
            // System.out.println("##3 C="+c+" J="+j+" time="+time+" s.index="+s.indexOf(time));
                if(first){
                  c=true;
                  ab[s.indexOf(time)] = "C";
                  //? Second check
                      for(int k=s.indexOf(time)+1; k<s.size(); k++){
                            if(s.get(k).equals(time)){
                              j=true;
                              ab[k]="J";
                              for(int p=k;p<s.size();p++){
                                if(s.get(k).equals(time)){
                                  continue_flag=true;
                                  break;
                                }
                              }
                              break;
                            }
                      }

                  // for(int i=0;i<n;i++){
                  //   System.out.print(""+ab[i]);
                  // }
                  // System.out.println("\n");      
                  first= false;
                  // System.out.println("##4 C="+c+" J="+j);
                  if(!continue_flag){
                    continue;
                  }
                }

          else{

              if(c && j) {
                System.out.println("Case #"+(z+1)+": IMPOSSIBLE");
                continue_flag=true;
                break;
              } 
              else if(c && !j) {
                j=true;
                ab[s.indexOf(time)] = "J";
              } 
              else if(!c && j) {
                c=true;
                ab[s.indexOf(time)] = "C";
              } 
              else {
                c=true;
                ab[s.indexOf(time)] = "C";
              }
    
              for(int k=s.indexOf(time)+1; k<s.size(); k++){
                  if(s.get(k).equals(time)){
                    if(c && j) {
                      System.out.println("Case #"+(z+1)+": IMPOSSIBLE");
                      continue_flag=true;
                      break;
                    } 
                    else if(c && !j) {
                      j=true;
                      ab[s.indexOf(time)] = "J";
                    } 
                    else if(!c && j) {
                      c=true;
                      ab[s.indexOf(time)] = "C";
                    } 
                    else {
                      c=true;
                      ab[s.indexOf(time)] = "C";
                    }    
                  }
              }
              // System.out.println("##5 C="+c+" J="+j);
              if(continue_flag){
                continue;
              }
            }
            // System.out.println("##6 C="+c+" J="+j);
          }

      }
      if(continue_flag){
        continue;
      }

      //? Printing ans
      System.out.print("Case #"+(z+1)+": ");
      for(int i=0;i<n;i++){
        System.out.print(""+ab[i]);
      }
      System.out.println("");



    }
    x.close();
  }
}

