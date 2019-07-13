package edu.mum.wap.dao;

import edu.mum.wap.model.Image;
import edu.mum.wap.model.Product;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MockData {

    public static final Map<Integer, Product> productDB = new HashMap<>();

    static {
        Product p1 = new Product();
        p1.setProductName("Samsung Galaxy S6");
        p1.setBrand("Samsung");
        p1.setBriefInformation("Samsung Galaxy S6 is a line of Android-based smartphones manufactured, released and marketed by Samsung Electronics.");
        p1.setDetailInformation("Samsung Galaxy S6 is a line of Android-based smartphones manufactured, released and marketed by Samsung Electronics. Succeeding the Samsung Galaxy S5, the S6 was not released as a singular model, but instead in two variations unveiled and marketed together—the Galaxy S6 and Galaxy S6 Edge—with the latter differentiated primarily by having a display that is wrapped along the sides of the device. The S6 and S6 Edge were unveiled on March 1, 2015, during the Samsung Unpacked press event at MWC Barcelona, and released April 10, 2015. During the subsequent Samsung Unpacked event on August 13, 2015 (alongside the Galaxy Note 5), Samsung unveiled a third model, the Galaxy S6 Edge+, which features a larger phablet-sized display.");
        p1.setPrice(1240.0);
        p1.setProductId(1001);
        p1.setImages(Arrays.asList(new Image("S61.jpg"), new Image("S61.png") ));

        Product p2 = new Product();
        p2.setProductName("iPhone X ");
        p2.setBrand("Apple");
        p2.setBriefInformation("iPhone X (Roman numeral X pronounced ten [9][10] is a smartphone designed, developed, and marketed by Apple Inc. ");
        p2.setDetailInformation("The iPhone X is intended to showcase what Apple considers technology of the future, specifically adopting OLED screen technology for the first time in iPhone history, as well as using a glass and stainless-steel form factor, offering wireless charging, and removing the home button in favor of introducing a new \"bezel-less\" design, shrinking the bezels, and not having a \"chin\", unlike many Android phones.");
        p2.setPrice(1590.0);
        p2.setProductId(1002);
        p2.setImages(Arrays.asList(new Image("iphonex.png"), new Image("iphonex.png") ));

        Product p3 = new Product();
        p3.setProductName("Samsung Galaxy S10");
        p3.setBrand("Samsung");
        p3.setBriefInformation("Samsung Galaxy S10 is a line of Android smartphones manufactured by Samsung Electronics. The Galaxy S10 series ");
        p3.setDetailInformation("Unveiled during the \"Samsung Galaxy Unpacked 2019\" press event held on February 20, 2019, the devices started shipping in certain regions such as Australia and the United States on March 6, 2019, then worldwide on March 8, 2019.[5] It is the tenth generation of Samsung's Galaxy S series of phones.");
        p3.setPrice(1850.0);
        p3.setProductId(1003);
        p3.setImages(Arrays.asList(new Image("S10.jpg"), new Image("S10.png") ));

        Product p4 = new Product();
        p4.setProductName("LG G series");
        p4.setBrand("LG");
        p4.setBriefInformation("The LG G series is a line of high-end Android devices produced by LG Electronics. The G designation was first introduced in 2012.");
        p4.setDetailInformation("The \"G\" designation was first introduced in 2012 as a branch of the LG Optimus series for flagship devices, but LG announced in July 2013 that the \"Optimus\" name would be discontinued for future flagships in favor of maintaining \"G\" and \"Vu\" as distinct brands.[1] The first purely G-branded phone, the LG G2, was unveiled in August 2013.");
        p4.setPrice(770.0);
        p4.setProductId(1004);
        p4.setImages(Arrays.asList(new Image("lg5.jpg"), new Image("lg5.jpg") ));

        productDB.put(1001, p1);
        productDB.put(1002, p2);
        productDB.put(1003, p3);
        productDB.put(1004, p4);


    }
}
