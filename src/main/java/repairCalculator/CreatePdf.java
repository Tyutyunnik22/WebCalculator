package repairCalculator;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.*;
import com.itextpdf.kernel.color.*;
import com.itextpdf.kernel.font.*;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/** 
 * Класс формирования pdf-документа
 * @author Mamleeva Z
 * @version 1.0
*/
public final class CreatePdf{
	/** Название таблицы */
	private static final String NAME_TABLE = "Таблица 1 - Расчет стоимости монтажных работ";
	/** Путь к логотипу */
	private static final String PATH_IMG = "logo.jpg";
	/** Путь к шрифту */
	private static final String PATH_TIMES_NR = "fonts/TimesNewRoman.ttf";
	/** Название документа */
	private static final String DEST = "RepairCalculator.pdf";
	/** Авторы проекта*/
	private static final String AUTHORS = "Авторы: \n"
			+ "Тютюнник Екатерина \n"
			+ "Салимгареев Камиль \n"
			+ "Скитяева Анастасия \n"
			+ "Мамлеева Зарина";
	
	public static String filePath = "";
	
    /** 
     * Формирование и сохранение pdf-документа в файл
     * @throws IOException исключение ввода-вывода, которое может быть вызвано из-за неправильных путей к шрифту, картинке,
     * не найденных библиотек, неправильных форматов, отсутствии нужных файлов и др.
     */
	public static void savePdf(Order order) throws IOException{
		PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));
		Document document = new Document(pdf);
        
		PdfFont font = PdfFontFactory.createFont(PATH_TIMES_NR, PdfEncodings.IDENTITY_H);
		
		float col = 280f;
		float columnWidth[] = {col, col, col};
		Table tHeader = new Table(columnWidth);
		tHeader.setBackgroundColor(new DeviceRgb(156,5,88)).setFontColor(Color.WHITE);
		tHeader.addCell(new Cell().add("MATRIX\nTeam")
			.setTextAlignment(TextAlignment.CENTER)
		    .setVerticalAlignment(VerticalAlignment.MIDDLE)
	        .setMarginTop(30f)
	        .setMarginBottom(30f)
	        .setFontSize(30f)
	        .setBorder(Border.NO_BORDER)
	        .setFont(font)
			);
		
		/*
		ImageData imageData = ImageDataFactory.create(PATH_IMG);
	    Image pdfImg = new Image(imageData);
	    pdfImg.setWidth(200);
	    pdfImg.setHeight(100);
	    tHeader.addCell(new Cell().add(pdfImg.setAutoScaleHeight(true))
	    	.setTextAlignment(TextAlignment.CENTER)
   		    .setVerticalAlignment(VerticalAlignment.MIDDLE)
	        .setBorder(Border.NO_BORDER)
			);
		*/
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date currentDate = new Date();
		tHeader.addCell(new Cell().add("Калькулятор ремонта\n"
			+ "Монтажные работы\n"
			+ "Дата и время создания:\n"	
			+ formatter.format(currentDate))
			.setTextAlignment(TextAlignment.RIGHT)
			.setVerticalAlignment(VerticalAlignment.MIDDLE)
	        .setMarginTop(30f)
	        .setMarginBottom(30f)
	        .setBorder(Border.NO_BORDER)
			.setMarginRight(10f)
			.setFont(font)
			);
		
		float itemInfoColWidth[] = {160, 200, 60, 60,80};
		Table tData = new Table(itemInfoColWidth);
		
		//Заполнение заголовков таблицы с данными
		String[] headText = {"Тип","Вид","Цена, руб.","Кол-во","Сумма, руб."};
		for (int i=0;i<headText.length;i++) {
			tData.addCell(new Cell()
				.add(headText[i])
				.setBackgroundColor(new DeviceRgb(63,169,219))
				.setTextAlignment(TextAlignment.CENTER)
				.setFontColor(Color.WHITE)
				.setFont(font)
				);
		}
		
		/*
		for (WorkItem wItem : Order.getWorkItemList()) {
			String col1 = wItem.getKind().getType().getName();
			String col2 = wItem.getKind().getName();
			String col3 = String.format(Locale.US, "%.2f", wItem.getKind().getPrice());
			String col4 = wItem.toString();
			String col5 = String.format(Locale.US, "%.2f", wItem.getSum());
			tData.addCell(new Cell().add(col1).setFont(font));
			tData.addCell(new Cell().add(col2).setFont(font));
			tData.addCell(new Cell().add(col3).setFont(font).setTextAlignment(TextAlignment.CENTER));
			tData.addCell(new Cell().add(col4).setFont(font).setTextAlignment(TextAlignment.CENTER));
			tData.addCell(new Cell().add(col5).setFont(font).setTextAlignment(TextAlignment.RIGHT));
		}
		*/
		
		/*
		//Заполнение итога таблицы с данными
		tData.addCell(new Cell(1,4)
			.add("Итоговая стоимость, руб.:")
			.setBackgroundColor(new DeviceRgb(63,169,219))
			.setFontColor(Color.WHITE)
			.setBorder(Border.NO_BORDER)
			.setTextAlignment(TextAlignment.RIGHT)
			.setFont(font)
			);
		tData.addCell(new Cell()
			.add(String.format(Locale.US, "%.2f",Order.getTotalsum()))
			.setBackgroundColor(new DeviceRgb(63,169,219))
			.setFontColor(Color.WHITE)
			.setBorder(Border.NO_BORDER)
			.setTextAlignment(TextAlignment.RIGHT)
			.setFont(font)
			.setBold()
			);
			*/
		
		document.add(tHeader);
		document.add(new Paragraph("\n"));
		document.add(new Paragraph(NAME_TABLE + "\n")
				.setTextAlignment(TextAlignment.RIGHT).setFont(font));
		document.add(tData);
		document.add(new Paragraph("\n"));
		document.add(new Paragraph(AUTHORS)
				.setTextAlignment(TextAlignment.RIGHT).setFont(font));
		document.close();
	}
}
