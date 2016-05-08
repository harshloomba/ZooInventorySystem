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
		
		//First Query
		List<AnimalFeed> animalFeedPerDay=getAnimalFeedDay();
		for(AnimalFeed t:animalFeedPerDay)
			System.out.println(t);
		
		//SecondQuery
		List<SpeciesFeed> speciesFeedFrequencyPerDay=getSpeciesFeedFreq();
		for(SpeciesFeed t:speciesFeedFrequencyPerDay)
			System.out.println(t);
		
		List<ZooInventory> zooInventroyCheck= notifyLessInventory();
		
		for(ZooInventory z: zooInventroyCheck)
			System.out.println("Items against Zoo which have less remainings: "+z);
		
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
	
	
	public static List getAnimalFeedDay()
	{
		List<AnimalFeed> result=new ArrayList<AnimalFeed>();
		
		Map<String,List<AnimalQuanityEntity>> process=new HashMap<String,List<AnimalQuanityEntity>>();
		
		for(AnimalQuanityEntity temp : animalFeedInventory)
		{
			List tempList=process.get(temp.getAnimal());
			
			if(tempList!=null)
			{
				tempList.add(temp);
				process.put(temp.getAnimal(), tempList);
			}
			else {
				List<AnimalQuanityEntity> temp2=new ArrayList<AnimalQuanityEntity>();
				temp2.add(temp);
				process.put(temp.getAnimal(), temp2);
			}
		}
		
		for(String s:process.keySet())
		{
			int sum=0;
			List<AnimalQuanityEntity> temp=process.get(s);
			for(AnimalQuanityEntity t: temp)
			{
				sum=sum+t.getFreequencyFeedTime()*t.getQuanityPerTime();
			}
			AnimalFeed tem=new AnimalFeed();
			tem.setAnimal(s);
			tem.setQuantity(sum/temp.size());
			result.add(tem);
		}
		
		return result;
		
	}
	
	public static List getSpeciesFeedFreq(){
		List<SpeciesFeed> result=new ArrayList<SpeciesFeed>();
		Map<String,List<AnimalQuanityEntity>> temp=new HashMap<String, List<AnimalQuanityEntity>>();
		
		for(AnimalQuanityEntity t : animalFeedInventory)
		{
			List<AnimalQuanityEntity> tempList=temp.get(t.getSpecies());
			
			if(tempList!=null)
			{
				tempList.add(t);
				temp.put(t.getSpecies(), tempList);
			}
			else {
				List<AnimalQuanityEntity> temp2=new ArrayList<AnimalQuanityEntity>();
				temp2.add(t);
				temp.put(t.getSpecies(), temp2);
			}
		}
		
		for(String s:temp.keySet())
		{
			int sum=0;
			List<AnimalQuanityEntity> te=temp.get(s);
			for(AnimalQuanityEntity t: te)
			{
				sum=sum+t.getFreequencyFeedTime();
			}
			SpeciesFeed tem=new SpeciesFeed();
			tem.setSpecies(s);
			tem.setAverageFeedFrequency(sum/temp.size());
			result.add(tem);
		}
		
		return result;
	}
	
	public static List notifyLessInventory()
	{
		List<ZooInventory> result=new ArrayList<ZooInventory>();
		
		int theshold=15;
		
		for(FoodQuantityEntity s: foodInventroy)
		{
			if(s.getWeight()==1 && s.getQuantity()<25)
			{
				ZooInventory a=new ZooInventory();
				a.setFood(s.getFoodItem());
				a.setZoo(s.getZoo());
				result.add(a);
			}
		}
		
		return result;
		
	}
	
	
}
