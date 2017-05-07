import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class ArabicPattern extends PApplet {

Polygon poly;
public void setup( ) {
  
  background(15);
  // Six-sided tiles
  // poly = new Polygon(90, 6, PI / 2.5, 9);
  // for (int j = 0; j < height; j += 2 * poly.h) {
  //     for (int i = 0; i < width; i += 2 * (poly.l + poly.r)) {
  //         pushMatrix();
  //         translate(i, j);
  //         poly.draw();
  //         translate(poly.l + poly.r, poly.h);
  //         poly.draw();
  //         popMatrix();
  //     }
  // }

}
public void draw( ) {
  background(15);
  float myAngle = radians(mouseX) ;
  float mydelta = map(mouseY, 0 , height,0,100);
  println("myAngle= "+ myAngle+" mydelta= "+ mydelta);

  poly = new Polygon(85, 6, myAngle, mydelta);
  for (int j = 0; j < height; j += 2 * poly.h) {
      for (int i = 0; i < width; i += 2 * (poly.l + poly.r)) {
          pushMatrix();
          translate(i, j);
          poly.draw();
          translate(poly.l + poly.r, poly.h);
          poly.draw();
          popMatrix();
      }
  }
}
class Polygon {
  float r = 0;
  int sides = 0 ;
  float theta = 0 ;
  float del =0 ;
  float alph = 0;
  float h = 0;
  float l = 0;
  float beta = 0;
  float  d = 0 ;
  PVector hank;

  Polygon(float r, int sides, float theta, float del ){
    this.r = r; // tile radius;
    this.sides = sides; // number of sides;
    this.theta = theta;
    this.del = del; // Hankin base offset
    alph = PI / 2 - PI / sides; // tile corner half-angle
    h = this.r * sin(alph); // tile half-height
    l = this.r * cos(alph); // tile half-base
    beta = PI - alph - theta; // Hankin intersection angle
    d = sin(alph)/sin(beta) * (l+ del); // Hankin length
    hank = new PVector(d * cos(theta), -d * sin(theta));
  }
  public void draw(){
    pushMatrix();
      for(int i = 0; i< sides; i++){
        /// side
        stroke(255,40);
        line(-l,h,l,h);
        //Hankins
        stroke(200);
        line(-del, h, -del + hank.x, h + hank.y);
        line(del-1, h, del - hank.x, h + hank.y);
        // rotate for next side
        rotate(TWO_PI / sides);
      }
    popMatrix();
  }
}
  public void settings() {  size(800,600 , P2D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ArabicPattern" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
