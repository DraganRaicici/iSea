package com.wwf.isea;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dragos on 9/22/14.
 */
public class Service {
    private static Service ourInstance = new Service();
    private ArrayList<SeaCreature> seaCreatures;
    private List<SeaCreature> seaCreaturesForUser;
    public  static final String SEACREATURE="seacreature";
    public  static final String POSITION="position";
    public  static final String LATITUDE="longitude";
    public  static final String LONGITUDE="latitude";

    public static Service getInstance() {
        return ourInstance;
    }

    private Service() {
    }


    public void createSomeObjects(){

        seaCreatures=new ArrayList<SeaCreature>();

        int image=R.drawable.nemo;
        String loremipsum="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam condimentum sodales nisl, sit amet scelerisque arcu dignissim sed. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vestibulum euismod cursus dui, ut tristique arcu lobortis vel. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam erat volutpat. Donec posuere lectus nulla. Cras finibus metus quis orci tempus, lacinia gravida ligula congue. Sed vitae nisl nunc. Quisque suscipit convallis dolor, sit amet tristique massa maximus a. Vestibulum tristique, lectus vitae lacinia euismod, turpis massa faucibus est, sed placerat nisl sapien id augue. Nullam cursus sem a arcu dignissim, eget semper enim posuere. Integer ac faucibus eros. Mauris sed volutpat augue, sed molestie dui. Nam vel sollicitudin arcu.";
        SeaCreature seaCreature=null;
        for (int i = 0; i < 20; i++) {

            seaCreature = new SeaCreature(i,"Fish"+i,"it is a nice fish"+i+loremipsum,image,"fish/round",i*10,i*2);
            seaCreatures.add(seaCreature);
        }
        for (int i = 20; i < 40; i++) {

            seaCreature = new SeaCreature(i,"Plant"+i,"My pant is green"+i,image,"plant/tall",i*2,i*10);
            seaCreatures.add(seaCreature);
        }


    }

    public ArrayList<SeaCreature> getSeaCreatures() {
        return seaCreatures;
    }
    public List<SeaCreature> getSeaCreaturesForSpecificUser(){


        seaCreaturesForUser=new ArrayList<SeaCreature>();


        int image1=R.drawable.blue_spotted;
        int image2=R.drawable.centropyge_loricula;
        int image3=R.drawable.chaetodon_falcula;
        int image4=R.drawable.nemo;
        String blueSpoted= "Deep black to tan fish with blue spots throughout";
        String centropyge="Vivid orange-red with vertical black stripes and blue patches toward the end of the dorsal and anal fins.";
        String chaetodon="Often confused with C. ulietensis, but easily distinguished. The saddles are wedge shaped rather than stripes and do not reach the underside. Overall more yellow coloring. ";
        String nemo="THE CUTTEST FISH EVER ";
        SeaCreature seaCreature1 = new SeaCreature(1,"Cephalopholis argus",blueSpoted,image1,"Blue dot grouper",10,10);
        SeaCreature seaCreature2 = new SeaCreature(2,"Angelfish",centropyge,image2,"Centropyge loricula",10,11);
        SeaCreature seaCreature3 = new SeaCreature(3,"Butterflyfish",chaetodon,image3,"Chaetodon falcula",10,12);
        SeaCreature seaCreature4 = new SeaCreature(4,"NEMO",nemo,image4,"PIXAR",10,13);



        seaCreaturesForUser.add(seaCreature1);
        seaCreaturesForUser.add(seaCreature2);
        seaCreaturesForUser.add(seaCreature3);
        seaCreaturesForUser.add(seaCreature4);





        return seaCreaturesForUser;

    }
}
