package com.peddrobatista.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.peddrobatista.entities.Department;
import com.peddrobatista.entities.HourContract;
import com.peddrobatista.entities.Worker;
import com.peddrobatista.entities.enums.WorkerLevel;

public class Program {
	
	public static void main(String args[]) throws ParseException {
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		 System.out.print("Entre com o nome do departamento: ");
		 String departmentName = teclado.nextLine();
		 System.out.println("Insira os dados do trabalhador: ");
		 System.out.print("Nome: ");
		 String workerName = teclado.nextLine();	
		 System.out.print("Nível: ");
		 String workerLevel = teclado.nextLine();	
		 System.out.print("Salário Base: ");
		 double baseSalary = teclado.nextDouble();	
		 Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName)); 
		 
		 System.out.print("Quantos contratos o trabalhador vai ter: "); // ctrl + espaço
		 int n = teclado.nextInt();
		 
		 for(int i = 1; i <= n; i++) {
			 System.out.println("Digite os dados do contrato #" + i);
			 System.out.print("Data (DD/MM/YYYY): ");
			 Date contractDate = sdf.parse(teclado.next());
			 System.out.print("Valor por hora: ");
			 double valuePerHour = teclado.nextDouble();
			 System.out.print("Duração (horas): ");
			 int hours = teclado.nextInt();
			 HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			 worker.addContract(contract);
		 }
		 System.out.println();
		 System.out.print("Insira o mês e o ano para calcular a renda (MM/yyyy): ");
		 String monthAndYear = teclado.next();
		 int month = Integer.parseInt(monthAndYear.substring(0, 2)); 
		 int year = Integer.parseInt(monthAndYear.substring(3));
		 System.out.println("Trabalhador: " + worker.getName());
		 System.out.println("Departamento: " + worker.getDepartment().getName());
		 System.out.println("Renda em " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		 
		teclado.close();
	}

}
