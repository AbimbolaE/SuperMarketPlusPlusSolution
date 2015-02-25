import com.supermarketplusplus.factory.ItemUpdaterFactory;
import com.supermarketplusplus.model.Item;
import com.supermarketplusplus.updater.ItemUpdater;

import java.util.ArrayList;
import java.util.List;


public class SuperMarketPlusPlus {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("Starting Supermarket Plus Plus");
		
        items = new ArrayList<Item>();
        items.add(new Item("Thermal Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Chicken", 5, 7));
        items.add(new Item("Sulfuras", 0, 80));
        items.add(new Item("Backstage Passes", 15, 20));
        items.add(new Item("Ginger Cake", 3, 6));
        items.add(new Item("Organic Banana", 10, 26));

        updateQuality();
}


	
    public static void updateQuality()
    {
        ItemUpdaterFactory itemUpdaterFactory = new ItemUpdaterFactory();
        ItemUpdater updater = null;
        for (Item item : items)
        {
            System.out.println("Before: ");
            printItemState(item);

            updater = itemUpdaterFactory.getUpdater(item.name);
            updater.update(item);

            System.out.println("After: ");
            printItemState(item);
            System.out.println("------");
        }
    }

    private static void printItemState(Item item) {
        System.out.printf("Item name: %s\t Item Sold In: %d days\t Item quality is: %d \n",
            item.getName(), item.getSellIn(), item.getQuality());
    }

}