/**
 * Write a description of class textAdventure here.
 *
 * @author (Piper Inns Hall)
 * @version (24/03/21)
 */
import java.util.Scanner;                    
public class textAdventure
{
    boolean stillPlaying;
    
    final int INVALIDDIRECTION = -1;
    int[] goNorth = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION,/*room 3*/4,/*room 4*/INVALIDDIRECTION,/*room 5*/1,/*room 6*/INVALIDDIRECTION,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    int[] goSouth = {/*room 0*/INVALIDDIRECTION,/*room 1*/5,/*room 2*/INVALIDDIRECTION,/*room 3*/INVALIDDIRECTION,/*room 4*/3,/*room 5*/INVALIDDIRECTION,/*room 6*/INVALIDDIRECTION,/*room 7*/8,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    int[] goEast = {/*room 0*/INVALIDDIRECTION,/*room 1*/3,/*room 2*/INVALIDDIRECTION,/*room 3*/INVALIDDIRECTION,/*room 4*/INVALIDDIRECTION,/*room 5*/4,/*room 6*/INVALIDDIRECTION,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    int[] goWest = {/*room 0*/1,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION,/*room 3*/INVALIDDIRECTION,/*room 4*/5,/*room 5*/7,/*room 6*/INVALIDDIRECTION,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    int[] goUp = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/1,/*room 3*/INVALIDDIRECTION,/*room 4*/INVALIDDIRECTION,/*room 5*/INVALIDDIRECTION,/*room 6*/7,/*room 7*/INVALIDDIRECTION,/*room 8*/9,/*room 9*/INVALIDDIRECTION};
    int[] goDown = {/*room 0*/INVALIDDIRECTION,/*room 1*/2,/*room 2*/INVALIDDIRECTION,/*room 3*/INVALIDDIRECTION,/*room 4*/6,/*room 5*/INVALIDDIRECTION,/*room 6*/INVALIDDIRECTION,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    
    private String[] roomDescript = {
    /*room 0*/"Grass patch",
    /*room 1*/"Sand dunes",
    /*room 2*/"Beware of cave Cave",
    /*room 3*/"Bright cave",
    /*room 4*/"Tide pool",
    /*room 5*/"Beach",
    /*room 6*/"Under water cave",
    /*room 7*/"Ocean",
    /*room 8*/"Stream",
    /*room 9*/"The end"};
    /**
     * Constructor for objects of class textAdventure
     */
    public textAdventure()
    {
        int currentRoom = 0;
        int nextRoom=-1;
        Scanner kb = new Scanner(System.in); 
        stillPlaying = true;
        System.out.println(roomDescript[currentRoom]);
        while (stillPlaying){
            String cmd = kb.nextLine();
            //cmd.toLowerCase();
            if(cmd.equals("north")) nextRoom=goNorth[currentRoom];
            if(cmd.equals("south")) nextRoom=goSouth[currentRoom];
            if(cmd.equals("east")) nextRoom=goEast[currentRoom];
            if(cmd.equals("west")) nextRoom=goWest[currentRoom];
            if(cmd.equals("up")) nextRoom=goUp[currentRoom];
            if(cmd.equals("down")) nextRoom=goDown[currentRoom];
            if(nextRoom == INVALIDDIRECTION) System.out.println("this is an invalid command :("); 
            else{ 
                //System.out.println("u\000c");
                currentRoom = nextRoom;
                System.out.println(roomDescript[currentRoom]);
            }
        }   
    }
}
