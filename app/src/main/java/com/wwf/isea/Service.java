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
    private List<SeaCreature> seaFood;

    public static Service getInstance() {
        return ourInstance;
    }

    private Service() {
    }


    public void createSomeObjects(){

        seaCreatures=new ArrayList<SeaCreature>();

        //int image=R.drawable.nemo;
        int image1=R.drawable.blue_spotted;
        int image2=R.drawable.centropyge_loricula;
        int image3=R.drawable.chaetodon_falcula;
        int image4=R.drawable.luidia;
        int image5=R.drawable.cucumber;
        int image6=R.drawable.worm;
        int image7=R.drawable.jellyfish;
        int image8=R.drawable.seal;
        int image9=R.drawable.mollusc;
        int image10=R.drawable.ballan;


        String jellyfish="This jellyfish has a flattened dome, and a widespread array of finely branched mouth tentacles. The arms cover about three quarters of the dome. In between, leaf-like appendages can extend from the tentacles. Color is greenish brown. No tentacles around the edge of the dome." +
                "Size: dome diameter up to 20 cm.";
        String cucumber="Body short and barrel-shaped, slightly curved and tapering posteriorly; up to 100 mm in length and 20 mm thick; coloured whitish-grey or pale red.";
        String luidia="Body with a small disc and five gently tapering arms of medium length; R/r: 6 to 10; up to 340 mm in diameter, but usually smaller. Coloured reddish brown, with darker transverse bands along the sides of the arms.";
        String blueSpoted= "Deep black to tan fish with blue spots throughout";
        String centropyge="Vivid orange-red with vertical black stripes and blue patches toward the end of the dorsal and anal fins.";
        String chaetodon="Often confused with C. ulietensis, but easily distinguished. The saddles are wedge shaped rather than stripes and do not reach the underside. Overall more yellow coloring. ";
        String worm="Animal with an elongate, ribbon-like body bearing an adhesive depression at the posterior end. It reaches a length of 20-70 mm and a width of 5-7 mm.";
        String seal="Leopard seals have a sinuous body and massive head and jaws. Because of the shape of the head, they appear almost reptilian. Females grow slightly longer and heavier, but not enough to allow the sexes " +
                "to be distinguished in the field based on size. The long body is thin overall, thickest through the shoulders and upper chest. There is no trace of a forehead. The head is widest at the eyes, " +
                " which appear small and set both far apart and well back from the end of the muzzle. The nostrils are on top of the muzzle, just back from the wide rounded end. The lower jaw is massive, wide, and deep, as are the throat and neck. The vibrissae are clear to pale, generally quite short andinconspicuous. " +
                " Leopard seals have an enormous gape. The very long (almost one-third of the body length) foreflippers are broad and otariid-like. They are completely furred and each digit bears a short terminal claw. The first digit is long and massive, creating a thick strong leading edge.";
        String mollusc="The shell has a long conical spire, sharply pointed, and without any knobs. The coloring is variegated in shades ranging from white via cream and yellow to brown. The tentacles are yellow with black bands. The color of the living animal is mottled in shades of yellow to brown." +
                " Size: the shell can reach up to 30 cm.";
        String fish=" body rather massive. Head broad, its length less than or equal to body depth. Strong canine-like teeth (7-11/7-12). Lips with 7-9 folds. Dorsal finrays XVIII-XXI + 9-13; anal finrays III + 8-12. Scales along lateral line 41-47, on temporo-occipital surface 15-25, on inter-operculum 0-3; ";

        SeaCreature seaCreature=null;

        SeaCreature seaCreature1 = new SeaCreature(1,"Cephalopholis argus",blueSpoted,image1,"Blue dot grouper",57.04075,10.55516);
        SeaCreature seaCreature2 = new SeaCreature(2,"Angelfish",centropyge,image2,"Centropyge loricula",57.35026,9.41259);
        SeaCreature seaCreature3 = new SeaCreature(3,"Butterflyfish",chaetodon,image3,"Chaetodon falcula",56.31046,7.95140);
        SeaCreature seaCreature4 = new SeaCreature(4,"Luidia sarsi",luidia,image4,"Starfish",56.78887,10.44530);
        SeaCreature seaCreature5 = new SeaCreature(5,"Paracucumaria hyndmani",cucumber,image5,"Sea cucumbers",55.46642,8.20409);
        SeaCreature seaCreature6 = new SeaCreature(6,"Cestoplana rubrocincta",worm,image6,"Sea worms",55.75187,10.10472);
        SeaCreature seaCreature7 = new SeaCreature(7,"Cassiopea frondosa",jellyfish,image7,"Jellyfish",55.66521,9.86302);
        SeaCreature seaCreature8 = new SeaCreature(8,"Leopard Seal",seal,image8,"Seals",56.54739,10.81884);
        SeaCreature seaCreature9 = new SeaCreature(9,"Charonia variegata",mollusc,image9,"Molluscs",56.55345,10.48925);
        SeaCreature seaCreature10 = new SeaCreature(10,"Ballan wrasse ",fish,image10,"Fish",56.66832,10.39037);

        seaCreatures.add(seaCreature1);
        seaCreatures.add(seaCreature2);
        seaCreatures.add(seaCreature3);
        seaCreatures.add(seaCreature4);
        seaCreatures.add(seaCreature5);
        seaCreatures.add(seaCreature6);
        seaCreatures.add(seaCreature7);
        seaCreatures.add(seaCreature8);
        seaCreatures.add(seaCreature9);
        seaCreatures.add(seaCreature10);

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
    public List<SeaCreature> getSeaFood(){


        seaFood=new ArrayList<SeaCreature>();


        int image1=R.drawable.seafoodone;
        int image2=R.drawable.seafoodtwo;
        int image3=R.drawable.seafoodthree;
        int image4=R.drawable.seafoodfour;
        String tacos="To make beer batter: In a large bowl, combine flour, cornstarch, baking powder, and salt. Blend egg and beer, then quickly stir into the flour mixture (don't worry about a few lumps).";
        String marinated="In a large bowl, stir together the garlic, olive oil, tomato sauce, and red wine vinegar. Season with basil, salt, and cayenne pepper. Add shrimp to the bowl, and stir until evenly coated. Cover, and refrigerate for 30 minutes to 1 hour, stirring once or twice.";
        String rockin="Clean oysters, and place in a large stockpot. Pour in beer and enough water to cover oysters; add 2 cloves garlic, seasoned salt, and peppercorns. Bring to a boil. Remove from heat, drain, and cool.";
        String salmon="In a medium glass bowl, prepare marinade by mixing garlic, light olive oil, basil, salt, pepper, lemon juice and parsley. Place salmon fillets in a medium glass baking dish, and cover with the marinade. Marinate in the refrigerator about 1 hour, turning occasionally";
        SeaCreature seaCreature1 = new SeaCreature(1,"Fish Tacos",tacos,image1,"Tacos",10,10);
        SeaCreature seaCreature2 = new SeaCreature(2,"Marinated Grilled Shimp",marinated,image2,"Shrimp",10,11);
        SeaCreature seaCreature3 = new SeaCreature(3,"Rockin' Oysters",rockin,image3,"Oysters",10,12);
        SeaCreature seaCreature4 = new SeaCreature(4,"Baked Salmon II",salmon,image4,"Salmon",10,13);

        seaFood.add(seaCreature1);
        seaFood.add(seaCreature2);
        seaFood.add(seaCreature3);
        seaFood.add(seaCreature4);

        return seaFood;

    }
}
