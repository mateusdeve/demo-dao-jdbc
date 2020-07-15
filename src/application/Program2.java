package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\nTeste 1: Insert Department");
		Department department = new Department(null, "Music");
		depDao.insert(department);
		
		System.out.println("Inserido com sucesso!");
		
		System.out.println("\nTeste 2: FindById Department");
		department = depDao.findById(3);
		
		System.out.println(department);
		
		System.out.println("\nTeste 2: FindAll Department");
		List<Department> list = depDao.findAll();
		
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\nTeste 4: Update Department");
		department = depDao.findById(7);
		department.setName("teste");
		depDao.update(department);
		
		System.out.println("Atualizado com sucesso!");
	
		System.out.println("\nTeste 5: Delete Department");
		int id = sc.nextInt();
					
		depDao.deletById(id);

		System.out.println("Deletado com sucesso!");
		
		
		sc.close(); 

	}

}
