# XMLParser
Задание.

1.Создать файл XML и соответствующую ему схему XSD.

2.При разработке XSD использовать простые и комплексные типы, перечисления, шаблоны и предельные значения.

3.Создать Java-класс, соответствующий данному описанию.

4.Создать приложение для разбора XML-документа и инициализации коллекции объектов информацией из XML-файла. Для разбора использовать SAX, DOM и StAX парсеры. Для сортировки объектов использовать интерфейс Comparator.

5.Произвести проверку XML-документа с привлечением XSD.

6.Определить метод, производящий преобразование разработанного XML-документа с помощью XSL в формат HTML (отсортировав объекты по одному из параметров).

Вариант - 9(Конфеты)
- Name - название конфеты;
- Energy - калорийность (ккал);
- Type (должно быть несколько) - тип конфеты (карамель, ирис, шоколадная [с начинкой либо нет]);
- Ingredients (должно быть несколько) - ингредиенты: вода, сахар (в мг), фруктоза (в мг), тип шоколада (для шоколадных), ванилин (в мг);
- Value - пищевая ценность: белки (в г), жиры (в г) и углеводы (в г);
- Production - предприятие-изготовитель.
Корневой элемент назвать Candies.
