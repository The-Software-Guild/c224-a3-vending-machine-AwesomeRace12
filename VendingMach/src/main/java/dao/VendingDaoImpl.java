/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.math.BigDecimal;
import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import dto.Item;
/**
 *
 * @author aakar
 */
public class VendingDaoImpl implements VendingDao{
     public enum CoinType {
        PENNY,NICKEL,DIME,QUARTER;
    }

    private CoinType coinType;

    private BigDecimal total = new BigDecimal("0.00");

    private final Map<String, Item> itemList = new HashMap<>();

    public final String INVENTORY_FILE;
    public static final String DELIMITER = "::";

    public VendingDaoImpl() {
        INVENTORY_FILE = "inventory.txt";
    }

    @Override
    public BigDecimal addCoin(String coinType, int amount) {
        this.coinType = this.coinType.valueOf(coinType);
        int value = 0;
        switch(this.coinType) {
            case PENNY:
                total = total.add(new BigDecimal(1*amount));
                break;
            case NICKEL:
                total = total.add(new BigDecimal(5 * amount));
                break;
            case DIME:
                total = total.add(new BigDecimal(10 * amount));
                break;
            case QUARTER:
                total = total.add(new BigDecimal(25 * amount));
                break;
        }
        return total;
    }

    @Override
    public BigDecimal getTotal() {
        BigDecimal convertToMoney = new BigDecimal(100);
        BigDecimal convertedTotal = total;
        convertedTotal = convertedTotal.divide(convertToMoney);
        convertedTotal = convertedTotal.setScale(2, RoundingMode.DOWN);
        return convertedTotal;
    }

    @Override
    public List<Item> getItemList() throws VendingException {
        loadInventory();
        return new ArrayList(itemList.values());
    }

    @Override
    public Item vendItem(Item item) throws VendingException {
        loadInventory();
        if (itemList.isEmpty()) {
            throw new VendingException("VENDING MACHINE EMPTY");
        }

        Item removedItem = itemList.remove(item.getItem()); 
        BigDecimal temp = new BigDecimal(removedItem.getPrice());

        if (temp.compareTo(getTotal()) > 0) {
            itemList.put(item.getItem(), removedItem); 

        }
        else {
            int amount = (removedItem.getAmount()) -1;
            removedItem.setAmount((amount));
            itemList.put(item.getItem(), removedItem);
            writeInventory();
        }
        return removedItem;
    }
    @Override
    public List<BigDecimal> getChange(Item item)  {
        BigDecimal itemPrice = new BigDecimal(item.getPrice());
        BigDecimal convert = new BigDecimal(100);
        itemPrice = itemPrice.multiply(convert);
        total = total.subtract(itemPrice);

        BigDecimal q = new BigDecimal(".25");
        BigDecimal d = new BigDecimal(".1");
        BigDecimal n = new BigDecimal(".05");
        BigDecimal p = new BigDecimal(".01");
        BigDecimal temp = getTotal();

        List<BigDecimal> totalList = new ArrayList<>();

        BigDecimal qChange = temp.divide(q);
        qChange = qChange.setScale(0, RoundingMode.DOWN);
        totalList.add(qChange);
        temp = temp.remainder(q);

        BigDecimal dChange = temp.divide(d);
        dChange = dChange.setScale(0, RoundingMode.DOWN);
        totalList.add(dChange);
        temp = temp.remainder(d);

        BigDecimal nChange = temp.divide(n);
        nChange = nChange.setScale(0, RoundingMode.DOWN);
        totalList.add(nChange);
        temp = temp.remainder(n);

        BigDecimal pChange = temp.divide(p);
        totalList.add(pChange);

        totalList.add(getTotal());
        return totalList;
    }

    private Item unmarshallItem(String itemAsText){
        String[] itemTokens = itemAsText.split(DELIMITER);
        String itemTitle = itemTokens[0];
        Item itemFromFile = new Item(itemTitle);
        itemFromFile.setPrice(Double.parseDouble(itemTokens[1]));
        itemFromFile.setAmount(Integer.parseInt(itemTokens[2]));
        return itemFromFile;
    }

    private String marshallItem(Item aItem){
        String itemAsText = aItem.getItem() + DELIMITER;
        itemAsText += aItem.getPrice()+ DELIMITER;
        itemAsText += aItem.getAmount();
        return itemAsText;
    }

    private void loadInventory() throws VendingException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingException("Could not load inventory data into memory.", e);
        }

        String currentLine;

        Item currentItem;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentItem = unmarshallItem(currentLine);

            itemList.put(currentItem.getItem(), currentItem);
        }

        scanner.close();
    }

    private void writeInventory() throws VendingException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingException("Could not save inventory data.", e);
        }

        String itemAsText;
        List<Item> itemList = this.getItemList();
        for (Item currentItem : itemList) {

            itemAsText = marshallItem(currentItem);

            out.println(itemAsText);

            out.flush();
        }

        out.close();
    }
}
