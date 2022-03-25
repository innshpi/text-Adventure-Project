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
    int[] goNorth = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION};
    int[] goSouth = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION};
    int[] goEast = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION};
    int[] goWest = {/*room 0*/1,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION};
    int[] goUp = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/1};
    int[] goDown = {/*room 0*/INVALIDDIRECTION,/*room 1*/2,/*room 2*/INVALIDDIRECTION};
    private String[] roomDescript = {/*room 0*/"Grass patch",/*room 1*/"Sand dunes",/*room 2*/"Beware of cave Cave"};
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
            cmd.toLowerCase();
            if(cmd.equals("north")) nextRoom=goNorth[currentRoom];
            if(cmd.equals("south")) nextRoom=goSouth[currentRoom];
            if(cmd.equals("east")) nextRoom=goEast[currentRoom];
            if(cmd.equals("west")) nextRoom=goWest[currentRoom];
            if(cmd.equals("up")) nextRoom=goUp[currentRoom];
            if(cmd.equals("down")) nextRoom=goDown[currentRoom];
            if(nextRoom == INVALIDDIRECTION) System.out.println("this is an invalid command :("); 
            else{ 
                currentRoom = nextRoom;
                System.out.println(roomDescript[currentRoom]);
            }
        }   
    }
}
