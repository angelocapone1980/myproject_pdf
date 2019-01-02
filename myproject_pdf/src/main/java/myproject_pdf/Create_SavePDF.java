package myproject_pdf;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Create_SavePDF {
	
	public static void main(String[] args) {
		

		try {
			PDDocument document = new PDDocument();
			
			
			for (int i = 0; i < 2; i++) {
				PDPage blankPage = new PDPage();
				document.addPage(blankPage);
				
			}
			document.save("myDoc.pdf");
			System.out.println("PDF created.....");
			document.close();
			
			File myPDF = new File("myDoc.pdf");
			PDDocument doc = PDDocument.load(myPDF);
			PDPage page = doc.getPage(0);
			PDImageXObject pdImage = PDImageXObject.createFromFile("java-icon.png",doc);
			PDPageContentStream contents = new PDPageContentStream(doc, page);
			contents.drawImage(pdImage,250,600,150,180);
			
			contents.beginText();
			contents.setFont(PDType1Font.COURIER_BOLD_OBLIQUE, 25);
			contents.newLineAtOffset(25, 500);
			
			String txt1 = "Corso Java Base Napoli";
			contents.showText(txt1);
			contents.endText();
			
			contents.close();	
			doc.save("myDoc.pdf");
			doc.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
