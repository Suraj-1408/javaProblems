import java.util.List;
import java.util.ArrayList;

public class ProductOfNumbers{

    // public ArrayList<String> methods;
    // public ArrayList<ArrayList<Integer>> dataValues;

    public ArrayList<Integer> result;       //just to track the resultant for the input arrays

    // public ProductOfNumbers(ArrayList<String> methodsName, ArrayList<ArrayList<Integer>> dataValues){
    public ProductOfNumbers(){
        // productOfNumbers = new productOfNumbers();
        // this.methods = methodsName;
        // this.dataValues = dataValues;
        // this.result = null;
        this.result = new ArrayList<>();
    }

    public void add(int num){
        // ArrayList<Integer> val = new ArrayList<>();
        // val.add(num);
        result.add(num);
    }

    ArrayList<Integer> productsArray = new ArrayList<>();
    public int getProduct(int k){
        ArrayList<Integer> window = new ArrayList<>(result.subList(result.size()-k, result.size()));

        int product = 1;
        for(int i = 0 ; i < window.size();i++){
            product = product * window.get(i);
        }
        //productsArray.add(product);

        return product;
    }

    // Main method to test your code locally
    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        
        productOfNumbers.add(3);                          // [3]
        productOfNumbers.add(0);                          // [3, 0]
        productOfNumbers.add(2);                          // [3, 0, 2]
        productOfNumbers.add(5);                          // [3, 0, 2, 5]
        productOfNumbers.add(4);                          // [3, 0, 2, 5, 4]
        
        System.out.println(productOfNumbers.getProduct(2)); // Expected: 20
        System.out.println(productOfNumbers.getProduct(3)); // Expected: 40
        System.out.println(productOfNumbers.getProduct(4)); // Expected: 0
        
        productOfNumbers.add(8);                          // [3, 0, 2, 5, 4, 8]
        System.out.println(productOfNumbers.getProduct(2)); // Expected: 32
    }

}