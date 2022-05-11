package repairCalculator;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/** 
 * Класс отвечает за предоставление информации о типе монтажных работ
 * @author Salimgareev K
 * @author Skityaeva A
 * @author Mamleeva Z
 * @version 1.0
*/
public final class WorkType extends Work{
	/** Путь к файлу с данными работ*/
	public static String filePath = "";
	
    /** 
     * Конструктор создание нового типа работ
     * @param substring название типа работ
     */
	public WorkType(String substring) {
		super.setName(substring);
	}

    /**
     * Получение массива названий типа работ
     * @return массив названий типа
     */
	public static String[] getWorkTypeList() {
		String fileName = filePath + "data.txt";
		ArrayList<String> list = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
			    new FileInputStream(fileName), "UTF-8"))) {
			String textLine = null;
		    while ((textLine = br.readLine()) != null) {
		    	if(!textLine.isEmpty() && textLine.contains("!")){
		    		list.add(textLine.substring(1));
		    	}
		    } 
		} catch (IOException ex) {
			String msg = String.format("Файл %s не найден", fileName);
		    JOptionPane.showMessageDialog(null,msg,"Загрузка файла",
		    		JOptionPane.ERROR_MESSAGE);
		}	
		return list.toArray(new String[list.size()]);
	}
	
    /**
     * Получение значения поля {@link Work#name}
     * @return возвращает название типа работ
     */
	@Override
	public String toString() {
		return super.name;
	}
}
