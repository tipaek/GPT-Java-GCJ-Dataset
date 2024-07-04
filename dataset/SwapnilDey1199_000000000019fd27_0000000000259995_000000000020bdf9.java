import java.util.*;
class Activity{
    private int pos;
    private int st;
    private int et;
    private char ch;
    public Activity(int pos,int st,int et){
        this.pos = pos;
        this.st = st;
        this.et = et;
        this.ch = 'X';
    }

    public char getCh(){
        return this.ch;
    }

    public void setCh(char ch){
        this.ch = ch;
    }

    public int getSt(){
        return this.st;
    }

    public int getEt(){
        return this.et;
    }
    
    public int getPos(){
        return this.pos;
    }

    public String toString(){
        return "St: "+this.st+" "+"Et: "+this.et;
    }
}
public class Solution{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int z = 1;
        StringBuffer sb = new StringBuffer();
        while(t-->0){
            int n = sc.nextInt();
            ArrayList<Activity> list = new ArrayList<>();
            for(int i = 0;i<n;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                list.add(new Activity(i,a,b));
            }
            Collections.sort(list, new Comparator<Activity>() {  //ascending
                public int compare(Activity x, Activity y) {
                    return x.getSt()-y.getSt();
                }
            });
            //System.out.println(list);
            int y = list.get(0).getEt();
            list.get(0).setCh('C');
            for(Activity x:list){
                if(x.getSt()>=y){
                    y = x.getEt();
                    x.setCh('C');
                }
                //System.out.println(x.getCh());
            }
            char ch;
            int j = 0;
            do{
                ch = list.get(j).getCh();
                j++;
            }while(ch!='X' && j<list.size());
            boolean b=true;
            if(j==list.size() && ch=='C') b=false;
            if(b){
                list.get(j-1).setCh('J');
                y = list.get(j-1).getEt();
                for(int k = j;k<list.size();k++){
                    Activity ac = list.get(k);
                    if(ac.getCh()=='X' && ac.getSt()>=y){
                        y = ac.getEt();
                        ac.setCh('J');
                    }
                }
            }
            StringBuffer temp = new StringBuffer();
            if(checkPossibility(list)){
                Collections.sort(list, new Comparator<Activity>() {  //ascending
                public int compare(Activity x, Activity y) {
                    return x.getPos()-y.getPos();
                }
            });
                for(Activity ac:list) temp.append(ac.getCh());
            }else{
                temp.append("IMPOSSIBLE");
            }
            //System.out.println(temp);
            sb.append("Case #"+z+": "+temp+"\n");
            z++;
        }
        System.out.println(sb);
    }

    public static boolean checkPossibility(ArrayList<Activity> list){
        for(Activity x:list){
            if(x.getCh()=='X') return false;
        }
        return true;
    }
}