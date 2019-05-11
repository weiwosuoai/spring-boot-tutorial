package site.exception.springbootexcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.exception.springbootexcel.model.WriteModel;
import site.exception.springbootexcel.model.WriteModel2;
import site.exception.springbootexcel.util.DataUtil;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PdfTests {

	private static final String PATH = "/Users/a123123/Work/tmp_files/testPDF.pdf";


	@Test
	public void writePdfSimple() throws Exception {
	    Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(PATH));
		document.open();
		document.add(new Paragraph("hello 世界"));
		document.close();
		writer.close();
	}





}
