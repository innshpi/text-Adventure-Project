/**
 * Write a description of class textAdventure here.
 *
 * @author (Piper Inns Hall)
 * @version (24/03/21)
 */
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
    /*room 0*/"almost there",
    /*room 1*/"You are walking across a barren sand flat, with nothing much in sight but sand dunes, and the\noccasional crab. You look east and across the dunes, and you see a small\nopening in the side of a tall rocky cliff. Interested, you walk towards the cave\nopening. South towards the right of the cave opening, is a winding dirt path lined\nwith dense trees and shrubs.",
    /*room 2*/"You descend down into the dark pit below, the only thing keeping you from\nplummeting to the bottom are the rusty steel rungs your hands are clasped to.\nWhen your feet finally meet the hard stone floor, you can see nothing but black.\nAs your eyes slowly adjust to the dark, you realise you’re in a vast, empty cavern.\nYou take in the scene and your eyes follow the impossibly high walls up to the\nceiling, which nests thousands of glowworms. Across the rocky floor there are\npatches of thriving moss and in the distance you hear the faint echoing of dripping\nwater.",
    /*room 3*/"Bright cave",
    /*room 4*/"Tide pool",
    /*room 5*/"Beach",
    /*room 6*/"Under water cave",
    /*room 7*/"Ocean",
    /*room 8*/"Stream",
    /*room 9*/"The end",
    /*room 0/10(starting descrpition)*/"grass patch",};
    
    //inventory
    final int YSRCH = 1;
    final int NSRCH = 0;
    int[] canSearch = {NSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH,YSRCH};
    boolean haveSword = false;
    boolean haveLifeJacket = false;
    /**
     * Constructor for objects of class textAdventure
     */
    public textAdventure()
    {
        System.out.println(roomDescript[10]);
        doableActions();
        while (stillPlaying){
            String cmd0 = kb.nextLine();
            //cmd0.toLowerCase();
            if(cmd0.equals("north"))nextRoom=goNorth[currentRoom];
            if(cmd0.equals("south"))nextRoom=goSouth[currentRoom];
            if(cmd0.equals("east"))nextRoom=goEast[currentRoom];
            if(cmd0.equals("west"))nextRoom=goWest[currentRoom];
            if(cmd0.equals("up"))nextRoom=goUp[currentRoom];
            if(cmd0.equals("down"))nextRoom=goDown[currentRoom];
            if (cmd0.equals("backpack")){
                backpack();
            }
            else if (cmd0.equals("search") && canSearch[currentRoom] == YSRCH){
                if(currentRoom == 1){
                    System.out.println("you rustle around the undergrowth and push away some shrubs,\ndiscovering an ominous trapdoor heading downwards.");
                    goDown[1]=2;
                    canSearch[currentRoom] = NSRCH;
                    doableActions();
                }    
                else if(currentRoom == 2){
                    System.out.println("you walk towards the sound of running water, when suddenly you can't move.\nbefore you realise what has happened, a giant spider jumps out at you from\nthe darkness.");
                    canSearch[currentRoom] = NSRCH;
                    spiderAttack();
                }
                else if(currentRoom == 3){
                    System.out.println("Perched on a particularly sharp stalagmite in the corner of\nthe cave is a lifejacket. It may come in handy so you pick it up.");
                    haveLifeJacket = true;
                    canSearch[currentRoom] = NSRCH;
                    doableActions();
                }
                else if(currentRoom == 4){
                    System.out.println("You wade through the glistening pools and in the depths of a large one is a sword buried underneath some sand.");
                    haveSword = true;
                    canSearch[currentRoom] = NSRCH;
                    doableActions();
                }
                else if(currentRoom == 5){
                    System.out.println("You climb to the top of the largest rock you can find and stare into the horizon.\nYou truly feel like an adventurer.");
                    canSearch[currentRoom] = NSRCH;
                    doableActions();
                }
                else {
                    System.out.println("You found nothing. You feel slightly demoralized for no particular reason");
                    canSearch[currentRoom] = NSRCH;
                    doableActions();
                }
            }
            else if(nextRoom>=0){
                System.out.print('\u000C');
                currentRoom = nextRoom;
                System.out.println(roomDescript[currentRoom]);
                doableActions();
                nextRoom=-1;
            }
            else System.out.println("You cannot do this right now.");
        }
    }
    public void spiderAttack(){
        if(haveSword){
            System.out.println("\nYou equip your sword, and strike down the spider in one blow. It dies\ninstantly and desintegrates, leaving behind a large fang.");
            doableActions();
        }
        else{
            System.out.println("\nBare fists dont seem to do much against the spider, and after a few useless\npunches, the spider suffocates you in web fluid, leaving you to die.");
            death();
        }
    }
    public void backpack(){
        System.out.println ("you open take your trusty backpack off of your back and lay the contents on the ground.\n\ninside is:");
        if(haveSword)System.out.println ("A sword");
        if(haveLifeJacket)System.out.println ("A lifejacket");
        else System.out.println ("nothing");
        System.out.println ("");
    }
    public void doableActions(){
        System.out.println("\nActions you can perform right now:");
        if(goNorth[currentRoom]>=0)System.out.println("North");
        if(goSouth[currentRoom]>=0)System.out.println("South");
        if(goEast[currentRoom]>=0)System.out.println("East");
        if(goWest[currentRoom]>=0)System.out.println("West");
        if(goUp[currentRoom]>=0)System.out.println("Up");
        if(goDown[currentRoom]>=0)System.out.println("Down");
        if(canSearch[currentRoom] == YSRCH)System.out.println("Search");
        System.out.println("Backpack");
    }
    public void death(){ 
        System.out.println ("\nUnfortunately, you died. Type respawn to try again");
        String cmd1 = kb.nextLine();
        if(cmd1.equals("respawn")){
            System.out.print('\u000C');
            
            currentRoom = 0;
            nextRoom=-1;
        
            goDown[1]=INVALIDDIRECTION;
            
            //inventory
            haveSword = false;
            haveLifeJacket = false;
            
            System.out.println(roomDescript[currentRoom]);
            doableActions();
        }
    }
}