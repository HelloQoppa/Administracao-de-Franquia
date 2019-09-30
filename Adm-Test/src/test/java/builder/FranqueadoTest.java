package builder;

import org.junit.Test;

import dao.FranqueadoDAO;
import model.Franqueado;

public class FranqueadoTest {
	
	@Test
	public void teste() {
		Franqueado ativo1 = new Franqueado( 3,"Jorge","Ribeiro","20/05/1994","45615774186","jorgel.junior@ucsal.edu.br","995688442","335488556","32548648"
				,"Pituaçu","Paralela","45236575","Salvador","Bahia");
		FranqueadoDAO ativar1 = new FranqueadoDAO();
		ativar1.inserir(ativo1);
		
		Franqueado ativo2 = new Franqueado();
		ativo2.setId(3);
		ativo2.setNome("Jorge");
		ativo2.setSobrenome("Ribeiro");
		ativo2.setDatanascimento("20/05/1994");
		ativo2.setCpf("45615774186");
		ativo2.setEmail("jorgel.junior@ucsal.edu.br");
		ativo2.setCelular("995688442");
		ativo2.setFoneresidencia("335488556");
		ativo2.setFonecomecial("32548648");
		ativo2.setEndereco("Pituaçu");
		ativo2.setBairro("Paralela");
		ativo2.setCep("45236575");
		ativo2.setCidade("Salvador");
		ativo2.setEstado("Bahia");		
		FranqueadoDAO ativar2 = new FranqueadoDAO();
		ativar2.inserir(ativo2);
		
		Franqueado ativo3 = FranqueadoBuilder.franqueado().build();
		System.out.println("Ativo3 = " + ativo3);
		FranqueadoDAO ativar3 = new FranqueadoDAO();
		ativar3.inserir(ativo3); 
		
		FranqueadoBuilder franqueadobuilder = FranqueadoBuilder.franqueado().Nome("Jorge");
		Franqueado franqueadoDeletado = franqueadobuilder.but().Nome("Jorge").Sobrenome("Ribeiro").build();
		System.out.println("Fraqueado Deletado = " + franqueadoDeletado); 
	}

}
