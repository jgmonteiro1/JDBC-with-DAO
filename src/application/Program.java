package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		Department obj = new Department(1, "books");
		Seller seller = new Seller(21, "Jo�o", "jgmoreira15@gmail.com", new Date(), 3000.0, obj);
		
		//Ao inv�s de instanciar com o new � chamado a f�brica que instancia o sellerDao, a f�brica mais o m�todo
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println(seller);
	}
}
