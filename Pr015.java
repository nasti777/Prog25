//Суперкласс (родительский для всех подклассов двухмерных фигур)
class TwoDShape {
  	private double width;
	private double height;
 	private String color;
	private double line;
	int i=25;

	TwoDShape() {
		width = height =0;
	}
	TwoDShape(double x) {
		width = height = x;
		line = 0.1;
		color = "Черный";
	}
	TwoDShape(double w, double h, String c, double l) {
		if (w < 21)
			width = w;
		else 
			System.out.println("Ширина не должна превышать 21 см");
		height = h;
		color = c;
		line = l;

	}
  //методы доступа к закрытым переменным экземпляра
	double getWidth() {
		return width;
	}
	double getHeight() {
		return height;
	}
	void setWidth(double w) {
		if (w < 21)
			width = w;
		else 
			System.out.println("Ширина фигуры должна быть меньше 21 см");	
	}

	void setHeight(double h) {
		if (h < 29)
			height = h;
		else 
			System.out.println("Ширина фигуры должна быть меньше 29 см");	
	}
  
  void showDim() {
	  System.out.println("Толщина линии фигуры " + line + "\nШирина двумерной фигуры: " + width + "\nВысота двумерной фигуры: " + height);
  }
  
  String getColor() {
    System.out.println("Цвет двумерной фигуры: " + color);
    return color;
  }

  void setColor(String c) {
	  color = c;
	}
}
//Подкласс  суперкласса TwoDShape (дочерний класс) для описания треугольников
class Triangle extends TwoDShape {
  	String style;
	int i = 50;
//Конструктор определенный в подклассе
	Triangle() {
		super();
		style = "Без стиля";
	}

	Triangle(double x) {
		super(x);
		style = "Точечный";	
	}
	
	Triangle(String s, double w, double h, String c, double l) {
		super(w, h, c, l);
		style = s;
	}
  	double area() {
    	return getWidth() * getHeight() / 2;
  }
  void showStyle() {
    	System.out.println("Стиль треугольника: " + style);
  }
	
	void showI() {
		System.out.println("Значение i в подклассе: " + i);
		System.out.println("Значение i в cуперклассе: " + super.i);
	}
}
//Подкласс суперкласса TwoDShape для описания прямоугольника
class Rectangle extends TwoDShape {
	Rectangle(double w, double h, String c, double l) {
		super(w, h, c, l);
	}
  //метод, проверяющий, является ли прямоугольник квадратом
  	boolean isSquare() {
    	if(getWidth() == getHeight()) return true;
    	return false;
  	}
  	double area() {
    	return getWidth() * getHeight();
  	}
  //Подкласс не имеет доступа к закрытым переменным суперкласса
  /*
  String getColor() {
    System.out.println("Цвет двумерной фигуры: " + color);
    rutern color;
  }
  */
}
class Pr015 {
  //Демонстрация создания треугольников и двумерных фигур
  public static void main(String[] args) {
	  Triangle t1 = new Triangle("Пунктирный", 5.1, 4.3, "Зеленый", 0.5);
	  Triangle t2 = new Triangle("Сплошной", 7.1, 3.3, "Красный", 0.2);
	  Triangle t3 = new Triangle(5.5);

/*      t2.setWidth(7.1);
		  t2.setHeight(4.3);
      t2.style = "Сплошной";
*/
	  TwoDShape s1 = new TwoDShape(10.0, 6.2, "Желтый", 0.1);
	  TwoDShape s2 = new TwoDShape();
	  TwoDShape s3 = new TwoDShape(5.0);
	  /*
	  s1.setWidth(10.0);
	  s1.setHeight(6.2);
	  */

      System.out.println("Информация об объекте t1: ");
      t1.showStyle();
      t1.showDim();
      System.out.println("Площадь: " + t1.area());
      System.out.println();
      String str = t1.getColor();

      System.out.println("Инфорамация об объекте t2: ");
      t2.showStyle();
      t2.showDim();
      System.out.println("Площадь: " + t2.area());
      System.out.println();

	  System.out.println("Информация об обьекте t3: ");
	  t3.showStyle();
	  t3.showDim();
	  System.out.println("Площадь: " + t3.area());
	  String str2 = t3.getColor();
	  System.out.println(str2);
	  System.out.println();
      //Родительский класс не имеет доступа к переменным, определённым в подклассе
      //s1.style = "Абстрактная фигура"; Родительский класс не может инициализировать переменную подкласса
      System.out.println("Информация об объекте s1: ");
      //Родительский класс не имеет доступа к методам своего подкласса
      //s1.showStyle(); метод подкласса, непременим к s1
      s1.showDim();
	  System.out.println("Информация об обьекте s2:");
	  s2.showDim();
	  System.out.println("Цвет фигуры s2: ");
	  s2.getColor();
	  
	  System.out.println("Информация об обьекте s3:");
	  s3.showDim();
	  System.out.println("Цвет фигуры s3: ");
	  s2.getColor();
      //System.out.println("Площадь: " + s1.area()); Вызов метода подкласса, неприменим к s1
      System.out.println();

      Rectangle r1 = new Rectangle(35.1, 4.3, "Синий", 0.6);
	  /*
      r1.setWidth(35.1);
	  r1.setHeight(4.3);
	  */

      System.out.println("Информация об объекте r1: ");
      r1.showDim();
      System.out.println("Площадь: " + r1.area());
      System.out.println("r1 является квадратом: " + r1.isSquare());
      System.out.println();

	  //Проверка доступа к одноименной переменной в суперклассе из подкласса
	  System.out.println("Значение i в экземпляре TwoDShape: " + s1.i);
	  System.out.println("Значение i в экземпляре Triangle: " + t1.i);
	  t1.showI();
  }
}
