package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;

	// Para for�ar a inje��o de depend�ncia para que o objeto conn fique a
	// disposi��o em qualquer lugar dessa classe.
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// Para iniciar o preparedStatement, st recebe conex�o.prepareStatement e �
			// passado o comando SQL como par�metro.
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName " + "FROM seller INNER JOIN department "
							+ "ON seller.DepartmentId = department.Id " + "WHERE seller.Id = ?");

			// O primeiro "?" vai receber o valor do id passado no par�metro do m�todo
			// findById
			st.setInt(1, id);
			// Meu resultado � = st.executeQuery. executeQuery = comando SQL
			rs = st.executeQuery();

			/*
			 * A classe DAO � respons�vel por pegar os dados do banco de dados relacional e
			 * transformar em objetos associados, logo, deve ser criado objetos. If para
			 * testar se veio algum resultado na consulta sql, caso n�o retorne nenhum
			 * registro o if � ignorado e � retornado o valor null Se der verdadeiro
			 * significa que retornou a tabela do banco de dados e � necess�rio a navega��o
			 * entre os dados dessa tabela para instanciar os objetos
			 */
			if (rs.next()) {
				// Inicia o departamento
				Department dp = new Department();
				// Pega o ID do departamento para setar o id dele
				dp.setId(rs.getInt("DepartmentId"));
				// Pega o nome do departamento para setar o nome dele
				dp.setName(rs.getString("DepName"));

				Seller obj = new Seller();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setDepartment(dp);
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
