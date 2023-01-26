public class ShoppingCart {
    Product[] productList;

    public ShoppingCart(Product[] productList) {
        this.productList = productList;
    }

    public Product[] getProductList() {
        return productList;
    }

    public void setProductList(Product[] productList) {
        this.productList = productList;
    }


    public int computeTotalPrice() throws InvalidPriceException {
        int totalPrice = 0;
        //algoritmul
        for (int i = 0; i < productList.length; i++) {
            if (productList[i].getPrice() <= 0) {
                throw new InvalidPriceException("price is negative");
            }
            totalPrice += productList[i].getPrice();
        }
        return totalPrice;
    }


}
