package bookpackext;

class Pr020 {
  public static void main(String[] args) {
    bookpack.Book[] books = new bookpack.Book[5];
    books[0] = new bookpack.Book("Портрет Дориана Грея", "О. Уайлд", "1989");
    books[1] = new bookpack.Book("Пеступление и наказание", "Ф.М. Достоевский", "1971");
    books[2] = new bookpack.Book("Мастер и Маргарита", "М.А. Булгаков", "1981");
    books[3] = new bookpack.Book("Оно", "С. Кинг", "1986");
    books[4] = new bookpack.Book("Мартин Иден", "Дж. Лондон", "1927");

    for(int i=0; i < books.legth; i++)
      books[i].show();
  }
}
