package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class AssetLoader {

    public static final String CHARACTER_SPRITESHEET = "/character/character_atlas_3app.png";
    public static final String CURSOR_ASSET = "/util/cursorff.png";
    public static final String NEXT_ARROW_BUTTON = "/util/nextarrow.png";
    public static final String PREVIOUS_ARROW_BUTTON = "/util/prevarrow.png";
    public static final String RANDOMIZER_BUTTON = "/util/randomizer.png";

    public static final String[] FEMALE_FIRSTNAMES =
            {
                    "abodji", "adebh", "alabali", "arhll", "arimbeh", "attano", "baharra", "bhowaqi", "biwali", "bokhn", "bolaff", "brohka", "dasshym", "datnan", "dennmo", "dhakya", "dhamya", "dhilogo", "dhinek", "dhodjbi", "dhovaka", "djawana", "djongo", "doyagha", "dyalani", "fhiroh", "ghonako", "gnayak", "hahtoa", "hozqha", "intana", "jhimei", "juramm", "jusana", "kalkaya", "kepaga", "khebica", "kholbeh", "khonebb", "koliwe", "konnala", "korolon", "lahmui", "laiboli", "lakshai", "lamahni", "lantaa", "linhbo", "llayan", "lloon", "lyhhia", "majha", "maladyu", "mallibo", "manafa", "mhalawi", "mihgazoo", "moldva", "molosi", "nabyano", "naidjaa", "nanghal", "nbulea", "ndanya", "nhalki", "nibnpha", "nimuili", "ondolo", "onggo", "paghlo", "pahtalo", "pandolu", "perjha", "piqoi", "pondhao", "qawhau", "raemha", "ranmaia", "rhabye", "rhoyod", "shakkal", "sumbla", "tadhara", "tajha", "talhdi", "tchakha", "telihgo", "toldha", "trimmna", "wabati", "whalon", "wonjhali", "yaalamo", "yalwann", "yandih", "zalikko", "zamqo", "zangho", "zazanh", "zimzizi"
            };
    public static final String[] TRIBE_LETTERS =
            {
                    "A'", "B'", "C'", "D'", "E'", "F'", "G'", "H'", "I'", "J'", "K'", "L'", "M'", "N'", "O'", "P'", "Q'", "R'", "S'", "T'", "U'", "V'", "W'", "X'", "Y'", "Z'",
            };
    public static final String[] MALE_FIRSTNAMES =
            {
                    "alih", "alih", "apa", "apa", "atoh", "atoh", "azih", "azih", "bahlo", "behm", "bhem", "bhin", "bhin", "binba", "binba", "chah", "chah", "chai", "chai", "datih", "datih", "falkh", "ghol", "ghol", "holha", "holha", "iaho", "iaho", "inwa", "inwa", "jenma", "jenma", "kayah", "kayah", "khot", "khot", "laqa", "laqa", "linh", "linh", "lohi", "lohi", "mhati", "mhati", "mitu", "mitu", "mona", "mona", "ndae", "ndae", "nhea", "nhea", "nijah", "nijah", "nuloh", "nuloh", "olh", "olh", "phel", "phel", "quih", "quih", "quon", "quon", "raht", "raht", "rhika", "rhika", "rihnn", "rihnn", "rinha", "rinha", "shtah", "shtah", "tenpe", "tenpe", "thub", "thub", "tiqa", "tiqa", "tyada", "tyada", "vanoh", "vanoh", "vett", "vett", "viloh", "viloh", "welhi", "welhi", "weta", "weta", "yhuh", "yhuh", "zhet", "zhet", "zinba", "zinba", "zula", "zula"
            };
    public static BufferedImage character_spritesheet;

    public AssetLoader(){

    }
    public static BufferedImage GetSpriteAtlas(String fileName) {
        BufferedImage img = null;
        InputStream is = AssetLoader.class.getResourceAsStream(fileName);
        try {
            assert is != null;
            img = ImageIO.read(is);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert is != null;
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }

    public void importImage() {
        InputStream is = getClass().getResourceAsStream("character/character_atlas_3app.png");

        try {
            character_spritesheet = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
