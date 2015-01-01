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
	
	public float getPosX() {
		return posX;
	}
	
	public float getPosY() {
		return posY;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
}
