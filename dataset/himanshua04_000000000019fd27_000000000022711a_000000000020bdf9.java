import java.util.*;

class Tri{
    int start;
    int end;
    int index;
    Tri(int s ,int e , int i){
        this.start=s;
        this.end=e;
        this.index=i;
    }
}
class Res{
    char ch;
    int index;
    Res(char ch ,int index){
        this.ch=ch;
        this.index=index;
    }
}
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tc =sc.nextInt();
        int tCount = 1;
        while(tCount<=tc){
            int n = sc.nextInt();
            Tri arr[] = new Tri[n];
            for(int i=0;i<n;i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                arr[i] = new Tri(start , end , i);
            }
            Arrays.sort(arr,new Comparator<Tri>() {
                @Override
                public int compare(Tri t1 , Tri t2){
                    return t1.start-t2.start;
                }
            });
            ArrayList<Res> res = new ArrayList<>();
            int jStart = -1;
            int cStart = -1;
            boolean isPossible = true;
            for(Tri event : arr){
                if(jStart<=event.start){
                    jStart=event.end;
                    res.add(new Res('J',event.index));
                }else if(cStart<=event.start){
                    cStart = event.end;
                    res.add(new Res('C',event.index));
                }else{
                    isPossible = false;
                    break;
                }
            }
            if(isPossible){
                Collections.sort(res , new Comparator<Res>() {
                    @Override
                    public int compare(Res r1 , Res r2){
                        return r1.index-r2.index;
                    }
                });
                sb.append("Case #"+tCount+": ");
                for(Res r : res){
                    sb.append(r.ch);
                }
                sb.append("\n");    
            }else sb.append("Case #"+tCount+": IMPOSSIBLE\n");
            tCount++;
        }
        System.out.println(sb);
    }
}