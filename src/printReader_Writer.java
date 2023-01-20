
/*
In this program, you are going to take input from a given file, going to count the numbers
appeared in the files and write them back to the file
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class printReader_Writer {
    String filenameWithPath = null;
    int[] numbers = new int[8];
    int numberOfTens = 0;
    int numberOfTwelves = 0;
    int numberOfFourteen = 0;
    int numberOfSixteemn = 0;

    public void setFileName(String filenameWithPath){
        this.filenameWithPath = filenameWithPath;
    }

    public String getFileName(){
        return this.filenameWithPath;
    }

    public void readFile(){
        try {
            File file = new File(getFileName());
            Scanner sc = new Scanner(file);
            int count = 0;

            while(sc.hasNext()) {
                this.numbers[count] = sc.nextInt();
                count++;
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void countNumbers(){
        for (int i = 0; i < numbers.length; i++){
            
        }
    }

}
