package manager;

import post.Post;
import store.Store;
import store.ProductCatalog;

/**
*
* @author leirelitwin
*/

public class Manager {

 public static void main(String[] args) {
        ProductCatalog pCatalog = new ProductCatalog();

        Store startThisStore = new Store("1st Store", "Invented address", pCatalog);
        Post startPost = new Post(startThisStore, pCatalog);

         startPost.start();
 }
 }
