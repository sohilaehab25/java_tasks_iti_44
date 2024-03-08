import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class IncorrectFilenameException extends Exception {
    public IncorrectFilenameException(String errorMessage) {
        super(errorMessage);
    }
}

class FileProcessor {
    public void readFirstLineFromFile(String fileName) throws IncorrectFilenameException {
        try (Scanner file = new Scanner(new File(fileName))) {
            if (file.hasNextLine()) {
                System.out.println("First line of the file: " + file.nextLine());
            } else {
                throw new IncorrectFilenameException("File is empty: " + fileName);
            }
        } catch (FileNotFoundException e) {
            throw new IncorrectFilenameException("File not found: " + fileName);
        }
    }

    // private boolean isCorrectFileName(String fileName) {
    //     return fileName != null && !fileName.isEmpty();
    // }
}

 class SearchingOnFile {
    public static void main(String[] args) {
        try {
            FileProcessor fileProcessor = new FileProcessor();
            String fileName = "sohila.java"; // Replace with an actual file name
            fileProcessor.readFirstLineFromFile(fileName);
        } catch (IncorrectFilenameException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
