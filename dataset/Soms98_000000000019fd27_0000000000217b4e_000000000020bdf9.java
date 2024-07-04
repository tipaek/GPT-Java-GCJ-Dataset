import java.util.*;

public class Parenting{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int t = 0;t<T;t++){
            int N = Integer.parseInt(sc.nextLine());
            char[] assignment = new char[N];
            ArrayList<Numer> numers = new ArrayList<Numer>();
            for(int i = 0;i<N;i++){
                String[] inp = sc.nextLine().split(" ");
                int s = Integer.parseInt(inp[0]);
                int e = Integer.parseInt(inp[1]);
                numers.add(new Numer(s,'S',i));
                numers.add(new Numer(e,'E',i));
            }
            Collections.sort(numers);
            ArrayList<Character> free = new ArrayList<Character>();
            free.add('C');
            free.add('J');
            boolean imposs = false;
            for(int j = 0;j<numers.size();j++){
                if(numers.get(j).label=='S'){
                    if(free.size()>0){
                        char man = free.remove(0);
                        assignment[numers.get(j).job] = man;
                    }
                    else{
                        imposs = true;
                        break;
                    }
                }
                else{
                    free.add(assignment[numers.get(j).job]);
                }
            }
            if(imposs){
                System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
            }
            else{
                String printing = "";
                for(int y = 0;y<assignment.length;y++){
                    printing += assignment[y];
                }
                System.out.println("Case #"+(t+1)+": "+printing);
            }
        }
    }
}

class Numer implements Comparable<Numer>{
    public int number;
    public char label;
    public int job;
    public Numer(int n, char l, int j){
        number = n;
        label = l;
        job = j;
    }
    public int compareTo(Numer other){
        if(number-other.number==0){
            return Character.compare(label,other.label);
        }
        return number-other.number;
    }
}