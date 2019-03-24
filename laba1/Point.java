package demo;

import java.util.Scanner;

public class Point 
{
  public static void main(String[] args) 
  {
	  int debug = 0;
	  
	  if(args[0].equals("-d") || (args.length>1 && args[1].equals("-d")))
	  {
		  debug = 1;
		  System.out.println("Вітаємо в режимі 'debug' ");
	  }
	  
	  if (args[0].equals("-h") || (args.length>1 && args[1].equals("-h")))
	  System.out.println("Привіт,ось твій хелп\n"
			        + "Виконав: Павло Зінько, КН-108 \n\n"
			        + "Мета:\n"
			        + "Ввести текст.Текст розбити на речення \n"
			        + "У словах зробити перевірку\n"
			        + "Якщо перша та остання літери співпали,вивести слово\n"
			        + "Після кожного слова потрібно поставити пробіл\n"
			        + "Після кінця речення потрібно поставити крапку і пробіл.В кінці введеного тексту поставте крапку\n\n"
			        + "Команди меню:\n"
			        + "Для виводу розділенного тексту введіть \"l\" \n"
			        + "Для виводу слів введіть \"w\" \n"
			        + "Для вводу нового тексту \"n\"");
	  System.out.println("\n\nВведіть рядок для редактування:"); 
	  
	  
	  Scanner in = new Scanner(System.in);
	  String joke = in.nextLine();
	  StrEditor.settings(joke);
	  System.out.print("Наступна команда: ");
	  String k = in.nextLine();
	  
	  
	  for(;;System.out.print("Наступна команда: "),k = in.nextLine())
	  {
		  switch(k.charAt(0))
		  {
			  case 'n': 
			  { 
				  System.out.println("Новий рядок: "); 
				  joke = in.nextLine(); 
				  StrEditor.settings(joke); 
				  break;
			  }  
			  case 'l':
			  {
				  StrEditor.tut();
				  break;
			  }
			  case 'w': 
			  {
				  StrEditor.WordChecker(debug);
				  break;
			  }
			  default: 
			  {
				  System.out.println("Вихід!"); 
				  return;
			  }
		  }
	  }
  }
  
}