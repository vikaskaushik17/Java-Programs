package vikdev.com;
import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();
    public Team(String name){
        this.name = name;
    }
    public String getName (){
        return name;
    }

    public boolean adPlayer(T player){
        if (members.contains(player)){
            System.out.println(player.getName() +" is already on this team ");
            return false;
        }else{
            members.add(player);
            System.out.println(player.getName()+" picked for team "+this.name);
            return true;
        }
    }

    public int numPlayer(){
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
        String message;
        if (ourScore > theirScore){
            won++;
            message = "win";
        }else if (ourScore == theirScore){
            tied++;
            message = "Tie";
        }else {
            lost++;
            message = "Lost";
        }played++;
        if (opponent != null){
            System.out.println(this.getName() +"  "+message+opponent.getName());
            opponent.matchResult(null,theirScore,ourScore);
        }
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()){
            return -1;
        }else if (this.ranking() < ranking()){
            return 1;
        }else {
            return 0;
        }
    }



    public int ranking(){
        return (won * 2) + tied;
    }
}
