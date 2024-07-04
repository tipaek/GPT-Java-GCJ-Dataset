import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ntc = sc.nextInt();
        int currTest = 1;
        while(currTest<=ntc){
            int n=sc.nextInt();
            sc.nextLine();
            ArrayList<Activity> acts=new ArrayList<>();
            int assignC=0,assignJ=0;
            boolean impossible = false;
            String[] ansStrArr=new String[n];
            for(int i=0;i<n;i++){
                String[] act=sc.nextLine().split(" ");
                acts.add(new Activity(Integer.parseInt(act[0]),Integer.parseInt(act[1]),i));
            }
            acts.sort((a1, a2) -> {
                int diff = a1.st - a2.st;
                if (diff == 0) {
                    diff = a1.ed - a2.ed;
                    if (diff == 0) {
                        return a1.ind - a2.ind;
                    } else {
                        return diff;
                    }
                } else {
                    return diff;
                }
            });

            for (Activity act : acts) {
                if (act.st < assignC && act.st < assignJ) {
                    impossible = true;
                    break;
                }
                if (act.st >= assignC) {
                    ansStrArr[act.ind] = "C";
                    assignC = act.ed;
                    continue;
                }
                ansStrArr[act.ind] = "J";
                assignJ = act.ed;
            }
            if(impossible){
                System.out.println("Case #"+currTest+": IMPOSSIBLE");
            }else{
                System.out.print("Case #"+currTest+": ");
                for(int i=0;i<n;i++){
                    System.out.print(ansStrArr[i]);
                }
                System.out.println();
            }
            currTest++;
        }
    }
}

class Activity{
    int st, ed, ind;
    Activity(int st, int ed, int ind){
        this.st = st;
        this.ed = ed;
        this.ind = ind;
    }
}