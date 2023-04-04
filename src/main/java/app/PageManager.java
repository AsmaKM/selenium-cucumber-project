package app;

import lombok.Getter;
import pages.*;

public class PageManager {

    private final AppSession appSession;
    private BasePage basePage;
    private Home home;
    private Installation installation;
    private Login login;
    private Product product;
    private Cart cart;
    private Checkout checkout;
    private Contact contact;
    private Ad ad;
    public PageManager(AppSession appSession){
        this.appSession = appSession;
    }

//     Using lazy initialization
    public BasePage getBasePage() {
        return (basePage == null) ? basePage = new BasePage(appSession) : basePage;
    }
    public Home getHome() {
        return (home == null) ? home = new Home(appSession) : home;
    }

    public Installation getInstallation() {
        return (installation == null) ? installation = new Installation(appSession) : installation;
    }

    public Login getLogin() {
        return (login == null) ? login = new Login(appSession) : login;
    }

    public Product getProduct(){
        return (product == null) ? product = new Product(appSession) : product;

    }
    public Cart getCart(){
        return (cart == null) ? cart = new Cart(appSession) : cart;

    }

    public Checkout getCheckout(){
        return (checkout == null) ? checkout = new Checkout(appSession) : checkout;

    }


    public Contact getContact(){
        return (contact == null) ? contact = new Contact(appSession) : contact;

    public Ad getAd(){
        return (ad == null) ? ad = new Ad(appSession) : ad;


    }
}

