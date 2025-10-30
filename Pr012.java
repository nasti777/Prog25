//Применение различного доступа к переменным внутри класса
class MyClass {
	private int a; //закрытый доступ, значение переменной меняется только из собственного класса MyClass
	public int b; //открытый (публичный) доступ, значение переменной может изменяться из любого класса
	int c; //доступ по умолчанию (в данном случае - аналог открытого доступа)
	//Методы доступа к закрытой перменной a
	void setA (int A) {
		if (A < 10)
			a = A;
		else {
			System.out.println("Значение параметра должно быть меньше 10");
			a = 0;
		}
	}
	int getA() {
		return a;
	}
}
//Возврат объема из метода
class ErrorMsg {
	String msgs[] = {
		"Ошибка вывода",
		"Ошибка ввода",
		"Отсутствует место на диске",
		"Выход индекса за границы диапазона"
	};

	String getErrorMsg(int i) {
		if(i >= 0 & i < msgs.length)
			return msgs[i];
		else
			return "неверное значение ошибки";
	}

}
class FailSoftArray {
	//Класс, где реализуется отказоустойчивый массив
	//Объявление сылки на массив и закрытого значения ошибки доступа
	private int a[];
	private int errval;

	//Открытая переменная, где хранится размер массива
	public int length;

	//Конструктор массива, первый параметр - размер, второй - значение при ошибки доступа  
	public FailSoftArray(int size, int errv) {
		a = new int[size];
		errval = errv;
		length = size;
	}

	//Метод доступа к элементам массива при чтении значения элемента по индексу
	public int get(int index) {
		if(indexOK(index))
			return a[index];
		return
			errval;
	}

	//Метод изменения значения элемента по индексу, второй параметр - новое значение
	public boolean put(int index, int val) {
		if(indexOK(index)) {
			a[index] = val;
			return true;
		}
		return false;
	}

	//Метод проверки корректности индекса
	private boolean indexOK(int index) {
		if(index >=0 & index < length)
			return true;
		return false;
	}
	
}
//Демонстрация передачи объектов методам
class Block {
	int a, b, c;
	int V;

	Block(int i, int j, int k) {
		a = i;
		b = j;
		c = k;
		V = a*b*c;
	}

	boolean sameBlock (Block ob) {
		if((ob.a == a) & (ob.b == b) & (ob.c == c))
			return true;
		else
			return false;
	}

	boolean sameV (Block ob) {
		if(ob.V == V)
			return true;
		else return false;
	}
}
class Err {
	String msg; //Сообщение
	int severity; //Уровень серьёзности ошибки
	
	Err(String m, int s) {
		msg = m;
		severity = s;
	}
}
class ErrorInfo {
	String msgs[] = {
		"Ошибка вывода",
		"Ошибка ввода",
		"Отсутствует место на диске",
		"Выход индекса за границы диапазона"
	};
	int howbad[] = {3,3,2,4};

	Err getErrorInfo(int i) {
		if(i >= 0 & i < msgs.length)
			return new Err (msgs[i], howbad[i]);
		else
			return new Err("Неверное значение ошибки", 0);
	}
}
class Pr012 {
	public static void main(String arg[]) {
		MyClass ob = new MyClass();
		ob.setA(5);
		System.out.println("Значение переменной a в объекте ob: " + ob.getA());
		ob.setA(10);
		System.out.println("Значение переменной a в объекте ob: " + ob.getA());
		//ob.a = 10; Ошибочный доступ к закрытой переменной
		//System.out.println("Значение переменной a в объекте ob: " + ob.a);
		ob.b = 10;
		ob.c = 10;
		System.out.println("Значение переменной b в объекте ob: " + ob.b);
		System.out.println("Значение переменной c в объекте ob: " + ob.c);

		//Пример работы с отказоустойчивым массивом
		FailSoftArray fs = new FailSoftArray(5, -1);
		int x;

		System.out.println("\nОбработка ошибок без вывода отчёта");
		for(int i=0; i < (fs.length * 2); i++)
			fs.put(i, i*10);

		for(int i=0; i < (fs.length * 2); i++) {
			x = fs.get(i);
			if(x != -1)
				System.out.println(x + " ");
		}
		System.out.println();

		System.out.println("\nОбработка ошибок с выводом отчёта");

		for(int i=0; i < (fs.length * 2); i++)
			if(!fs.put(i, i*10))
				System.out.println("Значение индекса " + i + " находится за пределами границ массива");
		for(int i=0; i < (fs.length * 2); i++) {
			x = fs.get(i);
			if(!fs.put(i, i*10))
				System.out.print(x + " ");
			else
				System.out.println("Значение индекса " + i + " находится за пределами границ массива");
		}

		//Провепку работы методов, принимающих объект Block в качестве параметра
		Block ob1 = new Block(10,2,5);
		Block ob2 = new Block(10,2,5);
		Block ob3 = new Block(4,5,5);

		System.out.println("\nob1 совпадает по размерам с ob2: " + ob1.sameBlock(ob2));

		System.out.println("ob2 совпадает по размерам с ob3: " + ob2.sameBlock(ob3));

		System.out.println("ob3 совпадает по объёму с ob3: " + ob2.sameV(ob3));
		ErrorMsg err = new ErrorMsg();

		//Применение метода, возвращающего строку
		System.out.println("\n" + err.getErrorMsg(2));
		System.out.println(err.getErrorMsg(7));

		//Применение метлда, возвращающего объект с ифнормацией об ошибке
		ErrorInfo err1 = new ErrorInfo();
		Err e;

		e = err1.getErrorInfo(2);
		System.out.println(e.msg + " уровень: " + e.severity);

		e = err1.getErrorInfo(7);
		System.out.println(e.msg + " уровень: " + e.severity);
	}
}
