package repairCalculator;

/** 
 * Абстрактный класс, который содержит общие поля и методы для описания работ
 * @author Salimgareev K
 * @version 1.0
*/
public abstract class Work {
	/** Название */
	protected String name;	//Переменная видна наследниками и в этом же пакете
	
	/**
     * Установка {@link Work#name}
     * @param name Название
     */
	public void setName(String name) {
		this.name = name;
	}
	
    /**
     * Получение значения поля {@link Work#name}
     * @return возвращает название
     */
	public String getName() {
		return name;
	}
	
	/**
     * Абстрактный метод преобразования класса к строке
     */
	abstract public String toString();
}

