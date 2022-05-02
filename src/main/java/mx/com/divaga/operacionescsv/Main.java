/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.divaga.operacionescsv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.xml.sax.SAXException;

/**
 *
 * @author kevinmolina
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("/Users/Molina/Desktop/basededatoscsv.csv"));
        try ( CSVPrinter csvPrinter = CSVFormat.DEFAULT.withHeader("NOMBRE", "ESPECIE", "GENERO", "EDAD", "NOMBRE CIENTIFICO")
                .print(bufferedWriter)) {
            csvPrinter.printRecord("PERRO", "CANINO", "MACHO", "10", "PERRUNIS");
            csvPrinter.printRecord("GATO", "FELINO", "HEMBRA", "2", "GATUNIS");
        }

        Reader in = new FileReader("/Users/Molina/Desktop/basededatoscsv.csv");

        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for (CSVRecord record : records) {

            String nombre = record.get(0);
            String especie = record.get(1);

            JOptionPane.showMessageDialog(null, "NOMBRE: " + nombre + " ESPECIE: " + especie);

        }

    }
    

}
