class Help {
	public static void main(String args[])
	  throws java.io.IOException {
		char choise;

		System.out.println("Справочная система");
		System.out.println(" 1. if");
		System.out.println(" 2. switch");
		System.out.print("Выберите нужное число: ");
		choise = (char) System.in.read();

		System.out.println("\n");

		switch(choise) {
			case '1':
				System.out.println("Оператор if:\n");
				System.out.println("if(логическое выражение) оператор;");
				System.out.println("else оператор;");
				break;
			case '2':
				System.out.println("оператор switch:\n");
				System.out.println("switch(выражение) {");
				System.out.println(" case константа:");
				System.out.println(" последовательность операторов");
				System.out.println(" break;");
				System.out.println(" // ...");
				System.out.println("}");
				break;
			default:
				System.out.println("Неверный выбор");
		}
	}
}
