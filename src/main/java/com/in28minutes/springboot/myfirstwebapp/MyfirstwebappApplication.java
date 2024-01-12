package com.in28minutes.springboot.myfirstwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itextpdf.barcodes.Barcode128;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.font.PdfFontFactory.EmbeddingStrategy;

@SpringBootApplication
public class MyfirstwebappApplication {

	public static void main(String[] args) {


		try {
			PdfWriter writer = new PdfWriter("output.pdf");
			PdfDocument pdf = new PdfDocument(writer);
			pdf.setDefaultPageSize(new PageSize(PageSize.A4.getWidth()/2, PageSize.A4.getHeight()/2));
			
			Document document = new Document(pdf);

			Barcode128 code128 = new Barcode128(pdf);
			code128.setCode("123456789");
			code128.setCodeType(Barcode128.CODE128);
			Image code128Image = new Image(code128.createFormXObject(pdf));
			document.add(code128Image);
			
			String REGULAR  = "src/main/resources/fonts/HYKANB.TTF";
			String REGULAR2 = "src/main/resources/fonts/YBUU02.TTF";
			FontProgram fontProgram  = FontProgramFactory.createFont(REGULAR);
			FontProgram fontProgram2 = FontProgramFactory.createFont(REGULAR2);
			PdfFont font  = PdfFontFactory.createFont(fontProgram, PdfEncodings.IDENTITY_V, EmbeddingStrategy.PREFER_EMBEDDED);  // 세로글씨
			PdfFont font2 = PdfFontFactory.createFont(fontProgram2, PdfEncodings.IDENTITY_H, EmbeddingStrategy.PREFER_EMBEDDED); // 가로글씨

			Paragraph p1 = new Paragraph("Testing of 하이 123 안녕하세요 letters").setFont(font);
			Paragraph p2 = new Paragraph("Testing2 of 하이 123 안녕하세요 letters2").setFont(font2);
			document.add(p1);
			document.add(p2);
			
			document.add(new Paragraph("안녕하세요 World!"));
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SpringApplication.run(MyfirstwebappApplication.class, args);
	}

}
