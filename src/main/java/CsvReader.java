import java.io.*;
import java.util.Scanner;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

public class CsvReader {

    /*
    * Scanner Class
    * String.split()
    * Using OpenCSV API (3rd Party library)
    * */

    // Using Scanner Class
    private void csvReaderMethod1(String filePath) {

        try {
            Scanner scanner = new Scanner(new File(filePath));

            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                System.out.print(scanner.next() + " ");
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Using String.split()
    private void csvReaderMethod2(String filePath) {

        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while ((line = br.readLine()) != null) {
                String[] laptop = line.split(",");
                System.out.println(laptop[0] + " " + laptop[1] + " " + laptop[2] + " " + laptop[3]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Using OpenCSV API

    private void csvReaderMethod3(String filePath) {
        try {
            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);

            String[] line;
            while ((line = csvReader.readNext()) != null) {
                for(String data : line) {
                    System.out.print(data + " ");
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        String filePath = new File("").getAbsolutePath() + File.separator + "/src/main/resources/laptops.csv";

        CsvReader csvObj = new CsvReader();
        System.out.println("********Reading data through Scanner Class********");
        csvObj.csvReaderMethod1(filePath);

        System.out.println("\n********Reading data through String.split() method********");
        csvObj.csvReaderMethod2(filePath);

        System.out.println("********Reading data through OpenCSV API********");
        csvObj.csvReaderMethod3(filePath);

    }
}
