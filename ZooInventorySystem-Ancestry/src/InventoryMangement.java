import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class InventoryMangement {
	
	private static List<FoodQuantityEntity> foodInventroy=new ArrayList<FoodQuantityEntity>(); 
	private static List<AnimalQuanityEntity> animalFeedInventory=new ArrayList<AnimalQuanityEntity>();
	
	public static void main(String args[])
	{
		String end="yes";
		while(end.equalsIgnoreCase("yes")){
		System.out.println("Enter Food Items -");
		System.out.println("==================");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter ZooName : ");
		String zoo= sc.nextLine();
		
		System.out.println("Enter foodName : ");
		String food= sc.nextLine();
		
		System.out.println("Enter Quantity : ");
		int quan=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Weight : ");
		int weig=sc.nextInt();
		sc.nextLine();
		
		FoodQuantityEntity temp=new FoodQuantityEntity();
		temp.setFoodItem(food);
		temp.setQuantity(quan);
		temp.setWeight(weig);
		temp.setZoo(zoo);
		
		updateFoodInventory(temp);
		System.out.println("whether u want to enter more items:");
		
		Scanner sc1=new Scanner(System.in);
		String checkEnd=sc1.nextLine();
		if(checkEnd.equalsIgnoreCase("no"))
			break;
		
		}
		end="yes";
		while (end.equalsIgnoreCase("yes"))
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter AnimalData");
			System.out.println("==================");
			
			System.out.println("Enter ZooName : ");
			String zoo= sc.nextLine();
			
			System.out.println("Enter AnimalName : ");
			String animal=sc.nextLine();
			
			System.out.println("Enter FoodFrequency : ");
			int frequency=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter FoodQuantity : ");
			int foodQuantity=sc.nextInt();
			sc.nextLine();
		
			System.out.println("Enter AnimalFood : ");
			String animalFood=sc.nextLine();
			
			System.out.println("Enter SpeciesName : ");
			String species=sc.nextLine();
			
			AnimalQuanityEntity temp=new AnimalQuanityEntity();
			temp.setAnimal(animal);
			temp.setAnimalZoo(zoo);
			temp.setFoodItem(animalFood);
			temp.setFreequencyFeedTime(frequency);
			temp.setQuanityPerTime(foodQuantity);
			temp.setSpecies(species);
			
			updateAnimalQu_inv(temp);
			
			System.out.println("whether u want to enter more items:");
			Scanner sc1=new Scanner(System.in);
			String checkEnd=sc1.nextLine();
			if(checkEnd.equalsIgnoreCase("no"))
				break;
			
		}
		
	}
	
	public static void updateAnimalQu_inv(AnimalQuanityEntity var)
	{
		int flag=0;
		for(AnimalQuanityEntity temp: animalFeedInventory)
		{
			if(temp.getAnimalZoo().equals(var.getAnimalZoo()) && temp.getAnimal().equals(var.getAnimal()))
			{
				temp.setFreequencyFeedTime(var.getFreequencyFeedTime());
				temp.setQuanityPerTime(var.getQuanityPerTime());
				flag=1;
				break;
				
			}
			
		}
		
		if(flag==0){
		animalFeedInventory.add(var);	
		}
		System.out.println("size of animalFeedinventory: "+animalFeedInventory.size());
		
	}
	
	public static void updateFoodInventory(FoodQuantityEntity var)
	{
		if(!foodInventroy.isEmpty())
		{
			for(FoodQuantityEntity temp: foodInventroy)
			{
				if(temp.getZoo().equals(var.getZoo()) && temp.getFoodItem().equals(var.getFoodItem()))
					{
						temp.setWeight(0);
						
					}
				
			}
			
		}
		
		foodInventroy.add(var);
		System.out.println("food inventory size: "+foodInventroy.size());
	}
		
	
}
