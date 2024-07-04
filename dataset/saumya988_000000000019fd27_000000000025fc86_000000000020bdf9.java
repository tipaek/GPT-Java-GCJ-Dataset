import java.util.*;

class Solution{

    static ArrayList<Integer> Cstart = new ArrayList<>();
    static ArrayList<Integer> Cend = new ArrayList<>();
    static ArrayList<Integer> Jstart = new ArrayList<>();
    static ArrayList<Integer> Jend = new ArrayList<>();
    static String str = "";

    public static boolean C(int start, int end){
        boolean flag = true;
        for(int i=0; i<Cstart.size(); i++){
            if(start<Cend.get(i)){
                if(start>Cstart.get(i)){
                    flag = false;
                    break;
                }
            }
            if(end>Cstart.get(i)){
                if(end<Cend.get(i)){
                    flag = false;
                    break;
                }
            }
            if(start<Cstart.get(i) && end>Cend.get(i)){
                flag = false;
                break;
            }
        }
        if(flag){
            Cstart.add(start);
            Cend.add(end);
            str+="C";
        }
        return flag;

    }

    public static boolean J(int start, int end){
        boolean flag = true;
        for(int i=0; i<Jstart.size(); i++){
            if(start<Jend.get(i)){
                if(start>Jstart.get(i)){
                    flag = false;
                    break;
                }
            }
            if(end<Jstart.get(i)){
                if(end>Jend.get(i)){
                    flag = false;
                    break;
                }
            }
            if(start<Jstart.get(i) && end>Jend.get(i)){
                flag = false;
                break;
            }
        }
        if(flag){
            Jstart.add(start);
            Jend.add(end);
            str+="J";
        }
        return flag;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int start[], end[];
        int endC=0, endJ=0, curCase = 1, n;
        //String schedule;
        
        while(curCase<=t){
            n = sc.nextInt();
            start = new int[n];
            end = new int[n];
            Cstart.clear();
            Cend.clear();
            Jstart.clear();
            Jend.clear();
            str = "";
            for(int i=0; i<n; i++){
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }
            //Cstart.add(start[0]);
            //Cend.add(end[0]);
            //str +="C";
            for(int i=0; i<n; i++){
                if(!C(start[i], end[i])){
                    if(!J(start[i], end[i])){
                        str = "IMPOSSIBLE";
                        break;
                    }
                    //str+=
                }
            }
            System.out.println("Case #"+curCase+": "+str);
            curCase++;
        }
    }
}