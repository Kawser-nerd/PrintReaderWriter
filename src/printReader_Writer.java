
/*
In this program, you are going to take input from a given file, going to count the numbers
appeared in the files and write them back to the file
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class printReader_Writer {
    String filenameWithPath = null;
    int[] numbers = new int[10]; // This is one dimensional Array which is going to hole the numbers we read from the file
    int numberOfTens = 0; // This is the variable which will count the number of time 10 is going to appear
    int numberOfTwelves = 0; // This is the variable which will count the number of time 10 is going to appear
    int numberOfFourteen = 0; // This is the variable which will count the number of time 10 is going to appear
    int numberOfSixteen = 0; // This is the variable which will count the number of time 10 is going to appear

    // This method is going to set the filename with path if the fileName with path is Passed //
    public void setFileName(String filenameWithPath){
        //this.filenameWithPath -- This variable indicates the local variable declared in this class. this keyword
        // references the variable and methods only in the same class

        this.filenameWithPath = filenameWithPath;
    }

    // This method returns the filename with path if it is set in the setFileName  //
    public String getFileName(){
        return this.filenameWithPath; // this method is returning the class variable with the stored value in the variable
    }

    // This method will read the file using Scanner class. Scanner class read the file in chunk. It will read the
    // File content in chunks and will read all the context part by part.
    public void readFile(){
        try {
            /*
            For reading a file, you first need to put the file inside File class. File class means the content is file
            At first, in the File class, you need to pass the fileName with path. If you use only fileName, it will create the
            file in the same folder.
             */
            File file = new File(getFileName());
            /*
            We need to create an Object/Instance of the File class to capture the methods of File. Once the instance created
            it will access all the APIs/Methods under scanner class. Here, Scanner class is going to open/read the file content.
            So, to pass the file in the Scanner class, we have to pass the file in the Scanner() section. This is the default
            Constructor of Scanner Class.
             */
            Scanner sc = new Scanner(file);
            // This is a variable to control the iteration of the array. Counter should start from 0 as the array index starts from 0
            int count = 0;

            while(sc.hasNext()) { // sc is the instance of the Scanner Class.
                this.numbers[count] = sc.nextInt();
                count++;
            }
            sc.close();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void countNumbers(){
        for (int i = 0; i < numbers.length; i++){
            if(numbers[i] == 10)
                numberOfTens++;
            else if(numbers[i] == 12)
                numberOfTwelves++;
            else if(numbers[i] == 14)
                numberOfFourteen++;
            else if(numbers[i] == 16)
                numberOfSixteen++;
        }
    }

    public void writeFile(){
        try{
            File file = new File(getFileName());
            PrintWriter pw = null;
            if (file.isFile() && file.exists())
               pw = new PrintWriter(new FileOutputStream(file, true));
            else
                pw = new PrintWriter(file);

            pw.println("10s -> "+ numberOfTens);
            pw.println("12s -> "+ numberOfTwelves);
            pw.println("14s -> "+ numberOfFourteen);
            pw.println("14s -> "+ numberOfSixteen);
            pw.close();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
