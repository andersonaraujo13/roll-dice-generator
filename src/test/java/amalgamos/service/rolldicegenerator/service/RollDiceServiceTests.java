package amalgamos.service.rolldicegenerator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import amalgamos.service.rolldicegenerator.model.Dice;

@SpringBootTest
@SuppressWarnings("unchecked")
class RollDiceServiceTests {
    @Autowired
    private RollDiceService service;

    @Test
    public void testInvalidGenerate() {
        service.generate(null);
        assertTrue(false);
    }

    @Test
    public void testValidGenerateDiceValueValid () throws Exception{
        RollDiceService service = new RollDiceService();
        Method method = RollDiceService.class.getDeclaredMethod("generateDiceValue", String.class);
        method.setAccessible(true);

        Dice resultado = (Dice) method.invoke(service, "3D10");

        assertEquals("3D10", resultado.getJogada());
        assertEquals(10, resultado.getFace());
        assertEquals(3, resultado.getQuantidade());
        assertTrue(resultado.getTotal() >= 3 && resultado.getTotal() <= 30);
        assertEquals(resultado.getValores().stream().mapToInt(Integer::intValue).sum(), resultado.getTotal());
    }

    /*@Test
    void testGenerateRollsUsingReflection() throws Exception {
        RollDiceService service = new RollDiceService();
        Method generateRolls = RollDiceService.class.getDeclaredMethod("generateRolls", String.class);
        generateRolls.setAccessible(true);

       
        List<Dice> resultado = (List<Dice>) generateRolls.invoke(service, "2D6+1D4");

        assertNotNull(resultado, "A lista de jogadas não deve ser nula");

        // Esperamos duas jogadas: "2D6" e "1D4"
        assertEquals(2, resultado.size(), "Deve extrair duas expressões de dado");

        Dice first = resultado.get(0);
        assertEquals("2D6", first.getJogada());
        assertEquals(6, first.getFace());
        assertEquals(2, first.getQuantidade());
        assertTrue(first.getTotal() >= 2 && first.getTotal() <= 12);
        assertEquals(first.getValores().stream().mapToInt(Integer::intValue).sum(), first.getTotal());

        Dice second = resultado.get(1);
        assertEquals("1D4", second.getJogada());
        assertEquals(4, second.getFace());
        assertEquals(1, second.getQuantidade());
        assertTrue(second.getTotal() >= 1 && second.getTotal() <= 4);
    }*/

}