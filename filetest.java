
/**
 * Write a description of class filetest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;  
import java.io.File;
import java.io.IOException;
public class filetest
{
    final int NUMROOMS = 11;
    
    File roomDFile=new File("roomD.txt");
    String[] roomD = new String[NUMROOMS];
    
    /**
     * Constructor for objects of class filetest
     */
    public filetest()
    {
        try {
            Scanner readFile = new Scanner(roomDFile);
            for(int i=0;i<NUMROOMS;i++)roomD[i] = "";
            for(int i=0;i<NUMROOMS;i++){
                String lineRead = readFile.nextLine();
                while(!lineRead.equals(";")){
                    roomD[i]+=lineRead+"\n";
                    lineRead = readFile.nextLine();
                }
            }
        }catch (IOException e){}
        for(int i=0;i<NUMROOMS;i++)System.out.println(roomD[i]);
    }
}