package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calcul {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите арифметическую операцию в формате: \"число\", \"операция\", \"число\".");
        String str = reader.readLine();
        Raspredelenie raspredelenie = new Raspredelenie();
        try {
            raspredelenie.opredelenieCifr(str);
        } catch (NumberFormatException e){
            System.out.println(e + " т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Пожалуйста, попробуйте снова!");
        }

    }
}

class Raspredelenie {

    public void opredelenieCifr(String s) {
        String bezProbelov = s.replaceAll("\\s", "");          // убираем пробелы
        TudaSuda tudaSuda = new TudaSuda();
        VichislenieArab v = new VichislenieArab();
        VichislenieRimskixCifr v1 = new VichislenieRimskixCifr();
        if (bezProbelov.contains("-")) {
            String[] array = bezProbelov.split("-");      // разбиваем на две части, разделителем служит знак операции
            String firstNumber = array[0];
            String secondNumber = array[1];
            if (tudaSuda.isArab(firstNumber) && tudaSuda.isArab(secondNumber)) {
                int numberOne = Integer.parseInt(firstNumber);
                int numberTwo = Integer.parseInt(secondNumber);
                System.out.println(v.minus(numberOne, numberTwo));
            } else if (tudaSuda.isRim(firstNumber) && tudaSuda.isRim(secondNumber)) {
                v1.vichislenieRimskixCifr(bezProbelov);
            } else
                System.out.println("Калькулятор умеет работать либо только с арабскими, либо только с римскими цифрами одновременно!\nПожалуйста попробуйте снова!");
        }
        if (bezProbelov.contains("+")) {
            String[] array = bezProbelov.split("\\+");      // разбиваем на две части, разделителем служит знак операции
            String firstNumber = array[0];
            String secondNumber = array[1];
            if (tudaSuda.isArab(firstNumber) && tudaSuda.isArab(secondNumber)) {
                int numberOne = Integer.parseInt(firstNumber);
                int numberTwo = Integer.parseInt(secondNumber);
                System.out.println(v.plus(numberOne, numberTwo));
            } else if (tudaSuda.isRim(firstNumber) && tudaSuda.isRim(secondNumber)) {
                v1.vichislenieRimskixCifr(bezProbelov);
            } else
                System.out.println("Калькулятор умеет работать либо только с арабскими, либо только с римскими цифрами одновременно!\nПожалуйста попробуйте снова!");
        }
        if (bezProbelov.contains("/")) {
            String[] array = bezProbelov.split("/");      // разбиваем на две части, разделителем служит знак операции
            String firstNumber = array[0];
            String secondNumber = array[1];
            if (tudaSuda.isArab(firstNumber) && tudaSuda.isArab(secondNumber)) {
                int numberOne = Integer.parseInt(firstNumber);
                int numberTwo = Integer.parseInt(secondNumber);
                System.out.println(v.razdelit(numberOne, numberTwo));
            } else if (tudaSuda.isRim(firstNumber) && tudaSuda.isRim(secondNumber)) {
                v1.vichislenieRimskixCifr(bezProbelov);
            } else
                System.out.println("Калькулятор умеет работать либо только с арабскими, либо только с римскими цифрами одновременно!\nПожалуйста попробуйте снова!");
        }
        if (bezProbelov.contains("*")) {
            String[] array = bezProbelov.split("\\*");      // разбиваем на две части, разделителем служит знак операции
            String firstNumber = array[0];
            String secondNumber = array[1];
            if (tudaSuda.isArab(firstNumber) && tudaSuda.isArab(secondNumber)) {
                int numberOne = Integer.parseInt(firstNumber);
                int numberTwo = Integer.parseInt(secondNumber);
                System.out.println(v.umnojit(numberOne, numberTwo));
            } else if (tudaSuda.isRim(firstNumber) && tudaSuda.isRim(secondNumber)) {
                v1.vichislenieRimskixCifr(bezProbelov);
            } else
                System.out.println("Калькулятор умеет работать либо только с арабскими, либо только с римскими цифрами одновременно!\nПожалуйста попробуйте снова!");
        }
    }
}

class TudaSuda {
    public boolean isArab(String s) {
        String[] arabArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        boolean b = false;
        for (int i = 0; i < 10; i++) {

            if (s.contains(arabArray[i])) {
                b = true;
                break;
            }
        }
        return b;

    }

    public boolean isRim(String s) {
        String[] rimArray = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        boolean b = false;
        for (int i = 0; i < 10; i++) {
            if (s.contains(rimArray[i])) {
                b = true;
                break;
            }
        }
        return b;
    }
}

class VichislenieArab {

    public int minus(int a, int b){
        int result = 101;
        if (a < 1 || a > 10 || b < 1 || b > 10){
            System.out.println("Введите числа от 1 до 10!");
        } else result = a - b;
        return result;
    }
    public int plus(int a, int b){
        int result = 101;
        if (a < 1 || a > 10 || b < 1 || b > 10){
            System.out.println("Введите числа от 1 до 10!");
        } else result = a + b;
        return result;
    }
    public int razdelit(int a, int b){
        int result = 101;
        if (a < 1 || a > 10 || b < 1 || b > 10){
            System.out.println("Введите числа от 1 до 10!");
        } else result = a / b;
        return result;
    }
    public int umnojit(int a, int b){
        int result = 101;
        if (a < 1 || a > 10 || b < 1 || b > 10){
            System.out.println("Введите числа от 1 до 10!");
        } else result = a * b;
        return result;
    }
}

class VichislenieRimskixCifr {

    public void vichislenieRimskixCifr(String s) {
        if (s.contains("-")){
            String[] s1 = s.split("-"); // разделили строку на две по знаку операции
            String stringNumber1 = s1[0];     // первое число  -> римское
            String stringNumber2 = s1[1];     // второе число  -> римское
            rimCifri rimC = rimCifri.I;       // создал объект енума, для того чтобы воспользоваться методом римВАраб
            int sNumber1 = rimC.rimVArab(stringNumber1);  // переводим римские в арабские с помощью метода рим В Араб ->
            int sNumber2 = rimC.rimVArab(stringNumber2);  // переводим римские в арабские с помощью метода рим В Араб ->
            VichislenieArab vich = new VichislenieArab(); // создаем объект класса ВычислениеАрабских
            int number1 = vich.minus(sNumber1, sNumber2); // создаем интовую переменную и передаем в нее вычисления метода
            if (number1 <= 0){
                System.out.println("В римской системе исчисления нет отрицательных чисел и цифры 0");
            }
            String st = rimC.arabVrim(number1);    // переводим обратно арабские в римские
            System.out.println(st);  // выводим ответ на экран
        }
        if (s.contains("+")){
            String[] s1 = s.split("\\+"); // разделили строку на две по знаку операции
            String stringNumber1 = s1[0];     // первое число  -> римское
            String stringNumber2 = s1[1];     // второе число  -> римское
            rimCifri rimC = rimCifri.I;       // создал объект енума, для того чтобы воспользоваться методом римВАраб
            int sNumber1 = rimC.rimVArab(stringNumber1);  // переводим римские в арабские с помощью метода рим В Араб ->
            int sNumber2 = rimC.rimVArab(stringNumber2);  // переводим римские в арабские с помощью метода рим В Араб ->
            VichislenieArab vich = new VichislenieArab(); // создаем объект класса ВычислениеАрабских
            int number1 = vich.plus(sNumber1, sNumber2); // создаем интовую переменную и передаем в нее вычисления метода
            String st = rimC.arabVrim(number1);    // переводим обратно арабские в римские
            System.out.println(st);  // выводим ответ на экран
        }
        if (s.contains("*")){
            String[] s1 = s.split("\\*"); // разделили строку на две по знаку операции
            String stringNumber1 = s1[0];     // первое число  -> римское
            String stringNumber2 = s1[1];     // второе число  -> римское
            rimCifri rimC = rimCifri.I;       // создал объект енума, для того чтобы воспользоваться методом римВАраб
            int sNumber1 = rimC.rimVArab(stringNumber1);  // переводим римские в арабские с помощью метода рим В Араб ->
            int sNumber2 = rimC.rimVArab(stringNumber2);  // переводим римские в арабские с помощью метода рим В Араб ->
            VichislenieArab vich = new VichislenieArab(); // создаем объект класса ВычислениеАрабских
            int number1 = vich.umnojit(sNumber1, sNumber2); // создаем интовую переменную и передаем в нее вычисления метода
            String st = rimC.arabVrim(number1);    // переводим обратно арабские в римские
            System.out.println(st);  // выводим ответ на экран
        }
        if (s.contains("/")){
            String[] s1 = s.split("/"); // разделили строку на две по знаку операции
            String stringNumber1 = s1[0];     // первое число  -> римское
            String stringNumber2 = s1[1];     // второе число  -> римское
            rimCifri rimC = rimCifri.I;       // создал объект енума, для того чтобы воспользоваться методом римВАраб
            int sNumber1 = rimC.rimVArab(stringNumber1);  // переводим римские в арабские с помощью метода рим В Араб ->
            int sNumber2 = rimC.rimVArab(stringNumber2);  // переводим римские в арабские с помощью метода рим В Араб ->
            VichislenieArab vich = new VichislenieArab(); // создаем объект класса ВычислениеАрабских
            int number1 = vich.razdelit(sNumber1, sNumber2); // создаем интовую переменную и передаем в нее вычисления метода
            String st = rimC.arabVrim(number1);    // переводим обратно арабские в римские
            System.out.println(st);  // выводим ответ на экран
        }
    }

    public enum rimCifri {
        O, I, II, III, IV, V, VI, VII, VIII, IX, X, XI, XII, XIII, XIV, XV, XVI, XVII, XVIII, XIX, XX,
        XXI, XXII, XXIII, XXIV, XXV, XXVI, XXVII, XXVIII, XXIX, XXX, XXXI, XXXII, XXXIII, XXXIV, XXXV, XXXVI, XXXVII, XXXVIII, XXXIX, XL,
        XLI, XLII, XLIII, XLIV, XLV, XLVI, XLVII, XLVIII, XLIX, L, LI, LII, LIII, LIV, LV, LVI, LVII, LVIII, LIX, LX,
        LXI, LXII, LXIII, LXIV, LXV, LXVI, LXVII, LXVIII, LXIX, LXX,
        LXXI, LXXII, LXXIII, LXXIV, LXXV, LXXVI, LXXVII, LXXVIII, LXXIX, LXXX,
        LXXXI, LXXXII, LXXXIII, LXXXIV, LXXXV, LXXXVI, LXXXVII, LXXXVIII, LXXXIX, XC,
        XCI, XCII, XCIII, XCIV, XCV, XCVI, XCVII, XCVIII, XCIX, C;

        public String arabVrim(int j) {
            String result = "В римской системе исчисления нет отрицательных чисел!";
            for (int i = 0; i <= rimCifri.values().length; i++) {
                if (j == i) {
                    result = (rimCifri.values()[i].toString());
                }
            }
            return result;
        }
        public int rimVArab(String s) {
            int result = 0;
            for (int i = 0; i < rimCifri.values().length; i++) {
                if (s.equals(values()[i].toString())) {
                    result = i;
                }
            }
            return result;
        }
    }
}
