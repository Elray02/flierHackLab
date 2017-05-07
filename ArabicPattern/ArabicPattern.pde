Polygon poly;
void setup( ) {
  size(800,600 , P2D);
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
void draw( ) {
  background(15);
  float myAngle = radians(mouseX) ;
  float mydelta = map(mouseY, 0 , height,0,100);
  println("myAngle= "+ myAngle+" mydelta= "+ mydelta);
  // angle = 4.10
  // delta = 25 
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
