import java.util.*;

class Solution{

    static class Activity{
        int begin,end,id;
        Activity(int id, int begin, int end){
            this.id = id;
            this.begin = begin;
            this.end = end;
        }
    }

    static Scanner in = new Scanner(System.in);
    public static void main(String args[]){
        int nCases = in.nextInt();
        for(int i=1;i<=nCases;i++) solve(i);
    }

    static void solve(int nCase){
        int n = in.nextInt(), begin, end;
        Activity[] activities = new Activity[n];
        char[] ans = new char[n];
        for(int i=0;i<n;i++){
            activities[i] = new Activity(i, in.nextInt(), in.nextInt());
        }
        Arrays.sort(activities, (a,b)->{
            return a.begin-b.begin;
        });
        int c=0,j=0;

        for(Activity a:activities){
            if(a.begin>=c){
                c = a.end;
                ans[a.id] = 'C';
            }else if(a.begin>=j){
                j = a.end;
                ans[a.id] = 'J';
            }else{
                System.out.printf("Case #%d: IMPOSSIBLE\n", nCase);
                return;
            }
        }
        System.out.printf("Case #%d: ",nCase);
        for(char ch:ans) System.out.print(ch);
        System.out.println();
    }
}