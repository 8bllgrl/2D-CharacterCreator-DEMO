package ui;

import entities.EnumGender;
import entities.MiqoCharacter;
import gamescreens.CharacterDisplayScreen;
import main.Game;

import java.awt.*;

public class UILoader {

    public int miqoAge;
    public int appearanceNumber;
    private MiqoCharacter miqoCharacter;
    private String miqoGender;
    private String firstName;
    private String lastName;
    private final String femaleABR = "F";
    private final String maleABR = "M";
    private String tribeLetter = "A'";
    private String genderABR;


    public UILoader(CharacterDisplayScreen characterDisplayScreen) {
        miqoCharacter = characterDisplayScreen.getCharacter();
        loadDesignatedText();
        firstName = miqoCharacter.getTribeLetter() + miqoCharacter.getFirstName();
        lastName = miqoCharacter.getLastName();
        getGenderABR();
    }

    private void getGenderABR() {
        if (miqoCharacter.getGender() == EnumGender.MALE){
            genderABR = maleABR;
        } else if (miqoCharacter.getGender() == EnumGender.FEMALE){
            genderABR = femaleABR;
        }
    }

    private void loadDesignatedText() {
        miqoAge = miqoCharacter.getAge();
        setGenderText();
    }

    public void drawUIImproved(Graphics2D g2) {
        drawBackground(g2);

        //Blue UI with the grey outlines.
        drawUIBlueBox(520, 80, 430, 460, g2); //EAST PANE
        drawUIBlueBox(0, 90, 200, 460, g2); //WEST PANE
        drawUIBlueBox(0, 0, 950, 110, g2); //NORTH PANE
        drawUIBlueBox(0, 490, 950, 259, g2); //SOUTH PANE
        drawUIBlueBox(15, 20, 165, 45, g2); //NAME BUTTON
        drawUIBlueBox(15, 130, 165, 45, g2); //GENDER BUTTON
        drawUIBlueBox(15, 265, 100, 45, g2); //VOICE BUTTON
        drawUIBlueBox(15, 365, 100, 45, g2); //AGE BUTTON
        drawUIBlueBox(480, 20, 215, 45, g2); //APPEARANCE BUTTON

        //Black boxes for text.

        drawDisplayBoxBlack(17, 65, 200, 45, g2); //NAME
        drawDisplayBoxBlack(225, 65, 200, 45, g2); //NAME 2
        drawDisplayBoxBlack(75, 315, 70, 45, g2); //VOICE
        drawDisplayBoxBlack(75, 415, 70, 45, g2); //AGE
        drawDisplayBoxBlack(550, 65, 70, 45, g2); //APPEARANCE
        drawDisplayBoxBlack(75,182,55,40,g2); //GENDER


    }

    public void drawBackground(Graphics2D g2) {
        g2.setColor(Color.darkGray);
        g2.fillRect(190, 90, 360, 430);
    }

    public void drawUIBlueBox(int x, int y, int width, int height, Graphics2D g2) {
        Color ffxivBlue = new Color(0, 63, 229);
        Color ffxivDark = new Color(11, 18, 59);
        GradientPaint gradientPaint2 = new GradientPaint(0, height + y, ffxivDark, 0, y, ffxivBlue);
        g2.setPaint(gradientPaint2);
        g2.fillRect(x, y, width, height);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.gray);
        g2.drawRect(x, y, width, height);
    }

    public void drawDisplayBoxBlack(int x, int y, int width, int height, Graphics2D g2) {
        g2.setColor(Color.black);
        g2.fillRect(x, y, width, height);
    }

    public void drawUIText(Graphics2D g2) {
        g2.setFont(new Font("Sitka Text", Font.ITALIC, 32));
        g2.setColor(Color.white);

        //First Name Button
        g2.drawString("Name", 55, 55);
        //Gender Button
        g2.drawString("Gender", 47, 162);
        //Voice Button
        g2.drawString("Voice", 25, 300);
        //Age Button
        g2.drawString("Age", 25, 400);
        //Appearance Button
        g2.drawString("Appearance", 500, 52);


    }

    public String getMiqoGender() {
        return miqoGender;
    }

    private void setGenderText(){
       EnumGender temp = miqoCharacter.getGender();
       if (temp == EnumGender.MALE){
           miqoGender = "M";
       } else if (temp == EnumGender.FEMALE){
           miqoGender = "F";
       }
//        System.out.println("set gender text");
    }

    public void drawUIValueText(Graphics2D g2) {
        //First Name
        g2.drawString(firstName, 25, 100);
        //Last Name
        g2.drawString(lastName, 300, 100);
        //Voice text
        g2.drawString(genderABR+":1", 82, 350);
        //Age text
        g2.drawString(String.valueOf(miqoAge), 95, 445);
        //Appearance Text
        g2.drawString(genderABR+"-1", 555, 100);
        //Gender Text
        g2.drawString(getMiqoGender(),88,210);
    }

    public void setNameText(){
        firstName = miqoCharacter.getTribeLetter() + miqoCharacter.getFirstName();
        lastName = miqoCharacter.getLastName();
    }


    public void update() {
        miqoAge = miqoCharacter.getAge();
        setGenderText();
        setNameText();
        getGenderABR();
    }

    public void render(Graphics2D g2){
        drawUIValueText(g2);
    }


}

