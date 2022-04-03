/**
 * Write a description of class textAdventure here.
 *
 * @author (Piper Inns Hall)
 * @version (24/03/21)
 */

//REMEMBER TO USE THIS CODE FOR END OF GAME
//goNorth[1]=8;
//System.out.println(goNorth[1]);

import java.util.Scanner;                    
public class textAdventure
{
    Scanner kb = new Scanner(System.in); 
    
    boolean stillPlaying = true;
    
    int currentRoom = 0;
    int nextRoom=-1;
    
    final int INVALIDDIRECTION = -1;
    int[] goNorth = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION,/*room 3*/4,/*room 4*/INVALIDDIRECTION,/*room 5*/1,/*room 6*/INVALIDDIRECTION,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    int[] goSouth = {/*room 0*/INVALIDDIRECTION,/*room 1*/5,/*room 2*/INVALIDDIRECTION,/*room 3*/INVALIDDIRECTION,/*room 4*/3,/*room 5*/INVALIDDIRECTION,/*room 6*/INVALIDDIRECTION,/*room 7*/8,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    int[] goEast = {/*room 0*/INVALIDDIRECTION,/*room 1*/3,/*room 2*/INVALIDDIRECTION,/*room 3*/INVALIDDIRECTION,/*room 4*/INVALIDDIRECTION,/*room 5*/4,/*room 6*/INVALIDDIRECTION,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    int[] goWest = {/*room 0*/1,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION,/*room 3*/INVALIDDIRECTION,/*room 4*/5,/*room 5*/7,/*room 6*/INVALIDDIRECTION,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    int[] goUp = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/1,/*room 3*/INVALIDDIRECTION,/*room 4*/INVALIDDIRECTION,/*room 5*/INVALIDDIRECTION,/*room 6*/7,/*room 7*/INVALIDDIRECTION,/*room 8*/0,/*room 9*/INVALIDDIRECTION};
    int[] goDown = {/*room 0*/INVALIDDIRECTION,/*room 1*/INVALIDDIRECTION,/*room 2*/INVALIDDIRECTION,/*room 3*/INVALIDDIRECTION,/*room 4*/6,/*room 5*/INVALIDDIRECTION,/*room 6*/INVALIDDIRECTION,/*room 7*/INVALIDDIRECTION,/*room 8*/INVALIDDIRECTION,/*room 9*/INVALIDDIRECTION};
    
    private String[] roomDescript = {
    /*room 0*/"Grass patch",
    /*room 1*/"You are at a barren beach, with nothing much in sight but sand dunes, and the\noccasional crab. You look east and across the dunes, and you see a small\nopening in the side of a tall rocky cliff. Interested, you walk towards the cave\nopening. South towards the right of the cave opening, is a winding dirt path lined\nwith dense trees and shrubs.",
    /*room 2*/"You descend down into the dark pit below, the only thing keeping you from\nplummeting to the bottom are the rusty steel rungs your hands are clasped to.\nWhen your feet finally meet the hard stone floor, you can see nothing but black.\nAs your eyes slowly adjust to the dark, you realise you’re in a vast, empty cavern.\nYou take in the scene and your eyes follow the impossibly high walls up to the\nceiling, which nests thousands of glowworms. Across the rocky floor there are\npatches of thriving moss and in the distance you hear the faint echoing of dripping\nwater.",
    /*room 3*/"Bright cave",
    /*room 4*/"Tide pool",
    /*room 5*/"Beach",
    /*room 6*/"Under water cave",
    /*room 7*/"Ocean",
    /*room 8*/"Stream",
    /*room 9*/"The end",
    /*room 0(starting descrpition)*/"almost there",};
    
    //inventory
    boolean haveLifeJacket = false;
    /**
     * Constructor for objects of class textAdventure
     */
    public textAdventure()
    {
        System.out.println(roomDescript[currentRoom]);
        while (stillPlaying){
            String cmd0 = kb.nextLine();
            //cmd.toLowerCase();
            if(cmd0.equals("north"))nextRoom=goNorth[currentRoom];
            if(cmd0.equals("south"))nextRoom=goSouth[currentRoom];
            if(cmd0.equals("east"))nextRoom=goEast[currentRoom];
            if(cmd0.equals("west"))nextRoom=goWest[currentRoom];
            if(cmd0.equals("up"))nextRoom=goUp[currentRoom];
            if(cmd0.equals("down"))nextRoom=goDown[currentRoom];
            if (cmd0.equals("search")){
                if(currentRoom == 1){
                    System.out.println("you rustle around the undergrowth and push away some shrubs,\ndiscovering an ominous trapdoor heading downwards.");
                    goDown[1]=2;
                }    
                else if(currentRoom == 2)System.out.println("room2");
                else if(currentRoom == 3)haveLifeJacket = true;
                else if(currentRoom == 4)System.out.println("room4");
                else System.out.println("found nothing");
            }
            else if (cmd0.equals("backpack")){
                backpack();
            }
            else if(nextRoom>=0){
                System.out.print('\u000C');
                currentRoom = nextRoom;
                System.out.println(roomDescript[currentRoom]);
            }
            else System.out.println("you cannot do this right now"); 
        }
    }
    public void backpack(){
        System.out.println ("you open take your trusty backpack off of your back and lay the contents on the ground.\n\ninside is:");
        if(haveLifeJacket)System.out.println ("A lifejacket");
        else System.out.println ("nothing");
    }
}