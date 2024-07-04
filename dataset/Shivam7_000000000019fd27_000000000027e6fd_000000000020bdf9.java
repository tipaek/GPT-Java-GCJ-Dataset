import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static class pair{
        Integer start,end,index;
        public pair(Integer s, Integer e, Integer ind){
            start = s;
            end = e;
            index = ind;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        for(int t=1;t<=test;t++){
            int n = scanner.nextInt(),s,e;
            List<pair> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                s = scanner.nextInt();
                e = scanner.nextInt();
                list.add(new pair(s,e,i));
            }
            list.sort(new Comparator<pair>() {
                @Override
                public int compare(pair t1, pair t2) {
                    if(t1.end.equals(t2.end))
                        return 0;
                    if(t1.end < t2.end)
                        return -1;
                    return 1;
                }
            });
//            System.out.println("Debug info");
//            for(pair p:list){
//                System.out.print(p.start + ": " + p.end + "--");
//            }
//            System.out.println();
            int p1End=-1, p2End=-1;
            boolean flag = true;
            char[] ans = new char[n];
            for(int i=0;i<n;i++){
                pair val = list.get(i);
                if(val.start < p1End && val.start < p2End){
                    flag = false;
                    break;
                }
                else if(val.start >= p1End && val.start>= p2End){
                    if(p1End < p2End){
                        p2End = val.end;
                        ans[val.index] = 'J';
                    }
                    else{
                        p1End = val.end;
                        ans[val.index] = 'C';
                    }
                }
                else if(val.start >= p1End){
                    p1End = val.end;
                    ans[val.index] = 'C';
                }
                else{
                    p2End = val.end;
                    ans[val.index] = 'J';
                }
            }
            if(flag){
                System.out.println(String.format("Case #%d: %s",t,String.copyValueOf(ans)));
            }
            else{
                System.out.println(String.format("Case #%d: IMPOSSIBLE",t));
            }

        }

    }
}
