package code.bussinesslayer;

public class BaseProduct extends MenuItem{

    public BaseProduct(String title,double rating,int calories,int proteins,int fats,int sodium,int price){
        super.setTitle(title);
        super.setRating(rating);
        super.setCalories(calories);
        super.setSodium(sodium);
        super.setProteins(proteins);
        super.setPrice(price);
        super.setFats(fats);
    }

    public BaseProduct(String baseProduct){
        baseProduct = baseProduct.substring(1,baseProduct.length()-1);
        String[] res = baseProduct.split(",", 0);
        this.setTitle(res[0].stripTrailing().stripLeading());
        this.setRating(Float.parseFloat(res[1].stripTrailing().stripLeading()));
        this.setCalories(Integer.parseInt(res[2].stripTrailing().stripLeading()));
        this.setProteins(Integer.parseInt(res[3].stripTrailing().stripLeading()));
        this.setFats(Integer.parseInt(res[4].stripTrailing().stripLeading()));
        this.setSodium(Integer.parseInt(res[5].stripTrailing().stripLeading()));
        this.setPrice(Integer.parseInt(res[6].stripTrailing().stripLeading()));
    }

    @Override
    public int computePrice() {
        return this.getPrice();
    }

}
