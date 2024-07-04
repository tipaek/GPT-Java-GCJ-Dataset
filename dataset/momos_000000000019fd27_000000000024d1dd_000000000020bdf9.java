import java.util.*;

class time implements Comparable<time>{
    int start;
    int end;
    time(int s, int e){
        start = s;
        end = e;
    }
    
    public int compareTo(time t){
        if(this.start == t.start) return 0;
        else if(this.start > t.start) return 1;
        else return -1;
    }
}

class Solution{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0;i<t;i++){
            int n = s.nextInt();
            ArrayList<time> l = new ArrayList<time>();
            HashMap<String, Integer> indexMap = new HashMap<String,Integer>();
            //StringBuffer res = new StringBuffer("");
            for(int j=0;j<n;j++){
                int ss = s.nextInt();
                int e = s.nextInt();
                time tm = new time(ss,e);
                l.add(tm);
                String key = ss+"|"+e;
                indexMap.put(key,j);
            }
            Collections.sort(l);
            int ltej = Integer.MIN_VALUE;
            int ltec = Integer.MIN_VALUE;
            
            char res[] = new char[n];
            int cnt = 0;
            
            for(int j=0;j<n;j++){
                time tm = l.get(j);
                String key = tm.start+"|"+tm.end;
                int ind = indexMap.get(key);
                //System.out.println(ltej+" "+ltec+" "+tm.start+" "+tm.end);
                if(ltej <= tm.start){
                    res[ind] = 'J';
                    //res.append("J");
                    ltej = tm.end;
                    cnt++;
                }
                else if(ltec <= tm.start){
                    res[ind] = 'C';
                    //res.append("C");
                    ltec = tm.end;
                    cnt++;
                }
                else{
                    break;
                }
            }
            
            if(cnt != n) System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            else System.out.println("Case #"+(i+1)+": " + String.valueOf(res));
            
        }
    }
    
}