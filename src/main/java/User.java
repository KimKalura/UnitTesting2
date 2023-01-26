public class User {
    private String userName;
    private String password;
    private ShoppingCart shoppingCart;

    public User(String userName, String password, ShoppingCart shoppingCart) {
        this.userName = userName;
        this.password = password;
        this.shoppingCart = shoppingCart;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }


    public boolean hasStrongPassword() {
        return password.length() >= 10;
    }

    public boolean hasValidUserName() {
        //return !"".equals(userName);
        return !userName.isBlank();
    }

    public boolean isValid() {
        return hasStrongPassword() && hasValidUserName();
    }

    public String generateInvoice() throws InvalidPriceException{
        return userName + " has paid " + shoppingCart.computeTotalPrice();
    }


}
