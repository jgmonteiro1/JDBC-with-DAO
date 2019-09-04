package model.dao;

import model.dao.impl.SellerDaoJDBC;

//Classe com opera��es est�ticas para instanciar os DAO;
public class DaoFactory {
	
	//Retorna o tipo da interface e instancia a classe que implementa essa interface
	public static SellerDao createSellerDao() {
		//Exp�e um m�todo do tipo da interface (SellerDao), mas internamente instancia uma implementa��o
		return new SellerDaoJDBC();
	}
}
