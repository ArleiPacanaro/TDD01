import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class CalculadoraTest {
    // antes de qualquer execução de teste, deve acontecer

    private Calculadora calculadora;

    // Para ser executado antes dos demais metodos...
    // metodos void que chamam a camada service
    // anotação @Test
    // na pasta de Teste


    @BeforeEach
    void setup(){
        calculadora  = new Calculadora();

    }

    @Test
    void deveSomar()
    {
        ///Calculadora calculadora = new Calculadora();
        int resultado = calculadora.somar(5,2);
        // assertJ
        assertThat(resultado).isEqualTo(7);
        //Assertions.assertEquals(7,resultado);
        //fail("teste não implementado");
    }

    @Test
    void deveSubtrair(){
        //Calculadora calculadora = new Calculadora();
        int resultado = calculadora.subtrair(5,2);
        Assertions.assertEquals(3,resultado);
        //fail("teste não implementado"); --- da Assertion do junit...
    }

    @Test
    void deveMultiplicar(){
        /// como uso o Java 17
        var resultado = calculadora.multiplicao(5,2);
        Assertions.assertEquals(10,resultado);
        //fail("teste não implementado");
    }

    @Test
    void deveDividir(){
        /// como uso o Java 17
        var resultado = calculadora.dividir(4,2);
        Assertions.assertEquals(2,resultado);
        //fail("teste não implementado");
    }

    @Test
    void deveDividir_gerarExcecaoQuandoDividirPorZero(){
        assertThrows(ArithmeticException.class,()->{
            calculadora.dividir(4,0);
        });
    }

    // com AssertJ
    @Test
    void deveDividir_gerarExcecaoQuandoDividirPorZeroAssertJ(){
        Throwable exception = catchThrowable(()->calculadora.dividir(4,0));
        assertThat(exception).isInstanceOf(ArithmeticException.class)
                .hasMessage("/ by zero");
    }
}
