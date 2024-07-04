import java.util.*;
import java.io.*;
class Solution
{
    public static void main(String args[]) throws IOException
    {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        int counter = 0;
        
        while(testCases-- > 0) {    
            counter++;    
            int no = Integer.parseInt(br.readLine());
            LinkedList<P> al = new LinkedList<P>();
            
            for(int i=0; i<no; i++) {
                 StringTokenizer str= new StringTokenizer(br.readLine());        
                 int start = Integer.parseInt(str.nextToken());
                 int end = Integer.parseInt(str.nextToken());
                 al.add(new P(start,end));
            }
            
            Collections.sort(al, new CustomComparator());
            
            int C = -1;
            int J = -1;
            String s = "";
            boolean impossible = false;
            for(int j=0; j<3600; j++) {
                if(C == j) {
                    C = -1;
                }
                
                if(J == j) {
                    J = -1;
                }
                
                if((!al.isEmpty()) && al.peekFirst().start == j ) {
                    if(C == -1) {
                        P element = al.removeFirst();
                    
                        C = element.end;
                        s += "C";    
                    } else if(J == -1) {
                        P element = al.removeFirst();
                        J = element.end;
                            s += "J";
                    } else {
                        impossible = true;
                    }
                    
                }
                
            }
            
            if(impossible) {
                System.out.println("Case #"+counter+": IMPOSSIBLE");
            } else {
                
                System.out.println("Case #"+counter+": "+s);
            }
            
        }
    
 }
}
class P
{
    public int start,end;
    P(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
}
 class CustomComparator implements Comparator<P> {
    @Override
    public int compare(P o1, P o2) {
        return o1.start - o2.start;
    }
}