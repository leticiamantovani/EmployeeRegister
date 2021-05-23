package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.emplyee;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<emplyee> list = new ArrayList<>();

        System.out.print("How many employees will be register:");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1) + ":");
            System.out.print("Id:");
            int id = sc.nextInt();
            while (hasId(list, id)) {
				System.out.println("Id already taken! Try again: ");
				id = sc.nextInt();
			}
            System.out.print("Name:");
            String name = sc.next();
            System.out.print("Salary:");
            Double salary = sc.nextDouble();

            emplyee emp = new emplyee(id, name, salary);

            list.add(emp);
        }

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int idtwo = sc.nextInt();

        emplyee pos = list.stream().filter(x -> x.getId() == idtwo).findFirst().orElse(null);

        if (pos == null) {
            System.out.println("This id does not exist");
        } 
        else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            pos.SalaryIncrease(percentage);
        }
        System.out.println();
        for (emplyee emp : list) {
            System.out.println(emp);
        }

        sc.close();
    }

    public static Integer position(List<emplyee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    public static boolean hasId(List<emplyee> list, int id) {
		emplyee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
