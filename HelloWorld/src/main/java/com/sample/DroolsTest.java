package com.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
    	
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	 List<Product> productList = new ArrayList<Product>();

            // go !
            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
          
            
            kSession.insert(message);
            
            
            ProductSummary productSumary = new ProductSummary();
            
            Product product1 = new Product();
            product1.setName("Vim Dish liquid gel 500 ml");
            product1.setCost(75);
            product1.setStoreName("Amazon");
            
            
            Product product2 = new Product();
            product2.setName("Pears Soap 4");
            product2.setCost(199);
            product2.setStoreName("Amazon");
            
            
            
            Product product3 = new Product();
            product3.setName("Lizol 500 ml");
            product3.setCost(85);
            product3.setStoreName("Amazon");
            
            Product product4 = new Product();
            product4.setName("Lizol 500 ml");
            product4.setCost(84);
            product4.setStoreName("BigBasket");
            
            
            Product gorfersLizol = new Product();
            gorfersLizol.setName("Lizol 500 ml");
            gorfersLizol.setCost(80);
            gorfersLizol.setStoreName("Grofers");
            
           
            productList.add(product1);
            productList.add(product2);
            productList.add(product3);
            productList.add(product4);
            productList.add(gorfersLizol);
            
            productSumary.setProducts(productList);
           
            kSession.insert(productSumary);
            Map<String,Product> map = new HashMap<>();

            kSession.setGlobal("map", map);    
            
          //  new HashSet().add
			/*
			 * Message message2 = new Message(); message.setMessage("Hello Worldff");
			 * message.setStatus(Message.HELLO); kSession.insert(message2);
			 */
            kSession.startProcess("com.sample.process");
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

   

}
