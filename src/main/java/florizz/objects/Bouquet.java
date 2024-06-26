package florizz.objects;



import florizz.core.FlorizzException;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Objects;

public class Bouquet {
    private String bouquetName;
    private HashMap<Flower, Integer> flowerHashMap;

    public Bouquet() {
        this("");
    }
    public Bouquet(String bouquetName){
        this.bouquetName = bouquetName;
        this.flowerHashMap = new HashMap<Flower,Integer>();
    }
    @Override
    public String toString() {
        return bouquetName;
    }

    public HashMap<Flower, Integer> getFlowerHashMap() {
        return flowerHashMap;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof Bouquet)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Bouquet c = (Bouquet) obj;

        // Compare the data members and return accordingly
        return Objects.equals(c.bouquetName.toUpperCase(), this.bouquetName.toUpperCase());
    }

    /**
     * Get total quantity of flowers in the bouquet
     * @return int total quantity of flowers
     */
    public int totalNumberOfFlowers() {
        int quantity = 0;
        for (Flower flower : flowerHashMap.keySet()) {
            quantity += flowerHashMap.get(flower);
        }
        return quantity;
    }

    /**
     * Checks if a flower exists in the bouquet.
     *
     * @param flowerName the flower to check for its existence
     * @return true if the flower exists in the bouquet, false otherwise
     */
    public boolean doesFlowerExist(Flower flowerName) {
        if (flowerHashMap.get(flowerName) == null) {
            return false;
        }
        return true;
    }

    /**
     * Adds flowers to the bouquet.
     *
     * @param flowerName Ihe name of the flower to add
     * @param quantity Ihe quantity of the flower to add
     * @throws FlorizzException If the quantity of flowers to add exceeds the maximum allowed value
     */
    public void addFlower(Flower flowerName, Integer quantity) throws FlorizzException {
        if (doesFlowerExist(flowerName)) {
            Integer currentQuantity = getFlowerQuantity(flowerName);
            int newQuantity = currentQuantity + quantity;
            if ((quantity > 0 && currentQuantity > Integer.MAX_VALUE - quantity) || newQuantity < 0) {
                throw new FlorizzException("You have added too much flowers!");
            }
            flowerHashMap.replace(flowerName, newQuantity);
        } else {
            flowerHashMap.put(flowerName,quantity);
        }
    }

    /**
     * Removes flowers from the bouquet.
     *
     * @param flowerName The name of the flower to remove
     * @param quantity The quantity of the flower to remove
     * @return True if the flower was successfully removed, false otherwise
     * @throws FlorizzException If the specified quantity is <= 0 or if it exceeds the current quantity of flowers
     */
    public boolean removeFlower(Flower flowerName, Integer quantity) throws FlorizzException {
        // if flower already in bouquet
        if (doesFlowerExist(flowerName)) {
            Integer currentQuantity = getFlowerQuantity(flowerName);
            int newQuantity = currentQuantity - quantity;
            if (quantity <= 0) {
                throw new FlorizzException("Please input a quantity between 1 and the " +
                        "current amount of flowers (inclusive).");
            }
            if (newQuantity < 0) {
                System.out.println("Tried to remove more than the quantity available, quantity set to 0");
                newQuantity = 0;
            }
            if (newQuantity == 0) {
                flowerHashMap.remove(flowerName);
            }
            flowerHashMap.replace(flowerName, newQuantity);
            return true;
        }
        return false;
    }

    /**
     * Get quantity of a flower. If flower does not exist in bouquet, return 0
     *
     * @param flowerName
     * @return
     */
    public Integer getFlowerQuantity(Flower flowerName) {
        if (flowerHashMap.get(flowerName) == null) {
            return 0;
        }
        return flowerHashMap.get(flowerName);
    }

    /**
     * get bouquet name
     * @return
     */
    public String getBouquetName() {
        return this.bouquetName;
    }

    public void setName(String newName) {
        this.bouquetName = newName;
    }

    public ArrayList<Flower> getFlowerList (){
        return new ArrayList<Flower> (flowerHashMap.keySet());
    }
}
