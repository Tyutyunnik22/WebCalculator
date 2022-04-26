package repairCalculator;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/** 
 * Класс отвечает за предоставление информации о видах монтажных работ
 * @author Salimgareev K
 * @author Skityaeva A
 * @author Mamleeva Z
 * @version 1.0
*/
public final class WorkKind extends Work{
	/** Список всех видов работ для всех типов */
	private static ArrayList<WorkKind> listWk = new ArrayList<WorkKind>();
	
	/** Тип работ, к которому относится этот вид работ*/
	private WorkType workType;
	
	/** Цена данного вида работ*/
	private Double price;
	
	/** Единица измерения данного вида работ*/
	private String units;
	
	public static String filePath = "";
	
    /** 
     * Конструктор создание нового вида работ
     * @param wt тип работ
     * @param name название вида работ
     * @param price цена
     * @param units единица измерения
     */
	public WorkKind(WorkType wt,String name,Double price,String units) {
		this.workType = wt;
		super.setName(name);
		this.price = price;
		this.units = units;
	}
	
    /**
     * Получение значения поля {@link WorkKind#price}
     * @return возвращает цену
     */
	public Double getPrice() {
		return price;
	}
	
    /**
     * Получение значения поля {@link WorkKind#units}
     * @return возвращает единицу измерения
     */
	public String getUnit() {
		return units;
	}
	
    /**
     * Получение значения поля {@link WorkKind#workType}
     * @return возвращает тип работ
     */
	public WorkType getType() {
		return workType;
	}
	
    /**
     * Получение значения поля {@link Work#name}
     * @return возвращает название вида работ
     */
	@Override
	public String toString() {
		return super.name;
	}
	
    /**
     * Получение массива видов работ для заданного типа
     * @param workType строка с названием типа работ
     * @return возвращает массив названий видов работ
     */
	public static String[] getNameList(String workType) {
		if (listWk.size() == 0) {
			//Если список работ = 0, то загрузить список работ из файла
			readFromFile();
		}
		ArrayList<String> array = new ArrayList<String>();
		for (WorkKind value : listWk) {
			if (value.workType.getName().equals(workType)) {
				  array.add(value.getName());
			}
		}
		return array.toArray(new String[array.size()]);
	}
	
	 /**
     * Чтение данных из файла и запись их в список {@link WorkKind#listWk} 
     */
	private static void readFromFile() {
		String fileName = filePath + "data.txt";
		ArrayList<String> list = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
			    new FileInputStream(fileName), "UTF-8"))) {
			String textLine = null;
			WorkType workType = null;
		    while ((textLine = br.readLine()) != null) {
		    	if(!textLine.isEmpty() && textLine.contains("!")){
		    		//Строка содержит "!", это значит тип работ
		    		list.add(textLine.substring(1));
		    		workType = new WorkType(textLine.substring(1));
		    	} else if (!textLine.isEmpty()){
		    		//Строка без "!", значит это вид работ с типом, который найден выше
		    		WorkKind wk = createWorkKind(workType, textLine);
		    		listWk.add(wk);
		    	}
		    } 
		} catch (IOException ex) {
			String msg = String.format("Файл %s не найден", fileName);
		    JOptionPane.showMessageDialog(null,msg,"Загрузка файла",
		    		JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	/**
     * Получение экземпляра вида работ из строки
     * @param wt тип работ
     * @param line строка с разделителями "tab" с информацией о виде работ: название, ед.изм.,цена
     * @return возвращает экземпляр вида работ
     */
	private static WorkKind createWorkKind(WorkType wt,String line) {
		//Разбиваем строку в массив строк
		String[] arr = line.split("\\t");
		String name = arr[0];    //Название
		String unit = arr[1];    //Ед.измерения
		String strPrice = arr[2];	//Цена
		
		// Выполняем перегруженный метод createWorkKind
		WorkKind wk = createWorkKind(wt, name, strPrice, unit);
		return wk;
	}

    /**
     * Создание экземпляра вида работ
     * @param wt тип работ
     * @param name название
     * @param strPrice цена
     * @param unit ед.измерения
     * @return возвращает созданный экземпляр вида
     */
	private static WorkKind createWorkKind(WorkType wt, String name, String strPrice, String unit) {
		Double price = 0.0;    //Цена по умолчанию
		try {
			//Преобразуем цену из строки в число
			price = Double.parseDouble(strPrice);
		} catch (NumberFormatException ex) {
			System.out.println("Чтение вида: цена не число!");
		}
		//Создаем экземпляр вида работ
		WorkKind wk = new WorkKind(wt, name, price, unit);
		return wk;
	}
	
    /**
     * Получение экземпляра из списка вида работ
     * @param typeName название типа работ
     * @param  kindName название вида работ
     * @return возвращает найденный экземпляр вида работ
     */
	public static WorkKind findWorkKind(String typeName,String kindName) {
		if (listWk.size() == 0) {
			//Если список работ = 0, то загрузить список работ из файла
			readFromFile();
		}
		for (WorkKind value : listWk) {
			if (value.workType.getName().equals(typeName) && value.getName().equals(kindName)) {
				  return value;
			}
		}
		return null;
	}
}

