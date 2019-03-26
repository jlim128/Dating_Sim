/**
 * Checkpoint class - class to contain info about a checkpoint
 * @author Jonathan Lim
 *
 */
public class Checkpoint {
	private int requiredLP;
	private int checkpointLocation;
	
	/**
	 * Checkpoint constructor - initializes where the checkpoint will be as well as the required love points needed to pass
	 * @param c - checkpoint location
	 * @param l - required love points
	 */
	public Checkpoint (int c, int l) {
		checkpointLocation = c;
		requiredLP = l;
	}
	
	/**
	 * Method to get location of checkpoint
	 * @return checkpoint location
	 */
	public int getCheckpoint() {
		return checkpointLocation;
	}
	
	/**
	 * Method to get required love points
	 * @return love points required
	 */
	public int getRequiredLP() {
		return requiredLP;
	}
}
