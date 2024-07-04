import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer noOfCases = Integer.parseInt(scanner.nextLine());
        for (Integer caz = 0; caz < noOfCases; caz++) {


            String caseString = "Case #" + (caz + 1) + ": ";
            Integer noActivities = scanner.nextInt();
            List<Activity> activities= new ArrayList<>();
            Comparator<Activity> compareByStart = new Comparator<Activity>() {
                @Override
                public int compare(Activity activity, Activity t1) {
                    return activity.getStart().compareTo(t1.getStart());
                }
            };
            Comparator<Activity> compareByPosition= new Comparator<Activity>() {
                @Override
                public int compare(Activity activity, Activity t1) {
                    return activity.getPosition().compareTo(t1.getPosition());
                }
            };

            for(int i=0;i<noActivities;i++){
                Activity a = new Activity(scanner.nextInt(),scanner.nextInt(),i);
                activities.add(a);
            }

            Collections.sort(activities,compareByStart);

            Integer end = 0;
            do{
                Integer finalEnd = end;
                Optional<Activity> optional=activities.stream()
                        .filter(a->a.getStart()>= finalEnd)
                        .findFirst();
                if(optional.isPresent()){
                    Activity act = optional.get();
                    act.setPerson("C");
                    end=act.getEnd();
                }
                else
                    break;
            }while (true);
            end = 0;
            do{
                Integer finalEnd = end;
                Optional<Activity> optional=activities.stream()
                        .filter(a->a.getStart()>= finalEnd && a.getPerson()==null)
                        .findFirst();
                if(optional.isPresent()){
                    Activity act = optional.get();
                    act.setPerson("J");
                    end=act.getEnd();
                }
                else
                    break;
            }while (true);


            Optional o = activities.stream().filter(a->a.getPerson()==null).findFirst();
            if(o.isPresent())
                System.out.println("IMPOSSIBLE");
            else {
                Collections.sort(activities,compareByPosition);
                String assignment="";
                for(Activity a: activities){
                    assignment+=a.getPerson();
                }
                System.out.println(caseString+assignment);
            }

        }
    }
}
class Activity{
    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    private Integer start;
    private Integer end;
    private Integer position;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    private String person;
    public Activity(Integer start, Integer end, Integer position) {
        this.start = start;
        this.end = end;
        this.position = position;
    }
}