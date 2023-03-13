package code.bussinesslayer;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem{

    List<BaseProduct> productList = new ArrayList<>();

    public CompositeProduct(String title, List<BaseProduct> baseProducts){

        this.setTitle(title);
        int calories = 0, proteins = 0, fats = 0, sodium = 0;
        double rating = 0;

        for(BaseProduct prod : baseProducts){
            this.productList.add(prod);
            calories += prod.getCalories();
            proteins += prod.getProteins();
            fats += prod.getFats();
            sodium += prod.getSodium();
            rating += prod.getRating();
        }
        this.setPrice(this.computePrice());
        this.setRating(rating / baseProducts.size());
        this.setFats(fats);
        this.setCalories(calories);
        this.setProteins(proteins);
        this.setSodium(sodium);

    }

    public int computePrice(){
        int sum = 0;
        for(BaseProduct p : productList){
            sum += p.computePrice();
        }
        return sum;
    }


}
