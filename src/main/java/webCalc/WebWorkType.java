package webCalc;

import java.util.ArrayList;
import java.util.List;

/** 
 * Класс отвечает за предоставление информации о типах монтажных работ для веб приложения
 * @author Salimgareev K
 * @version 1.0
*/
public class WebWorkType {
	/** Название типа*/
    private String name;
    /** Логическая переменная, выбрано ли значение*/
    private boolean select;
 
    /** 
     * Конструктор создание нового типа работ для веб приложения
     * @param name название типа работ
     * @param whatSelect выбранное значение
     */
    public WebWorkType(String name, String whatSelect) {
        super();
        this.name = name;
        if (name.equals(whatSelect)) {
        	this.select = true;
        } 
    }

    /**
     * Получение выбранного значения
     * @return возвращает выбранное значение
     */
    public boolean getSelect() {
    	return select;
    }
    
    /**
     * Получение названия типа
     * @return возвращает название типа
     */
    public String getName() {
        return name;
    }
    
    /** 
     * Получение списка типов работ
     * @param whatSelect выбранное значение
     * @return возвращает список типов работ
     */
    public static List<WebWorkType> getList(String whatSelect) {
    	String[] masType = repairCalculator.WorkType.getWorkTypeList();
        List<WebWorkType> listCategory = new ArrayList<>();
        for (String m1 : masType) {
        	listCategory.add(new WebWorkType(m1 ,whatSelect)); 
        }
        return listCategory;
    }
}
