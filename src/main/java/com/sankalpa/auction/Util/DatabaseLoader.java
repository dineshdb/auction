package com.sankalpa.auction.Util;

import com.sankalpa.auction.model.*;
import com.sankalpa.auction.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        State live = stateRepository.save(new State("LIVE"));
        State ready = stateRepository.save(new State("READY"));
        State sold = stateRepository.save(new State("SOLD"));

        Category movieProp = categoryRepository.save(new Category("Movie Prop"));
        Category painting = categoryRepository.save(new Category("Painting"));
        Category antique = categoryRepository.save(new Category("Antique"));
        Category gadget = categoryRepository.save(new Category("Gadget"));
        Category automobile = categoryRepository.save(new Category("Automobile"));
        Category jewellery = categoryRepository.save(new Category("Jewellery"));

        List<User> userList = new ArrayList<>();
        userList.add(userRepository.save(new User("hkeemar0@tinyurl.com", "KpAXyOL", "nkeemar0", "4711065522", "Keemar")));
        userList.add(userRepository.save(new User("wwagen1@furl.net", "OoXS0dPd", "swagen1", "2721167273", "Wagen")));
        userList.add(userRepository.save(new User("mmcwhan2@dyndns.org", "81RwRy7", "cmcwhan2", "7775342958", "McWhan")));
        userList.add(userRepository.save(new User("gminard3@last.fm", "ScxWpVfnSFEo", "sminard3", "6841452381", "Minard")));
        userList.add(userRepository.save(new User("dhollow4@nytimes.com", "jlom6YezIbq", "nhollow4", "7143045279", "Hollow")));
        userList.add(userRepository.save(new User("smungan5@taobao.com", "S1tb5sxNKbEt", "bmungan5", "8324159096", "Mungan")));
        userList.add(userRepository.save(new User("ldeeman6@army.mil", "Z4BceXvQlZt", "wdeeman6", "5524908551", "Deeman")));
        userList.add(userRepository.save(new User("cheningam7@psu.edu", "WsnjVAh", "bheningam7", "8724024848", "Heningam")));
        userList.add(userRepository.save(new User("cstrangward8@flavors.me", "95qARnWHwdld", "lstrangward8", "3291525092", "Strangward")));
        userList.add(userRepository.save(new User("fgrisdale9@cmu.edu", "k48IrpJ", "mgrisdale9", "3664714558", "Strangward")));
        userList.add(userRepository.save(new User("byurenina@zdnet.com", "jcykDASLJAJU", "tyurenina", "6263903601", "Yurenin")));
        userList.add(userRepository.save(new User("cwaitlandb@drupal.org", "n0LobebM", "rwaitlandb", "2121562452", "Waitland")));
        userList.add(userRepository.save(new User("gbrastedc@wired.com", "Zx9LqPs", "tbrastedc", "2119552264", "Brasted")));
        userList.add(userRepository.save(new User("rackwoodd@salon.com", "PzE9elpSo", "backwoodd", "9447277255", "Ackwood")));
        userList.add(userRepository.save(new User("bguwere@jimdo.com", "C3TfsN95Y3Zk", "aguwere", "7512439388", "Guwer")));
        userList.add(userRepository.save(new User("dpepperellf@rediff.com", "0MHUKtTaO09e", "epepperellf", "4438770804", "Pepperell")));
        userList.add(userRepository.save(new User("ktophamg@gnu.org", "kxNwdL1", "atophamg", "4133078522", "Topham")));
        userList.add(userRepository.save(new User("ikinsleyh@macromedia.com", "Z6FdekCcoHN", "kkinsleyh", "2437879462", "Kinsley")));
        userList.add(userRepository.save(new User("acouragei@cargocollective.com", "7yyjppZ", "acouragei", "5819207964", "Courage")));
        userList.add(userRepository.save(new User("draeburnj@icq.com", "wRpKBh4", "draeburnj", "1722032519", "Raeburn")));
        userList.add(userRepository.save(new User("rheggk@ustream.tv", "DjrShRH", "sheggk", "6131985214", "Hegg")));
        userList.add(userRepository.save(new User("rskittreall@quantcast.com", "WXrjQXKNCZL", "sskittreall", "7094859986", "Skittreal")));
        userList.add(userRepository.save(new User("fleylandm@cmu.edu", "JXotky7LNNCZ", "aleylandm", "5274051353", "Leyland")));
        userList.add(userRepository.save(new User("lskatchern@pcworld.com", "7JSgpr6XF", "askatchern", "5683393296", "Skatcher")));
        userList.add(userRepository.save(new User("glockep@webnode.com", "V5SDuTFGwPE", "elockep", "1187773736", "Locke")));
        userList.add(userRepository.save(new User("mmorrallo@reddit.com", "NzmTR31AS", "fmorrallo", "9839717424", "Morrall")));
        userList.add(userRepository.save(new User("dtennockq@indiegogo.com", "tFUZDvBHok", "ttennockq", "1748716681", "Tennock")));
        userList.add(userRepository.save(new User("atosh502@gmail.com", "passw0rd", "atosh502", "9843599926", "Ktm")));
        userList.add(userRepository.save(new User("admin@ioe.com", "admin", "admin123", "6299953489", "Pulchowk")));
        userList.add(userRepository.save(new User("foo@bar.com", "bar", "foobar", "1234567891", "Lalitpur")));
        userList.add(userRepository.save(new User("snow@den.com", "den", "snowden", "2345619209", "Russia")));
        User seller = userRepository.save(new User("seller@gmail.com", "passw0rd", "seller", "123765490", "Pokhara"));

        List<Item> itemList = new ArrayList<>();
        List<Auction> auctionList = new ArrayList<>();
        auctionList.add(auctionRepository.save(new Auction("Auction 1", "00:01:00", "2018-06-23", "First Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 2", "01:01:00", "2018-06-23", "Second Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 3", "02:01:00", "2018-06-23", "Third Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 4", "03:01:00", "2018-06-23", "Fourth Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 5", "04:01:00", "2018-06-23", "Fifth Auction", "300")));

        auctionList.add(auctionRepository.save(new Auction("Auction 5", "05:01:00", "2018-06-23", "Sixth Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 7", "06:01:00", "2018-06-23", "Seventh Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 8", "07:01:00", "2018-06-23", "Eight Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 9", "08:01:00", "2018-06-23", "Ninth Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 10", "09:01:00", "2018-06-23", "Tenth Auction", "300")));

        auctionList.add(auctionRepository.save(new Auction("Auction 11", "10:01:00", "2018-06-23", "Eleventh Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 12", "11:01:00", "2018-06-23", "Twelvth Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 13", "12:01:00", "2018-06-23", "Thirteenth Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 14", "13:01:00", "2018-06-23", "Fourteenth Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 15", "14:01:00", "2018-06-23", "Fifteenth Auction", "300")));

        auctionList.add(auctionRepository.save(new Auction("Auction 16", "15:01:00", "2018-06-23", "Sixteenth Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 17", "16:01:00", "2018-06-23", "Seventeeth Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 18", "17:01:00", "2018-06-23", "Eighteenth Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 19", "18:01:00", "2018-06-23", "Nineteenth Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 20", "19:01:00", "2018-06-23", "Twentith Auction", "300")));

        auctionList.add(auctionRepository.save(new Auction("Auction 21", "20:01:00", "2018-06-23", "21st Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 22", "21:01:00", "2018-06-23", "22nd Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 23", "22:01:00", "2018-06-23", "23rd Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 24", "23:01:00", "2018-06-23", "24th Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 25", "00:20:00", "2018-06-23", "25th Auction", "300")));

        auctionList.add(auctionRepository.save(new Auction("Auction 26", "00:10:00", "2018-06-24", "26th Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 27", "01:10:00", "2018-06-24", "27th Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 28", "02:10:00", "2018-06-24", "28th Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 29", "03:10:00", "2018-06-24", "29th Auction", "300")));
        auctionList.add(auctionRepository.save(new Auction("Auction 30", "04:10:00", "2018-06-24", "30th Auction", "300")));

        String PREFIX = "http://localhost:8080/downloadFile/";

        Item item1 = itemRepository.save(new Item("Shield", "Shield of Captain America", 100, PREFIX+"movie1.jpg"));
        itemList.add(item1);
        Item item2 = itemRepository.save(new Item("Helmet", "Helmet of Mageneto", 100, PREFIX+"movie2.jpg"));
        itemList.add(item2);
        Item item3 = itemRepository.save(new Item("Totem", "Totem of DeCaprio", 100, PREFIX+"movie3.jpg"));
        itemList.add(item3);
        Item item4 = itemRepository.save(new Item("Dragon fly", "Dragon fly from Oblivion", 100, PREFIX+"movie4.jpg"));
        itemList.add(item4);
        Item item5 = itemRepository.save(new Item("Infinity gauntlet", "Inf. Gauntlet : Thanos", 100, PREFIX+"movie5.jpg"));
        itemList.add(item5);

        item1.addItemCategory(movieProp);
        item2.addItemCategory(movieProp);
        item3.addItemCategory(movieProp);
        item4.addItemCategory(movieProp);
        item5.addItemCategory(movieProp);
        movieProp.setItem(item1);
        movieProp.setItem(item2);
        movieProp.setItem(item3);
        movieProp.setItem(item4);
        movieProp.setItem(item5);
        categoryRepository.save(movieProp);

        Item item6 = itemRepository.save(new Item("Girl", "Painting of a girl", 100, PREFIX+"painting1.jpg"));
        itemList.add(item6);
        Item item7 = itemRepository.save(new Item("Tree", "Two trees", 100, PREFIX+"painting2.jpg"));
        itemList.add(item7);
        Item item8 = itemRepository.save(new Item("Lake", "Lake Painting", 100, PREFIX+"painting3.jpg"));
        itemList.add(item8);
        Item item9 = itemRepository.save(new Item("Weird", "Weird Painting", 100, PREFIX+"painting4.jpg"));
        itemList.add(item9);
        Item item10 = itemRepository.save(new Item("Woods", "Walking into the woods", 100, PREFIX+"painting5.jpg"));
        itemList.add(item10);

        item6.addItemCategory(painting);
        item7.addItemCategory(painting);
        item8.addItemCategory(painting);
        item9.addItemCategory(painting);
        item10.addItemCategory(painting);

        painting.setItem(item6);
        painting.setItem(item7);
        painting.setItem(item8);
        painting.setItem(item9);
        painting.setItem(item10);
        categoryRepository.save(painting);

        Item item11 = itemRepository.save(new Item("Freezer", "Old School Freezer Pepsi-Cola", 100, PREFIX+"antique1.jpg"));
        itemList.add(item11);
        Item item12 = itemRepository.save(new Item("Radio", "Antique Radio", 100, PREFIX+"antique2.jpg"));
        itemList.add(item12);
        Item item13 = itemRepository.save(new Item("Kettle", "Beautiful Kettle", 100, PREFIX+"antique3.JPG"));
        itemList.add(item13);
        Item item14 = itemRepository.save(new Item("Watch", "Gold watch", 100, PREFIX+"antique4.jpg"));
        itemList.add(item14);
        Item item15 = itemRepository.save(new Item("Telephone", "Telephone", 100, PREFIX+"antique5.jpg"));
        itemList.add(item15);

        item11.addItemCategory(antique);
        item12.addItemCategory(antique);
        item13.addItemCategory(antique);
        item14.addItemCategory(antique);
        item15.addItemCategory(antique);
        antique.setItem(item11);
        antique.setItem(item12);
        antique.setItem(item13);
        antique.setItem(item14);
        antique.setItem(item15);
        categoryRepository.save(antique);

        Item item16 = itemRepository.save(new Item("Deadpool Gear", "Fighting Gear of Deadpool", 100, PREFIX+"gadget1.jpg"));
        itemList.add(item16);
        Item item17 = itemRepository.save(new Item("DMC", "DeLorean Car", 100, PREFIX+"gadget2.jpg"));
        itemList.add(item17);
        Item item18 = itemRepository.save(new Item("Sword", "Lightsaber from Star Wars", 100, PREFIX+"gadget3.jpg"));
        itemList.add(item18);
        Item item19 = itemRepository.save(new Item("Gamepad", "Smartphone enables gamepad", 100, PREFIX+"gadget4.jpg"));
        itemList.add(item19);
        Item item20 = itemRepository.save(new Item("Drone", "Mini Drone", 100, PREFIX+"gadget5.jpg"));
        itemList.add(item20);

        item16.addItemCategory(gadget);
        item17.addItemCategory(gadget);
        item18.addItemCategory(gadget);
        item19.addItemCategory(gadget);
        item20.addItemCategory(gadget);
        gadget.setItem(item16);
        gadget.setItem(item17);
        gadget.setItem(item18);
        gadget.setItem(item19);
        gadget.setItem(item20);
        categoryRepository.save(gadget);

        Item item21 = itemRepository.save(new Item("Prototype", "Next Generation car's prototype", 100, PREFIX+"automobile1.jpg"));
        itemList.add(item21);
        Item item22 = itemRepository.save(new Item("Green Car", "Environment friendly car", 100, PREFIX+"automobile2.jpg"));
        itemList.add(item22);
        Item item23 = itemRepository.save(new Item("Antique Car", "Early Car model", 100, PREFIX+"automobile3.jpg"));
        itemList.add(item23);
        Item item24 = itemRepository.save(new Item("Three wheel car", "Car from Mr.Bean's Series", 100, PREFIX+"automobile4.jpg"));
        itemList.add(item24);
        Item item25 = itemRepository.save(new Item("Mini", "Mr. Bean's car", 100, PREFIX+"automobile5.jpeg"));
        itemList.add(item25);

        item21.addItemCategory(automobile);
        item22.addItemCategory(automobile);
        item23.addItemCategory(automobile);
        item24.addItemCategory(automobile);
        item25.addItemCategory(automobile);
        automobile.setItem(item21);
        automobile.setItem(item22);
        automobile.setItem(item23);
        automobile.setItem(item24);
        automobile.setItem(item25);
        categoryRepository.save(automobile);

        Item item26 = itemRepository.save(new Item("Bracelets", "Gold Jewellery", 100, PREFIX+"jewellery1.jpg"));
        itemList.add(item26);
        Item item27 = itemRepository.save(new Item("Ring", "Diamond ring", 100, PREFIX+"jewellery2.jpg"));
        itemList.add(item27);
        Item item28 = itemRepository.save(new Item("Earrings", "Platinum earrings", 100, PREFIX+"jewellery3.jpeg"));
        itemList.add(item28);
        Item item29 = itemRepository.save(new Item("King's crown", "Crown of Nepalese kings", 100, PREFIX+"jewellery4.jpg"));
        itemList.add(item29);
        Item item30 = itemRepository.save(new Item("Bangles", "Gold Jewellery", 100, PREFIX+"jewellery5.jpg"));
        itemList.add(item30);

        item26.addItemCategory(jewellery);
        item27.addItemCategory(jewellery);
        item28.addItemCategory(jewellery);
        item29.addItemCategory(jewellery);
        item20.addItemCategory(jewellery);
        jewellery.setItem(item26);
        jewellery.setItem(item27);
        jewellery.setItem(item27);
        jewellery.setItem(item29);
        jewellery.setItem(item30);
        categoryRepository.save(jewellery);

        for (int i = 0; i < auctionList.size(); i++){
            Auction auction = auctionList.get(i);
            Item item = itemList.get(i);

            auction.addItem(item);
            item.setAuction(auction);

            auction.setSeller(seller);
            item.setSeller(seller);

            auctionRepository.save(auction);
            itemRepository.save(item);
        }

        Random rand = new Random();

        for (User user : userList){
            for (Item item : itemList){
                int rating = rand.nextInt(5) + 1;
                ratingRepository.save(new Rating(user.getUserId(), item.getItemId(), rating));
            }
        }
    }
}
