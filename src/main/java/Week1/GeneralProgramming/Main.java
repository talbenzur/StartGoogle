package Week1.GeneralProgramming;

public class Main {
    public static void main(String[] args) {
        Team team;
        {
            try {
                team = new Team(1, 3, 4, 3);
                team.PrintTeam();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
