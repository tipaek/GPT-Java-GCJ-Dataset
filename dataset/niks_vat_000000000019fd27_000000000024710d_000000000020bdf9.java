import java.util.*;

class Solution{

    static class Ranges implements Comparable<Ranges>{
        int start;
        int end;
        public Ranges(int s, int e){
            this.start=s;
            this.end=e;
        }

        public int compareTo(Ranges o){
            return this.start-o.start;
        }


    }
    
    
    public static void main(String... args){
        
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=1;t<=T;t++){
            
            HashMap<String, Character> hm = new HashMap<>();
            ArrayList<String> org = new ArrayList<>();

            int n = in.nextInt();
            ArrayList<Ranges> al = new ArrayList<Ranges>();
            for(int i=0;i<n;i++){
                int start = in.nextInt();
                int end = in.nextInt();
                al.add(new Ranges(start, end));
                org.add(String.valueOf(start)+"|"+String.valueOf(end));
            }

            Collections.sort(al);

            String ans = "";
            int c = 0;
            int j = al.get(0).end;
            hm.put(al.get(0).start+"|"+al.get(0).end, 'J');

            boolean impos = false;
            for(int i=1;i<n;i++){
                Ranges curr = al.get(i);
                if(curr.start<c){
                    if(curr.start<j){
                        impos=true;
                        break;
                    }else{
                        //ans+="J";
                        hm.put(String.valueOf(curr.start)+"|"+String.valueOf(curr.end), 'J');
                        j = Math.max(j, curr.end);
                    }
                }else{
                    //ans+="C";
                    hm.put(String.valueOf(curr.start)+"|"+String.valueOf(curr.end), 'C');
                    c = Math.max(c,curr.end);
                }
            }

            

            if(impos){
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }else{
                for(int i=0;i<n;i++){
                    ans += hm.get(org.get(i));
                }
                System.out.println("Case #"+t+": "+ans);
            }



        }
        
    }

   
   
    
}