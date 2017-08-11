
public class Ship {
String name;
int length;
int width;
boolean isAlive;
int life;

public Ship(String name, int length, int width, boolean isAlive, int life) {
	super();
	this.name = name;
	this.length = length;
	this.width = width;
	this.isAlive = isAlive;
	this.life = life;
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getLength() {
	return length;
}
public void setLength(int length) {
	this.length = length;
}
public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public boolean isAlive() {
	return isAlive;
}
public void setAlive(boolean isAlive) {
	this.isAlive = isAlive;
}
public int getLife() {
	return life;
}
public void setLife(int life) {
	this.life = life;
}


}
