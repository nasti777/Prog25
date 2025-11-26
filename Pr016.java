//Знакомство с обьектами
class Avto {
	private int pass; //Количество пассажиров включая водителя
	private int V; //Емкость топливного бака в л.
	private double rash; //расход топлива в л/100км

	Avto() {
		pass = 0;
    V = 0;
		rash = 0.0;       
	}

	Avto(int p, int v, double r) {
		pass = p;
		V = v;
		rash = r;
	}

	 //Метод вычисления растояния которое авто проедет на полном баке:
	double range() {  
		return ((double)(V*100))/rash;	
	}

	double rashTopl(int km) {
		return (double)km*rash/100;
	}

	//Методы доступа к переменным 
	int getPass() {
		return pass;
	}

	void setPass(int p) {
		pass = p;
	}

	int getV() {
		return V;
	}

	void setV(int v) {
		V = v;
	}

	double getRash() {
		return rash;
	}

	void setRash(double r) {
		rash = r;
	}
}

class Truck extends Avto {
	//Грузоподьёмность грузовика
	private int cargocap;

	//Конструктор
	Truck(int p, int v, double r, int c){
		super(p, v, r);
		cargocap = c;
	}
	int getCargo() {
		return cargocap;
	}

	void putCargo(int c) {
		cargocap = c;
	}
}	

class Pr016 {
	public static void main(String args[]) {
		double range;
		Avto bmw = new Avto(5, 80, 12.5);

	  /*	
    bmw.pass = 5;
		bmw.V = 80;
		bmw.rash = 12.5;
	  */
    
		System.out.println("\nИнформация о BMW X5: ");

		System.out.println("Количество пассажиров у BMW X5: " + bmw.getPass());
		System.out.println("Обьем бака у BMW X5: " + bmw.getV() + " л ");
		//Вызов метода вычисления расстояния внутри метода System.out.println();
		System.out.println("Расход топлива у BMW X5: " + bmw.getRash() + " л/100км" + "\nРасстояние для bmw: " + bmw.range() + " км");

	  //range = ((double)(bmw.V * 100)) / bmw.rash;
		range = bmw.range();
	  System.out.println("bmw X5 проедет на полном баке " + range + " км");	
		System.out.println("BMW X5 потратит на 100 км. " + bmw.rashTopl(100) + " литров топлива");

		int distance = 3350; //Расстояние до Москвы 

		System.out.println("BMW X5 потратит на 100 км. " + bmw.rashTopl(distance) + " литров топлива, чтобы доехать до Москвы");

		//Создание грузовиков

		Truck zil = new Truck(2, 170, 25.0, 7);
		Truck kamaz = new Truck(3, 800, 35.0, 8);

		System.out.println("\nИнформация о ЗИЛ: ");

		System.out.println("Количество пассажиров у ЗИЛ: " + zil.getPass());
		System.out.println("Обьем бака у ЗИЛ: " + zil.getV() + " л ");
		//Вызов метода вычисления растояние в нутри метода System.out.println();
		System.out.println("Расход топлива у ЗИЛ: " + zil.getRash() + " л/100км" + "\nРасстояние для bmw: " + zil.range() + " км");
	  //range = ((double)(bmw.V * 100)) / bmw.rash;
		range = bmw.range();
	  System.out.println("ЗИЛ проедет на полном баке " + range + " км");	
		System.out.println("ЗИЛ потратит на 100 км. " + zil.rashTopl(100) + " литров топлива");
		System.out.println("Масса груза для ЗИЛ: " + zil.getCargo() + " тонн");

		System.out.println("\nИнформация о КАМАЗ: ");

		System.out.println("Количество пассажиров у КАМАЗ: " + kamaz.getPass());
		System.out.println("Обьем бака у КАМАЗ: " + kamaz.getV() + " л ");
		//Вызов метода вычисления растояние в нутри метода System.out.println();
		System.out.println("Расход топлива у КАМАЗ: " + kamaz.getRash() + " л/100км" + "\nРасстояние для bmw: " + kamaz.range() + " км");
	  //range = ((double)(bmw.V * 100)) / bmw.rash;
		range = bmw.range();
	  System.out.println("КАМАЗ проедет на полном баке " + range + " км");	
		System.out.println("КАМАЗ потратит на 100 км. " + kamaz.rashTopl(100) + " литров топлива");
		System.out.println("Масса груза для КАМАЗ: " + kamaz.getCargo() + " тонн");

		/*
		System.out.println("\nИнформация о Mercedes SLC 43: ");

		Avto mercedes = new Avto();
		mercedes.pass = 2;
		mercedes.V = 60;
		mercedes.rash = 10.2;
		System.out.println("Количество пассажиров у mercedes: " + mercedes.pass);
		System.out.println("Обьем бака у mercedes: " + mercedes.V + " л ");
		System.out.println("Расход топлива у mercedes: " + mercedes.rash + " л/100км");

	  //range = ((double)(mercedes.V * 100)) / mercedes.rash;
		range = mercedes.range();
		System.out.println("mercedes CLS 43 проедет на полном баке " + range + " км");

		System.out.println("mercedes CLS 43 потратит на 100 км. " + mercedes.rashTopl(distance) + " литров топлива, чтобы доехать до Москвы");
		//Хранение значений в простых типах переменных
		int p1 = 50, p2 = 75;
		p1 = p2;
		p2 = 100;
		System.out.println("Значения р1 и р2: " + p1 + " " + p2 );

		//Хранение значений в обьектных типах
		//Операции присваивания означают копирование ссылки на обьект а не на всех значениях обьекта
		Avto bmw1, bmw2;
		bmw1 = bmw;
		bmw2 = mercedes;
		bmw1.rash = 14.5;
		System.out.println("Расход для bmw и bmw1: " + bmw.rash + " " + bmw1.rash);
		bmw2.rash = 9.99;
		System.out.println("Расход для bmw2 и mercedes: " + bmw2.rash + " " + mercedes.rash);
	  */
	}
}
