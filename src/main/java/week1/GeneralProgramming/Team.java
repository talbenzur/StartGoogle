package week1.GeneralProgramming;

enum Position{
    GoalKeeper,
    Defender,
    Midfielder,
    Attacker
}

public class Team {
    private static final int TEAMSIZE = 11;
    private final String[] names={"Tal","Shani", "Rotem",
            "Lior", "Ron", "Or", "Sara","Roi", "Lia"};

    private Player[] team= new Player[TEAMSIZE];

    public Team(int NumOfGoalKeeper, int NumOfDefender,
               int NumOfMidfielder, int NumOfAttacker ) throws Exception {
        CheckConditionOfTeam(NumOfGoalKeeper,NumOfDefender,NumOfMidfielder,NumOfAttacker);
        CreateTeam(NumOfGoalKeeper,NumOfDefender,NumOfMidfielder,NumOfAttacker);

    }

    private String RandomName (){
        int pick = (int)Math.floor(Math.random()*(names.length));
        return names[pick];
    }
    private int RandomJerseyNumber(){
        //random number between 1-100
        int randomNum = (int)Math.floor(Math.random()*(100)+1);

        while(!CheckIfJerseyNumUnique(randomNum)){
            randomNum = (int)Math.floor(Math.random()*(100)+1);
        }
        return randomNum;
    }
    private boolean CheckIfJerseyNumUnique(int number){

        for(Player player:team){
            if(player==null){
                return true;
            }
            if(player.getJerseyNumber()==number){
                return false;
            }
        }
        return true;
    }
    private void CheckConditionOfTeam(int NumOfGoalKeeper, int NumOfDefender,
                                 int NumOfMidfielder, int NumOfAttacker ) throws Exception {
        if(NumOfGoalKeeper!=1){
            throw new Exception("A team cannot have more than one goal keeper");
        }
        if(NumOfDefender<=2){
            throw new Exception("A team must have at least two of Defender");
        }
        if(NumOfMidfielder<=2){
            throw new Exception("A team must have at least two of Midfielder");
        }
        if(NumOfAttacker<=2){
            throw new Exception("A team must have at least two of Attacker");
        }
        if(NumOfGoalKeeper+NumOfDefender+NumOfMidfielder+NumOfAttacker>TEAMSIZE){
            throw new Exception("A team sould have only "+TEAMSIZE+" players");
        }

    }
    private void CreateTeam (int NumOfGoalKeeper, int NumOfDefender,
                             int NumOfMidfielder, int NumOfAttacker ){
        int i;
        int j;
        for(i=0;i<NumOfGoalKeeper;i++) {
            team[i]=new Player(RandomName(),RandomJerseyNumber(),Position.GoalKeeper);
        }
        for(j=i;j<NumOfDefender;j++) {
            team[j]=new Player(RandomName(),RandomJerseyNumber(),Position.Defender);
        }
        for(i=j;i<NumOfMidfielder;i++) {
            team[i]=new Player(RandomName(),RandomJerseyNumber(),Position.Midfielder);
        }
        for(j=i;j<NumOfAttacker;j++) {
            team[j]=new Player(RandomName(),RandomJerseyNumber(),Position.Attacker);
        }
        for(i=j;i<TEAMSIZE;i++){//generate the rest
            int randomNum = (int)Math.floor(Math.random()*(4));
            team[i]=new Player(RandomName(),RandomJerseyNumber(),Position.values()[randomNum]);
        }

    }

    public void PrintTeam(){
        for(Player player:team){
            player.PrintPlayer();
        }
    }
}
