package com.livejournal.karino2.pdf2jpegzip;
import java.io.*;

// javac com/livejournal/karino2/pdf2jpegzip/*.java
// java com.livejournal.karino2.pdf2jpegzip.Pdf2Jpeg ../TOEFL対策続必修単語集 ./result

public class Pdf2Jpeg {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: pdf2jpeg srcdir destdir");
            return;
        }
        File srcDir = new File(args[0]);
        PdfParser parser = new PdfParser(new File(args[1]));
        File[] pdfs = srcDir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                    if (filename.endsWith(".pdf"))
                        return true;
                    return false;
                }
        });

        for(File file : pdfs) {
            System.out.println(file.getName());
            try {
                parser.doOnePdf(file);
            } catch(IOException e)  {
                System.out.println("IO Exception: " + e.getMessage());
            }
        }
    }
}