package gamecycles.morphpotion.util;

public class Vec2i {
	public int x=0;
	public int y=0;
	
	public Vec2i(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public boolean equals(Vec2i other){
		if(this.x==other.x && this.y==other.y){
			return true;
		}
		
		return false;
	}
}
