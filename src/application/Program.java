package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Teste 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Teste 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste 3: seller findByAll ===");
		List<Seller> all = sellerDao.findAll();
		
		
		for(Seller obj : all) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste 4: seller Insert ===");
		Seller newSeler = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeler);
		System.out.println("Inserido! Novo id = "+ newSeler.getId());
		
		System.out.println("\n=== Teste 5: seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Marta Waine");
		sellerDao.update(seller);
		System.out.println("Atualização completa!");
		
		
	}

}
