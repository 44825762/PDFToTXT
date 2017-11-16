package pdfToword;
import java.io.File;
import java.io.FileWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
public class pdfToevery {
    public static void main(String[] args) throws Exception{
        //File pdfFile = new File("E:\\javaTest\\������ϰ����-����ƪ.pdf");
    	File pdfFile = new File("E:\\����\\ACMICPC�㷨ѵ���̳�.pdf");
        File out = new File("E:\\javaTest\\������ϰ����-����ƪ.txt");
        int pages;
        if(!out.exists()){
        	out.createNewFile();
        }
        PDDocument document = null;
        try
        {
            document=PDDocument.load(pdfFile);
            pages = document.getNumberOfPages();
            PDFTextStripper stripper=new PDFTextStripper();
            stripper.setSortByPosition(true);
            stripper.setStartPage(1);
            stripper.setEndPage(pages);
            //String content = stripper.getText(document);
            String content = stripper.getText(document);
            System.out.println(pages);   
            filesave(content,out);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public static void filesave(String content,File out) throws Exception{
    	FileWriter fileWritter = new FileWriter(out, true);  
        fileWritter.write(content);  
        fileWritter.close();
    	
    }

}