
public class AnimalQuanityEntity {

	private String species;
	private String animal;
	private int freequencyFeedTime;
	private int quanityPerTime;
	private String foodItem;
	private String animalZoo;
	public String getAnimalZoo() {
		return animalZoo;
	}
	
	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public void setAnimalZoo(String animalZoo) {
		this.animalZoo = animalZoo;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public int getFreequencyFeedTime() {
		return freequencyFeedTime;
	}
	public void setFreequencyFeedTime(int freequencyFeedTime) {
		this.freequencyFeedTime = freequencyFeedTime;
	}
	public int getQuanityPerTime() {
		return quanityPerTime;
	}
	public void setQuanityPerTime(int quanityPerTime) {
		this.quanityPerTime = quanityPerTime;
	}
	public String getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}
	
	
}
