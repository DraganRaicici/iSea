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

            seaCreature = new SeaCreature(i,"Fish"+i,"it is a nice fish"+i+loremipsum,image,"fish/round");
            seaCreatures.add(seaCreature);
        }
        for (int i = 20; i < 40; i++) {

            seaCreature = new SeaCreature(i,"Plant"+i,"My pant is green"+i,image,"plant/tall");
            seaCreatures.add(seaCreature);
        }


    }

    public ArrayList<SeaCreature> getSeaCreatures() {
        return seaCreatures;
    }
    public List<SeaCreature> getSeaCreaturesForSpecificUser(){


        seaCreaturesForUser=new ArrayList<SeaCreature>();


        int image=R.drawable.nemo;
        String loreIp= "Lorem ipsum dolor sit amet";
        SeaCreature seaCreature = null;

        for(int i =0;i< 5; i++){
            seaCreature=new SeaCreature(i,"FISH","That is a cute fish",image,"Fish/round");
            seaCreaturesForUser.add(seaCreature);
        }



        return seaCreaturesForUser;

    }
}
