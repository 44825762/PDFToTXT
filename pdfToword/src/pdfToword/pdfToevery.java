package pdfToword;
import java.io.File;
import java.io.FileWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
public class pdfToevery {
    public static void main(String[] args) throws Exception{
        //File pdfFile = new File("E:\\javaTest\\机考复习材料-基础篇.pdf");
    	File pdfFile = new File("E:\\资料\\ACMICPC算法训练教程.pdf");
        File out = new File("E:\\javaTest\\机考复习材料-基础篇.txt");
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