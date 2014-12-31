package elements;

public class Net {
	private static final float width = 20f;
	private static final float height = 20f;
	private final float posX;
	private final float posY;

	public Net(float posX, float posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public float getX() {
		return posX;
	}
	
	public float getY() {
		return posY;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
}
