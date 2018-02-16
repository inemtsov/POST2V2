/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniellenunez
 */
public class PanelMediator 
{
    private CheckPanel checkPanel;
    private ProductPanel productPanel;
    private CustomerNamePanel customerNamePanel;
    
    private ProductCatalog productCatalog;
    private Sale sale;
    
    PostFrame framePayment;

    public PanelMediator(ProductCatalog productCatalog)
    {
        this.productCatalog = productCatalog; 
        framePayment =  new PostFrame();
        framePayment.setVisible(true);
    }
    
    public void setProductCatalog(ProductCatalog productCatalog)
    {
        this.productCatalog = productCatalog;
    }
    
    public void setSale(Sale sale)
    {
        this.sale = sale;
    }
    
    public Item getItem(String upc)
    {
        return this.productCatalog.getItem(upc);
    }
    
    public String calculateSubtotalForItem(Item item)
    {
        sale.calculateSubtotalforItem(item);
    }
    
    public void setName(String name)
    {
        
    }
}
