import java.io.*;
import java.nio.file.Paths;

public class FileReaderLocal {
    static String readFile(String fileName) {
        String path = Paths.get("").toAbsolutePath().toString() + "/src/main/resources";

        System.out.println("Path: " + path);
        System.out.println("File: " + fileName + "\n");


        File file = new File(path, fileName);

        StringBuilder stringBuilder = new StringBuilder();

        try {
            FileInputStream fileInputStream = new FileInputStream(file);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (stringBuilder.toString().equals("")) {
                    stringBuilder.append(line);
                } else {
                    stringBuilder.append("\n").append(line);
                }
            }

            bufferedReader.close();
        }
        catch (IOException ex) {
            System.err.println("Can't read file.");
        }

        return stringBuilder.toString();
    }
}
