
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
            // This count is a variable to control the iteration of the array. Counter should start from 0 as the array index starts from 0
            int count = 0;

            while(sc.hasNext()) { // sc is the instance of the Scanner Class. hasNext() method checks whether there is End-of-File
                // in the file. It will perform the loop until it finds out the End-Of-File in the input file.
                this.numbers[count] = sc.nextInt(); // sc.nextInt() will consider all the entry from file as Integer value. Without
                // nextInt(), it takes input as string values. This method considers anything in between two spaces as Integer values.
                count++; // It will count the number it can successfully read from the file.
            }
            sc.close(); // This will close the file as well as close the scanner port of the program
        }
        catch (IOException ex){ // this section handles the File I/O exceptions if requires. The main program runs
                                // inside the try block. If any problem appears in the try block, then that activates the
                                // catch block and show the problem appeared. Based on the class appeared in the catch
                                // section, that class shows the result.
            System.out.println(ex.getMessage()); // This will print the error message in the terminal
        }
    }

    public void countNumbers(){
        /*
            This will compare the predefined numbers with the numbers in the array.  We have put some numbers in the file
            In this following section, we will compare the numbers one by one. Once the comparison is successful, it will
            increase the count of the numbers
         */

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
        /*
        IN this section, we are going to write our counted variable one by one in the file. The File class open the file.
        In the File default constructor, we have to pass the file which we want to open. In the Printwrite class default
        constructor, we have to pass the file name which we have opened using File.
         */

        try{
            // The following line will open the file in the memory. We have to pass the file with the path to open it.
            File file = new File(getFileName());
            // The PrintWrite class will create a writter for the file. This will write stuffs in the file.
            PrintWriter pw = null;
            if (file.isFile() && file.exists()) // These two methods check whether the given filename with path is
                // a file or not. At the same time, it will check whether the file exists or not. If not, it will create
                // If the file is present, it will open the file in Append mode.Append mode means, the file will keep its
                //content and add new stuff after that.
                // The following line will open the file in append mode. Inside PrintWriter default constructor, if you use
                //fileOutputStream, it will allow the PrintWriter to open the file in Append mode. In addition to
                // regular FileOUtputStream, we have to pass true as parameter.
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
