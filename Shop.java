import java.util.*;
import java.util.stream.Collectors;

public class Shop {
  public static void main(String[] args) {
      Set<Computer> computers = new HashSet<>();
      computers.add(new Computer("Dell XPS 13", 16, 512, "Windows 10", "silver"));
      computers.add(new Computer("MacBook Air", 8, 256, "macOS", "grey"));
      computers.add(new Computer("Lenovo ThinkPad", 8, 512, "Windows 10", "black"));
      computers.add(new Computer("HP Spectre", 16, 256, "Windows 10", "gold"));

      // Запрос критериев фильтрации
      Scanner scanner = new Scanner(System.in);
      Map<String, Object> filter = new HashMap<>();
      System.out.println("Введите цифру, соответствующую необходимому критерию:");
      System.out.println("1 - ОЗУ");
      System.out.println("2 - Объем ЖД");
      System.out.println("3 - Операционная система");
      System.out.println("4 - Цвет");

      int criteria = scanner.nextInt();
      if (criteria == 1) {
          System.out.println("Введите минимальное значение ОЗУ (гБ):");
          int minRam = scanner.nextInt();
          filter.put("ram", minRam);
      } else if (criteria == 2) {
          System.out.println("Введите минимальный объем ЖД (гБ):");
          int minHdd = scanner.nextInt();
          filter.put("hdd", minHdd);
      } else if (criteria == 3) {
          System.out.println("Введите операционную систему:");
          String os = scanner.next();
          filter.put("os", os);
      } else if (criteria == 4) {
          System.out.println("Введите цвет:");
          String color = scanner.next();
          filter.put("color", color);
      }

      // Применяем фильтр и выводим результат
      List<Computer> filterComputers = computers.stream()
              .filter(f -> isCriteriaCorrect(f, filter))
              .collect(Collectors.toList());

      System.out.println("Найденные ноутбуки:");
      for (Computer f : filterComputers) {
          System.out.println("Модель: " + f.getModel());
          System.out.println("ОЗУ: " + f.getRam() + " гБ");
          System.out.println("Объем ЖД: " + f.getHdd() + " гБ");
          System.out.println("ОС: " + f.getOs());
          System.out.println("Цвет: " + f.getColor());
          System.out.println();
      }
      scanner.close();
  }

  // Метод для проверки, соответствует ли ноутбук критериям фильтрации
  public static boolean isCriteriaCorrect(Computer computer, Map<String, Object> filter) {
        for (Map.Entry<String, Object> entry : filter.entrySet()) {
            String criteria = entry.getKey();
            Object value = entry.getValue();

            if (criteria.equals("ram")) {
                int minRam = (int) value;
                if (computer.getRam() < minRam) {
                    return false;
                }
            } else if (criteria.equals("hdd")) {
                int minHdd = (int) value;
                if (computer.getHdd() < minHdd) {
                    return false;
                }
            } else if (criteria.equals("os")) {
                String os = (String) value;
                if (!computer.getOs().equalsIgnoreCase(os)) {
                    return false;
                }
            } else if (criteria.equals("color")) {
                String color = (String) value;
                if (!computer.getColor().equalsIgnoreCase(color)) {
                    return false;
                }
            }
        }
        return true;
    }
}