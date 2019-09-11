package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("----Test 1--------FindById");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n-----Test2--------FindByDepartmenmt");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n-----Teste 3--------SellerFindAll");
		List<Seller> list1 = sellerDao.findAll();
		for(Seller obj : list1) {
			System.out.println(obj);
		}
		
		System.out.println("\n-----Teste 4--------SellerInsert");
		Seller seller2 = new Seller(null,"Jesus Cristo", "jeje@gmail.com", new Date(),5000.00, department);
		sellerDao.insert(seller2);
		System.out.println(seller2);
		
	}
}
