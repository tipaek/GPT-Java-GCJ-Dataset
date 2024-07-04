import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); scanner.nextLine();
        for(int i = 0; i < t; i++) {
            solve(scanner, i+1);
        }
    }

    public static void solve(Scanner in, int id) {
        int activity_count = in.nextInt();

        //Get activities by start
        ArrayList<Activity> activities = new ArrayList<>();
        for(int i = 0; i < activity_count; i++) {
            activities.add(new Activity(i, in.nextInt(), in.nextInt()));
        }
        activities.sort(Comparator.comparingInt(a -> a.start));

        int camaronAvailable = 0;
        int jamieAvailable = 0;
        for(Activity ac : activities) {
            if(ac.start >= camaronAvailable) {
                camaronAvailable = ac.end;
                ac.assigned = 'C';
            }else if(ac.start >= jamieAvailable) {
                jamieAvailable = ac.end;
                ac.assigned = 'J';
            }else{
                System.out.println("Case #" + id + ": IMPOSSIBLE");
                return;
            }
        }

        activities.sort(Comparator.comparingInt(a -> a.id));

        StringBuilder output = new StringBuilder();
        activities.stream().map(a -> a.assigned).forEach(output::append);

        System.out.println("Case #" + id + ": " + output.toString());
    }
}

class Activity {
    int id;
    int start;
    int end;
    char assigned = '\0';

    public Activity(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }
}