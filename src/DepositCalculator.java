import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay;
        int monthsOfYear = 12;
        int power = 2;

        pay = amount * Math.pow((1 + yearRate / monthsOfYear), monthsOfYear * depositPeriod);
        return roundValue(pay, power);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        double pay;
        int power = 2;

        pay = amount + amount * yearRate * depositPeriod;
        return roundValue(pay, power);
    }

    double roundValue(double value, int power) {
        double powerNumber;
        int numberTen = 10;

        powerNumber = Math.pow(numberTen, power);
        return Math.round(value * powerNumber) / powerNumber;
    }

    void printMenu() {
        int amount;
        int period;
        int action;
        double cashOut = 0;
        double yearRate = 0.06;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) {
            cashOut = calculateSimplePercent(amount, yearRate, period);
        } else if (action == 2) {
            cashOut = calculateComplexPercent(amount, yearRate, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + cashOut);
    }

    public static void main(String[] args) {
        new DepositCalculator().printMenu();
    }
}
/* Строка 25: лучше назвать переменную numberHundred как-то по-другому. В зависимости от параметра power,
эта переменная может и не равняться ста

Строка 43: Не хвататает открывающей фигурной скобки {

Строка 45: Не хватает закрывающей фигурной скобки }
 */