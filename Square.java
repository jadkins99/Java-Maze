public class Square{
  public Thing t;
  public boolean n,e,w,s;
  public int locationX, locationY;

  public Square(boolean n,boolean e,boolean w, boolean s,int locationX, int locationY){
    this.n = n;
    this.e = e;
    this.w = w;
    this.s = s;
    this.locationX = locationX;
    this.locationY = locationY;
    t = null;
  }
  public String contains(){
    if(t != null) return t.getType();
    else return null;
  }

  public Thing getThing(){
    return t;
  }
  public void setThing(Thing t){
      this.t = t;
  }
  public void removeThing() {
      this.t = null;
  }
  public void setWall(char wallToSet,boolean wallOrNoWall){
    if(wallToSet == 'n') n = wallOrNoWall;
    else if(wallToSet == 'e') e = wallOrNoWall;
    else if(wallToSet == 'w') w = wallOrNoWall;
    else if(wallToSet == 's') s = wallOrNoWall;
  }

  public void display() {
      if(w == true) { System.out.print("| "); }

      if(n == true && s == true) { System.out.print("-_");}
      if(n == true && s == false) { System.out.print("--");}
      if(n == false && s == true) { System.out.print("__");}


      if(e == true) { System.out.print(" |"); }

  }
}
