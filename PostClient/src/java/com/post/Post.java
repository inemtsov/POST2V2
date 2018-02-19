package com.post;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Justin
 */

public class Post
{ 
    public static void main(String[] args) throws ParserConfigurationException, SAXException 
    {
        ProductCatalog p = new ProductCatalog();
        PanelMediator mediator = new PanelMediator(p);
    }
}
