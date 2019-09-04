package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		Department obj = new Department(1, "books");
		Seller seller = new Seller(21, "João", "jgmoreira15@gmail.com", new Date(), 3000.0, obj);
		
		//Ao invés de instanciar com o new é chamado a fábrica que instancia o sellerDao, a fábrica mais o método
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println(seller);
	}
}
