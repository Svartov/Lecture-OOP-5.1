package sample;

import java.io.*; // Link Libraries

public class Program {
    public static void main(String[] args) {

        File folderIn = new File(""); // Enter first folder

        File folderOut = new File(""); // Enter the second folder

        String fileExt = "docx"; // file format

        try {
            long totalBytes = FileService.copyFolderDocx(folderIn, folderOut, fileExt);
            System.out.println("copying: " + totalBytes + " bytes");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}