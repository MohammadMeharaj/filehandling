import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        // Create a new text file and write data to it
        writeDataToFile();

        // Read data from the created text file
        readDataFromFile();

        //Append data to file
        AppenddataToFile();

        //display modified data to file
        try {
            DisplayModifiedData();
        } catch (FileNotFoundException e) {
            System.out.println("error occured");;
        }

        //Rename data to existing file
        Rename();
        
        //delete file
        Delete();
    }

    public static void writeDataToFile() {
        try {
            File file = new File("example.txt"); // Specify the file name
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("HI HELLO \n");
            bw.write("EEEEEEEEEEEEEE\n");
            bw.write("UUUUUUUUUUUUUUUUUUUUU");

            bw.close();
            System.out.println("SUCCESSFULLY COMPLTED WRITTEN ONE.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static void readDataFromFile() {
        try {
            File file = new File("example.txt"); // Specify the same file name
            FileReader fr=new FileReader(file);
            Scanner scanner = new Scanner(fr);

            System.out.println("Data read from the file:");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
        }
    }
    public static void AppenddataToFile()
    {
        String Append= "This is new data to append.";

        try {
            
            
            FileWriter fileWriter = new FileWriter("example.txt", true);

            // Write the data to the file.
            fileWriter.write(Append);
            // Close the FileWriter to ensure that the data is saved to the file.
            fileWriter.close();

            System.out.println("Data appended to the file.");
        
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
    public static void DisplayModifiedData() throws FileNotFoundException
    {
        String display;
        File file = new File("example.txt"); // Specify the same file name
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        try{
            if((display=br.readLine())!=null)
            {
                System.out.println(display);
            }
            br.close();
            fr.close();
        }
            catch(IOException ie1)
            {
                System.out.println("error occured in dispaly method");
            }
        }
    
    public static void Rename()
    {
        File file=new File("example.txt");
        File newfilename=new File("NewFile.txt");
       
        if(file.renameTo(newfilename))
        {
            System.out.println("Rename is successfully done");
        }
        else{
            System.out.println("Failed to rename , not done");
        }
    }
    public static void Delete()
    {
        File file = new File("NewFile.txt");
        try {
            if(file.delete())
            {
                System.out.println("deletefile");
            }
        } catch (Exception e) {
           System.out.println("Failed");
        }
    }

   
}