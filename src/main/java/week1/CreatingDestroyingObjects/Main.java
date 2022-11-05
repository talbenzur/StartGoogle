package week1.CreatingDestroyingObjects;

public class Main {
    public static void main(String[] args) {
        String[] namesOfPlayers1={"Tal","Shani", "Rotem",
                "Lior", "Ron", "Or", "Sara","Roi", "Lia"};
        String[] namesOfPlayers2={"Matan", "Sagi","Rona","Moshe",
                "Yoni","Harel","Haim","David"};

        Team team1;
        {
            try {
                team1=Team.createNewTeam(namesOfPlayers1,1, 3, 4, 3);
                team1.PrintTeamToFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Team team2;
        {
            try {
                team2 =Team.createNewTeam(namesOfPlayers2,1, 4, 4, 2);
                team2.PrintTeamToFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
