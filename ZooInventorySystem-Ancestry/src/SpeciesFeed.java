
public class SpeciesFeed {

	private String species;
	private int averageFeedFrequency;
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public int getAverageFeedFrequency() {
		return averageFeedFrequency;
	}
	public void setAverageFeedFrequency(int averageFeedFrequency) {
		this.averageFeedFrequency = averageFeedFrequency;
	}
	@Override
	public String toString() {
		return "SpeciesFeed [species=" + species + ", averageFeedFrequency="
				+ averageFeedFrequency + "]";
	}
	
}
