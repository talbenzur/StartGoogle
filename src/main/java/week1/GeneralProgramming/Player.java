package week1.GeneralProgramming;

public class Player {
    private String name;
    private int jerseyNumber;
    private int grade;
    private Position pos;

    public Player(String name,int jerseyNum, Position pos) {
        this.name=name;
        this.jerseyNumber=jerseyNum;
        this.grade=RandomGrade();
        this.pos = pos;
    }

    private int RandomGrade(){
        int min=0,max=100;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }
    public void PrintPlayer(){
        System.out.println("Name: "+this.name+
                " ,Jersey number: "+this.jerseyNumber+
                " ,Position: "+this.pos+
                " ,Grade: "+this.grade);
    }
}
