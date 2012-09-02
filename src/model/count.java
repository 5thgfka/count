package model;

/**
 * model.count
 * @author ekse
 *
 */
public class count {
	/**
	 * count: one count project
	 * 
	 * id        : primary key
	 * name      : name
	 * countdate : count date
	 * 
	 */
	
	public int id;
	public String name;
	public String countdate;
	
	public count() {
		/**
		 * default constructor
		 */
	}
	
	public count(int id, String name, String countdate) {
		
		this.id = id;
		this.name = name;
		this.countdate = countdate;
	}
}
