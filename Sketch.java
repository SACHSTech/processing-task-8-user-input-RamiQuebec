import processing.core.PApplet;

public class Sketch extends PApplet {
  /**
   * Variables
   */
  boolean isClickedOnGrass = false;
  boolean isLeftMousePressed = false;
  boolean isColorMode = false;

  int[] flowerX = new int[1000];
  int[] flowerY = new int[1000];
  int[] flowerColors = new int[1000];
  int flowerCount = 0;
  int flowerSize = 10;

  boolean isNight = false;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    size(400, 400);
  }

  /**
   * Called once at the beginning of execution. Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(255, 255, 0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    fill(0, 255, 0);
    rect(0, 300, 400, 100);
    for (int i = 0; i < flowerCount; i++) {
      drawFlower(flowerX[i], flowerY[i], flowerColors[i]);
    }
  }

  /**
   * mousePressed method, used to detect if mouseY is above 300 to change the isClickedOnGrass boolean
   * does the same on isLeftMousePressed if the mouseY is below 300
   * Also stores flower into the arrays to re-draw by checknig if isClickedOnGrass is true
   */
  public void mousePressed() {
    if (mouseY > 300) {
      isClickedOnGrass = true;
    } else {
      isClickedOnGrass = false;
    }
    if (mouseY < 300) {
      if (mouseButton == LEFT) {
        isLeftMousePressed = true;
      }
    }

    if (isClickedOnGrass) {
      storeFlower(mouseX, mouseY);
    }
  }

  /**
   * mouseReleased method, used to detect if left mouseButton is released to set the
   * isLeftMousePressed to false
   */
  public void mouseReleased() {
    if (mouseButton == LEFT) {
      if (mouseY < 300) {
          isLeftMousePressed = false;
      }
    }
  }

  /**
   * mouseDragged method which checks isLeftMousePressed boolean to draw
   */
  public void mouseDragged() {
    if (isLeftMousePressed) {
        if (isLeftMousePressed) {
            stroke(0);
            if (isColorMode) {
                stroke(random(255), random(255), random(255));
            }
            line(pmouseX, pmouseY, mouseX, mouseY);
        }    
    }
  }

  /**
   * storeFlower function taking x and y parameters to store the positions in a array
   * also stores random color in array for random colors on the flowers
   * @param x mouseX location of the flower
   * @param y mouseY location of the flower
   */
  void storeFlower(int x, int y) {
    flowerX[flowerCount] = x;
    flowerY[flowerCount] = y;
    flowerColors[flowerCount] = color(random(255), random(255), random(255));
    flowerCount++;
  }

  /**
   * 
   * @param x mouseX position for hte flower
   * @param y mouseY position for the flower
   * @param flowerColor Uses the stored flowerColor array to make a random color for the flower
   */
  void drawFlower(int x, int y, int flowerColor) {
    fill(0, 0, 0);
    line(x, y, x, y + 15);
    fill(flowerColor);
    ellipse(x, y, flowerSize, flowerSize);
  }

  /**
   * keyPressed method, used to detect if T is pressed to change isNight boolean to change the 
   * time of the day, also detects keyCode left arrow and right arrow to change the flower size, last
   * but not least it also detects if C is pressed to change the isColorMode boolean
   */  
   public void keyPressed() {
    if (key == 'T' || key == 't') {
      isNight = !isNight;
      if (isNight) {
        background(0);
      } else {
        background(255, 255, 0);
      }
    }
    
    if (keyCode == LEFT) {
      flowerSize = max(5, flowerSize - 1);
    } else if (keyCode == RIGHT) {
      flowerSize = min(25, flowerSize + 1);
    }
    if (key == 'C' || key == 'c') {
        isColorMode = !isColorMode;
    }
  }

  /**
   * Checks if key (C) is released to make the isColorMode function false
   */
  public void keyReleased() {
    if (key == 'C' || key == 'c') {
        isColorMode = false;
    }
  }
}