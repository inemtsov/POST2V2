package post;

import gui.PanelMediator;
import store.Store;
import store.ProductCatalog;

/**
*
* @author leirelitwin
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
