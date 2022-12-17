package sample;

import java.io.File; // Link Libraries
import java.io.FileInputStream; // Link Libraries
import java.io.FileOutputStream; // Link Libraries
import java.io.IOException; // Link Libraries
import java.io.InputStream; // Link Libraries
import java.io.OutputStream; // Link Libraries

public class FileService {

    public static long copyFile(File fileIn, File fileOut) throws IOException {
        try (InputStream is = new FileInputStream(fileIn);
             OutputStream os = new FileOutputStream(fileOut)) {
            return is.transferTo(os);
        }
    }

    public static long copyFolderDocx(File folderIn, File folderOut, String ext) throws IOException{
        File[] files = folderIn.listFiles(); // Аn array where all our files with this extension will be stored
        long totalBytes  = 0; // Total number of bytes
        if(files != null) { // Checking for files
            for (File file : files) {
                if(file.isFile() && (file.getName().endsWith(ext))){
                    File fileOut = new File(folderOut, file.getName());
                    totalBytes+= copyFile(file,folderOut);
                }
            }
        }
        return totalBytes;
    }

}