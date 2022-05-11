package webCalc;

import java.util.ArrayList;
import java.util.List;

/** 
 * Класс отвечает за предоставление информации о видах монтажных работ для веб приложения
 * @author Salimgareev K
 * @version 1.0
*/
public class WebWorkKind {
	/** Название вида*/
    private String name;
    /** Логическая переменная, выбрано ли значение*/
    private boolean select;
 
    /** 
     * Конструктор создание нового вида работ для веб приложения
     * @param name название вида работ
     * @param whatSelect выбранное значение
     */
    public WebWorkKind(String name, String whatSelect) {
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
     * Получение названия вида
     * @return возвращает название вида
     */
    public String getName() {
        return name;
    }
    
    /** 
     * Получение списка видов работ
     * @param workType название типа работ
     * @param whatSelect выбранное значение
     * @return возвращает список видов работ
     */
    public static List<WebWorkKind> getList(String workType, String whatSelect) {
    	String[] masKind = repairCalculator.WorkKind.getNameList(workType);
        List<WebWorkKind> listWorkKind = new ArrayList<>();
        for (String m1 : masKind) {
        	listWorkKind.add(new WebWorkKind(m1 ,whatSelect)); 
        }
        
        return listWorkKind;
    }
}
