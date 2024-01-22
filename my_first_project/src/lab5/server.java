package lab5;

import java.io.*;
import java.net.*;
import java.util.Random;


public class server {
  public static void main(String[] args) throws Exception
  {
    Socket s = null;
    try
    { // посылка строки клиенту
      ServerSocket server = new ServerSocket(8030);
      s = server.accept();  // ожидание подключения
      PrintStream ps = new PrintStream(s.getOutputStream());
      System.out.println("Все идет по плану-1");
      Random random = new Random();
      int randomNumber = random.nextInt(154) + 1;

      sonet(randomNumber, ps);
      System.out.println("Все идет по плану0" + String.valueOf(randomNumber) );
      ps.flush();
      s.close(); // разрыв соединения
    } catch (IOException e)
    {
      System. out.println( " ошибка : " + e);
    }

  }

  static void sonet(int number, PrintStream ps)
  {
    try
    {
      File file = new File("C:\\Users\\4\\IdeaProjects\\my_first_project\\src\\lab5\\Sonets.txt");
      FileInputStream fis = new FileInputStream(file);
      InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
      BufferedReader br = new BufferedReader(isr);

      String line;
      int i = 0;
      System.out.println("Все идет по плану1");
      while ((line = br.readLine()) != null)
      { // идем по строкам и если нашлась подходящая - то отправляем
        if (line.contains("Сонет " + number + " "))

          ps.println(line);
          System.out.println(line);
          if (i<30) // не отправляется больше 30 строк
            i++;
          else
            break;
      }
      br.close();
    } catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}