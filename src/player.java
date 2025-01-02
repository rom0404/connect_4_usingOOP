import java.util.Scanner;



public class player {

    private String name;


    private int ID;

    public player(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void make_a_move(board board){
        Scanner scanner=new Scanner(System.in);
        boolean valid_move=false;

        while (!valid_move){
            System.out.println("in which row would you like to play??  (0-6)");
            int column=scanner.nextInt();
            if (column<0 || column>6){
                System.out.println("looks like you're playing connect 6!");
            } else if (board.column_is_full(column)) {
                System.out.println("find a new column, looks like this one is already full!");
            }else {
                board.place_disc(ID,column);
                valid_move=true;
            }
        }

    }


}
