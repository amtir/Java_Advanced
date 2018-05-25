package module2;

public abstract class Quadrilateral {
	
	private Integer base = null;
	private Integer height = null; 
	
	public Quadrilateral(Integer base, Integer height) {
		this.base=base;
		this.height = height;
	}
	
	public Integer getBase() {
		return base;
	}

	public void setBase(Integer base) {
		this.base = base;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	abstract public Integer area() ;
}


class Rectangle extends Quadrilateral {
	
	public Rectangle(Integer base) {
		super(base,base);
	}
	
	public Rectangle(Integer base, Integer height) {
		super(base,height);
	}
	
	@Override
	public Integer area() {
		
		return this.getBase()*this.getHeight();
	}
	
	public static void main(String[] args) {	
		
		Quadrilateral ObjRect = new Rectangle(10, 5);
		Quadrilateral ObjSqu = new Rectangle(5);
		
		System.out.printf("Rectangle base = %d, height = %d, area = %d%n", 
				ObjRect.getBase(),  ObjRect.getHeight(), ObjRect.area());
		System.out.printf("Rectangle base = %d, height = %d, area = %d", 
				ObjSqu.getBase(),  ObjSqu.getHeight(), ObjSqu.area());
	}
}
