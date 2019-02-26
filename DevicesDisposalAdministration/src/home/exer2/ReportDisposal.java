package home.exer2;

import java.util.List;
import java.nio.file.*;
import java.io.*;

/**
 * Provides the method to create and print a list of pickup objects to XML file.
 * The file is stored in the root folder of the project
 *
 * @author Tzeni
 */
public class ReportDisposal {

    List<PickUp> pickups;

    public ReportDisposal(List<PickUp> pickups) {
        this.pickups = pickups;
    }

    public void printToXML() {
        //Holds the name of the file to be created
        String fileString = "outputDisposal.xml";
        //Creating the path object of the file
        Path filePath = Paths.get(fileString);
        if (Files.notExists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e1) {

                e1.printStackTrace();
            }
        }
        //Converting the path object to file to use in the FileWriter constructor 
        File newFile = filePath.toFile();

        /*
         Typical try-with-resources block that features three streams: FileWriter,BufferedWriter and PrintWriter.
          The FileWriter object connects the file tho the stream.
          The BufferedWriter object 
        */
        try ( PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(newFile)))) {
            for (PickUp pck : pickups) {
                out.print(pck);
            }

        } catch (IOException e) {
            System.err.println(e);
        }

    }

}
