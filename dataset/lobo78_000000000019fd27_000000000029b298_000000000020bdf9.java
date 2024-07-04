import java.util.LinkedList;
import java.util.Scanner;

public class Solution{
    LinkedList<Character> assigment = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        for(int i = 1; i<=x; i++){
            Solution solution = new Solution();
            int n = Integer.parseInt(sc.nextLine());
            LinkedList<int[]> jobs = new LinkedList<>();
            LinkedList<int[]> C = new LinkedList<>();
            LinkedList<int[]> J = new LinkedList<>();
            LinkedList<Character> list = new LinkedList<>();
            for(int j = 0; j<n; j++){
                String string = sc.nextLine();
                String [] arr = string.split(" ");
                int [] job = new int[2];
                job[0] = Integer.parseInt(arr[0]);
                job[1] = Integer.parseInt(arr[1]);
                jobs.add(job);
            }
            solution.distribute(jobs,C,J,0,list);
            StringBuilder stringBuilder = new StringBuilder();
            if(solution.assigment.isEmpty()){
                System.out.println("Case #"+i+": IMPOSSIBLE");
            }else {
                for (Character c : solution.assigment) {
                    stringBuilder.append(c);
                }
                System.out.println("Case #"+i+": "+stringBuilder.toString());
            }
        }
    }

    public void distribute(LinkedList<int[]> jobs, LinkedList<int[]> C, LinkedList<int[]> J, int index, LinkedList<Character> list){
        if(index==jobs.size()){
            assigment.addAll(list);
            return;
        }
        int [] job = jobs.get(index);
        if(assigment.size() == 0 && isPossible(C, job)){
            list.add('C');
            C.add(job);
            distribute(jobs, C, J, index+1, list);
        }
        if(assigment.size() == 0 && isPossible(J, job)){
            list.add('J');
            J.add(job);
            distribute(jobs, C, J, index+1, list);
        }
    }

    public boolean isPossible(LinkedList<int[]> jobs, int [] job){
        for(int[] arr: jobs){
            boolean overlap = arr[0] < job[1] && job[0] < arr[1];
            if(overlap){
                return false;
            }
        }
        return true;
    }
}