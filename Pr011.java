class Pr011 {
	public static void main (String args[]) {
		//Поразрядные операции над кодами символов
		char ch;
		for (int i = 0; i < 26; i++) {
			ch = (char) ('a' + i);
			System.out.print (ch);
			//Сброс шестого бита у символа при помощи &
			ch = (char) ((int) ch & 65503);

			System.out.print(ch + " ");
		}
		System.out.println("\n");
		//Отображение битов в 6-разрядном представлении
		int t;
		byte val;
		val = -126;
		for (t = 128; t > 0; t = t/2) {
			if((val & t) != 0) System.out.print("1 ");
			else System.out.print("0 ");
		}
		System.out.println("\n");

		//Преобразование из верхнего регистра в нижний
		for (int i = 0; i < 26; i++) {
			ch = (char) ('A' + i);
			System.out.print (ch);
			//Установка 6-ого бита у символа при помощи | (поразрядная операция или)
			ch = (char) ((int) ch | 32);

			System.out.print(ch + " ");
		}
		System.out.println("\n");

		//Шифрование строки при помощи поразрядной операции исключающего ИЛИ

		String str = "Очередь секретная строка";
		String encstr = "";
		String decstr = "";
		int key = 150;

		System.out.print("Исходная строка: ");
		System.out.println(str);

		//Шифрование:
		for (int i = 0; i < str.length(); i++)
			encstr = encstr + (char) (str.charAt(i) ^ key);
		System.out.print("Зашифрованая строка: ");
		System.out.println(encstr);

		//Расшифровка: 
		for (int i = 0; i < str.length(); i++)
			decstr = decstr + (char) (encstr.charAt(i) ^ key);

		System.out.print("Расшифрованная строка: ");
		System.out.println(decstr);

		//Демонстрация использования поразрядной операции НЕ
		byte b = -34;


		for (t = 128; t > 0; t = t/2) {
			if((b & t) != 0) System.out.print("1 ");
			else System.out.print("0 ");
		}
		System.out.println("\n");

		//Инвертирование бит в знечении b
		b = (byte) ~b;

		for (t = 128; t > 0; t = t/2) {
			if((b & t) != 0) System.out.print("1 ");
			else System.out.print("0 ");
		}
		System.out.println("\n" + b + "\n");

		//Операции сдвига << и >>

		int val1 = 1;
		for (int i = 0; i < 8; i++) {
			for (t = 128; t > 0; t = t/2) {
				if((val1 & t) != 0) System.out.print("1 ");
				else System.out.print("0 ");
			}
			System.out.println();
			val1 = val1 << 1;
		}
		System.out.println();


		val1 = 128;
		for (int i = 0; i < 8; i++) {
			for (t = 128; t > 0; t = t/2) {
				if((val1 & t) != 0) System.out.print("1 ");
				else System.out.print("0 ");
			}
			System.out.println();
			val1 = val1 >> 1;
		}
		System.out.println();

		//Оператор ? - используется вместо конструкции if()... else ...
		int value = 2, absValue;
		if (value < 0)
			absValue = -value;
		else
			absValue = value;

		System.out.println("Значение value: " + value + "\nАбсолютное значение value: " + absValue);
		value = -2;

		absValue = value < 0 ? -value : value;
		System.out.println("Значение value: " + value + "\nАбсолютное значение value: " + absValue);

		//Пример использования оператора ? для предотвращения запрещенных арифметических операций
		//Запрещённная арифметическая операция - деление на ноль: value = 10/0;
		System.out.println();
		int result;
		for(int i = -5; i < 6; i++) {
			result = i != 0 ? 100/i : 0;
		if(i != 0)
			System.out.println("100/ " + i + " равно " + result);
		}

		//Аналогичное решение в альтернотивной форме
		System.out.println();
		for(int i = -5; i < 6; i++) {
			if(i != 0 ? true : false)
				System.out.println("100/ " + i + " равно " + 100 / i);
		}
	}
}
