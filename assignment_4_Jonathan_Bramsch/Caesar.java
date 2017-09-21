import java.util.*;
import java.io.*;

public class Caesar {

    public static void main(String[] args) {
        if (args.length < 2 || args.length > 3) {
            System.out.println("Incorrect arguments passed.");
            System.out.println("Usage: Caesar key inputfile outputfile");
            System.exit(0);
        }

        File inFile;
        FileReader reader;
        FileWriter writer;
        int key = 0;
        int charValue;
        char outputChar = ' ';
        String outputStr = "";

        try {
            key = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Incorrect key argument passed.");
            System.exit(0);
        }

        try {
            inFile = new File(args[1]);
            reader = new FileReader(inFile);

            for (int x = 1; x <= inFile.length(); x++) {
                charValue = reader.read();
                charValue = applyKey(charValue, key);
                outputChar = (char) charValue;
                outputStr += outputChar;
            }

        } catch (Exception e) {
            System.out.println("Input file not found or readable.");
            System.exit(0);
        }

        if (args.length == 3) {
            try {
                writer = new FileWriter(args[2]);
                writer.write(outputStr);
                writer.close();
            } catch (IOException e) {
                System.out.println("Output file not writeable.");
                System.exit(0);
            }
        } else {
            System.out.println(outputStr);
        }

    }

    public static int applyKey(int character, int key) {
        int newChar = character + key;
        while (newChar < 32 || newChar > 126) {
            if (newChar > 126) { newChar = newChar - 94; }
            else if (newChar < 32) { newChar = newChar + 94; }
        }
    return newChar;
    }
}
