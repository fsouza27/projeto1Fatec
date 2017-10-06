package br.sceweb.teste_unitario;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;

public class UC01CadastrarEmpresa {
	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	
	@Ignore
	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
		assertEquals(1,empresaDAO.adiciona(empresa));
	}
	
	@Test
	public void CT02UC01FBCadastra_cnpj_invalido() {
		assertEquals("CNPJ inválido",empresa.setCnpj());
	}
	
	@Test
	public void CT03UC01FBCadastra_Cnpj_ja_cadastrado() {
		empresaDAO.adiciona(empresa);
		assertEquals(0, empresaDAO.adiciona(empresa));
		
	}
	
	@After //teste roda logo após a execução de cada caso de teste acima @Test
	public void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
	}
}



