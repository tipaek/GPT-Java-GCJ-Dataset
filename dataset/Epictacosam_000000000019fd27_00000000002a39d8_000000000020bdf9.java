import java.util.*;

public class Solution{


    public static void main(String[] args){

        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();

        for(int i = 0 ; i < n ; i ++ ){

            int events = stdin.nextInt();
            // System.out.println("this many events " + events);
            int cBusyTill = 0;
            int jBusyTill = 0;
            List<event> eventsTimes = new ArrayList<>();

            System.out.print("Case #" + (i+1) + ": ");

            for(int j = 0 ; j < events; j++){
                int eventStart = stdin.nextInt();
                int eventEnd = stdin.nextInt();
                eventsTimes.add( new event(eventStart, eventEnd));
            }
            Collections.sort(eventsTimes);

            String solution = "";

            for(int j = 0 ; j < events ; j++ ){

                int start = eventsTimes.get(j).start;
                int end = eventsTimes.get(j).end;

                // 0 case fucking it up
                if(cBusyTill <=  start ){
                    cBusyTill = end;
                    // System.out.print("C");
                    solution += 'C';
                }
                
                else if(jBusyTill <= start ){
                    jBusyTill = end;
                    // System.out.print("J");
                    solution+= 'J';
                }

                else{
                    solution = "IMPOSSIBLE";
                    // System.out.print("IMPOSSIBLE");
                    break;
                }

            }
            System.out.println(solution);
        }

        stdin.close();


    }

    public static class event implements Comparable<event>{
        int start;
        int end;
        
        public event(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(event x) {
          if ( x.start < this.start) {
            return 1;
          }
    
          else if(x.start == this.start){
    
            if(x.end < this.end)
                return 1;
            else if (x.end == this.end){
                
                return 0;
            }
    
            else 
                return(-1);
    
          }
    
          else 
            return(-1);
        }

    }

}