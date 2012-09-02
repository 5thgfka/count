package model;
/**
 * model.vote
 * @author ekse
 *
 */
public class vote {
	/**
	 * an item one count hold
	 * id      : id of the vote
	 * countid : the countid of the vote
	 * name    : name of the vote
	 * times   : count times
	 */
	public int id;
	public int countid;
	public String name;
	public int times;
	
	public vote() {
		/**
		 * default constructor
		 */
	}
	
	public vote(int id, int countid, String name, int times) {
		
		this.id = id;
		this.countid = countid;
		this.name = name;
		this.times = times;
	}
}
