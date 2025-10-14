//Конструкторы
class MyClass {
  int x;
//Простой конструктор
  MyClass() {
    x = 10;
  }
}
class MyClass2 {
  int x;
//Конструтор с параметрами
  MyClass2(int i) {
    x = i;
  }
}

class Pr009 {
  public static void main(String args[]) {
    MyClass t1 = new MyClass();
    MyClass t2 = new MyClass();

    System.out.println("Значение x внутри t1: " + t1.x + "Значение x внутри t2: " + t2.x);

    MyClass t3 = new MyClass2(10);
    MyClass t4 = new MyClass2(88);

    System.out.println("Значение x внутри t3: " + t3.x + "Значение x внутри t4: " + t4.x);

    Avto bmw = new Avto(5, 80, 12.5);
    Avto mercedes = new Avto(2, 60, 10.2);

    System.out.println("BMWW X5 перевозит " + bmw.pass + " пассажиров на " + bmw.range() + " км");
    System.out.println("Mercedes SLC 43 перевозит " + mercedes.pass + " пассажиров на " + mercedes.range() + " км");
  }
}
