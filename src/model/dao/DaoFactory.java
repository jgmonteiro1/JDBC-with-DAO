package model.dao;

import model.dao.impl.SellerDaoJDBC;

//Classe com operações estáticas para instanciar os DAO;
public class DaoFactory {
	
	//Retorna o tipo da interface e instancia a classe que implementa essa interface
	public static SellerDao createSellerDao() {
		//Expõe um método do tipo da interface (SellerDao), mas internamente instancia uma implementação
		return new SellerDaoJDBC();
	}
}
