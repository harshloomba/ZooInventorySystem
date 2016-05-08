public class AnimalFeed
	{
		
		String animal;
		int quantity;
		public String getAnimal() {
			return animal;
		}
		public void setAnimal(String animal) {
			this.animal = animal;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		@Override
		public String toString() {
			return "AnimalFeed [animal=" + animal + ", quantity=" + quantity
					+ "]";
		}
		
	}
