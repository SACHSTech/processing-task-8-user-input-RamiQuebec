import processing.core.PApplet;

/**
 * Main class to execute sketch
 * @author Rami Kabak
 * This program is the user-input processing task, which is designed to test my knowledge
 * on user-input, using many methods such as keyPressed, keyReleased, mousePressed, mouseDragging, etc
 */
class Main {
  public static void main(String[] args) {
    
    String[] processingArgs = {"MySketch"};
	  Sketch mySketch = new Sketch();
	  PApplet.runSketch(processingArgs, mySketch);
  }
  
}