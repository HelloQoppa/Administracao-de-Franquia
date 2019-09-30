package mockito;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import dao.FranqueadoDAO;
import dao.FranquiaDAO;
import model.Franqueado;
import model.Franquias;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ FranqueadoDAO.class })
public class PowerMock {

	@Test
	public void franquiaCadastrado() throws Exception {

		PowerMockito.mock(FranqueadoDAO.class);

		PowerMockito.when(FranqueadoDAO.getByID(3))
				.thenReturn(new Franqueado(3, "Caio", "Pedro", "22/05/1994", "1526584", "Luizl.junior@ucsal.edu.br",
						"47484884", "544982", "448952282", "Pituacu", "ali", "4115125252", "Salvador", "Bahia"));
		PowerMockito.when(FranqueadoDAO.getByID(4))
				.thenReturn(new Franqueado(4, "Junior", "Albe", "20/05/1994", "1526584", "Luizl.junior@ucsal.edu.br",
						"47484884", "544982", "448952282", "Pituacu", "ali", "4115125252", "Salvador", "Bahia"));

		Franqueado franqueado = new Franqueado(5, "Luiz", "dos", "20/05/1994", "1526584", "caio.junior@ucsal.edu.br",
				"47484884", "544982", "448952282", "Pituacu", "ali", "4115125252", "Salvador", "Bahia");
		Franquias fr = new Franquias();
		fr.setId(1);
		fr.setNome("tudo");
		fr.setFranqueado(franqueado);
		fr.setLocal("Caixa d' agua");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm");
		fr.setHora_fun(LocalTime.parse("12:00", timeFormat));

		FranquiaDAO.inserir(fr);
		PowerMockito.verifyStatic(Mockito.atLeastOnce());

	}

}
