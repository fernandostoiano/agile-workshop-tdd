package br.com.caelum.tdd.exercicio1;

import static br.com.caelum.tdd.exercicio1.Cargo.DBA;
import static br.com.caelum.tdd.exercicio1.Cargo.DESENVOLVEDOR;
import static br.com.caelum.tdd.exercicio1.Cargo.TESTER;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculadoraDeSalarioTest {

	private CalculadoraDeSalario calculadora;

	@Before
	public void setUp() {
		calculadora = new CalculadoraDeSalario();
	}
	
	@Test
	public void deveRetornar4000MenosImpostosDe20PorCentoSeDesenvolvedorGanhaMaisDe3000(){
		Funcionario desenvolvedor = umFuncionario(DESENVOLVEDOR, comSalarioBase(4000.0));
		
		double salario = calculadora.calcula(desenvolvedor);
		
		assertEquals(4000.0 * 0.8, salario, 0.000001);
	}

	@Test
	public void deveRetornar1000MenosImpostosDe10PorCentoSeDesenvolvedorGanhaMenosDe3000(){
		Funcionario desenvolvedor = umFuncionario(DESENVOLVEDOR, comSalarioBase(1000.0));
		
		double salario = calculadora.calcula(desenvolvedor);
		
		assertEquals(1000.0 * 0.9, salario, 0.000001);
	}


	@Test
	public void deveRetornar4000MenosImpostosDe25PorCentoSeDBAGanhaMaisDe2000(){
		Funcionario dba = umFuncionario(DBA, comSalarioBase(4000.0));
		
		double salario = calculadora.calcula(dba);
		
		assertEquals(4000.0 * 0.75, salario, 0.000001);
	}

	@Test
	public void deveRetornar1000MenosImpostosDe15PorCentoSeDBAGanhaMenosDe2000(){
		Funcionario dba = umFuncionario(DBA, comSalarioBase(1000.0));
		
		double salario = calculadora.calcula(dba);
		
		assertEquals(1000.0 * 0.85, salario, 0.000001);
	}

	@Test
	public void deveRetornar4000MenosImpostosDe25PorCentoSeTestadorGanhaMaisDe2000(){
		Funcionario testador = umFuncionario(TESTER, comSalarioBase(4000.0));
		
		double salario = calculadora.calcula(testador);
		
		assertEquals(4000.0 * 0.75, salario, 0.000001);
	}

	@Test
	public void deveRetornar1000MenosImpostosDe15PorCentoSeTestadorGanhaMenosDe2000(){
		Funcionario testador = umFuncionario(TESTER, comSalarioBase(1000.0));
		
		double salario = calculadora.calcula(testador);
		
		assertEquals(1000.0 * 0.85, salario, 0.000001);
	}
	
	@Test
	public void deveRetornarSalarioMenus20PorCentoSeTestadorGanharMaisDe5000() throws Exception {
		Funcionario testador = umFuncionario(Cargo.GERENTE, comSalarioBase(6000));
		
		double salario = calculadora.calcula(testador);
		
		assertEquals(6000.0 * 0.8, salario, 0.000001);
	}
	
	@Test
	public void deveRetornarSalarioMenus15PorCentoSeTestadorGanharIgual5000() throws Exception {
		Funcionario testador = umFuncionario(Cargo.GERENTE, comSalarioBase(5000));
		
		double salario = calculadora.calcula(testador);
		
		assertEquals(5000.0 * 0.85, salario, 0.000001);
	}
	
	@Test
	public void deveRetornarSalarioMenus15PorCentoSeTestadorGanharMenus5000() throws Exception {
		Funcionario testador = umFuncionario(Cargo.GERENTE, comSalarioBase(4000));
		
		double salario = calculadora.calcula(testador);
		
		assertEquals(4000.0 * 0.85, salario, 0.000001);
	}
	
	private Funcionario umFuncionario(Cargo cargo, double salario) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Martin Fowler");
		funcionario.setSalarioBase(salario);
		funcionario.setCargo(cargo);
		return funcionario;
	}
	

	private double comSalarioBase(double salario) {
		return salario;
	}
}
