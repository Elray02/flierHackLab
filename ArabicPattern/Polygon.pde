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
  void draw(){
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
