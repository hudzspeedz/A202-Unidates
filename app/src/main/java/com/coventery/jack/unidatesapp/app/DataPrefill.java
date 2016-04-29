package com.coventery.jack.unidatesapp.app;

import android.util.Log;
import com.coventery.jack.unidatesapp.app.DatabaseHandler;
import com.coventery.jack.unidatesapp.app.Users;
import com.coventery.jack.unidatesapp.LoginActivity;

/**
 * Created by user on 08/04/2016.
 */
public class DataPrefill {
    public void Dataprefill(DatabaseHandler db){

        Log.d("Insert", "Inserting ...");
        db.addUser(new Users("user1", "pass1", "selena", "gomez", "23", "coventry",
                "http://familyhealthc.com/wp-content/uploads/2016/01/selena-gomez-hot-1.jpg",
                "http://images6.fanpop.com/image/photos/34000000/selena-gomez-2013-selena-gomez-34087559-1500-1545.jpg",
                "http://celebmafia.com/wp-content/uploads/2013/10/selena-gomez-in-a-bikini-miami-october-2013_8.jpg"));
        db.addUser(new Users("user2", "pass2", "faye", "raygan", "32", "coventry",
                "http://media.mademan.com/chickipedia/uploaded_photos/a/ac/faye-reagan-posing-sexy-leopard-swimsuit-135023_thumb_585x795.jpeg",
                "http://galeri5.uludagsozluk.com/4/faye-reagan_65350.jpg",
                "http://famousas.es/wp-content/uploads/2011/11/faye-reagan-1.jpg"));
        db.addUser(new Users("user3", "pass3", "lisa", "ann", "52", "coventry",
                "https://upload.wikimedia.org/wikipedia/commons/1/1c/Lisa_Ann_at_XRCO_Awards_2007_4.jpg",
                "http://super-cars-365.com/wp-content/uploads/2016/02/Lisa-Ann.jpeg",
                "http://1.bp.blogspot.com/-J7bBg2tlkNw/Vca88Ne6aeI/AAAAAAAAigE/8M3vsfQ9ijM/s1600/lisa%2Bann%2B2.jpg"));
        db.addUser(new Users("user4", "pass4", "dani", "daniels", "26", "coventry",
                "http://data.whicdn.com/images/202651173/large.jpg",
                "http://farm9.static.flickr.com/8340/8225846626_974217dda8.jpg",
                "http://img.ifcdn.com/images/824dee8b34cb3fdc4cdf5f60fbbcbc8c0d07ccb3b99f2d0134e5926633e1b4b9_1.jpg"));
        db.addUser(new Users("user5", "pass5", "alexis", "texis", "28", "coventry",
                "http://www2.pictures.zimbio.com/gi/Alexis+Texas+2016+AVN+Adult+Entertainment+jVF3jV2dFwpl.jpg",
                "http://www4.pictures.zimbio.com/gi/2015+AVN+Adult+Entertainment+Expo+2WApJvAwmf9x.jpg",
                "http://ecx.images-amazon.com/images/I/51rTh9wj58L.jpg"));
        db.addUser(new Users("user6", "pass6", "penelapy", "lopez", "24", "london",
                "http://4.bp.blogspot.com/-wEWu3AuVK4k/VeBdppPzOHI/AAAAAAAAP3s/ZMROS2QK6LQ/s400/Screen%2BShot%2B2015-08-28%2Bat%2B14.14.40.png",
                "http://cdn.lolwot.com/wp-content/uploads/2015/04/20-of-the-hottest-women-in-the-world-3.jpg",
                "http://www.inrumor.com/wp-content/uploads/2011/05/Penelope-Cruz.jpg"));
        db.addUser(new Users("user7", "pass7", "sunny", "leone", "25", "coventry",
                "http://static.dnaindia.com/sites/default/files/2015/12/14/404541-sunny-after-hrs.jpg",
                "http://khoobsurati.com/wp-content/uploads/2015/02/Sunny-Leone-2.jpg",
                "http://media.santabanta.com/newsite/cinemascope/feed/sunny-leone177.jpg"));
        db.addUser(new Users("user8", "pass8", "hannah", "davis", "24", "coventry",
                "http://nocoastbias.com/wp-content/uploads/2015/07/10979551_931651686874963_373781172_n.jpg",
                "http://media3.popsugar-assets.com/files/2015/02/05/885/n/1922398/6d3fbf1f8dcd0949_5ad3ef667c4811e2864822000a9f09cf_7gHsyGP.xxxlarge/i/Hannah-Davis-Bikini-Pictures-Instagram.jpg",
                "https://s-media-cache-ak0.pinimg.com/736x/54/4e/02/544e02cd3bc565d84f59038032246110.jpg"));
        db.addUser(new Users("user9", "pass9", "lacy", "chaybert", "26", "coventry",
                "https://pbs.twimg.com/profile_images/509383180554498048/fsY0kq5u.jpeg",
                "http://farm8.staticflickr.com/7343/13316855743_26fab0b519_o.jpg",
                "http://i.imgur.com/mZJdbQu.jpg"));
        db.addUser(new Users("user10", "pass10", "eva", "longera", "27", "coventry",
                "http://wegotthiscovered.com/wp-content/uploads/eva-longoria.jpg",
                "http://i.forbesimg.com/media/lists/people/eva-longoria_416x416.jpg",
                "http://speakerdata.s3.amazonaws.com/photo/image/866644/eva-longoria__140212193922.jpg"));
        db.addUser(new Users("use11", "pass11", "keely", "hazell", "26", "coventry",
                "http://realitybox.co.uk/wp-content/uploads/2015/07/Keeley_Hazell_850_Wallpaper.jpg",
                "http://i216.photobucket.com/albums/cc178/verturdan/Keeley%20Hazell/KeeleyHazell3.jpg",
                "http://wickedchopspoker.com/wp-content/uploads/2013/12/Keeley-Hazell-5.jpg"));


        Log.d("inserted", "inserted");

    }

}
