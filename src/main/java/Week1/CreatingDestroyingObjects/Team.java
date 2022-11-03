package Week1.CreatingDestroyingObjects;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

enum Position{
    GoalKeeper,
    Defender,
    Midfielder,
    Attacker
}

public class Team {
    private static final int TEAMSIZE = 11;

    private final String TeamName=random_name(5);
    private Player[] team= new Player[TEAMSIZE];

    public Team(int NumOfGoalKeeper, int NumOfDefender,
               int NumOfMidfielder, int NumOfAttacker ) throws Exception {
        CheckConditionOfTeam(NumOfGoalKeeper,NumOfDefender,NumOfMidfielder,NumOfAttacker);
        CreateTeam(NumOfGoalKeeper,NumOfDefender,NumOfMidfielder,NumOfAttacker);

    }

    //Add static factory methods that create a team given a specific formation.
    // A formation is the number of players each position has.
    public static Team createNewTeam(String[] namesOfPlayers,int NumOfGoalKeeper, int NumOfDefender,
    int NumOfMidfielder, int NumOfAttacker) throws Exception {
        NameGenerator.setNames(namesOfPlayers);
        CheckConditionOfTeam(NumOfGoalKeeper,NumOfDefender,NumOfMidfielder,NumOfAttacker);
        Team team=new Team(NumOfGoalKeeper,NumOfDefender,NumOfMidfielder,NumOfAttacker);
        return team;
    }


    private String RandomName (){
        int pick = (int)Math.floor(Math.random()*(NameGenerator.getNames().length));
        return NameGenerator.getNames()[pick];
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
    private static void CheckConditionOfTeam(int NumOfGoalKeeper, int NumOfDefender,
                                             int NumOfMidfielder, int NumOfAttacker) throws Exception {
        if(NumOfGoalKeeper!=1){
            throw new Exception("A team cannot have more than one goal keeper");
        }
        if(NumOfDefender<2){
            throw new Exception("A team must have at least two of Defender");
        }
        if(NumOfMidfielder<2){
            throw new Exception("A team must have at least two of Midfielder");
        }
        if(NumOfAttacker<2){
            throw new Exception("A team must have at least two of Attacker");
        }
        if(NumOfGoalKeeper+NumOfDefender+NumOfMidfielder+NumOfAttacker>TEAMSIZE){
            throw new Exception("A team sould have only "+TEAMSIZE+" players");
        }

    }
    private  void CreateTeam(int NumOfGoalKeeper, int NumOfDefender,
                                   int NumOfMidfielder, int NumOfAttacker){
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


    public static String random_name(int len) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public void PrintTeam(){
        System.out.println("Team name: "+TeamName);
        for(Player player:team){
            player.PrintPlayer();
        }
    }
    public String TeamToString(){
        String text="Team name: "+TeamName;
        for(Player player:team){
            text+="\r\n"+player.PlayerToString();
        }
        return text;
    }

    public void PrintTeamToFile(){
        String text=TeamToString();
        try{
            FileWriter fWriter = new FileWriter("C:/Users/tbz19/Documents/Team-"+TeamName+"-Detail.txt");
            fWriter.write(text);
            System.out.println(text);
            fWriter.close();
            System.out.println(
                    "File is created successfully with the content.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
