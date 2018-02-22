package post;


import gui.PanelMediator;
import store.Store;
import store.ProductCatalog;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Post {

    ProductCatalog pCatalog;
    Store store;

    public Post(Store store, ProductCatalog pCatalog) {
        this.pCatalog = pCatalog;
        this.store = store;
    }

    public void start() {
        new PanelMediator(pCatalog);
    }
}
