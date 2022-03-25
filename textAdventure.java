
/**
 * Write a description of class textAdventure here.
 *
 * @author (Piper Inns Hall)
 * @version (24/03/21)
 */
import java.util.Scanner;                    
public class textAdventure
{
    final int INVALIDDIRECTION = -1;
    int[] goNorth = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION};
    int[] goSouth = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION};
    int[] goEast = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION};
    int[] goWest = {/*room 0*/1,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION};
    int[] goUp = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/1};
    int[] goDown = {/*room 0*/INVALIDDIRECTION,/*room 1*/2,/*room 2*/INVALIDDIRECTION};
    //int w-+[] roomDescript ={/*room 0*/"Grass patch",/*room 1*/"Sand dunes",/*room 2*/"Beware of cave Cave"};
    /**
     * Constructor for objects of class textAdventure
     */
    public textAdventure()
    {
        
    }
}
