package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import repairCalculator.WorkType;

/** 
 * Тестовый класс проверки загрузки типа монтажных работ из файла
 * @author Salimgareev K
 * @version 1.0
*/
public class WorkTypeTest {
	/**
    * Проверяет кол-во загруженных типов работ, оно должно быть равно 6
    * А также в типах должны содержаться определенные значения
    */
	@Test
	public void testGetWorkTypeList() {
		String path = "src/main/webapp";

		File file = new File(path);
		String folderPath = file.getAbsolutePath()  + File.separator;
		String filePath = folderPath + "data.txt";
		File f = new File(filePath);
		if(!f.exists() || f.isDirectory()) { 
			fail("Файл не найден: " + filePath);
		}
		
		WorkType.filePath = folderPath;
		//Загружаем реальные данные из файла
		String[] data = WorkType.getWorkTypeList();
		if (data.length == 0) {
			fail("Массив типов монтажных работ = 0");
		} else if(data.length != 6) {
			fail("Длина массива типов монтажных работ должна быть = 6");
		}
		//Тестовые значения, которые будем искать в реальных данных
		String[] testData = {"Полы (монтажные работы)","Стены (монтажные работы)",
							 "Потолки (монтажные работы)","Окна, двери",
							 "Сантехнические работы","Электрика"};
		for (String testLine: testData) {
			boolean find = false;	//Переменная для проверки - найдено значение или нет
			for (String realLine: data) {
				if (realLine.equals(testLine)) {
					find = true;	//Значение найдено
				}
			}
			if (find == false) {
				fail("Не найден тип монтажных работ - " + testLine);
			}
		}
	}
}