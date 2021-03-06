import java.util.HashMap;
import java.util.TreeMap;

public class Menus {

    private TreeMap< Integer , String > menuMap;
    private HashMap< String , Integer > cookingTimeMap;
    private HashMap< String , Integer > priceMap;

    Menus(){

        menuMap = new TreeMap<Integer, String>();
        menuMap.put(1,"후라이드 치킨");
        menuMap.put(2,"양념 치킨");
        menuMap.put(3,"양파 치킨");
        menuMap.put(4,"짭조름 파닭 치킨");
        menuMap.put(5,"양념반 후라이드반");

        cookingTimeMap = new HashMap<String, Integer>();
        cookingTimeMap.put("후라이드 치킨",30);
        cookingTimeMap.put("양념 치킨",35);
        cookingTimeMap.put("양파 치킨",40);
        cookingTimeMap.put("짭조름 파닭 치킨",50);
        cookingTimeMap.put("양념반 후라이드반",40);

        priceMap = new HashMap<String, Integer>();
        priceMap.put("후라이드 치킨",15000);
        priceMap.put("양념 치킨",20000);
        priceMap.put("양파 치킨",20000);
        priceMap.put("짭조름 파닭 치킨",22000);
        priceMap.put("양념반 후라이드반",30000);
    }

    public TreeMap< Integer , String > getMenuMap(){
        return this.menuMap;
    }

    public HashMap< String , Integer > getCookingTimeMap(){
        return this.cookingTimeMap;
    }

    public HashMap< String , Integer > getPriceMap(){
        return this.priceMap;
    }

    public int getCountOfMenu() {
        return 5;
    }

}
